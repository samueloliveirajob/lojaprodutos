package br.com.loja.domain.venda.service;

import java.util.List;

import br.com.loja.domain.venda.VendaFilters;
import br.com.loja.infrastructure.repository.trng.venda.entity.VendaEntity;

public interface VendaService {

    List<VendaEntity> listBy(Long idStelo, VendaFilters filters, Long count);

    VendaEntity findVenda(Long sellerId, Long id);

    Long count(Long sellerId, VendaFilters filters);
}
