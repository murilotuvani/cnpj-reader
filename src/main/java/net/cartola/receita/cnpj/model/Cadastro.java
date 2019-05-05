package net.cartola.receita.cnpj.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 24/04/2019 23:05:00
 *
 * @author murilotuvani
 */
public class Cadastro {

    private long cnpj;
    private UnidadeTipo unidadeTipo = UnidadeTipo.MATRIZ;
    private String razaoSocial;
    private String nomeFantasia;
    private SituacaoCadastral situacaoCadastral;
    private Date dataSituacaoCadastral;
    private int motivoSituacaoCadastral;
    private String cidadeExteriorNome;
    private int paisCodigo;
    private String paisNome;
    private int codigoNaturezaJuridica;
    private Date inicioAtividade;
    private int cnae;
    private String tipoLogradouro;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private int cep;
    private String uf;
    private int codigoMunicipio;
    private String municipio;
    private String ddd1;
    private String telefone1;
    private String ddd2;
    private String telefone2;
    private String dddFax;
    private String fax;
    private String correioEletronico;
    private String qualificacaoResponsavel;
    private BigDecimal capitalSocial;
    private String porte;
    private int opcaoSimples;
    private Date dataOpacaoSimples;
    private Date dataExclusaoSimples;
    private boolean opcaoMei;
    private String situacaoEspecial;
    private Date dataSiutacaoEspecial;

    private List<CnaeSecundario> cnaesSecundarios;
    private List<Socio> socios;

    public long getCnpj() {
        return cnpj;
    }

    public void setCnpj(long cnpj) {
        this.cnpj = cnpj;
    }

    public UnidadeTipo getUnidadeTipo() {
        return unidadeTipo;
    }

