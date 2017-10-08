package br.com.loja.controller;

public class SendSmsResponse {

	private String detailDescription;
	
	private String statusDescription;
	
	private String detailCode;
	
	private String statusCode;

	
	/**
	 * @return the detailDescription
	 */
	public String getDetailDescription() {
		return detailDescription;
	}

	/**
	 * @param detailDescription the detailDescription to set
	 */
	public void setDetailDescription(String detailDescription) {
		this.detailDescription = detailDescription;
	}

	/**
	 * @return the statusDescription
	 */
	public String getStatusDescription() {
		return statusDescription;
	}

	/**
	 * @param statusDescription the statusDescription to set
	 */
	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}

	/**
	 * @return the detailCode
	 */
	public String getDetailCode() {
		return detailCode;
	}

	/**
	 * @param detailCode the detailCode to set
	 */
	public void setDetailCode(String detailCode) {
		this.detailCode = detailCode;
	}

	/**
	 * @return the statusCode
	 */
	public String getStatusCode() {
		return statusCode;
	}

	/**
	 * @param statusCode the statusCode to set
	 */
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	
}
