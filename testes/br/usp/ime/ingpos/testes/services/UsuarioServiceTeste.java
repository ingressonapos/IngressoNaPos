package br.usp.ime.ingpos.testes.services;

import java.util.List;

import org.junit.Test;

import br.usp.ime.ingpos.modelo.DadosPessoais;
import br.usp.ime.ingpos.modelo.TipoEstadoCivil;
import br.usp.ime.ingpos.modelo.Usuario;
import br.usp.ime.ingpos.modelo.dao.UsuarioDao;
import br.usp.ime.ingpos.services.UsuarioService;
import br.usp.ime.ingpos.testes.BancoDeDadosTestCase;
import br.usp.ime.ingpos.web.controllers.UsuarioSessao;

public class UsuarioServiceTeste extends BancoDeDadosTestCase {

	public UsuarioServiceTeste(String name) {
		super(name);
	}

	@Test
	public void testAutenticar() {
		final UsuarioService usuarioService = new UsuarioService(
				new UsuarioDao(getSessionCreator()), new UsuarioSessao());

		assertTrue(usuarioService.autenticar("teste@teste.com", "12345"));
	}

	@Test
	public void testRegistrar() {
		final UsuarioService usuarioService = new UsuarioService(
				new UsuarioDao(getSessionCreator()), new UsuarioSessao());
		
		assertTrue(usuarioService.autenticar("teste@teste.com", "12345"));
	}

	@Test
	public void testCadastrarDadosPessoais() {
		final UsuarioDao usuarioDao = new UsuarioDao(getSessionCreator());
		final List<Usuario> usuarios = usuarioDao.findAll();

		assertTrue(!usuarios.isEmpty());

		final Usuario usuario = usuarios.get(0);
		final UsuarioSessao usuarioSessao = new UsuarioSessao();
		usuarioSessao.setUsuario(usuario);

		final UsuarioService usuarioService = new UsuarioService(usuarioDao,
				usuarioSessao);
		
		final DadosPessoais dadosPessoais = new DadosPessoais();
		dadosPessoais.setCpf("12345678900");
		dadosPessoais.setEmail("admin@admin.com");
		dadosPessoais.setEstadoCivil(TipoEstadoCivil.SOLTEIRO);
		dadosPessoais.setNacionalidade("Brasileiro");
		
		usuarioService.cadastrarDadosPessoais(usuario, dadosPessoais);
		
		assertEquals(usuario.getDadosPessoais().getCpf(), dadosPessoais.getCpf());
		assertEquals(usuario.getDadosPessoais().getEmail(), dadosPessoais.getEmail());
		assertEquals(usuario.getDadosPessoais().getEstadoCivil(), dadosPessoais.getEstadoCivil());
		assertEquals(usuario.getDadosPessoais().getNacionalidade(), dadosPessoais.getNacionalidade());
	}
	
	@Test
	public void testCadastrarDadosPessoaisPersistencia()
	{
		final UsuarioDao usuarioDao = new UsuarioDao(getSessionCreator());
		final List<Usuario> usuarios = usuarioDao.findAll();

		assertTrue(!usuarios.isEmpty());

		final Usuario usuario = usuarios.get(0);
		
		assertEquals(usuario.getDadosPessoais().getCpf(), "12345678900");
	}
}
