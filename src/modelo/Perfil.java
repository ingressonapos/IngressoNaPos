package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Perfil {
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
