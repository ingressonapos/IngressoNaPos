package br.usp.ime.ingpos.web.controllers;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.usp.ime.ingpos.modelo.dao.CurriculoDAO;

@Resource
public class CadastroController {
	private Result result;
	private UsuarioSessao usuarioSessao;
	
	public CadastroController( Result result, UsuarioSessao usuarioSessao) {
		this.result = result;
		this.usuarioSessao = usuarioSessao;
	}
	
	
	@Get
	@Path("/cadastro/dadosUsuario")
	public void dadosUsuario() {
		
	}	
	
	@Get
	@Path("/cadastro/dadosCurriculo")
	public void dadosCurriculo() {
		
	}
	
	@Get
	@Path("cadastro/registro")
	public void registro(){
		// TODO Criar a permissão para acessar sem login
	}
	

}
