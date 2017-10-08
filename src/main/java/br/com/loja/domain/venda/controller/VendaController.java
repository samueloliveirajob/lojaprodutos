package br.com.loja.domain.venda.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.loja.domain.bandeira.service.BandeiraService;
import br.com.loja.domain.pagamento.DescricaoMeioPagamentoService;
import br.com.loja.domain.venda.*;
import br.com.loja.domain.venda.service.VendaService;
import br.com.loja.infrastructure.repository.cdto.bandeira.entity.BandeiraEntity;
import br.com.loja.infrastructure.repository.cdto.pagamento.entity.DescricaoMeioPagamentoEntity;
import br.com.loja.view.endpoint.venda.VendaDTO;
import br.com.loja.view.endpoint.venda.VendasDTO;
import br.com.loja.view.endpoint.venda.VendasDTOBuilder;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class VendaController {

    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private VendaService vendaService;

    @Autowired
    private DescricaoMeioPagamentoService descricaoMeioPagamentoService;

    @Autowired
    private BandeiraService bandeiraService;

    public VendasDTO getAll(Long idStelo, VendaFilters filters) {
        Long count = vendaService.count(idStelo, filters);
        VendasDTO vendas = VendasDTOBuilder.aVendasDTO()
                .withAmount(count)
                .withData(vendaService.listBy(idStelo, filters, count)
                        .stream()
                        .map((vendaEntity) -> this.createVendaDTO(vendaEntity))
                        .collect(Collectors.toList())).build();

        vendas.getData().forEach(vendaDTO -> {
            this.getDescricaoMeioPagamento(vendaDTO);
//            this.getDescricalCanalOrigem(vendaDTO);
//            if (vendaDTO.getPagamento().getCartao() != null) {
//                this.getDescricaoBandeiras(vendaDTO);
//            }
            this.getStatusVenda(vendaDTO);
        });
        return vendas;
    }


    public VendaDTO getOne(Long idStelo, Long id) {

        VendaDTO dto = new VendaDTO(vendaService.findVenda(idStelo, id));

        this.getDescricaoMeioPagamento(dto);
        this.getDescricalCanalOrigem(dto);
        this.getDescricaoBandeiras(dto);
        this.getStatusVenda(dto);

        return dto;
    }

    private void getDescricaoMeioPagamento(VendaDTO dto) {

        LOGGER.info("Recuperando a descricao do meio de pagamento");

        List<DescricaoMeioPagamentoEntity> entities = descricaoMeioPagamentoService.findAll();
        entities.stream().forEach((i) -> {
            if (dto.getPagamento().getCodigo().equals(i.getId())) {
                dto.getPagamento().setDescricao(i.getDescricao());
            }
        });
    }

    private void getDescricalCanalOrigem(VendaDTO dto) {

        LOGGER.info("Recuperando a descricao do canal de origm");
        dto.getCanal().setDescricao(CanalOrigem.find(dto.getCanal().getCodigo()).description());
    }

    private void getDescricaoBandeiras(VendaDTO dto) {

        List<BandeiraEntity> banderas = bandeiraService.findAll();
        banderas.stream().forEach((i) -> {
            if (dto.getPagamento().getCartao().getCodigoBandeira().equals(i.getId().toString())) {
                dto.getPagamento().getCartao().setDescricaoBandeira(i.getDescricao());
                LOGGER.info("Descricao da bandeira " + i.getDescricao());
            }
        });
    }

    private void getStatusVenda(VendaDTO dto) {
        LOGGER.info("Recuperando a descricao do status da venda");
        dto.getStatus().setDescricao(StatusVenda.find(dto.getStatus().getCodigo()).description());
    }

    private VendaDTO createVendaDTO(Venda venda) {
        LOGGER.info(">>>>>>>>>>> Criando VendaDTO <<<<<<<<<<<<<");
        return new VendaDTO(venda);
    }
}
