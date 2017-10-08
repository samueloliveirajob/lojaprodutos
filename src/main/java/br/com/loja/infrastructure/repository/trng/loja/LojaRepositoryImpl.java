package br.com.loja.infrastructure.repository.trng.loja;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import br.com.loja.domain.loja.Loja;
import br.com.loja.infrastructure.repository.trng.GenericTRNGJdbcDAO;
import br.com.loja.infrastructure.repository.trng.loja.entity.DocumentoEntity;
import br.com.loja.infrastructure.repository.trng.loja.entity.EnderecoEntity;
import br.com.loja.infrastructure.repository.trng.loja.entity.LojaEntity;
import br.com.loja.infrastructure.repository.trng.loja.entity.SubcategoriaEntity;
import br.com.loja.infrastructure.repository.trng.loja.entity.TelefoneEntity;

@Repository
public class LojaRepositoryImpl extends GenericTRNGJdbcDAO implements LojaRepository {

    @Override
    public Loja findBy(Long idVendedor) {

        StringBuilder sql = new StringBuilder();

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("idVendedor", idVendedor);

        //        try {
//            return namedParameterJdbcTemplate.queryForObject(sql.toString(), parameters, new LojaMapper());
//        } catch (DataAccessException e) {
//            LOGGER.warn("Não foram encontrados registros para a query");
//        }
//        return null;

        LojaEntity loja = new LojaEntity();
        loja.setRazaoSocial("Games Max Nat LDTA");
        loja.setNomeFantasia("Maquininha");
        loja.setSite("http://www.natgames.com.br");
        loja.setIdentificacaoFaturaCartao("nat-jogos");

        DocumentoEntity documento = new DocumentoEntity();
        documento.setTipo("cnpj");
        documento.setValor("44.623.584/0001-27");
        loja.setDocumento(documento);

        SubcategoriaEntity subcategoria = new SubcategoriaEntity();
        subcategoria.setId(97);
        subcategoria.setDescricao("Brinquedos");
        loja.setSubcategoria(subcategoria);

        TelefoneEntity telefone = new TelefoneEntity();
        telefone.setTipo("Comercial");
        telefone.setValor("(18) 9991-2146");
        loja.setTelefone(telefone);

        EnderecoEntity endereco = new EnderecoEntity();
        endereco.setCep("95055-480");
        endereco.setLogradouro("Rua Otávio Rocha");
        endereco.setNumero("853");
        endereco.setComplemento("complemento testinho");
        endereco.setBairro("De Lazzer");
        endereco.setEstado("RS");
        endereco.setCidade("Caxias do Sul");
        loja.setEndereco(endereco);

        return loja;
    }
}
