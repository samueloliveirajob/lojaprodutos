package br.com.loja.infrastructure.repository.cdto.envio.entity;

import java.io.Serializable;
import java.util.Date;

public class ControleEnvioEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long idUri;

	private Integer idCanalOrigem;
	
	private String nomeCompleto;
	
	private String nuAgencia;
	
	private String idSolicitante;
	
	private String urlCompra;
	
	private String usrIncl;
	
	private String usrAlt;
	
	private Date dtInclusao;
	
	private Date dtAlteracao;
	
	
	/**
	 * @param idUri
	 * @param idCanalOrigem
	 * @param nomeCompleto
	 * @param nuAgencia
	 * @param idSolicitante
	 * @param urlCompra
	 * @param usrIncl
	 * @param usrAlt
	 * @param dtInclusao
	 * @param dtAlteracao
	 */
	public ControleEnvioEntity(Long idUri, Integer idCanalOrigem, String nomeCompleto, String nuAgencia,
			String idSolicitante, String urlCompra, String usrIncl, String usrAlt, Date dtInclusao, Date dtAlteracao) {
		super();
		this.idUri = idUri;
		this.idCanalOrigem = idCanalOrigem;
		this.nomeCompleto = nomeCompleto;
		this.nuAgencia = nuAgencia;
		this.idSolicitante = idSolicitante;
		this.urlCompra = urlCompra;
		this.usrIncl = usrIncl;
		this.usrAlt = usrAlt;
		this.dtInclusao = dtInclusao;
		this.dtAlteracao = dtAlteracao;
	}
	

	/**
	 * 
	 */
	public ControleEnvioEntity() {
		super();
	}

	/**
	 * @return the idUri
	 */
	public Long getIdUri() {
		return idUri;
	}

	/**
	 * @param idUri the idUri to set
	 */
	public void setIdUri(Long idUri) {
		this.idUri = idUri;
	}

	/**
	 * @return the idCanalOrigem
	 */
	public Integer getIdCanalOrigem() {
		return idCanalOrigem;
	}

	/**
	 * @param idCanalOrigem the idCanalOrigem to set
	 */
	public void setIdCanalOrigem(Integer idCanalOrigem) {
		this.idCanalOrigem = idCanalOrigem;
	}

	/**
	 * @return the nomeCompleto
	 */
	public String getNomeCompleto() {
		return nomeCompleto;
	}

	/**
	 * @param nomeCompleto the nomeCompleto to set
	 */
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	/**
	 * @return the nuAgencia
	 */
	public String getNuAgencia() {
		return nuAgencia;
	}

	/**
	 * @param nuAgencia the nuAgencia to set
	 */
	public void setNuAgencia(String nuAgencia) {
		this.nuAgencia = nuAgencia;
	}

	/**
	 * @return the idSolicitante
	 */
	public String getIdSolicitante() {
		return idSolicitante;
	}

	/**
	 * @param idSolicitante the idSolicitante to set
	 */
	public void setIdSolicitante(String idSolicitante) {
		this.idSolicitante = idSolicitante;
	}

	/**
	 * @return the urlCompra
	 */
	public String getUrlCompra() {
		return urlCompra;
	}

	/**
	 * @param urlCompra the urlCompra to set
	 */
	public void setUrlCompra(String urlCompra) {
		this.urlCompra = urlCompra;
	}

	/**
	 * @return the usrIncl
	 */
	public String getUsrIncl() {
		return usrIncl;
	}

	/**
	 * @param usrIncl the usrIncl to set
	 */
	public void setUsrIncl(String usrIncl) {
		this.usrIncl = usrIncl;
	}

	/**
	 * @return the usrAlt
	 */
	public String getUsrAlt() {
		return usrAlt;
	}

	/**
	 * @param usrAlt the usrAlt to set
	 */
	public void setUsrAlt(String usrAlt) {
		this.usrAlt = usrAlt;
	}

	/**
	 * @return the dtInclusao
	 */
	public Date getDtInclusao() {
		return dtInclusao;
	}

	/**
	 * @param dtInclusao the dtInclusao to set
	 */
	public void setDtInclusao(Date dtInclusao) {
		this.dtInclusao = dtInclusao;
	}

	/**
	 * @return the dtAlteracao
	 */
	public Date getDtAlteracao() {
		return dtAlteracao;
	}

	/**
	 * @param dtAlteracao the dtAlteracao to set
	 */
	public void setDtAlteracao(Date dtAlteracao) {
		this.dtAlteracao = dtAlteracao;
	}
	
	
	
	
}
