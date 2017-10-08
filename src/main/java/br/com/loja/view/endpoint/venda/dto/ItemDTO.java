package br.com.loja.view.endpoint.venda.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.loja.domain.venda.Item;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ItemDTO {

    @JsonProperty("product")
    private ProdutoDTO produto;
    @JsonProperty("amount")
    private Integer quantidade;

    public ItemDTO(Item item) {
        this.produto = new ProdutoDTO(item.produto());
        this.quantidade = item.quantidade();
    }

    public ProdutoDTO getProduto() {
        return produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }
}
