package web.controllers;

import java.io.Serializable;

import modelo.Usuario;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;


@Component
@SessionScoped
public class UsuarioSessao implements Serializable  {
	private static final long serialVersionUID = 1L; 
	private Usuario usuario;
	
	public Usuario getUsuario(){
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public String getNome(){
		return usuario.getNome();
	}

}
