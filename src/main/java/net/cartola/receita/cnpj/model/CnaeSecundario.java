package net.cartola.receita.cnpj.model;

import java.io.Serializable;

/**
 * 28/04/2019 16:07:09
 * @author murilotuvani
 */
public class CnaeSecundario implements Serializable {
    
    private long cnpjEmpresa;
    private int cnaeSecundaria;

    public long getCnpjEmpresa() {
        return cnpjEmpresa;
    }

    public void setCnpjEmpresa(long cnpjEmpresa) {
        this.cnpjEmpresa = cnpjEmpresa;
    }

    public int getCnaeSecundaria() {
        return cnaeSecundaria;
    }

    public void setCnaeSecundaria(int cnaeSecundaria) {
        this.cnaeSecundaria = cnaeSecundaria;
    }

    @Override
    public String toString() {
        return "CnaeSecundario{cnpjEmpresa=" + cnpjEmpresa + ", cnaeSecundaria=" + cnaeSecundaria + '}';
    }
    
}
