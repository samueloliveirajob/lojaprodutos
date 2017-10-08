package br.com.loja.domain.loja;

public interface Loja {

    Documento documento();

    String email();

    String razaoSocial();

    Subcategoria subcategoria();

    String nomeFantasia();

    String site();

    String identificacaoFaturaCartao();

    Telefone telefone();

    Endereco endereco();
}
