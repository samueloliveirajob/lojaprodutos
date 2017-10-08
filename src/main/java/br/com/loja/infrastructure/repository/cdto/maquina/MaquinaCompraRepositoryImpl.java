package br.com.loja.infrastructure.repository.cdto.maquina;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.loja.infrastructure.repository.cdto.GenericCDTOJdbcDAO;
import br.com.loja.infrastructure.repository.cdto.maquina.entity.MaquinaCompraEntity;
import br.com.loja.infrastructure.repository.cdto.maquina.mapper.MaquinaCompraMapper;
import br.com.loja.view.endpoint.maquininha.MaquinaCompraDTO;

@Repository
public class MaquinaCompraRepositoryImpl extends GenericCDTOJdbcDAO implements MaquinaCompraRepository {

    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    @PersistenceContext(unitName="cdtoEntityManagerFactory")
    private EntityManager cdtoEntityManager;

	@Override
	@Transactional(transactionManager="cdtoTransactionManager")
	public Boolean save(MaquinaCompraEntity entity) {
		
		try {
			cdtoEntityManager.persist(entity);
			return Boolean.TRUE;
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return Boolean.FALSE;
		}
		
	}
   
    public List<MaquinaCompraDTO> findAllMaqEC(Long idStelo) {
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT");
        sql.append(" maq.ID_MAQ_CMPR,");
        sql.append(" maq.ID_STELO,");
        sql.append(" maq.TP_MAQ,");
        sql.append(" maq.TP_OPER,");
        sql.append(" maq.QTDE,");
        sql.append(" maq.DT_INCL,");
        sql.append(" maq.DT_CMPR_FIM ");
        sql.append(" FROM");
        sql.append(" USR_CADU.TB_MAQ_CMPR maq");
        sql.append(" WHERE");
        sql.append("     maq.ID_STELO = :idStelo");
        sql.append(" AND maq.DT_CMPR_FIM is null");
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("idStelo", idStelo);
        List<MaquinaCompraDTO> maquinasDTO = null;
        try {
//            maquinasDTO = namedParameterJdbcTemplate.query(sql.toString(), parameters, new MaquinaCompraMapper());
        } catch (DataAccessException e) {
            LOGGER.warn("Não foram encontrados registros para a query");
        }
        return maquinasDTO;
    }


	
}

