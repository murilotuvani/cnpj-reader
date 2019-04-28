package net.cartola.receita.cnpj.model;

import java.util.Date;

/**
 * 28/04/2019 15:33:12
 *
 * @author murilotuvani
 */
public class Socio {

    private long cnpjEmpresa;
    private SocioIdentificador identificador;
    private String nome;
    private String cpfCnpjSocio;
    private String codigoQualificacaoSocio;
    private double percentualCapitalSocial;
    private Date dataEntrada;
    private String codigoPais;
    private String nomePais;
    private String cpfRepresentanteLegal;
    private String nomeRepresentanteLegal;
    private String codigoQualificacaoRepresentanteLegal;

    public long getCnpjEmpresa() {
        return cnpjEmpresa;
    }

    public void setCnpjEmpresa(long cnpjEmpresa) {
        this.cnpjEmpresa = cnpjEmpresa;
    }

    public SocioIdentificador getIdentificador() {
        return identificador;
    }

    public void setIdentificador(SocioIdentificador identificador) {
        this.identificador = identificador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpfCnpjSocio() {
        return cpfCnpjSocio;
    }

    public void setCpfCnpjSocio(String cpfCnpjSocio) {
        this.cpfCnpjSocio = cpfCnpjSocio;
    }

    public String getCodigoQualificacaoSocio() {
        return codigoQualificacaoSocio;
    }

    public void setCodigoQualificacaoSocio(String codigoQualificacaoSocio) {
        this.codigoQualificacaoSocio = codigoQualificacaoSocio;
    }

    public double getPercentualCapitalSocial() {
        return percentualCapitalSocial;
    }

    public void setPercentualCapitalSocial(double percentualCapitalSocial) {
        this.percentualCapitalSocial = percentualCapitalSocial;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public String getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }

    public String getNomePais() {
        return nomePais;
    }

    public void setNomePais(String nomePais) {
        this.nomePais = nomePais;
    }

    public String getCpfRepresentanteLegal() {
        return cpfRepresentanteLegal;
    }

    public void setCpfRepresentanteLegal(String cpfRepresentanteLegal) {
        this.cpfRepresentanteLegal = cpfRepresentanteLegal;
    }

    public String getNomeRepresentanteLegal() {
        return nomeRepresentanteLegal;
    }

    public void setNomeRepresentanteLegal(String nomeRepresentanteLegal) {
        this.nomeRepresentanteLegal = nomeRepresentanteLegal;
    }

    public String getCodigoQualificacaoRepresentanteLegal() {
        return codigoQualificacaoRepresentanteLegal;
    }

    public void setCodigoQualificacaoRepresentanteLegal(String codigoQualificacaoRepresentanteLegal) {
        this.codigoQualificacaoRepresentanteLegal = codigoQualificacaoRepresentanteLegal;
    }

    @Override
    public String toString() {
        return "Socio{" + "cnpjEmpresa=" + cnpjEmpresa + ", identificador=" + identificador + ", nome=" + nome + ", cpfCnpjSocio=" + cpfCnpjSocio + ", codigoQualificacaoSocio=" + codigoQualificacaoSocio + ", percentualCapitalSocial=" + percentualCapitalSocial + ", dataEntrada=" + dataEntrada + ", codigoPais=" + codigoPais + ", nomePais=" + nomePais + ", cpfRepresentanteLegal=" + cpfRepresentanteLegal + ", nomeRepresentanteLegal=" + nomeRepresentanteLegal + ", codigoQualificacaoRepresentanteLegal=" + codigoQualificacaoRepresentanteLegal + '}';
    }

}
