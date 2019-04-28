package net.cartola.receita.cnpj.parser;

import net.cartola.receita.cnpj.model.CnaeSecundario;

/**
 * 28/04/2019 16:07:22
 * @author murilotuvani
 */
public class CnaeSecundarioParser {

    public CnaeSecundario parse(String linha) {
        CnaeSecundario c = new CnaeSecundario();
        
        int pos = 3;
        int tam = 14;
        String aux = linha.substring(pos, pos + tam);
        pos += tam;
        c.setCnpjEmpresa(Long.parseLong(aux.trim()));
        
        tam = 7;
        aux = linha.substring(pos, pos + tam);
        pos += tam;
        int cnaeSecundaria = Integer.parseInt(aux);
        c.setCnaeSecundaria(cnaeSecundaria);
        
        return c;
    }
}
