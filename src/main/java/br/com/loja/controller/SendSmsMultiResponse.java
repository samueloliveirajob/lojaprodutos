package br.com.loja.controller;

import java.util.List;

public class SendSmsMultiResponse {

	private List<SendSmsResponse> sendSmsResponseList;

	/**
	 * @return the sendSmsResponseList
	 */
	public List<SendSmsResponse> getSendSmsResponseList() {
		return sendSmsResponseList;
	}

	/**
	 * @param sendSmsResponseList the sendSmsResponseList to set
	 */
	public void setSendSmsResponseList(List<SendSmsResponse> sendSmsResponseList) {
		this.sendSmsResponseList = sendSmsResponseList;
	}
	
}
