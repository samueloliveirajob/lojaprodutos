package br.com.loja.infrastructure.repository.trng.ferramentas.pagamento.mapper;

import org.springframework.jdbc.core.RowMapper;

import br.com.loja.domain.ferramentas.pagamento.ConfiguracaoPagamento;
import br.com.loja.infrastructure.repository.trng.ferramentas.pagamento.entity.ConfiguracaoPagamentoEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ConfiguracaoPagamentoMapper implements RowMapper<ConfiguracaoPagamento> {

    @Override
    public ConfiguracaoPagamento mapRow(ResultSet resultSet, int i) throws SQLException {

        if (resultSet != null) {
            ConfiguracaoPagamentoEntity entity = new ConfiguracaoPagamentoEntity();
            entity.setNumeroMaximoDeParcelas(resultSet.getInt("numero_maximo_de_parcelas"));
            entity.setValorMinimoDaParcela(resultSet.getDouble("valor_minimo_da_parcela"));
        }
        return null;
    }
}
