package br.com.loja.infrastructure.repository.trng.venda.entity;

import br.com.loja.domain.venda.EnderecoEntrega;

public class EnderecoEntregaEntity implements EnderecoEntrega {

    private Integer cep;
    private String cidade;
    private String estado;
    private String pais;
    private String bairro;
    private Integer numero;
    private String logradouro;
    private String complemento;

    @Override
    public Integer cep() {
        return this.cep;
    }

    @Override
    public String cidade() {
        return this.cidade;
    }

    @Override
    public String estado() {
        return this.estado;
    }

    @Override
    public String pais() {
        return this.pais;
    }

    @Override
    public String bairro() {
        return this.bairro;
    }

    @Override
    public Integer numero() {
        return this.numero;
    }

    @Override
    public String logradouro() {
        return this.logradouro;
    }

    @Override
    public String complemento() {
        return this.complemento;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
