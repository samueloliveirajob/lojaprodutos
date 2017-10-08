package br.com.loja.view.endpoint.venda;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.loja.domain.venda.Produto;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProdutoDTO {

    @JsonProperty("name")
    private String nome;
    @JsonProperty("price")
    private Double valor;

    public ProdutoDTO(Produto produto) {
        this.nome = produto.nome();
        this.valor = produto.valor();
    }

    public String getNome() {
        return nome;
    }

    public Double getValor() {
        return valor;
    }
}
