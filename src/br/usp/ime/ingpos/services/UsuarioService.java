package br.usp.ime.ingpos.services;

import java.util.List;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.RequestScoped;
import br.usp.ime.ingpos.modelo.DadosPessoais;
import br.usp.ime.ingpos.modelo.Usuario;
import br.usp.ime.ingpos.modelo.dao.UsuarioDao;
import br.usp.ime.ingpos.seguranca.Criptografia;
import br.usp.ime.ingpos.web.controllers.UsuarioSessao;

@RequestScoped
@Component
public class UsuarioService {
	private final UsuarioDao usuarioDAO;
	private final UsuarioSessao usuarioSessao;

	public UsuarioService(final UsuarioDao usuarioDAO,
			final UsuarioSessao usuarioSessao) {
		this.usuarioDAO = usuarioDAO;
		this.usuarioSessao = usuarioSessao;
	}

	public void salvar(final Usuario usuario) {
		final String senha = Criptografia.md5(usuario.getDadosPessoais()
				.getSenha());
		usuario.getDadosPessoais().setSenha(senha);
		usuarioDAO.save(usuario);
	}

    public Usuario procurarPorEmail(String email) {
        return usuarioDAO.procurarPorEmail(email);
    }

    public List<Usuario> listaTodos() {
        return usuarioDAO.findAll();
    }

	public boolean autenticar(final String userName, String senha) {
		senha = Criptografia.md5(senha);

		final Usuario usuario = usuarioDAO.findByEmailAndPassword(userName,
				senha);

		final boolean success;
		if (usuario == null) {
			success = false;
		} else {
			usuarioSessao.setUsuario(usuario);
			success = true;
		}
		return success;
	}

	public void deautenticate() {
		usuarioSessao.setUsuario(null);
	}

	public void cadastrarDadosPessoais(Usuario usuario,
			DadosPessoais dadosPessoais) {
        usuario.setDadosPessoais( dadosPessoais);
		usuarioDAO.save(usuario);
	}
}
