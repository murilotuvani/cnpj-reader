package net.cartola.receita.cnpj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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

/**
 * 24/04/2019 00:26:37
 *
 * @author murilo
 */
public class CnpjReader {

    public static void main(String[] args) {
        File f = new File("/Users/murilo/Documents/cnpj/F.K032001K.D90308");
        f = new File("/Users/murilotuvani/OneDrive/cnpj/sample.txt");
        if (f.exists() && f.canRead()) {
            CnpjReader c = new CnpjReader();
            c.read(f);
        } else {
            System.out.println("Nao encontrou o arquivo : " + f.getAbsolutePath());
        }
    }

    private void read(File f) {
        CadastroParser cadastroParser = new CadastroParser();
        SocioParser socioParser = new SocioParser();
        CnaeSecundarioParser cnaeSecundarioParser = new CnaeSecundarioParser();
        
        try (FileReader     fr = new FileReader(f);
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
            Map<Long, Cadastro> mapa = new HashMap<>();
            while ((line = br.readLine()) != null) {
                if (line.startsWith("1")) {
                    detalhe++;
                    if (mapa.size() >= 10) {
                        send(mapa);
                        mapa = new HashMap<>();
                    }
                    Cadastro cadastro = cadastroParser.parse(line);
                    mapa.put(cadastro.getCnpj(), cadastro);
                    System.out.println(cadastro);
                    System.out.flush();
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
                    send(mapa);
                    trailler++;
                } else {
                    outros++;
                }
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

    private void send(Map<Long, Cadastro> mapa) {
        List<Cadastro> cadastros = new ArrayList<>(mapa.values());
        CnpjSerializer serializer = new CnpjSerializer();
        String json = serializer.toJson(cadastros);
        System.out.print(json);
    }
}
