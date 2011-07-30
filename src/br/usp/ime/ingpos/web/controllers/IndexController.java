package br.usp.ime.ingpos.web.controllers;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;

@Resource
public class IndexController {
	private UsuarioSessao usuarioSessao;
	
	public IndexController(UsuarioSessao usuarioSessao){
		this.usuarioSessao = usuarioSessao;
	}
	
	@Get
	@Path("/")
	public void index() {
	}

}
