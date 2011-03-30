package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Usuario {
	@Id
	@GeneratedValue
	private Long usuarioID;
	@Column(length=50)
	private String nome;
	@Column(length=50)
	private String login;
	@Column(length=50)
	private String senha;
	@ManyToOne
	Perfil perfil;
	
	public Long getUsuarioID() {
		return usuarioID;
	}
	public void setUsuarioID(Long usuarioID) {
		this.usuarioID = usuarioID;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Perfil getPerfil() {
		return perfil;
	}
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	

}
