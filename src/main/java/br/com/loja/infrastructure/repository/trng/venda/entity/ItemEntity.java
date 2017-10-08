package br.com.loja.infrastructure.repository.trng.venda.entity;

import br.com.loja.domain.venda.Item;

public class ItemEntity implements Item {

    private ProdutoEntity produto;
    private Integer quantidade;

    @Override
    public ProdutoEntity produto() {
        return this.produto;
    }

    @Override
    public Integer quantidade() {
        return this.quantidade;
    }

    public void setProduto(ProdutoEntity produto) {
        this.produto = produto;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
