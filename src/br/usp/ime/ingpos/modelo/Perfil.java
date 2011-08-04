package br.usp.ime.ingpos.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Perfil 
implements
Serializable
{
	private static final long serialVersionUID = 5653550355165213879L;
	
	@Id
	@GeneratedValue
	private Long perfilID;
	private String descricao;
	public Long getPerfilID() {
		return perfilID;
	}
	public void setPerfilID(Long perfilID) {
		this.perfilID = perfilID;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

}
