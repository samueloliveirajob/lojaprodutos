package br.com.loja.infrastructure.repository.trng.venda.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.loja.domain.venda.VendaFilters;
import br.com.loja.domain.venda.VendaNotFound;
import br.com.loja.infrastructure.repository.trng.GenericTRNGJdbcDAO;
import br.com.loja.infrastructure.repository.trng.venda.entity.VendaEntity;
import br.com.loja.infrastructure.repository.trng.venda.mapper.OrdersDetailsMapper;
import br.com.loja.infrastructure.repository.trng.venda.mapper.VendaMapper;
import br.com.loja.view.endpoint.venda.OrderDetailDTO;

@Repository
public class VendaRepositoryImpl extends GenericTRNGJdbcDAO implements VendaRepository {

    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    @PersistenceContext(unitName = "trng")
    private EntityManager entityManager;

    public Stream<Object[]> streamBy(Long idStelo, VendaFilters filters) {
        Map<String, Object> parameters = new HashMap<>();
        StringBuilder sql = new StringBuilder();
        Session session = entityManager.unwrap(Session.class);
        sql.append(" SELECT * FROM ( ");
        sql.append("       SELECT ");
        sql.append("           VENDA.DT_INCL_VDA AS DATA_CRIACAO, ");
        sql.append("           VENDA.CD_PDIDO_ESTBL_COML AS ID_PEDIDO_LOJA, ");
        sql.append("           VENDA.CD_PDIDO AS ID_PEDIDO_STELO, ");
        sql.append("           PEDIDO.ID_TRANS_CANAL AS ID_TRANSACAO, ");
        sql.append("           PEDIDO.CD_STTUS_PDIDO AS CODIGO_STATUS, ");
        sql.append("           VENDA.VR_TOT_VDA AS VALOR_TOTAL, ");
        sql.append("           PEDIDO.CD_ORIGEM_PRODUTO AS CODIGO_CANAL_ORIGEM, ");
        sql.append("           PEDIDO.NU_DCTO_COMPR AS NUMERO_DOCUMENTO_COMPRADOR, ");
        sql.append("           null AS NOME_DOCUMENTO_COMPRADOR, ");
        sql.append("           null AS EMAIL_DOCUMENTO_COMPRADOR, ");
        sql.append("           PAGAMENTO.NU_TARGET AS NUMERO_CARTAO, ");
        sql.append("           PAGAMENTO.CD_TPO_PGTO AS CODIGO_MEIO_PAGAMENTO,");
        sql.append("           PAGAMENTO.CD_PPRIE AS CODIGO_BANDEIRA,");
        sql.append("           PAGAMENTO.NU_PCELA AS NUMERO_PARCELAS,");
        sql.append("           null AS MOTIV_RECUSA,");
        sql.append("           null AS CHARGEBACK_DISPUTA,");
        sql.append("           null AS DT_CHARGEBACK_DISPUTA,");
        sql.append("           null AS STATUS_CHARGEBACK_DISPUTA,");
        sql.append("           null AS NU_TERMINAL, ");
        sql.append("           PEDIDO.NU_NSU_STELO AS DOC                 ");
        sql.append("       FROM ");
        sql.append("           USR_GEPD.TB_VDA VENDA INNER JOIN USR_GEPD.TB_PDIDO PEDIDO ON  VENDA.CD_PDIDO = PEDIDO.CD_PDIDO ");
        sql.append("           AND VENDA.CD_VDDOR = PEDIDO.CD_VDDOR_ROOT_PDIDO INNER JOIN USR_GEPD.TB_PGTO PAGAMENTO ON PEDIDO.CD_PDIDO = PAGAMENTO.CD_PDIDO ");
        sql.append("       WHERE ");
        sql.append("           VENDA.CD_VDDOR = :idStelo ");
        insertFilters(filters, parameters, sql);
        sql.append("       ORDER BY VENDA.CD_PDIDO DESC ");
        sql.append("       ) INDICE WHERE  ROWNUM <= :quantity ");
        parameters.put("idStelo", idStelo);
        NativeQuery nativeQuery = session.createNativeQuery(sql.toString());
        parameters.entrySet().stream().forEach(param -> nativeQuery.setParameter(param.getKey(), param.getValue()));
        Stream<Object[]> stream = nativeQuery.stream();
        return stream;
    }

