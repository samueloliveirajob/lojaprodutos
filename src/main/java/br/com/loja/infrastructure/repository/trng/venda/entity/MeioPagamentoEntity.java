package br.com.loja.infrastructure.repository.trng.venda.entity;

import br.com.loja.domain.venda.MeioPagamento;

public class MeioPagamentoEntity implements MeioPagamento {

    private Long codigo;
    private String descricao;
    private Double valorParcela;
    private Integer quantidadeParcelas;
    private CartaoCreditoEntity cartao;

    @Override
    public Long codigo() {
        return this.codigo;
    }

    @Override
    public String descricao() {
        return this.descricao;
    }

    @Override
    public Double valorParcela() {
        return this.valorParcela;
    }

    @Override
    public Integer quantidadeParcelas() {
        return this.quantidadeParcelas;
    }

    @Override
    public CartaoCreditoEntity cartao() {
        return this.cartao;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setValorParcela(Double valorParcela) {
        this.valorParcela = valorParcela;
    }

    public void setQuantidadeParcelas(Integer quantidadeParcelas) {
        this.quantidadeParcelas = quantidadeParcelas;
    }

    public void setCartao(CartaoCreditoEntity cartao) {
        this.cartao = cartao;
    }
}