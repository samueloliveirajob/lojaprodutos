package br.com.loja.infrastructure.repository.trng.ferramentas.pagamento;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import br.com.loja.domain.ferramentas.pagamento.ConfiguracaoPagamento;
import br.com.loja.infrastructure.repository.trng.GenericTRNGJdbcDAO;
import br.com.loja.infrastructure.repository.trng.ferramentas.pagamento.entity.ConfiguracaoPagamentoEntity;

@Repository
public class ConfiguracaoPagamentoRepositoryImpl extends GenericTRNGJdbcDAO implements ConfiguracaoPagamentoRepository {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public ConfiguracaoPagamento findBy(Long idVendedor) {

        StringBuilder sql = new StringBuilder();

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("idVendedor", idVendedor);

//        try {
//            return namedParameterJdbcTemplate.queryForObject(sql.toString(), parameters, new ConfiguracaoPagamentoMapper());
//        } catch (DataAccessException e) {
//            LOGGER.warn("Não foram encontrados registros para a query");
//        }
//        return null;

        ConfiguracaoPagamentoEntity entity = new ConfiguracaoPagamentoEntity();
        entity.setValorMinimoDaParcela(5.01);
        entity.setNumeroMaximoDeParcelas(3);

        return entity;
    }
}
