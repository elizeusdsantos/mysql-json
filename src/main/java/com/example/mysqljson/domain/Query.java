package com.example.mysqljson.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
}
