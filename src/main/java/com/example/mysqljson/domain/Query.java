package com.example.mysqljson.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Query {

    private List<String> capitalSocial;
    private List<String> matrizFilial;
    private List<String> qsaNome;
    private List<String> codIbge;
    private List<String> estado;
    private List<String> cidade;
    private List<String> cep;
    private List<String> bairro;
    private List<String> endereco;
    private List<String> razaoSocial;
    private List<String> nomeFantasia;
    private List<String> naturezaJuridica;
    private List<String> cnae;
    private List<String> cnaePrincipal;
    private List<String> cnaeSecundario;
    private List<String> tipoAtividade;
    private List<String> situacaoCadastral;

    public List<String> getCapitalSocial() {
        return capitalSocial;
    }

    public Query setCapitalSocial(List<String> capitalSocial) {
        this.capitalSocial = capitalSocial;
        return this;
    }

    public List<String> getMatrizFilial() {
        return matrizFilial;
    }

    public Query setMatrizFilial(List<String> matrizFilial) {
        this.matrizFilial = matrizFilial;
        return this;
    }

    public List<String> getQsaNome() {
        return qsaNome;
    }

    public Query setQsaNome(List<String> qsaNome) {
        this.qsaNome = qsaNome;
        return this;
    }

    public List<String> getCodIbge() {
        return codIbge;
    }

    public Query setCodIbge(List<String> codIbge) {
        this.codIbge = codIbge;
        return this;
    }

    public List<String> getEstado() {
        return estado;
    }

    public Query setEstado(List<String> estado) {
        this.estado = estado;
        return this;
    }

    public List<String> getCidade() {
        return cidade;
    }

    public Query setCidade(List<String> cidade) {
        this.cidade = cidade;
        return this;
    }

    public List<String> getCep() {
        return cep;
    }

    public Query setCep(List<String> cep) {
        this.cep = cep;
        return this;
    }

    public List<String> getBairro() {
        return bairro;
    }

    public Query setBairro(List<String> bairro) {
        this.bairro = bairro;
        return this;
    }

    public List<String> getEndereco() {
        return endereco;
    }

    public Query setEndereco(List<String> endereco) {
        this.endereco = endereco;
        return this;
    }

    public List<String> getRazaoSocial() {
        return razaoSocial;
    }

    public Query setRazaoSocial(List<String> razaoSocial) {
        this.razaoSocial = razaoSocial;
        return this;
    }

    public List<String> getNomeFantasia() {
        return nomeFantasia;
    }

    public Query setNomeFantasia(List<String> nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
        return this;
    }

    public List<String> getNaturezaJuridica() {
        return naturezaJuridica;
    }

    public Query setNaturezaJuridica(List<String> naturezaJuridica) {
        this.naturezaJuridica = naturezaJuridica;
        return this;
    }

    public List<String> getCnae() {
        return cnae;
    }

    public Query setCnae(List<String> cnae) {
        this.cnae = cnae;
        return this;
    }

    public List<String> getCnaePrincipal() {
        return cnaePrincipal;
    }

    public Query setCnaePrincipal(List<String> cnaePrincipal) {
        this.cnaePrincipal = cnaePrincipal;
        return this;
    }

    public List<String> getCnaeSecundario() {
        return cnaeSecundario;
    }

    public Query setCnaeSecundario(List<String> cnaeSecundario) {
        this.cnaeSecundario = cnaeSecundario;
        return this;
    }

    public List<String> getTipoAtividade() {
        return tipoAtividade;
    }

    public Query setTipoAtividade(List<String> tipoAtividade) {
        this.tipoAtividade = tipoAtividade;
        return this;
    }

    public List<String> getSituacaoCadastral() {
        return situacaoCadastral;
    }

    public Query setSituacaoCadastral(List<String> situacaoCadastral) {
        this.situacaoCadastral = situacaoCadastral;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Query query = (Query) o;
        return Objects.equals(capitalSocial, query.capitalSocial) &&
                Objects.equals(matrizFilial, query.matrizFilial) &&
                Objects.equals(qsaNome, query.qsaNome) &&
                Objects.equals(codIbge, query.codIbge) &&
                Objects.equals(estado, query.estado) &&
                Objects.equals(cidade, query.cidade) &&
                Objects.equals(cep, query.cep) &&
                Objects.equals(bairro, query.bairro) &&
                Objects.equals(endereco, query.endereco) &&
                Objects.equals(razaoSocial, query.razaoSocial) &&
                Objects.equals(nomeFantasia, query.nomeFantasia) &&
                Objects.equals(naturezaJuridica, query.naturezaJuridica) &&
                Objects.equals(cnae, query.cnae) &&
                Objects.equals(cnaePrincipal, query.cnaePrincipal) &&
                Objects.equals(cnaeSecundario, query.cnaeSecundario) &&
                Objects.equals(tipoAtividade, query.tipoAtividade) &&
                Objects.equals(situacaoCadastral, query.situacaoCadastral);
    }

    @Override
    public int hashCode() {
        return Objects.hash(capitalSocial, matrizFilial, qsaNome, codIbge, estado, cidade, cep, bairro, endereco,
                razaoSocial, nomeFantasia, naturezaJuridica, cnae, cnaePrincipal, cnaeSecundario, tipoAtividade,
                situacaoCadastral);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Query.class.getSimpleName() + "[", "]")
                .add("capitalSocial=" + capitalSocial)
                .add("matrizFilial=" + matrizFilial)
                .add("qsaNome=" + qsaNome)
                .add("codIbge=" + codIbge)
                .add("estado=" + estado)
                .add("cidade=" + cidade)
                .add("cep=" + cep)
                .add("bairro=" + bairro)
                .add("endereco=" + endereco)
                .add("razaoSocial=" + razaoSocial)
                .add("nomeFantasia=" + nomeFantasia)
                .add("naturezaJuridica=" + naturezaJuridica)
                .add("cnae=" + cnae)
                .add("cnaePrincipal=" + cnaePrincipal)
                .add("cnaeSecundario=" + cnaeSecundario)
                .add("tipoAtividade=" + tipoAtividade)
                .add("situacaoCadastral=" + situacaoCadastral)
                .toString();
    }
}
