package br.com.loja.infrastructure.repository.trng.venda.repository;

import java.util.List;
import java.util.stream.Stream;

import br.com.loja.domain.venda.VendaFilters;
import br.com.loja.infrastructure.repository.trng.venda.entity.VendaEntity;
import br.com.loja.view.endpoint.venda.VendaDTO;
import br.com.loja.view.endpoint.venda.VendasDTO;

public interface VendaRepository {
    Stream streamAll();

    VendaEntity findVenda(Long sellerId, Long id);

    Long count(Long sellerId, VendaFilters filters);

    List<VendaEntity> listFirst(Long idStelo, Long quantity, VendaFilters filters);

    List<VendaEntity> listNext(Long idStelo, Long cdPdido, Long quantity, VendaFilters filters);

    List<VendaEntity> listPrevious(Long idStelo, Long cdPdido, Long quantity, VendaFilters filters);

    List<VendaEntity> listLast(Long idStelo, Long quantity, VendaFilters filters);
}
