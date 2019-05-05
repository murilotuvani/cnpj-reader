package net.cartola.receita.cnpj.serializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import net.cartola.receita.cnpj.model.Cadastro;

/**
 * 05/05/2019 09:50:00
 * @author murilotuvani
 */
public class CnpjSerializer {
    
    private static final Gson GSON = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd")
            .setPrettyPrinting().create();
    
    
        
    public String toJson(Cadastro cadastro) {
        String json = GSON.toJson(cadastro);
        return json;
    }
    
    public String toJson(List<Cadastro> cadastros) {
        String json = GSON.toJson(cadastros);
        return json;
    }

}
