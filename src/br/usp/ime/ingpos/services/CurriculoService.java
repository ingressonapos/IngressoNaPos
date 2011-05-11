package br.usp.ime.ingpos.services;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.RequestScoped;
import br.com.caelum.vraptor.ioc.SessionScoped;
import br.usp.ime.ingpos.modelo.Curriculo;
import br.usp.ime.ingpos.modelo.Usuario;
import br.usp.ime.ingpos.modelo.dao.CurriculoDAO;
import br.usp.ime.ingpos.web.controllers.UsuarioSessao;

@RequestScoped
@Component
public class CurriculoService {
	private CurriculoDAO curriculoDAO;
	private UsuarioSessao usuarioSessao;

	
	public CurriculoService(final CurriculoDAO curriculoDAO,
			final UsuarioSessao usuarioSessao) {
		this.curriculoDAO = curriculoDAO;
		this.usuarioSessao = usuarioSessao;
	}

	public Curriculo getCurriculo() {
		return usuarioSessao.getUsuario().getCandidato().getCurriculo();
	}

	public void cadastraCurriculo(Curriculo curriculo) {
		curriculoDAO.saveOrUpdate(curriculo);
	}

	public Curriculo procuraCurriculo(Usuario usuario){
		return usuario.getCandidato().getCurriculo();
	}
}
