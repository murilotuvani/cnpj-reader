package net.cartola.receita.cnpj.parser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.cartola.receita.cnpj.model.Socio;
import net.cartola.receita.cnpj.model.SocioIdentificador;

/**
 * 28/04/2019 15:33:05
 *
 * @author murilotuvani
 */
public class SocioParser {

    private static final SimpleDateFormat SDF_YYYYMMDD = new SimpleDateFormat("yyyyMMdd");

    public Socio parse(String linha) {
        Socio s = new Socio();

        int pos = 3;
        int tam = 14;
        String aux = linha.substring(pos, pos + tam);
        pos += tam;
        s.setCnpjEmpresa(Long.parseLong(aux.trim()));

        tam = 1;
        aux = linha.substring(pos, pos + tam);
        pos += tam;
        switch (aux.trim()) {
            case "1":
                s.setIdentificador(SocioIdentificador.PESSOA_FISICA);
                break;
            case "2":
                s.setIdentificador(SocioIdentificador.PESSOA_JURIDICA);
                break;
            case "3":
                s.setIdentificador(SocioIdentificador.ESTRANGEIRO);
                break;
        }

        tam = 150;
        aux = linha.substring(pos, pos + tam);
        s.setNome(aux.trim());
        pos += tam;

        tam = 14;
        aux = linha.substring(pos, pos + tam);
        pos += tam;
        //s.setCpfCnpjSocio(Long.parseLong(aux.trim()));
        s.setCpfCnpjSocio(aux.trim());

        tam = 2;
        aux = linha.substring(pos, pos + tam);
        pos += tam;
        s.setCodigoQualificacaoSocio(aux.trim());

        tam = 5;
        aux = linha.substring(pos, pos + tam);
        pos += tam;
        double percentual = Double.parseDouble(aux.trim());
        s.setPercentualCapitalSocial(percentual);

        tam = 8;
        aux = linha.substring(pos, pos + tam);
        pos += tam;
        Date data;
        try {
            data = SDF_YYYYMMDD.parse(aux.trim());
            s.setDataEntrada(data);
        } catch (ParseException ex) {
            Logger.getLogger(CadastroParser.class.getName()).log(Level.SEVERE, null, ex);
        }

        tam = 3;
        aux = linha.substring(pos, pos + tam);
        s.setCodigoPais(aux.trim());
        pos += tam;

        tam = 70;
        aux = linha.substring(pos, pos + tam);
        pos += tam;
        s.setNomePais(aux.trim());

        tam = 11;
        aux = linha.substring(pos, pos + tam);
        pos += tam;
        //s.setCpfRepresentanteLegal(Long.parseLong(aux.trim()));
        s.setCpfRepresentanteLegal(aux.trim());

        tam = 60;
        aux = linha.substring(pos, pos + tam);
        pos += tam;
        s.setNomeRepresentanteLegal(aux.trim());

        tam = 2;
        aux = linha.substring(pos, pos + tam);
        pos += tam;
        s.setCodigoQualificacaoRepresentanteLegal(aux.trim());

        return s;
    }

}
