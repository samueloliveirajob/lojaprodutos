package br.com.loja.infrastructure.repository.cdto.envio.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.loja.infrastructure.repository.cdto.GenericCDTOJdbcDAO;
import br.com.loja.infrastructure.repository.cdto.envio.EnvioRepository;
import br.com.loja.infrastructure.repository.cdto.envio.entity.ControleEnvioEntity;
import br.com.loja.infrastructure.repository.cdto.envio.mapper.ControleEnvioMapper;
import br.com.loja.infrastructure.repository.enums.TipoEnvio;
import br.com.loja.view.endpoint.envio.dto.EnvioDTO;

@Repository
public class EnvioRepositoryImpl extends GenericCDTOJdbcDAO implements EnvioRepository {

	private static final Logger LOGGER = LogManager.getLogger();
	
	private static final String USU_APP = "APP_CREDENCIAMENTO";

	@Autowired
	@PersistenceContext(unitName="cdtoEntityManagerFactory")
	private EntityManager cdtoEntityManager;

	@Override
	@Transactional(transactionManager="cdtoTransactionManager")
	public Boolean save(ControleEnvioEntity entity) {

		try {
			cdtoEntityManager.persist(entity);
			return Boolean.TRUE;
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return Boolean.FALSE;
		}

	}


	public ControleEnvioEntity saveURI(ControleEnvioEntity entity) {

		String sqlInsert = "INSERT INTO USR_CADU.TB_URI "
				+ " (ID_URI, ID_CANAL_ORIGE, NM_COPLT,  NU_AG, ID_SOLCT, NM_URL, USUAR_INCL, USUAR_ALT, DT_INCL, DT_ALT) "
				+ " VALUES "
				+ " (:idUri, :idCanalOrigem, :nmCompleto, :nuAgencia, :idSolicitante, :nmUrl, :usrIncl, :usrAlt, :dtIncl, :dtAlt) ";
		try {

			Long nextVal = getSequenceUri();
			entity.setIdUri(nextVal);
			entity.setUrlCompra(entity.getUrlCompra()+entity.getIdUri());

			Map<String, Object> parameters = new HashMap<>();
			parameters.put("idUri", entity.getIdUri());
			parameters.put("idCanalOrigem", entity.getIdCanalOrigem());
			parameters.put("nmCompleto",    entity.getNomeCompleto());
			parameters.put("nuAgencia", entity.getNuAgencia());
			parameters.put("idSolicitante", entity.getIdSolicitante());
			parameters.put("nmUrl",   entity.getUrlCompra());
			parameters.put("usrIncl", entity.getUsrIncl());
			parameters.put("usrAlt",  entity.getUsrAlt());
			parameters.put("dtIncl",  entity.getDtInclusao());
			parameters.put("dtAlt",   entity.getDtAlteracao());
			namedParameterJdbcTemplate.update(sqlInsert, parameters) ;

			return entity;

		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}

	}

	/**
	 * @return
	 * @throws Exception 
	 */
	private Long getSequenceUri() throws Exception {
		Map<String, Object> pmeters = new HashMap<>();

		Long nextVal = (Long) this.namedParameterJdbcTemplate.queryForObject("SELECT USR_CADU.SQ_URI.NEXTVAL FROM DUAL", pmeters, new RowMapper(){
			public Object mapRow(ResultSet resultSet, int rowNum)
					throws SQLException {
				return resultSet.getLong("NEXTVAL");
			}
		});

		if(null == nextVal || nextVal == 0l){
			throw new Exception("getSequenceUri == null or getSequenceUri == 0");
		}else{
			return nextVal;
		}

	}
	
