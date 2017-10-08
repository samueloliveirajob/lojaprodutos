package br.com.loja.infrastructure.repository.trng.ferramentas.seguranca;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import br.com.loja.domain.ferramentas.seguranca.ChaveSeguranca;
import br.com.loja.infrastructure.repository.trng.GenericTRNGJdbcDAO;
import br.com.loja.infrastructure.repository.trng.ferramentas.seguranca.mapper.ChaveSegurancaMapper;

@Repository
public class ChaveSegurancaRepositoryImpl extends GenericTRNGJdbcDAO implements ChaveSegurancaRepository {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public ChaveSeguranca findBy(Long idVendedor) {
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT ");
        sql.append("        ec.id_cli as id_cli, ");
        sql.append("        ec.cli_secret as cli_secret, ");
        sql.append("        url.nm_url as nm_url");
        sql.append(" FROM ");
        sql.append(" usr_cadu.tb_ec@cdto ec, ");
        sql.append(" usr_cadu.tb_ec_url@cdto url ");
        sql.append(" WHERE ");
        sql.append(" ec.id_stelo = url.id_stelo ");
        sql.append(" AND ec.id_stelo = :idVendedor ");
        sql.append(" AND ROWNUM = 1");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("idVendedor", idVendedor);
        try {
            return namedParameterJdbcTemplate.queryForObject(sql.toString(), parameters, new ChaveSegurancaMapper());
        } catch (DataAccessException e) {
            LOGGER.warn("Não foram encontrados registros para a query");
        }

        return null;
    }
}