    @Override
    @Transactional("transactionManager")
    public Stream streamAll() {
        Session session = entityManager.unwrap(Session.class);
        Stream stream = session.createSQLQuery("\n" +
                "     SELECT \n" +
                "         VENDA.DT_INCL_VDA AS dataCriacao, \n" +
                "         VENDA.CD_PDIDO_ESTBL_COML AS codigoPedidoLoja, \n" +
                "         VENDA.CD_PDIDO AS codigoPedidoStelo \n"+
                "     FROM \n" +
                "         USR_GEPD.TB_VDA VENDA ").stream();
        return stream;
    }

    @Override
    public List<VendaEntity> listFirst(Long idStelo, Long quantity, VendaFilters filters) {
        Map<String, Object> parameters = new HashMap<>();
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT * FROM ( ");
        sql.append("     SELECT ");
        sql.append("         VENDA.DT_INCL_VDA AS DATA_CRIACAO, ");
        sql.append("         VENDA.CD_PDIDO_ESTBL_COML AS ID_PEDIDO_LOJA, ");
        sql.append("         VENDA.CD_PDIDO AS ID_PEDIDO_STELO, ");
        sql.append("         PEDIDO.ID_TRANS_CANAL AS ID_TRANSACAO, ");
        sql.append("         PEDIDO.NU_NSU_STELO AS DOC, ");
        sql.append("         PEDIDO.CD_STTUS_PDIDO AS CODIGO_STATUS, ");
        sql.append("         VENDA.VR_TOT_VDA AS VALOR_TOTAL, ");
        sql.append("         PEDIDO.CD_ORIGEM_PRODUTO AS CODIGO_CANAL_ORIGEM, ");
        sql.append("         PEDIDO.NU_DCTO_COMPR AS NUMERO_DOCUMENTO_COMPRADOR, ");
        sql.append("         PAGAMENTO.CD_TPO_PGTO AS CODIGO_MEIO_PAGAMENTO, ");
        sql.append("         PAGAMENTO.NU_PCELA AS NUMERO_PARCELAS, ");
        sql.append("         PAGAMENTO.NU_TARGET AS NUMERO_CARTAO, ");
        sql.append("         PAGAMENTO.CD_PPRIE AS CODIGO_BANDEIRA ");
        sql.append("     FROM ");
        sql.append("         USR_GEPD.TB_VDA VENDA INNER JOIN USR_GEPD.TB_PDIDO PEDIDO ON  VENDA.CD_PDIDO = PEDIDO.CD_PDIDO ");
        sql.append("         AND VENDA.CD_VDDOR = PEDIDO.CD_VDDOR_ROOT_PDIDO INNER JOIN USR_GEPD.TB_PGTO PAGAMENTO ON PEDIDO.CD_PDIDO = PAGAMENTO.CD_PDIDO ");
        sql.append("     WHERE ");
        sql.append("         VENDA.CD_VDDOR = :idStelo ");
        insertFilters(filters, parameters, sql);
        sql.append("     ORDER BY VENDA.CD_PDIDO DESC ");
        sql.append("     ) INDICE WHERE  ROWNUM <= :quantity ");

        parameters.put("idStelo", idStelo);
        parameters.put("quantity", quantity);

        return namedParameterJdbcTemplate.query(sql.toString(), parameters, new VendaMapper());
    }

    @Override
    public List<VendaEntity> listNext(Long idStelo, Long cdPdido, Long quantity, VendaFilters filters) {
        Map<String, Object> parameters = new HashMap<>();
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT * FROM ( ");
        sql.append("     SELECT ");
        sql.append("         VENDA.DT_INCL_VDA AS DATA_CRIACAO, ");
        sql.append("         VENDA.CD_PDIDO_ESTBL_COML AS ID_PEDIDO_LOJA, ");
        sql.append("         VENDA.CD_PDIDO AS ID_PEDIDO_STELO, ");
        sql.append("         PEDIDO.ID_TRANS_CANAL AS ID_TRANSACAO, ");
        sql.append("         PEDIDO.NU_NSU_STELO AS DOC, ");
        sql.append("         PEDIDO.CD_STTUS_PDIDO AS CODIGO_STATUS, ");
        sql.append("         VENDA.VR_TOT_VDA AS VALOR_TOTAL, ");
        sql.append("         PEDIDO.CD_ORIGEM_PRODUTO AS CODIGO_CANAL_ORIGEM, ");
        sql.append("         PEDIDO.NU_DCTO_COMPR AS NUMERO_DOCUMENTO_COMPRADOR, ");
        sql.append("         PAGAMENTO.CD_TPO_PGTO AS CODIGO_MEIO_PAGAMENTO, ");
        sql.append("         PAGAMENTO.NU_PCELA AS NUMERO_PARCELAS, ");
        sql.append("         PAGAMENTO.NU_TARGET AS NUMERO_CARTAO, ");
        sql.append("         PAGAMENTO.CD_PPRIE AS CODIGO_BANDEIRA ");
        sql.append("     FROM ");
        sql.append("         USR_GEPD.TB_VDA VENDA INNER JOIN USR_GEPD.TB_PDIDO PEDIDO ON  VENDA.CD_PDIDO = PEDIDO.CD_PDIDO ");
        sql.append("         AND VENDA.CD_VDDOR = PEDIDO.CD_VDDOR_ROOT_PDIDO INNER JOIN USR_GEPD.TB_PGTO PAGAMENTO ON PEDIDO.CD_PDIDO = PAGAMENTO.CD_PDIDO ");
        sql.append("     WHERE ");
        sql.append("         VENDA.CD_VDDOR = :idStelo ");
        insertFilters(filters, parameters, sql);
        sql.append("         AND VENDA.CD_PDIDO < :cdPdido ");
        sql.append("     ORDER BY VENDA.CD_PDIDO DESC ");
        sql.append("     ) INDICE WHERE  ROWNUM <= :quantity ");

        parameters.put("idStelo", idStelo);
        parameters.put("cdPdido", cdPdido);
        parameters.put("quantity", quantity);

        return namedParameterJdbcTemplate.query(sql.toString(), parameters, new VendaMapper());
    }

    @Override
    public List<VendaEntity> listPrevious(Long idStelo, Long cdPdido, Long quantity, VendaFilters filters) {
        Map<String, Object> parameters = new HashMap<>();
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT * FROM ( ");
        sql.append("     SELECT ");
        sql.append("         VENDA.DT_INCL_VDA AS DATA_CRIACAO, ");
        sql.append("         VENDA.CD_PDIDO_ESTBL_COML AS ID_PEDIDO_LOJA, ");
        sql.append("         VENDA.CD_PDIDO AS ID_PEDIDO_STELO, ");
        sql.append("         PEDIDO.ID_TRANS_CANAL AS ID_TRANSACAO, ");
        sql.append("         PEDIDO.NU_NSU_STELO AS DOC, ");
        sql.append("         PEDIDO.CD_STTUS_PDIDO AS CODIGO_STATUS, ");
        sql.append("         VENDA.VR_TOT_VDA AS VALOR_TOTAL, ");
        sql.append("         PEDIDO.CD_ORIGEM_PRODUTO AS CODIGO_CANAL_ORIGEM, ");
        sql.append("         PEDIDO.NU_DCTO_COMPR AS NUMERO_DOCUMENTO_COMPRADOR, ");
        sql.append("         PAGAMENTO.CD_TPO_PGTO AS CODIGO_MEIO_PAGAMENTO, ");
        sql.append("         PAGAMENTO.NU_PCELA AS NUMERO_PARCELAS, ");
        sql.append("         PAGAMENTO.NU_TARGET AS NUMERO_CARTAO, ");
        sql.append("         PAGAMENTO.CD_PPRIE AS CODIGO_BANDEIRA ");
        sql.append("     FROM");
        sql.append("         USR_GEPD.TB_VDA VENDA INNER JOIN USR_GEPD.TB_PDIDO PEDIDO ON  VENDA.CD_PDIDO = PEDIDO.CD_PDIDO ");
        sql.append("         AND VENDA.CD_VDDOR = PEDIDO.CD_VDDOR_ROOT_PDIDO INNER JOIN USR_GEPD.TB_PGTO PAGAMENTO ON PEDIDO.CD_PDIDO = PAGAMENTO.CD_PDIDO ");
        sql.append("     WHERE");
        sql.append("         VENDA.CD_VDDOR = :idStelo ");
        insertFilters(filters, parameters, sql);
        sql.append("         AND VENDA.CD_PDIDO > :cdPdido ");
        sql.append("     ORDER BY VENDA.CD_PDIDO ASC ");
        sql.append("     ) INDICE WHERE  ROWNUM <= :quantity ");
        sql.append(" ORDER BY INDICE.ID_PEDIDO_STELO DESC ");

        parameters.put("idStelo", idStelo);
        parameters.put("cdPdido", cdPdido);
        parameters.put("quantity", quantity);

        return namedParameterJdbcTemplate.query(sql.toString(), parameters, new VendaMapper());
    }

    @Override
    public List<VendaEntity> listLast(Long idStelo, Long quantity, VendaFilters filters) {
        Map<String, Object> parameters = new HashMap<>();
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT * FROM (");
        sql.append("     SELECT");
        sql.append("         VENDA.DT_INCL_VDA AS DATA_CRIACAO,");
        sql.append("         VENDA.CD_PDIDO_ESTBL_COML AS ID_PEDIDO_LOJA,");
        sql.append("         VENDA.CD_PDIDO AS ID_PEDIDO_STELO,");
        sql.append("         PEDIDO.ID_TRANS_CANAL AS ID_TRANSACAO,");
        sql.append("         PEDIDO.NU_NSU_STELO AS DOC,");
        sql.append("         PEDIDO.CD_STTUS_PDIDO AS CODIGO_STATUS,");
        sql.append("         VENDA.VR_TOT_VDA AS VALOR_TOTAL,");
        sql.append("         PEDIDO.CD_ORIGEM_PRODUTO AS CODIGO_CANAL_ORIGEM,");
        sql.append("         PEDIDO.NU_DCTO_COMPR AS NUMERO_DOCUMENTO_COMPRADOR,");
        sql.append("         PAGAMENTO.CD_TPO_PGTO AS CODIGO_MEIO_PAGAMENTO,");
        sql.append("         PAGAMENTO.NU_PCELA AS NUMERO_PARCELAS,");
        sql.append("         PAGAMENTO.NU_TARGET AS NUMERO_CARTAO,");
        sql.append("         PAGAMENTO.CD_PPRIE AS CODIGO_BANDEIRA");
        sql.append("     FROM");
        sql.append("         USR_GEPD.TB_VDA VENDA INNER JOIN USR_GEPD.TB_PDIDO PEDIDO ON  VENDA.CD_PDIDO = PEDIDO.CD_PDIDO");
        sql.append("         AND VENDA.CD_VDDOR = PEDIDO.CD_VDDOR_ROOT_PDIDO INNER JOIN USR_GEPD.TB_PGTO PAGAMENTO ON PEDIDO.CD_PDIDO = PAGAMENTO.CD_PDIDO");
        sql.append("     WHERE");
        sql.append("         VENDA.CD_VDDOR = :idStelo");
        insertFilters(filters, parameters, sql);
        sql.append("     ORDER BY VENDA.CD_PDIDO ASC");
        sql.append("     ) INDICE WHERE  ROWNUM <= :quantity");
        sql.append(" ORDER BY INDICE.ID_PEDIDO_STELO DESC");

        parameters.put("idStelo", idStelo);
        parameters.put("quantity", quantity);

        return namedParameterJdbcTemplate.query(sql.toString(), parameters, new VendaMapper());
    }

    @Override
    public VendaEntity findVenda(Long sellerId, Long id) {
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT * FROM  ( SELECT ROWNUM AS indice, vendas.* ");
        sql.append(" FROM ( SELECT ");
        sql.append("            venda.dt_incl_vda AS data_criacao, ");
        sql.append("            venda.cd_pdido_estbl_coml AS id_pedido_loja, ");
        sql.append("            venda.cd_pdido AS id_pedido_stelo, ");
        sql.append("            pedido.id_trans_canal AS id_transacao, ");
        sql.append("            pedido.nu_nsu_stelo AS doc, ");
        sql.append("            pedido.cd_sttus_pdido AS codigo_status, ");
        sql.append("            venda.vr_tot_vda AS valor_total, ");
        sql.append("            pedido.cd_origem_produto AS codigo_canal_origem, ");
        sql.append("            pedido.nu_dcto_compr AS numero_documento_comprador, ");
        sql.append("            pagamento.cd_tpo_pgto AS codigo_meio_pagamento, ");
        sql.append("            pagamento.nu_pcela AS numero_parcelas, ");
        sql.append("            pagamento.nu_target AS numero_cartao, ");
        sql.append("            pagamento.cd_pprie AS codigo_bandeira ");
        sql.append("        FROM usr_gepd.tb_vda venda ");
        sql.append("            INNER JOIN usr_gepd.tb_pdido pedido ON venda.cd_pdido = pedido.cd_pdido ");
        sql.append("            AND venda.cd_vddor = pedido.cd_vddor_root_pdido ");
        sql.append("            INNER JOIN usr_gepd.tb_pgto pagamento ON pedido.cd_pdido = pagamento.cd_pdido ");
        sql.append("        WHERE venda.cd_vddor =:seller_id ");
        sql.append("        ORDER BY venda.cd_pdido DESC ) vendas ) vendas_indice ");
        sql.append(" WHERE  vendas_indice.id_pedido_stelo =:id ");
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("seller_id", sellerId);
        parameters.put("id", id);
        VendaEntity entity = null;
        try {
            entity = namedParameterJdbcTemplate.queryForObject(sql.toString(), parameters, new VendaMapper());
        } catch (DataAccessException e) {
            LOGGER.warn("Não foram encontrados registros para a query");
        }
        return entity;
    }

    private void insertFilters(VendaFilters filters, Map<String, Object> parameters, StringBuilder sql) {
        if (filters.hasCustomerDoc()) {
            sql.append("         AND PEDIDO.NU_DCTO_COMPR IN(:customerDoc) ");
            parameters.put("customerDoc", filters.getCustomerDoc());
        }
        if (filters.hasTransactionID()) {
            sql.append("         AND PEDIDO.ID_TRANS_CANAL IN(:transactionId) ");
            parameters.put("transactionId", filters.getTransactionID());
        }
        if (filters.hasOrderStoreID()) {
            sql.append("         AND VENDA.CD_PDIDO_ESTBL_COML IN(:orderStoreId) ");
            parameters.put("orderStoreId", filters.getOrderStoreID());
        }
        if (filters.hasOrderSteloID()) {
            sql.append("         AND VENDA.CD_PDIDO IN(:orderSteloId) ");
            parameters.put("orderSteloId", filters.getOrderSteloID());
        }
        if (filters.hasDoc()) {
            sql.append("         AND PEDIDO.NU_NSU_STELO IN(:doc) ");
            parameters.put("doc", filters.getDoc());
        }
        if (filters.hasLastFourDigitsCC()) {
            sql.append("         AND SUBSTR(PAGAMENTO.NU_TARGET ,-4,4) IN(:lastFourDigitsCC) ");
            parameters.put("lastFourDigitsCC", filters.getLastFourDigitsCC());
        }
        if (filters.hasFirstSixDigitsCC()) {
            sql.append("         AND SUBSTR(PAGAMENTO.NU_TARGET ,0,6) IN(:firstSixDigitsCC) ");
            parameters.put("firstSixDigitsCC", filters.getFirstSixDigitsCC());
        }
        if (filters.hasDateInterval()) {
            sql.append("         AND VENDA.DT_INCL_VDA BETWEEN :dateFrom AND :dateTo ");
            parameters.put("dateFrom", filters.getDateFrom());
            parameters.put("dateTo", filters.getDateTo());
        }
        if (filters.hasOrderStatus()) {
            sql.append("         AND PEDIDO.CD_STTUS_PDIDO IN(:orderStatus) ");
            parameters.put("orderStatus", filters.getOrderStatus());
        }
        if (filters.hasChannel()) {
            sql.append("         AND PEDIDO.CD_ORIGEM_PRODUTO IN(:channel) ");
            parameters.put("channel", filters.getChannel());
        }
        if (filters.hasPaymentMethod()) {
            sql.append("         AND PAGAMENTO.CD_TPO_PGTO IN(:paymentMethod) ");
            parameters.put("paymentMethod", filters.getPaymentMethod());
        }
    }

    public List<OrderDetailDTO> findDetalheVenda(Long sellerId, Long id) {
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT");
        sql.append(" item_venda.nm_item_vda AS item_name,");
        sql.append(" item_venda.qt_item_vda AS item_quantity,");
        sql.append(" item_venda.vl_untar_item_vda AS item_amount,");
        sql.append(" entrega_item.vr_frete_entrg_item AS item_shipping_cost,");
        sql.append(" endereco_entrega.ds_logdr_ender AS shipping_street,");
        sql.append(" endereco_entrega.ds_nro_ender AS shipping_number,");
        sql.append(" endereco_entrega.nm_bairo_ender AS shipping_district,");
        sql.append(" endereco_entrega.nm_cidde_ender AS shipping_city,");
        sql.append(" endereco_entrega.nm_est_ender AS shipping_state,");
        sql.append(" endereco_entrega.nm_pais_ender AS shipping_country,");
        sql.append(" endereco_entrega.cd_postal_ender AS shipping_zip_code");
        sql.append(" FROM");
        sql.append(" usr_gepd.tb_item_vda item_venda");
        sql.append(" INNER JOIN usr_gepd.tb_entrg_item entrega_item ON");
        sql.append("     item_venda.cd_pdido = entrega_item.cd_pdido");
        sql.append(" AND");
        sql.append("     item_venda.cd_item_vda = entrega_item.cd_item_vda");
        sql.append(" AND");
        sql.append("     item_venda.cd_vddor = entrega_item.cd_vddor");
        sql.append(" INNER JOIN usr_gepd.tb_ender_entrg endereco_entrega ON entrega_item.cd_ender_entrg = endereco_entrega.cd_ender_entrg");
        sql.append(" WHERE");
        sql.append("     item_venda.cd_vddor = :seller_id");
        sql.append(" AND");
        sql.append("     item_venda.cd_pdido = :id");
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("seller_id", sellerId);
        parameters.put("id", id);
        List<OrderDetailDTO> details = null;
        try {
            details = namedParameterJdbcTemplate.query(sql.toString(), parameters, new OrdersDetailsMapper());
        } catch (DataAccessException e) {
            LOGGER.warn("Não foram encontrados registros para a query");
        }
        return details;
    }

    @Override
    public Long count(Long sellerId, VendaFilters filters) {
        Map<String, Object> parameters = new HashMap<>();
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT ");
        sql.append("  COUNT(pedido.cd_pdido) ");
        sql.append("  FROM usr_gepd.tb_vda venda ");
        sql.append("  INNER JOIN usr_gepd.tb_pdido pedido ON venda.cd_pdido = pedido.cd_pdido ");
        sql.append("  AND venda.cd_vddor = pedido.cd_vddor_root_pdido ");
        sql.append("  INNER JOIN usr_gepd.tb_pgto pagamento ON pedido.cd_pdido = pagamento.cd_pdido ");
        sql.append(" WHERE venda.cd_vddor = :seller_id ");
        insertFilters(filters, parameters, sql);
        parameters.put("seller_id", sellerId);
        Long amount = namedParameterJdbcTemplate.queryForObject(sql.toString(), parameters, Long.class);
        if (amount == 0) {
            throw new VendaNotFound();
        }
        return amount;
    }
}

