package net.cartola.receita.cnpj;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.cartola.receita.cnpj.model.Cadastro;
import net.cartola.receita.cnpj.model.CnaeSecundario;
import net.cartola.receita.cnpj.model.Socio;
import net.cartola.receita.cnpj.parser.CadastroParser;
import net.cartola.receita.cnpj.parser.CnaeSecundarioParser;
import net.cartola.receita.cnpj.parser.SocioParser;
import net.cartola.receita.cnpj.serializer.CnpjSerializer;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PutMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;

/**
 * 24/04/2019 00:26:37
 *
 * @author murilo
 */
public class CnpjReader {

    public static void main(String[] args) {
        File f = new File("/Users/murilo/Documents/cnpj/F.K032001K.D90308");
//        f = new File("/Users/murilotuvani/OneDrive/cnpj/sample.txt");
        if (f.exists() && f.canRead()) {
            CnpjReader c = new CnpjReader();
            if (Boolean.parseBoolean(System.getProperty("clear", "true"))) {
                try {
                    c.clear();
                } catch (IOException ex) {
                    Logger.getLogger(CnpjReader.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            c.read(f);
        } else {
            System.out.println("Nao encontrou o arquivo : " + f.getAbsolutePath());
        }
    }

    private void read(File f) {
        CadastroParser cadastroParser = new CadastroParser();
        SocioParser socioParser = new SocioParser();
        CnaeSecundarioParser cnaeSecundarioParser = new CnaeSecundarioParser();

        try (FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr)) {
            String line = null;
            int header = 0;
            int detalhe = 0;
            int cnaeSecundarioCount = 0;
            int cnaeSecundarioSemEmpresaCount = 0;
            int socioCount = 0;
            int socioSemEmpresaCount = 0;
            int trailler = 0;
            int outros = 0;
            int limite = Integer.parseInt(System.getProperty("registros.limite", "10"));
            Map<Long, Cadastro> mapa = new HashMap<>();
            while ((line = br.readLine()) != null) {
                if (line.startsWith("1")) {
                    detalhe++;
                    if (mapa.size() >= limite) {
                        send(mapa);
                        mapa = new HashMap<>();
                    }
                    Cadastro cadastro = cadastroParser.parse(line);
                    mapa.put(cadastro.getCnpj(), cadastro);
//                    System.out.println(cadastro);
//                    System.out.flush();
                } else if (line.startsWith("2")) {
                    socioCount++;
                    Socio socio = socioParser.parse(line);
                    if (mapa.containsKey(socio.getCnpjEmpresa())) {
                        mapa.get(socio.getCnpjEmpresa()).addSocio(socio);
                    } else {
                        socioSemEmpresaCount++;
                    }
                    System.out.println(socio);
                    System.out.flush();
                } else if (line.startsWith("6")) {
                    cnaeSecundarioCount++;
                    CnaeSecundario cnaeSecundaria = cnaeSecundarioParser.parse(line);
                    if (mapa.containsKey(cnaeSecundaria.getCnpjEmpresa())) {
                        mapa.get(cnaeSecundaria.getCnpjEmpresa()).addCnaeSecundaria(cnaeSecundaria);
                    } else {
                        cnaeSecundarioSemEmpresaCount++;
                    }
                    System.out.println(cnaeSecundaria);
                    System.out.flush();
                } else if (line.startsWith("0")) {
                    header++;
                } else if (line.startsWith("9")) {
                    trailler++;
                } else {
                    outros++;
                }
            }
            if (!mapa.isEmpty()) {
                send(mapa);
            }
            System.out.println("Header   : " + header);
            System.out.println("Empresa  : " + detalhe);
            System.out.println("Sócio    : " + socioCount);
            System.out.println("Sócio    : " + socioSemEmpresaCount + " sem empresa");
            System.out.println("CNAE Sec : " + cnaeSecundarioCount);
            System.out.println("CNAE Sec : " + cnaeSecundarioSemEmpresaCount + " sem empresa");
            System.out.println("Trailler : " + trailler);
            System.out.println("Outros   : " + outros);
            System.out.println("Header   : " + header);
        } catch (IOException ex) {
            Logger.getLogger(CnpjReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void send(final Map<Long, Cadastro> mapa) {
        Runnable r = () -> {
            try {
                List<Cadastro> cadastros = new ArrayList<>(mapa.values());
                CnpjSerializer serializer = new CnpjSerializer();
                String json = serializer.toJson(cadastros);
                String url = System.getProperty("server", "http://localhost:8080") + "/api/cnpj/list";
                PutMethod putMethod = new PutMethod(url);
                putMethod.addRequestHeader("Accept", "application/json");
                putMethod.addRequestHeader("Content-type", "application/json");
                
                RequestEntity requestEntity = new StringRequestEntity(json, "application/json", "UTF-8");
                putMethod.setRequestEntity(requestEntity);
                HttpClient client = new HttpClient();
                int response = client.executeMethod(putMethod);
                if (response == 200) {
                    System.out.println("Registros criados");
                } else {
                    System.out.println("Http Code : " + response);
                    ByteArrayOutputStream baos = getResponseBody(putMethod);
                    String responseBody = baos.toString();
                    System.out.println(responseBody);
                }
//                System.out.print(json);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(CnpjReader.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(CnpjReader.class.getName()).log(Level.SEVERE, null, ex);
            }
        };
        Thread t = new Thread(r);
        t.start();
    }
    
    public static ByteArrayOutputStream getResponseBody(HttpMethod method) throws IOException {
        InputStream input = method.getResponseBodyAsStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        BufferedInputStream bis = new BufferedInputStream(input);
        int aByte;
        while ((aByte = bis.read()) != -1) {
            baos.write(aByte);
        }
        baos.flush();
        baos.close();
        bis.close();
        return baos;
    }

    private void clear() throws IOException {
        String url = System.getProperty("server", "http://localhost:8080") + "/api/cnpj/clear";
        GetMethod method = new GetMethod(url);
        method.addRequestHeader("Accept", "application/json");
        method.addRequestHeader("Content-type", "application/json");

        HttpClient client = new HttpClient();
        int response = client.executeMethod(method);
        if (response == 200) {
            System.out.println("Registros criados");
        }
    }
}
