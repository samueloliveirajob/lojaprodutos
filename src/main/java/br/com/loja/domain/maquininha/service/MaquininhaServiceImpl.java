package br.com.loja.domain.maquininha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.loja.domain.maquininha.Maquininha;
import br.com.loja.domain.maquininha.MaquininhaNotFound;
import br.com.loja.infrastructure.repository.trng.maquininha.MaquininhaRepository;

import java.util.List;

@Service
public class MaquininhaServiceImpl implements MaquininhaService {

    @Autowired
    MaquininhaRepository repository;

    @Override
    public List<Maquininha> findBy(Long idVendedor) {

        List<Maquininha> maquininhas = repository.findBy(idVendedor);
        if (maquininhas == null) {
            throw new MaquininhaNotFound();
        }

        return maquininhas;
    }
}
