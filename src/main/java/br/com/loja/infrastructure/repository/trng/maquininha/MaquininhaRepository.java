package br.com.loja.infrastructure.repository.trng.maquininha;

import java.util.List;

import br.com.loja.domain.maquininha.Maquininha;

public interface MaquininhaRepository {

    List<Maquininha> findBy(Long idVendedor);
}
