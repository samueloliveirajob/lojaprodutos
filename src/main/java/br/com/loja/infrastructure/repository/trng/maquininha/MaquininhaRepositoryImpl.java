package br.com.loja.infrastructure.repository.trng.maquininha;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import br.com.loja.domain.maquininha.Maquininha;
import br.com.loja.infrastructure.repository.trng.GenericTRNGJdbcDAO;
import br.com.loja.infrastructure.repository.trng.maquininha.entity.MaquininhaEntity;

@Repository
public class MaquininhaRepositoryImpl extends GenericTRNGJdbcDAO implements MaquininhaRepository {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public List<Maquininha> findBy(Long idVendedor) {

        StringBuilder sql = new StringBuilder();

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("idVendedor", idVendedor);

//        try {
//            return namedParameterJdbcTemplate.queryForObject(sql.toString(), parameters, new MaquininhaMapper());
//        } catch (DataAccessException e) {
//            LOGGER.warn("Não foram encontrados registros para a query");
//        }

        List<Maquininha> list = new ArrayList<>();

        MaquininhaEntity maquininha1 = new MaquininhaEntity();
        maquininha1.setModelo("Stelo MOB");
        maquininha1.setCogigoAtivacao("1408256770");
        maquininha1.setNumeroSerie("__5A001244");
        maquininha1.setDataCompra(new Date());
        maquininha1.setValor(778.80);
        maquininha1.setStatus("Ativada");
        list.add(maquininha1);

        MaquininhaEntity maquininha2 = new MaquininhaEntity();
        maquininha2.setModelo("Stelo MOB");
        maquininha2.setCogigoAtivacao("1408256770");
        maquininha2.setNumeroSerie("__5A001244");
        maquininha2.setDataCompra(new Date());
        maquininha2.setValor(778.80);
        maquininha2.setStatus("Ativada");
        list.add(maquininha2);

        return list;
    }
}
