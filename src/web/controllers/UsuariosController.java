package web.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;



import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;


@Resource
public class UsuariosController {
	
	private Result result;
	private UsuarioSessao usuarioSessao;
	private HttpServletRequest request;
	
	public UsuariosController(HttpServletRequest request, Result result, UsuarioSessao usuarioSessao){
		this.request = request;
		this.result = result;
		this.usuarioSessao = usuarioSessao;
	}

}
