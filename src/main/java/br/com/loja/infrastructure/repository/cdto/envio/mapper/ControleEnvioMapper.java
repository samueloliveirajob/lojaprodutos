package br.com.loja.infrastructure.repository.cdto.envio.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.loja.infrastructure.repository.cdto.envio.entity.ControleEnvioEntity;

public class ControleEnvioMapper implements RowMapper<ControleEnvioEntity> {

    public ControleEnvioEntity mapRow(ResultSet rs, int rowNum) throws SQLException {

    	ControleEnvioEntity controle = null;
    	
        if (rs != null){
        	 controle = new ControleEnvioEntity();
        	 controle.setIdUri(rs.getLong("ID_URI"));
        	 controle.setIdCanalOrigem(rs.getInt("ID_CANAL_ORIGE"));
        	 controle.setNomeCompleto(rs.getString("NM_COPLT"));
        	 controle.setNuAgencia(rs.getString("NU_AG"));
        	 controle.setIdSolicitante(rs.getString("ID_SOLCT"));
        	 controle.setUrlCompra(rs.getString("NM_URL"));
        	 controle.setUsrIncl(rs.getString("USUAR_INCL"));
        	 controle.setUsrAlt(rs.getString("USUAR_ALT"));
        	 controle.setDtInclusao(rs.getDate("DT_INCL"));
        	 controle.setDtAlteracao(rs.getDate("DT_ALT"));
        	 return controle;
        }
        
        return controle;
    }
}