	public void saveURIEnviado(String identificacao, String celEnviado, String email, Boolean status) {
		
		String sqlInsert = "INSERT INTO USR_CADU.TB_URI_ENVIADO (ID_URI_ENVIADO, ID_URI, NU_DDD_FONE, NU_FONE, NM_EMAIL, STTUS, USUAR_INCL, USUAR_ALT, DT_INCL, DT_ALT) "
				+ "VALUES "
				+ "(USR_CADU.SQ_URI_ENVIADO.NEXTVAL, :idUri, :nuDddFone, :nuFone, :nmEmail, :status, :usrIncl , :usrAlt, :dtIncl, :dtAlt)";

		try {
			
			String ddd = null;
			String cel = null;
			
			if(celEnviado != null && celEnviado.length() > 2) {
				ddd = celEnviado.substring(0, 2);
				cel = celEnviado.substring(2);
			}

			Map<String, Object> parameters = new HashMap<>();
			parameters.put("idUri",   identificacao);
			parameters.put("nuDddFone", ddd);
			parameters.put("nuFone",    cel);
			parameters.put("nmEmail", email);
			parameters.put("status",  status);
			parameters.put("usrIncl", USU_APP);
			parameters.put("usrAlt",  USU_APP);
			parameters.put("dtIncl",  new Date());
			parameters.put("dtAlt",   new Date());
			namedParameterJdbcTemplate.update(sqlInsert, parameters) ;

		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		
	}
	


	@Override
	public ControleEnvioEntity findControleEnvio(EnvioDTO requestEnvioDTO) {

		StringBuilder sql = new StringBuilder();

		sql.append(" SELECT ");
		sql.append(" uri.ID_URI, ");
		sql.append(" uri.ID_CANAL_ORIGE,"); 
		sql.append(" uri.NM_COPLT, ");
		sql.append(" uri.NU_AG, ");
		sql.append(" uri.ID_SOLCT, ");
		sql.append(" uri.NM_URL, ");
		sql.append(" uri.USUAR_INCL, "); 
		sql.append(" uri.USUAR_ALT, ");
		sql.append(" uri.DT_INCL, ");
		sql.append(" uri.DT_ALT ");
		sql.append(" FROM USR_CADU.TB_URI uri ");
		sql.append(" WHERE uri.ID_CANAL_ORIGE = :canalOrigem "); 
		sql.append(" AND ( 0=:nuAgencia or uri.NU_AG = :nuAgencia ) ");
		sql.append(" AND ( 0=:idSolicitante or uri.ID_SOLCT = :idSolicitante ) ");

		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("canalOrigem", requestEnvioDTO.getCanalOrigem());
		parameters.addValue("nuAgencia", requestEnvioDTO.getNuAgencia() == null ? 0 : requestEnvioDTO.getNuAgencia());
		parameters.addValue("idSolicitante", requestEnvioDTO.getIdSolicitante() == null ? 0 : requestEnvioDTO.getIdSolicitante());

		List<ControleEnvioEntity> controles = null;
		try {
			controles = this.namedParameterJdbcTemplate.query(sql.toString(), parameters, new ControleEnvioMapper());
		} catch (DataAccessException e) {
			LOGGER.warn("Não foram encontrados registros para a query");
		}
		if(null != controles && !controles.isEmpty()){
			return controles.get(0);  
		}else{
			return null;
		}

	}


	@Override
	public ControleEnvioEntity findControleEnvioByCodeUrl(String codeUrl) {

		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT");
		sql.append(" ctrl.ID_URI,");
		sql.append(" ctrl.ID_CANAL_ORIGE,");
		sql.append(" ctrl.NM_COPLT,");
		sql.append(" ctrl.NU_AG,");
		sql.append(" ctrl.ID_SOLCT,");
		sql.append(" ctrl.NM_URL,");
		sql.append(" ctrl.USUAR_INCL,");
		sql.append(" ctrl.USUAR_ALT, ");
		sql.append(" ctrl.DT_INCL, ");
		sql.append(" ctrl.DT_ALT, ");
		sql.append(" ctrl.ENCODE ");
		sql.append(" FROM ");
		sql.append(" USR_CADU.TB_URI ctrl");
		sql.append(" WHERE");
		sql.append("     ctrl.ID_URI = :idUri ");
		
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("idUri", codeUrl);

		List<ControleEnvioEntity> controles = null;
		try {
			controles = this.namedParameterJdbcTemplate.query(sql.toString(), parameters, new ControleEnvioMapper());
		} catch (DataAccessException e) {
			LOGGER.warn("Não foram encontrados registros para a query");
		}
		if(null != controles && !controles.isEmpty()){
			return controles.get(0);  
		}else{
			return null;
		}
	}

}

