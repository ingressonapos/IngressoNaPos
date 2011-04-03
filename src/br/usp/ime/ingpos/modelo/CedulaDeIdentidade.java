package br.usp.ime.ingpos.modelo;

public enum CedulaDeIdentidade {

	RG("", ""), RNE("", "");
	
	private String numero;
	private String digitos;
	
	CedulaDeIdentidade(String numero, String digitos) {
		this.numero = numero;
		this.digitos = digitos;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getDigitos() {
		return digitos;
	}

	public void setDigitos(String digitos) {
		this.digitos = digitos;
	}
}