    public void setUnidadeTipo(UnidadeTipo unidadeTipo) {
        this.unidadeTipo = unidadeTipo;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public SituacaoCadastral getSituacaoCadastral() {
        return situacaoCadastral;
    }

    public void setSituacaoCadastral(SituacaoCadastral situacaoCadastral) {
        this.situacaoCadastral = situacaoCadastral;
    }

    public Date getDataSituacaoCadastral() {
        return dataSituacaoCadastral;
    }

    public void setDataSituacaoCadastral(Date dataSituacaoCadastral) {
        this.dataSituacaoCadastral = dataSituacaoCadastral;
    }

    public int getMotivoSituacaoCadastral() {
        return motivoSituacaoCadastral;
    }

    public void setMotivoSituacaoCadastral(int motivoSituacaoCadastral) {
        this.motivoSituacaoCadastral = motivoSituacaoCadastral;
    }

    public String getCidadeExteriorNome() {
        return cidadeExteriorNome;
    }

    public void setCidadeExteriorNome(String cidadeExteriorNome) {
        this.cidadeExteriorNome = cidadeExteriorNome;
    }

    public int getPaisCodigo() {
        return paisCodigo;
    }

    public void setPaisCodigo(int paisCodigo) {
        this.paisCodigo = paisCodigo;
    }

    public String getPaisNome() {
        return paisNome;
    }

    public void setPaisNome(String paisNome) {
        this.paisNome = paisNome;
    }

    public int getCodigoNaturezaJuridica() {
        return codigoNaturezaJuridica;
    }

    public void setCodigoNaturezaJuridica(int codigoNaturezaJuridica) {
        this.codigoNaturezaJuridica = codigoNaturezaJuridica;
    }

    public Date getInicioAtividade() {
        return inicioAtividade;
    }

    public void setInicioAtividade(Date inicioAtividade) {
        this.inicioAtividade = inicioAtividade;
    }

    public int getCnae() {
        return cnae;
    }

    public void setCnae(int cnae) {
        this.cnae = cnae;
    }

    public String getTipoLogradouro() {
        return tipoLogradouro;
    }

    public void setTipoLogradouro(String tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public int getCodigoMunicipio() {
        return codigoMunicipio;
    }

    public void setCodigoMunicipio(int codigoMunicipio) {
        this.codigoMunicipio = codigoMunicipio;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getDdd1() {
        return ddd1;
    }

    public void setDdd1(String ddd1) {
        this.ddd1 = ddd1;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getDdd2() {
        return ddd2;
    }

    public void setDdd2(String ddd2) {
        this.ddd2 = ddd2;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public String getDddFax() {
        return dddFax;
    }

    public void setDddFax(String dddFax) {
        this.dddFax = dddFax;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getCorreioEletronico() {
        return correioEletronico;
    }

    public void setCorreioEletronico(String correioEletronico) {
        this.correioEletronico = correioEletronico;
    }

    public String getQualificacaoResponsavel() {
        return qualificacaoResponsavel;
    }

    public void setQualificacaoResponsavel(String qualificacaoResponsavel) {
        this.qualificacaoResponsavel = qualificacaoResponsavel;
    }

    public BigDecimal getCapitalSocial() {
        return capitalSocial;
    }

    public void setCapitalSocial(BigDecimal capitalSocial) {
        this.capitalSocial = capitalSocial;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public int getOpcaoSimples() {
        return opcaoSimples;
    }

    public void setOpcaoSimples(int opcaoSimples) {
        this.opcaoSimples = opcaoSimples;
    }

    public Date getDataOpacaoSimples() {
        return dataOpacaoSimples;
    }

    public void setDataOpacaoSimples(Date dataOpacaoSimples) {
        this.dataOpacaoSimples = dataOpacaoSimples;
    }

    public Date getDataExclusaoSimples() {
        return dataExclusaoSimples;
    }

    public void setDataExclusaoSimples(Date dataExclusaoSimples) {
        this.dataExclusaoSimples = dataExclusaoSimples;
    }

    public boolean getOpcaoMei() {
        return opcaoMei;
    }

    public void setOpcaoMei(boolean opcaoMei) {
        this.opcaoMei = opcaoMei;
    }

    public String getSituacaoEspecial() {
        return situacaoEspecial;
    }

    public void setSituacaoEspecial(String situacaoEspecial) {
        this.situacaoEspecial = situacaoEspecial;
    }

    public Date getDataSiutacaoEspecial() {
        return dataSiutacaoEspecial;
    }

    public void setDataSiutacaoEspecial(Date dataSiutacaoEspecial) {
        this.dataSiutacaoEspecial = dataSiutacaoEspecial;
    }

    public List<CnaeSecundario> getCnaesSecundarios() {
        return cnaesSecundarios;
    }

    public void setCnaesSecundarios(List<CnaeSecundario> cnaesSecundarios) {
        this.cnaesSecundarios = cnaesSecundarios;
    }

    public List<Socio> getSocios() {
        return socios;
    }

    public void setSocios(List<Socio> socios) {
        this.socios = socios;
    }

    @Override
    public String toString() {
        return "Cadastro{cnpj=" + cnpj + ", unidadeTipo=" + unidadeTipo + ", razaoSocial=" + razaoSocial + ", nomeFantasia=" + nomeFantasia + ", situacaoCadastral=" + situacaoCadastral + ", dataSituacaoCadastral=" + dataSituacaoCadastral + ", motivoSituacaoCadastral=" + motivoSituacaoCadastral + ", cidadeExteriorNome=" + cidadeExteriorNome + ", paisCodigo=" + paisCodigo + ", paisNome=" + paisNome + ", codigoNaturezaJuridica=" + codigoNaturezaJuridica + ", inicioAtividade=" + inicioAtividade + ", cnae=" + cnae + ", tipoLogradouro=" + tipoLogradouro + ", logradouro=" + logradouro + ", numero=" + numero + ", complemento=" + complemento + ", bairro=" + bairro + ", cep=" + cep + ", uf=" + uf + ", codigoMunicipio=" + codigoMunicipio + ", municipio=" + municipio + ", ddd1=" + ddd1 + ", telefone1=" + telefone1 + ", ddd2=" + ddd2 + ", telefone2=" + telefone2 + ", dddFax=" + dddFax + ", fax=" + fax + '}';
    }

    public boolean addSocio(Socio socio) {
        if (this.socios == null) {
            this.socios = new ArrayList<>();
        }
        return this.socios.add(socio);
    }

    public boolean addCnaeSecundaria(CnaeSecundario cnaeSecundaria) {
        if (this.cnaesSecundarios == null) {
            this.cnaesSecundarios = new ArrayList<>();
        }
        return this.cnaesSecundarios.add(cnaeSecundaria);
    }

}
