package br.usp.ime.ingpos.modelo;


import javax.persistence.Entity;


public enum CedulaDeIdentidade {
	RG("", ""), RNE("", ""), PASSAPORTE("","");
	
	private String numero;
	private String digito;
	
	CedulaDeIdentidade(String numero, String digito) {
		this.numero = numero;
		this.digito = digito;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getDigito() {
		return digito;
	}
	public void setDigito(String digito) {
		this.digito = digito;
	}
}