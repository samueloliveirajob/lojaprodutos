package br.com.loja.view.endpoint.venda;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.loja.domain.venda.EnderecoEntrega;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnderecoEntregaDTO {

    @JsonProperty("cep")
    private Integer cep;
    @JsonProperty("city")
    private String cidade;
    @JsonProperty("state")
    private String estado;
    @JsonProperty("country")
    private String pais;
    @JsonProperty("district")
    private String bairro;
    @JsonProperty("number")
    private Integer numero;
    @JsonProperty("street")
    private String logradouro;
    @JsonProperty("complement")
    private String complemento;

    public EnderecoEntregaDTO(EnderecoEntrega enderecoEntrega) {
        this.cep = enderecoEntrega.cep();
        this.cidade = enderecoEntrega.cidade();
        this.estado = enderecoEntrega.estado();
        this.pais = enderecoEntrega.pais();
        this.bairro = enderecoEntrega.bairro();
        this.numero = enderecoEntrega.numero();
        this.logradouro = enderecoEntrega.logradouro();
        this.complemento = enderecoEntrega.complemento();
    }

    public Integer getCep() {
        return cep;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getPais() {
        return pais;
    }

    public String getBairro() {
        return bairro;
    }

    public Integer getNumero() {
        return numero;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getComplemento() {
        return complemento;
    }
}
