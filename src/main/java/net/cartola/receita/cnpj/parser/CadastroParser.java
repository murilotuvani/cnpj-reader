package net.cartola.receita.cnpj.parser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.cartola.receita.cnpj.model.Cadastro;
import net.cartola.receita.cnpj.model.SituacaoCadastral;
import net.cartola.receita.cnpj.model.UnidadeTipo;

/**
 * 24/04/2019 23:26:09
 *
 * @author murilotuvani
 */
public class CadastroParser {

    private static final SimpleDateFormat SDF_YYYYMMDD = new SimpleDateFormat("yyyyMMdd");

    public Cadastro parse(String linha) {
        Cadastro c = new Cadastro();
        int pos = 3;
        int tam = 14;
        String aux = linha.substring(pos, pos + tam);
        pos += tam;
        c.setCnpj(Long.parseLong(aux));

        tam = 1;
        aux = linha.substring(pos, pos + tam);
        pos += tam;
        c.setUnidadeTipo("2".equals(aux) ? UnidadeTipo.FILIAL : UnidadeTipo.MATRIZ);

        tam = 150;
        aux = linha.substring(pos, pos + tam);
        pos += tam;
        c.setRazaoSocial(aux.trim());

        tam = 55;
        aux = linha.substring(pos, pos + tam);
        pos += tam;
        c.setNomeFantasia(aux.trim());

        tam = 2;
        aux = linha.substring(pos, pos + tam);
        pos += tam;
        int iaux = Integer.parseInt(aux);
        switch (iaux) {
            case 1:
                c.setSituacaoCadastral(SituacaoCadastral.NULA);
                break;
            case 2:
                c.setSituacaoCadastral(SituacaoCadastral.ATIVA);
                break;
            case 3:
                c.setSituacaoCadastral(SituacaoCadastral.SUSPENSA);
                break;
            case 4:
                c.setSituacaoCadastral(SituacaoCadastral.INAPTA);
                break;
            case 8:
                c.setSituacaoCadastral(SituacaoCadastral.BAIXADA);
                break;
        }

        tam = 8;
        aux = linha.substring(pos, pos + tam);
        pos += tam;
        Date data;
        try {
            data = SDF_YYYYMMDD.parse(aux);
            c.setDataSituacaoCadastral(data);
        } catch (ParseException ex) {
            Logger.getLogger(CadastroParser.class.getName()).log(Level.SEVERE, null, ex);
        }

        tam = 2;
        aux = linha.substring(pos, pos + tam);
        pos += tam;
        iaux = Integer.parseInt(aux);
        c.setMotivoSituacaoCadastral(iaux);

        tam = 55;
        aux = linha.substring(pos, pos + tam);
        pos += tam;
        c.setCidadeExteriorNome(aux.trim());

        tam = 3;
        aux = linha.substring(pos, pos + tam);
        pos += tam;
        if (!"".equals(aux.trim())) {
            iaux = Integer.parseInt(aux.trim());
            c.setPaisCodigo(iaux);
        }

        tam = 70;
        aux = linha.substring(pos, pos + tam);
        pos += tam;
        c.setPaisNome(aux.trim());

        tam = 4;
        aux = linha.substring(pos, pos + tam);
        pos += tam;
        if (!"".equals(aux.trim())) {
            iaux = Integer.parseInt(aux.trim());
            c.setCodigoNaturezaJuridica(iaux);
        }

        tam = 8;
        aux = linha.substring(pos, pos + tam);
        pos += tam;
        try {
            data = SDF_YYYYMMDD.parse(aux);
            c.setInicioAtividade(data);
        } catch (ParseException ex) {
            Logger.getLogger(CadastroParser.class.getName()).log(Level.SEVERE, null, ex);
        }

        tam = 7;
        aux = linha.substring(pos, pos + tam);
        pos += tam;
        if (!"".equals(aux.trim())) {
            iaux = Integer.parseInt(aux.trim());
            c.setCnae(iaux);
        }

        return c;
    }
}
