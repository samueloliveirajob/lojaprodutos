package br.com.loja.infrastructure.repository.trng.venda.mapper;

import org.springframework.jdbc.core.RowMapper;

import br.com.loja.infrastructure.repository.trng.loja.entity.DocumentoEntity;
import br.com.loja.infrastructure.repository.trng.venda.entity.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VendaMapper implements RowMapper<VendaEntity> {

    @Override
    public VendaEntity mapRow(ResultSet resultSet, int i) throws SQLException {

        VendaEntity venda;
        StatusEntity status;
        CanalVendaEntity canal;
        MeioPagamentoEntity pagamento;
        ClienteEntity cliente;

        if (resultSet != null) {

            venda = new VendaEntity();
            venda.setDataCriacao(resultSet.getTimestamp("data_criacao").toLocalDateTime());
            venda.setCodigoPedidoLoja(resultSet.getString("id_pedido_loja"));
            venda.setCodigoPedidoStelo(resultSet.getLong("id_pedido_stelo"));
            venda.setIdTransacao(resultSet.getString("id_transacao"));
            venda.setDoc(resultSet.getString("doc"));

            status = new StatusEntity();
            status.setCodigo(resultSet.getString("codigo_status"));
            venda.setStatus(status);

            venda.setTotal(resultSet.getDouble("valor_total"));

            canal = new CanalVendaEntity();
            canal.setCodigo(resultSet.getString("codigo_canal_origem"));
            venda.setCanal(canal);

            cliente = new ClienteEntity();
            DocumentoEntity documento = new DocumentoEntity();
            documento.setValor(resultSet.getString("numero_documento_comprador"));
            cliente.setDocumento(documento);
            venda.setCliente(cliente);

            pagamento = new MeioPagamentoEntity();
            pagamento.setCodigo(resultSet.getLong("codigo_meio_pagamento"));
            pagamento.setValorParcela(0d);
            pagamento.setQuantidadeParcelas(resultSet.getInt("numero_parcelas"));
            CartaoCreditoEntity cartao;
            if (pagamento.codigo() == 1) {
                cartao = new CartaoCreditoEntity();
                cartao.setNumeroCartao(resultSet.getString("numero_cartao"));
                cartao.setCodigoBandeira(resultSet.getString("codigo_bandeira"));
                pagamento.setCartao(cartao);
            }
            venda.setPagamento(pagamento);
            return venda;
        }
        return null;
    }
}
