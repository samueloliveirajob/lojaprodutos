package br.com.loja.infrastructure.repository.trng.venda.entity;

import br.com.loja.domain.venda.CartaoCredito;

public class CartaoCreditoEntity implements CartaoCredito {

    private String codigoBandeira;
    private String descricaoBandeira;
    private String numeroCartao;

    @Override
    public String codigoBandeira() {
        return this.codigoBandeira;
    }

    @Override
    public String descricaoBandeira() {
        return this.descricaoBandeira;
    }

    @Override
    public String numeroCartao() {
        return this.numeroCartao;
    }

    public void setCodigoBandeira(String codigoBandeira) {
        this.codigoBandeira = codigoBandeira;
    }

    public void setDescricaoBandeira(String descricaoBandeira) {
        this.descricaoBandeira = descricaoBandeira;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }
}
