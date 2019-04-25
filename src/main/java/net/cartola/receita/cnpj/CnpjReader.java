package net.cartola.receita.cnpj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.cartola.receita.cnpj.model.Cadastro;
import net.cartola.receita.cnpj.parser.CadastroParser;

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
        try (FileReader     fr = new FileReader(f);
             BufferedReader br = new BufferedReader(fr)) {
            String line = null;
            int header = 0;
            int detalhe = 0;
            int cnaeSecundario = 0;
            int socio = 0;
            int trailler = 0;
            int outros = 0;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("1")) {
                    detalhe++;
                    Cadastro cadastro = cadastroParser.parse(line);
                    System.out.println(cadastro);
                    System.out.flush();
                } else if (line.startsWith("2")) {
                    socio++;
                } else if (line.startsWith("6")) {
                    cnaeSecundario++;
                } else if (line.startsWith("0")) {
                    header++;
                } else if (line.startsWith("9")) {
                    trailler++;
                } else {
                    outros++;
                }
            }
            System.out.println("Header   : " + header);
            System.out.println("Empresa  : " + detalhe);
            System.out.println("Sócio    : " + socio);
            System.out.println("CNAE Sec : " + cnaeSecundario);
            System.out.println("Trailler : " + trailler);
            System.out.println("Outros   : " + outros);
            System.out.println("Header   : " + header);
        } catch (IOException ex) {
            Logger.getLogger(CnpjReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
