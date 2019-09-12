package net.cartola.receita.cnpj.serializer;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import net.cartola.receita.cnpj.model.Cadastro;
import net.cartola.receita.cnpj.model.CnaeSecundario;
import net.cartola.receita.cnpj.model.Socio;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author murilotuvani
 */
public class CnpjSerializerTest {

    public CnpjSerializerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of toJson method, of class CnpjSerializer.
     */
    @Test
    public void testToJson() throws ParseException {
        System.out.println("toJson");
        Cadastro cadastro = new Cadastro();
        cadastro.setCnpj(999999999000199L);
        cadastro.setCnae(1234567);
        cadastro.setRazaoSocial("ACME Industries S/A");
        cadastro.setNomeFantasia("ACME");
        cadastro.setMunicipio("São Paulo");
        cadastro.setUf("SP");
        cadastro.setCapitalSocial(new BigDecimal(250000000));

        CnaeSecundario cs = new CnaeSecundario();
        cs.setCnpjEmpresa(cadastro.getCnpj());
        cs.setCnaeSecundaria(7654321);
        List<CnaeSecundario> csl = new ArrayList<>();
        csl.add(cs);
        cadastro.setCnaesSecundarios(csl);

        Socio s = new Socio();
        s.setNome("Pernalonga");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = sdf.parse("05/02/1930");
        s.setDataEntrada(date);

        List<Socio> socios = new ArrayList<>();
        socios.add(s);

        s = new Socio();
        s.setNome("Gaguinho");
        s.setDataEntrada(date);
        socios.add(s);
        cadastro.setSocios(socios);

        CnpjSerializer instance = new CnpjSerializer();
        String expResult = "{\n"
                + "  \"cnpj\": 999999999000199,\n"
                + "  \"unidadeTipo\": \"MATRIZ\",\n"
                + "  \"razaoSocial\": \"ACME Industries S/A\",\n"
                + "  \"nomeFantasia\": \"ACME\",\n"
                + "  \"motivoSituacaoCadastral\": 0,\n"
                + "  \"paisCodigo\": 0,\n"
                + "  \"codigoNaturezaJuridica\": 0,\n"
                + "  \"cnae\": 1234567,\n"
                + "  \"cep\": 0,\n"
                + "  \"uf\": \"SP\",\n"
                + "  \"codigoMunicipio\": 0,\n"
                + "  \"municipio\": \"São Paulo\",\n"
                + "  \"capitalSocial\": 250000000,\n"
                + "  \"opcaoSimples\": 0,\n"
                + "  \"opcaoMei\": false,\n"
                + "  \"cnaesSecundarios\": [\n"
                + "    {\n"
                + "      \"cnpjEmpresa\": 999999999000199,\n"
                + "      \"cnaeSecundaria\": 7654321\n"
                + "    }\n"
                + "  ],\n"
                + "  \"socios\": [\n"
                + "    {\n"
                + "      \"cnpjEmpresa\": 0,\n"
                + "      \"nome\": \"Pernalonga\",\n"
                + "      \"percentualCapitalSocial\": 0.0,\n"
                + "      \"dataEntrada\": \"1930-02-05\"\n"
                + "    },\n"
                + "    {\n"
                + "      \"cnpjEmpresa\": 0,\n"
                + "      \"nome\": \"Gaguinho\",\n"
                + "      \"percentualCapitalSocial\": 0.0,\n"
                + "      \"dataEntrada\": \"1930-02-05\"\n"
                + "    }\n"
                + "  ]\n"
                + "}";
        String result = instance.toJson(cadastro);
        System.out.println(result);
        assertEquals(expResult, result);
    }

}
