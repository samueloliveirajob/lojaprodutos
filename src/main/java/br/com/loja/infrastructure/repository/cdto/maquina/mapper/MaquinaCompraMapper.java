package br.com.loja.infrastructure.repository.cdto.maquina.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.loja.view.endpoint.maquininha.MaquinaCompraDTO;
import br.com.loja.view.endpoint.venda.OrderDetailDTO;

public class MaquinaCompraMapper implements RowMapper<MaquinaCompraDTO> {

    @Override
    public MaquinaCompraDTO mapRow(ResultSet resultSet, int i) throws SQLException {

    	MaquinaCompraDTO maquinaDTO = null;
    	
        if (resultSet != null) {
        	 maquinaDTO = new MaquinaCompraDTO();
        	 maquinaDTO.setIdMaqCmpr(resultSet.getLong("ID_MAQ_CMPR"));
        	 maquinaDTO.setIdStelo(resultSet.getLong("ID_STELO"));
        	 maquinaDTO.setIdTpMaq(resultSet.getInt("TP_MAQ"));
        	 maquinaDTO.setIdTpOper(resultSet.getInt("TP_OPER"));
        	 maquinaDTO.setQtde(resultSet.getInt("QTDE"));
        	 maquinaDTO.setDtIncl(resultSet.getDate("DT_INCL"));
        	 maquinaDTO.setDtCmprFim(resultSet.getDate("DT_CMPR_FIM"));
             return maquinaDTO;
        }
        return null;
    }
}
