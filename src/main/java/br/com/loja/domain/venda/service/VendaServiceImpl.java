package br.com.loja.domain.venda.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.loja.domain.venda.VendaFilters;
import br.com.loja.domain.venda.VendaNotFound;
import br.com.loja.infrastructure.repository.trng.venda.entity.VendaEntity;
import br.com.loja.infrastructure.repository.trng.venda.repository.VendaRepository;
import br.com.loja.infrastructure.utils.MethodLoggerBuilder;

import java.util.List;

@Service
public class VendaServiceImpl implements VendaService {

    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private VendaRepository repository;


    @Override
    public List<VendaEntity> listBy(Long idStelo, VendaFilters filters, Long count) {
        MethodLoggerBuilder logger = MethodLoggerBuilder.instance()
                .withClass(this.getClass().getSimpleName())
                .withMethod("listBy")
                .withParams(idStelo, filters, count);
        List<VendaEntity> vendaEntities = listCase(idStelo, filters, count);
        LOGGER.info(logger.log());
        return vendaEntities;
    }

    private List<VendaEntity> listCase(Long idStelo, VendaFilters filters, Long count) {
        if (filters.getLast()) {
            long mod = count % filters.getQuantity();
            return repository.listLast(idStelo, mod == 0 ? filters.getQuantity() : mod, filters);
        } else if (filters.hasPrevious()) {
            return repository.listPrevious(idStelo, filters.getPrevious(), filters.getQuantity(), filters);
        } else if (filters.hasNext()) {
            return repository.listNext(idStelo, filters.getNext(), filters.getQuantity(), filters);
        } else {
            return repository.listFirst(idStelo, filters.getQuantity(), filters);
        }
    }

    @Override
    public VendaEntity findVenda(Long sellerId, Long id) throws VendaNotFound {
        MethodLoggerBuilder logger = MethodLoggerBuilder.instance()
                .withClass(this.getClass().getSimpleName())
                .withMethod("listBy")
                .withParams(sellerId, id);

        VendaEntity venda = repository.findVenda(sellerId, id);
        if (venda == null) {
            logger.withReturn(null);
            LOGGER.info(logger.log());
            throw new VendaNotFound();
        }

        //List<OrderDetailDTO> details = this.findOrderDetail(sellerId, id);
        //venda.setDetails(details);
        LOGGER.info(logger.log());
        return venda;
    }

    @Override
    public Long count(Long sellerId, VendaFilters filters) {
        MethodLoggerBuilder logger = MethodLoggerBuilder.instance()
                .withClass(this.getClass().getSimpleName())
                .withMethod("listBy")
                .withParams(sellerId);
        Long count = repository.count(sellerId, filters);
        LOGGER.info(logger.withReturn(count).log());
        return count;
    }
}
