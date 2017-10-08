package br.com.loja.infrastructure.repository.cdto.bandeira;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.loja.infrastructure.repository.cdto.bandeira.entity.BandeiraEntity;

import java.util.List;

public interface BandeiraRepository extends JpaRepository<BandeiraEntity, Long> {

    @Override
    List<BandeiraEntity> findAll();
}
