package br.com.loja.view.endpoint.maquininha;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.loja.infrastructure.repository.cdto.maquina.entity.MaquinaCompraEntity;

public class MaquinaCompraDTO {

	
	@JsonProperty("idMaqCmpr")
	private Long idMaqCmpr;
	@JsonProperty("idStelo")
	private Long idStelo;
	@JsonProperty("idTpMaq")
	private Integer idTpMaq;
	@JsonProperty("idTpOper")
	private Integer idTpOper;
	@JsonProperty("qtde")
	private Integer qtde;
	
	@JsonProperty("dtIncl")
//	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dtIncl;
	
	@JsonProperty("dtCmprFim")
//	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dtCmprFim;

	

    public MaquinaCompraDTO(MaquinaCompraEntity entity) {
        this.idMaqCmpr = entity.getIdMaqCmpr();
        this.idStelo = entity.getIdStelo();
        this.idTpMaq = entity.getIdTpMaq();
        this.idTpOper = entity.getIdTpOper();
        this.qtde = entity.getQtde();
        this.dtIncl = entity.getDtIncl();
        this.dtCmprFim = entity.getDtCmprFim();
    }

    
	public MaquinaCompraDTO() {
		super();
	}





	/**
	 * @return the idMaqCmpr
	 */
	public Long getIdMaqCmpr() {
		return idMaqCmpr;
	}



	/**
	 * @param idMaqCmpr the idMaqCmpr to set
	 */
	public void setIdMaqCmpr(Long idMaqCmpr) {
		this.idMaqCmpr = idMaqCmpr;
	}



	/**
	 * @return the idStelo
	 */
	public Long getIdStelo() {
		return idStelo;
	}



	/**
	 * @param idStelo the idStelo to set
	 */
	public void setIdStelo(Long idStelo) {
		this.idStelo = idStelo;
	}



	/**
	 * @return the idTpMaq
	 */
	public Integer getIdTpMaq() {
		return idTpMaq;
	}



	/**
	 * @param idTpMaq the idTpMaq to set
	 */
	public void setIdTpMaq(Integer idTpMaq) {
		this.idTpMaq = idTpMaq;
	}



	/**
	 * @return the idTpOper
	 */
	public Integer getIdTpOper() {
		return idTpOper;
	}



	/**
	 * @param idTpOper the idTpOper to set
	 */
	public void setIdTpOper(Integer idTpOper) {
		this.idTpOper = idTpOper;
	}



	/**
	 * @return the qtde
	 */
	public Integer getQtde() {
		return qtde;
	}



	/**
	 * @param qtde the qtde to set
	 */
	public void setQtde(Integer qtde) {
		this.qtde = qtde;
	}



	/**
	 * @return the dtIncl
	 */
	public Date getDtIncl() {
		return dtIncl;
	}



	/**
	 * @param dtIncl the dtIncl to set
	 */
	public void setDtIncl(Date dtIncl) {
		this.dtIncl = dtIncl;
	}



	/**
	 * @return the dtCmprFim
	 */
	public Date getDtCmprFim() {
		return dtCmprFim;
	}



	/**
	 * @param dtCmprFim the dtCmprFim to set
	 */
	public void setDtCmprFim(Date dtCmprFim) {
		this.dtCmprFim = dtCmprFim;
	}

    
    
    
}
