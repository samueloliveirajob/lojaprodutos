package br.com.loja.infrastructure.repository.trng.venda.repository;

import java.util.Date;

/**
 * Created by STELO\renato.5a on 9/15/17.
 */
public class VendaExportEntity {


    private Date dataCriacao;
    private String codigoPedidoLoja;
    private Long codigoPedidoStelo;

    public VendaExportEntity() {
    }

    public VendaExportEntity(Date dataCriacao, String codigoPedidoLoja, Long codigoPedidoStelo) {
        this.dataCriacao = dataCriacao;
        this.codigoPedidoLoja = codigoPedidoLoja;
        this.codigoPedidoStelo = codigoPedidoStelo;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getCodigoPedidoLoja() {
        return codigoPedidoLoja;
    }

    public void setCodigoPedidoLoja(String codigoPedidoLoja) {
        this.codigoPedidoLoja = codigoPedidoLoja;
    }

    public Long getCodigoPedidoStelo() {
        return codigoPedidoStelo;
    }

    public void setCodigoPedidoStelo(Long codigoPedidoStelo) {
        this.codigoPedidoStelo = codigoPedidoStelo;
    }
}
