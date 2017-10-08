package br.com.loja.view.endpoint.loja;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.loja.domain.loja.Endereco;

public class EnderecoDTO {

    @JsonProperty("cep")
    private String cep;
    @JsonProperty("street")
    private String logradouro;
    @JsonProperty("number")
    private String numero;
    @JsonProperty("complemento")
    private String complemento;
    @JsonProperty("district")
    private String bairro;
    @JsonProperty("state")
    private String estado;
    @JsonProperty("city")
    private String cidade;

    public EnderecoDTO(Endereco endereco) {
        this.cep = endereco.cep();
        this.logradouro = endereco.logradouro();
        this.numero = endereco.numero();
        this.complemento = endereco.complemento();
        this.bairro = endereco.bairro();
        this.estado = endereco.estado();
        this.cidade = endereco.cidade();
    }

    public String getCep() {
        return cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getEstado() {
        return estado;
    }

    public String getCidade() {
        return cidade;
    }
}
