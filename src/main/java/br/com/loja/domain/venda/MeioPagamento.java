package br.com.loja.domain.venda;

public interface MeioPagamento {

    Long codigo();

    String descricao();

    Double valorParcela();

    Integer quantidadeParcelas();

    CartaoCredito cartao();
}
