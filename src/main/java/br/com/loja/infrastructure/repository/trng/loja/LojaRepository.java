package br.com.loja.infrastructure.repository.trng.loja;

import br.com.loja.domain.loja.Loja;

public interface LojaRepository {

    Loja findBy(Long idVendedor);
}
