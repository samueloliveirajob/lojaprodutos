package br.com.loja.infrastructure.repository.trng.loja.entity;

import br.com.loja.domain.loja.Endereco;

public class EnderecoEntity implements Endereco {

    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String estado;
    private String cidade;

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String cep() {
        return this.cep;
    }

    @Override
    public String logradouro() {
        return this.logradouro;
    }

    @Override
    public String numero() {
        return this.numero;
    }

    @Override
    public String complemento() {
        return this.complemento;
    }

    @Override
    public String bairro() {
        return this.bairro;
    }

    @Override
    public String estado() {
        return this.estado;
    }

    @Override
    public String cidade() {
        return this.cidade;
    }
}
