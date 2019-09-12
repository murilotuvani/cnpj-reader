package net.cartola.receita.cnpj.parser;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
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
        iaux = Integer.parseInt(somenteNumeros(aux));
        c.setMotivoSituacaoCadastral(iaux);

        tam = 55;
        aux = linha.substring(pos, pos + tam);
        pos += tam;
        c.setCidadeExteriorNome(aux.trim());

        tam = 3;
        aux = linha.substring(pos, pos + tam);
        pos += tam;
        if (!"".equals(aux.trim())) {
            iaux = Integer.parseInt(somenteNumeros(aux.trim()));
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
            iaux = Integer.parseInt(somenteNumeros(aux.trim()));
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
            iaux = Integer.parseInt(somenteNumeros(aux.trim()));
            c.setCnae(iaux);
        }
        
        tam = 20;
        aux = linha.substring(pos, pos + tam);
        pos += tam;
        c.setTipoLogradouro(aux.trim());

        tam = 60;
        aux = linha.substring(pos, pos + tam);
        pos += tam;
        c.setLogradouro(aux.trim());
        
        tam = 6;
        aux = linha.substring(pos, pos + tam);
        pos += tam;
        c.setNumero(aux.trim());

        tam = 156;
        aux = linha.substring(pos, pos + tam);
        pos += tam;
        c.setComplemento(aux.trim());
        
        tam = 50;
        aux = linha.substring(pos, pos + tam);
        pos += tam;
        c.setBairro(aux.trim());
        
        tam = 8;
        aux = linha.substring(pos, pos + tam);
        pos += tam;
        if (!"".equals(aux.trim())) {
            iaux = Integer.parseInt(somenteNumeros(aux.trim()));
            c.setCep(iaux);
        }
        
        tam = 2;
        aux = linha.substring(pos, pos + tam);
        pos += tam;
        c.setUf(aux.trim());
        
        tam = 4;
        aux = linha.substring(pos, pos + tam);
        pos += tam;
        if (!"".equals(aux.trim())) {
            iaux = Integer.parseInt(somenteNumeros(aux.trim()));
            c.setCodigoMunicipio(iaux);
        }
        
        tam = 50;
        aux = linha.substring(pos, pos + tam);
        pos += tam;
        c.setMunicipio(aux.trim());
        
        tam = 4;
        aux = linha.substring(pos, pos + tam);
        pos += tam;
        c.setDdd1(aux.trim());
        
        tam = 8;
        aux = linha.substring(pos, pos + tam);
        pos += tam;
        c.setTelefone1(aux.trim());
        
        tam = 4;
        aux = linha.substring(pos, pos + tam);
        pos += tam;
        c.setDdd2(aux.trim());
        
        tam = 8;
        aux = linha.substring(pos, pos + tam);
        pos += tam;
        c.setTelefone2(aux.trim());
        
        tam = 4;
        aux = linha.substring(pos, pos + tam);
        pos += tam;
        c.setDddFax(aux.trim());
        
        tam = 8;
        aux = linha.substring(pos, pos + tam);
        pos += tam;
        c.setFax(aux.trim());
        
        tam = 115;
        aux = linha.substring(pos, pos + tam);
        pos += tam;
        c.setCorreioEletronico(aux.trim());
        
        tam = 2;
        aux = linha.substring(pos, pos + tam);
        pos += tam;
        c.setQualificacaoResponsavel(aux.trim());
        
        tam = 14;
        aux = linha.substring(pos, pos + tam);
        pos += tam;
        c.setCapitalSocial(new BigDecimal(aux.trim()));
        
        tam = 2;
        aux = linha.substring(pos, pos + tam);
        pos += tam;
        c.setPorte(aux.trim());
        
        tam = 1;
        aux = linha.substring(pos, pos + tam);
        pos += tam;
        if (!"".equals(aux.trim())) {
            iaux = Integer.parseInt(somenteNumeros(aux.trim()));
            c.setOpcaoSimples(iaux);
        }
        
        tam = 8;
        aux = linha.substring(pos, pos + tam);
        pos += tam;
        if (!"00000000".equals(aux.trim())) {
            try {
                data = SDF_YYYYMMDD.parse(aux);
                c.setDataOpacaoSimples(data);
            } catch (ParseException ex) {
                Logger.getLogger(CadastroParser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        tam = 8;
        aux = linha.substring(pos, pos + tam);
        pos += tam;
        if (!"00000000".equals(aux.trim())) {
            try {
                data = SDF_YYYYMMDD.parse(aux);
                c.setDataExclusaoSimples(data);
            } catch (ParseException ex) {
                Logger.getLogger(CadastroParser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        tam = 1;
        aux = linha.substring(pos, pos + tam);
        pos += tam;
        c.setOpcaoMei("S".equals(aux));
        
        tam = 23;
        aux = linha.substring(pos, pos + tam);
        pos += tam;
        c.setSituacaoEspecial(aux.trim());
        
        tam = 8;
        aux = linha.substring(pos, pos + tam);
        pos += tam;
        
        if (!"".equals(aux.trim()) && !"00000000".equals(aux.trim())) {
            try {
                data = SDF_YYYYMMDD.parse(aux);
                c.setDataSiutacaoEspecial(data);
            } catch (ParseException ex) {
                Logger.getLogger(CadastroParser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return c;
    }
    
    public boolean isNull(String str) {
        return (str == null || str.trim().equals(""));
    }
    
    public String somenteNumeros(String string) {
        return somenteNumeros(string, null);
    }

    public String somenteNumeros(String string, char... ignorados) {
        if (isNull(string)) {
            return string;
        }

        Set<Character> ignoradosSet = new HashSet<>();
        if (ignorados != null) {
            for (char c : ignorados) {
                ignoradosSet.add(c);
            }
        }
        char[] characters = string.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char character : characters) {
            if (ignorados != null) {
                if (ignoradosSet.contains(character)) {
                    sb.append(character);
                }
            }
            if (Character.isDigit(character)) {
                sb.append(character);
            }
        }
        return sb.toString();
    }
}
