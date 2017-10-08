package br.com.loja.domain.bandeira.service;

import java.util.List;

import br.com.loja.infrastructure.repository.cdto.bandeira.entity.BandeiraEntity;

public interface BandeiraService {

    List<BandeiraEntity> findAll();

    void delete();
}
