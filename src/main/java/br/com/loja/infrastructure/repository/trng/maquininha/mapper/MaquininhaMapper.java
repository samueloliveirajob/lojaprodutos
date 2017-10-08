package br.com.loja.infrastructure.repository.trng.maquininha.mapper;

import org.springframework.jdbc.core.RowMapper;

import br.com.loja.domain.maquininha.Maquininha;
import br.com.loja.infrastructure.repository.trng.maquininha.entity.MaquininhaEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MaquininhaMapper implements RowMapper<Maquininha> {

    @Override
    public Maquininha mapRow(ResultSet resultSet, int i) throws SQLException {

        MaquininhaEntity entity = null;
        if (resultSet != null) {
            entity = new MaquininhaEntity();
            entity.setModelo(resultSet.getString("modelo"));
            entity.setCogigoAtivacao(resultSet.getString("codigo_ativacao"));
            entity.setNumeroSerie(resultSet.getString("numero_serie"));
            entity.setDataCompra(resultSet.getDate("data_compra"));
            entity.setValor(resultSet.getDouble("valor"));
            entity.setStatus(resultSet.getString("status"));
        }

        return entity;
    }
}
