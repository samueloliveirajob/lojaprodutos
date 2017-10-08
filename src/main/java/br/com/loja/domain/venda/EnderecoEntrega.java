package br.com.loja.domain.venda;

public interface EnderecoEntrega {

    Integer cep();

    String cidade();

    String estado();

    String pais();

    String bairro();

    Integer numero();

    String logradouro();

    String complemento();
}
