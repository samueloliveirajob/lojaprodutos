package br.com.loja.view.endpoint.envio.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SmsDTO {

	@JsonProperty("identificacao")
	private String identificacao;
	
	@JsonProperty("celular")
	private String celular;
	
	@JsonProperty("urlCompra")
	private String urlCompra;
	
	@JsonProperty("celularesErro")
	private List<String> celularesErro;
	
	@JsonProperty("celularesSucesso")
	private List<String> celularesSucesso;
	
	
	/**
	 * @return the identificacao
	 */
	public String getIdentificacao() {
		return identificacao;
	}
	/**
	 * @param identificacao the identificacao to set
	 */
	public void setIdentificacao(String identificacao) {
		this.identificacao = identificacao;
	}
	/**
	 * @return the celular
	 */
	public String getCelular() {
		return celular;
	}
	/**
	 * @param celular the celular to set
	 */
	public void setCelular(String celular) {
		this.celular = celular;
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
	 * @return the celularesErro
	 */
	public List<String> getCelularesErro() {
		return celularesErro;
	}
	/**
	 * @param celularesErro the celularesErro to set
	 */
	public void setCelularesErro(List<String> celularesErro) {
		this.celularesErro = celularesErro;
	}
	/**
	 * @return the celularesSucesso
	 */
	public List<String> getCelularesSucesso() {
		return celularesSucesso;
	}
	/**
	 * @param celularesSucesso the celularesSucesso to set
	 */
	public void setCelularesSucesso(List<String> celularesSucesso) {
		this.celularesSucesso = celularesSucesso;
	}
	
}
