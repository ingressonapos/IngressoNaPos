package br.usp.ime.ingpos.modelo;

public class AreaDeInteresse {
	private String descricao;
	private boolean selecionada;
	
	public AreaDeInteresse(String descricao, boolean selecionada)
	{
		this.descricao = descricao;
		this.selecionada = selecionada;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public boolean isSelecionada() {
		return selecionada;
	}
	public void setSelecionada(boolean selecionada) {
		this.selecionada = selecionada;
	}
}