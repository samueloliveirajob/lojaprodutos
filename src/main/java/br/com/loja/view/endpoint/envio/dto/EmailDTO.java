package br.com.loja.view.endpoint.envio.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmailDTO {
	
	@JsonProperty("identificacao")
	private String identificacao;	

	@JsonProperty("nome")
	private String nome;
	
	@JsonProperty("emailList")
	private String emailList;

	@JsonProperty("urlCompra")
	private String urlCompra;
	
	@JsonProperty("emailsErro")
	private List<String> emailsErro;
	
	@JsonProperty("emailsSucesso")
	private List<String> emailsSucesso;	
	
	public String getIdentificacao() {
		return identificacao;
	}

	public void setIdentificacao(String identificacao) {
		this.identificacao = identificacao;
	}	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmailList() {
		return emailList;
	}

	public void setEmailList(String emailList) {
		this.emailList = emailList;
	}

	public String getUrlCompra() {
		return urlCompra;
	}

	public void setUrlCompra(String urlCompra) {
		this.urlCompra = urlCompra;
	}
	
	public List<String> getEmailsErro() {
		return emailsErro;
	}

	public void setEmailsErro(List<String> emailsErro) {
		this.emailsErro = emailsErro;
	}

	public List<String> getEmailsSucesso() {
		return emailsSucesso;
	}

	public void setEmailsSucesso(List<String> emailsSucesso) {
		this.emailsSucesso = emailsSucesso;
	}	
	
}
