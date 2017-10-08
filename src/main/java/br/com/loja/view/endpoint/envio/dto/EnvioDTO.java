package br.com.loja.view.endpoint.envio.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EnvioDTO {

	
	@JsonProperty("idUri")
	private Long idUri;
	
	@JsonProperty("canalOrigem")
	private Integer canalOrigem;
	
	@JsonProperty("nome")
	private String nome;
	
	@JsonProperty("nuAgencia")
	private String nuAgencia;
	
	@JsonProperty("idSolicitante")
	private String idSolicitante;
	
	@JsonProperty("urlCompra")
	private String urlCompra;
	
	
	
	
	public EnvioDTO(Integer canalOrigem, String nome, String nuAgencia, String idSolicitante){
		super();
		this.canalOrigem = canalOrigem;
		this.nome = nome;
		this.nuAgencia = nuAgencia;
		this.idSolicitante = idSolicitante;
	}
	
	public EnvioDTO(Integer canalOrigem, String nome, String idSolicitante) {
		super();
		this.canalOrigem = canalOrigem;
		this.nome = nome;
		this.idSolicitante = idSolicitante;
	}

	public EnvioDTO() {
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
	 * @return the canalOrigem
	 */
	public Integer getCanalOrigem() {
		return canalOrigem;
	}

	/**
	 * @param canalOrigem the canalOrigem to set
	 */
	public void setCanalOrigem(Integer canalOrigem) {
		this.canalOrigem = canalOrigem;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
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
	
	
		
}
