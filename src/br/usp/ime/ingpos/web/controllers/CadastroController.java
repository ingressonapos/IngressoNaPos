package br.usp.ime.ingpos.web.controllers;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;

@Resource
public class CadastroController {
	
	public CadastroController() {
	}
	
	
	@Get
	@Path("/cadastro/dadosUsuario")
	public void dadosUsuario() {
		
	}

}
