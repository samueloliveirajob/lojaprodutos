package br.com.loja.infrastructure.repository.cdto.maquina.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.loja.view.endpoint.maquininha.MaquinaCompraDTO;

@Entity
@Table(name = "TB_MAQ_CMPR" , schema="USR_CADU")
@SequenceGenerator(name = "SeqMaquinaGenerator", sequenceName = "SQ_TB_MAQ_CMPR", allocationSize = 0 , schema="USR_CADU")
public class MaquinaCompraEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SeqMaquinaGenerator")
	@Column(name = "ID_MAQ_CMPR", nullable = false)
	private Long idMaqCmpr;
	
	@Column(name = "ID_STELO", nullable = false)
	private Long idStelo;
	
	@Column(name = "TP_MAQ", nullable = false)
	private Integer idTpMaq;
	
	@Column(name = "TP_OPER", nullable = false)
	private Integer idTpOper;
	
	@Column(name = "QTDE", nullable = false)
	private Integer qtde;
	
	@Column(name = "DT_INCL", nullable = false)
	private Date dtIncl;
	
	@Column(name = "DT_CMPR_FIM")
	private Date dtCmprFim;

	
	
	public MaquinaCompraEntity(Long idStelo, Integer idTpMaq, Integer idTpOper, Integer qtde,
			Date dtIncl, Date dtCmprFim) {
		super();
		this.idStelo = idStelo;
		this.idTpMaq = idTpMaq;
		this.idTpOper = idTpOper;
		this.qtde = qtde;
		this.dtIncl = dtIncl;
		this.dtCmprFim = dtCmprFim;
	}

	public MaquinaCompraEntity(MaquinaCompraDTO maquinaDTO) {
		this.idMaqCmpr = maquinaDTO.getIdMaqCmpr();
		this.idStelo = maquinaDTO.getIdStelo();
		this.idTpMaq = maquinaDTO.getIdTpMaq();
		this.idTpOper = maquinaDTO.getIdTpOper();
		this.qtde = maquinaDTO.getQtde();
		this.dtIncl = maquinaDTO.getDtIncl();
		this.dtCmprFim = maquinaDTO.getDtCmprFim();
	}

	public Long getIdMaqCmpr() {
		return idMaqCmpr;
	}

	public void setIdMaqCmpr(Long idMaqCmpr) {
		this.idMaqCmpr = idMaqCmpr;
	}

	public Long getIdStelo() {
		return idStelo;
	}

	public void setIdStelo(Long idStelo) {
		this.idStelo = idStelo;
	}

	public Integer getIdTpMaq() {
		return idTpMaq;
	}

	public void setIdTpMaq(Integer idTpMaq) {
		this.idTpMaq = idTpMaq;
	}

	public Integer getIdTpOper() {
		return idTpOper;
	}

	public void setIdTpOper(Integer idTpOper) {
		this.idTpOper = idTpOper;
	}

	public Integer getQtde() {
		return qtde;
	}

	public void setQtde(Integer qtde) {
		this.qtde = qtde;
	}

	public Date getDtIncl() {
		return dtIncl;
	}

	public void setDtIncl(Date dtIncl) {
		this.dtIncl = dtIncl;
	}

	public Date getDtCmprFim() {
		return dtCmprFim;
	}

	public void setDtCmprFim(Date dtCmprFim) {
		this.dtCmprFim = dtCmprFim;
	}
	
	
}
