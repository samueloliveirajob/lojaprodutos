package br.com.loja.infrastructure.repository.trng.ferramentas.seguranca.mapper;

import org.springframework.jdbc.core.RowMapper;

import br.com.loja.domain.ferramentas.seguranca.ChaveSeguranca;
import br.com.loja.infrastructure.repository.trng.ferramentas.seguranca.entity.ChaveSegurancaEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ChaveSegurancaMapper implements RowMapper<ChaveSeguranca> {

    @Override
    public ChaveSeguranca mapRow(ResultSet resultSet, int i) throws SQLException {

        if (resultSet != null) {
            ChaveSegurancaEntity entity = new ChaveSegurancaEntity();
            entity.setIdCliente(resultSet.getString("id_cli"));
            entity.setChaveSeguranca(resultSet.getString("cli_secret"));
            entity.setUrlCallback(resultSet.getString("nm_url"));

            return entity;
        }
        return null;
    }
}
