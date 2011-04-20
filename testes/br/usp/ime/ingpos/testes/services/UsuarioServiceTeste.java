package br.usp.ime.ingpos.testes.services;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import br.usp.ime.ingpos.modelo.CEP;
import br.usp.ime.ingpos.modelo.CedulaDeIdentidade;
import br.usp.ime.ingpos.modelo.DadosPessoais;
import br.usp.ime.ingpos.modelo.Endereco;
import br.usp.ime.ingpos.modelo.Telefone;
import br.usp.ime.ingpos.modelo.Telefone.NumeroTel;
import br.usp.ime.ingpos.modelo.TipoCedulaDeIdentidade;
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
		
		final CedulaDeIdentidade cedulaDeIdentidade = new CedulaDeIdentidade();
		cedulaDeIdentidade.setTipo(TipoCedulaDeIdentidade.RG);
		cedulaDeIdentidade.setNumero("45645655");
		cedulaDeIdentidade.setDigito("2");
		
		final CEP cep = new CEP();
		cep.setRegiao("12345");
		cep.setSufixo("000");
		
		final DadosPessoais dadosPessoais = new DadosPessoais();
		dadosPessoais.setCpf("12345678900");
		dadosPessoais.setEmail("admin@admin.com");
		dadosPessoais.setEstadoCivil(TipoEstadoCivil.SOLTEIRO);
		dadosPessoais.setNacionalidade("Brasileiro");
		dadosPessoais.setDataDeNascimento(new Date(88/12/10));
		dadosPessoais.setNomeCompleto("Maria Imaculada");
		dadosPessoais.setCedulaDeIdentidade(cedulaDeIdentidade);
		
		usuarioService.cadastrarDadosPessoais(usuario, dadosPessoais);
		
		assertEquals(usuario.getDadosPessoais().getCpf(), dadosPessoais.getCpf());
		assertEquals(usuario.getDadosPessoais().getEmail(), dadosPessoais.getEmail());
		assertEquals(usuario.getDadosPessoais().getEstadoCivil(), dadosPessoais.getEstadoCivil());
		assertEquals(usuario.getDadosPessoais().getNacionalidade(), dadosPessoais.getNacionalidade());
		assertEquals(usuario.getDadosPessoais().getDataDeNascimento(), dadosPessoais.getDataDeNascimento());
		assertEquals(usuario.getDadosPessoais().getNomeCompleto(), dadosPessoais.getNomeCompleto());
		assertEquals(usuario.getDadosPessoais().getCedulaDeIdentidade(), dadosPessoais.getCedulaDeIdentidade());
		assertEquals(usuario.getDadosPessoais().getEnderecoCorrespondencia(), dadosPessoais.getEnderecoCorrespondencia());
		assertEquals(usuario.getDadosPessoais().getEnderecoPermanente(), dadosPessoais.getEnderecoPermanente());
	}
	
	@Test
	public void testCadastrarDadosPessoaisPersistencia()
	{
		final UsuarioDao usuarioDao = new UsuarioDao(getSessionCreator());
		final List<Usuario> usuarios = usuarioDao.findAll();

		assertTrue(!usuarios.isEmpty());

		final Usuario usuario = usuarios.get(0);
		
		final CedulaDeIdentidade cedulaDeIdentidade = new CedulaDeIdentidade();
		cedulaDeIdentidade.setTipo(TipoCedulaDeIdentidade.RG);
		cedulaDeIdentidade.setNumero("45645655");
		cedulaDeIdentidade.setDigito("2");
		
		assertEquals(usuario.getDadosPessoais().getCpf(), "12345678900");
		assertEquals(usuario.getDadosPessoais().getEmail(), "admin@admin.com");
		assertEquals(usuario.getDadosPessoais().getEstadoCivil(), TipoEstadoCivil.SOLTEIRO);
		assertEquals(usuario.getDadosPessoais().getNacionalidade(), "Brasileiro");
		assertEquals(usuario.getDadosPessoais().getDataDeNascimento(), new Date(88/12/10));
		assertEquals(usuario.getDadosPessoais().getNomeCompleto(), "Maria Imaculada");
		assertEquals(usuario.getDadosPessoais().getCedulaDeIdentidade().getDigito(), cedulaDeIdentidade.getDigito());
		assertEquals(usuario.getDadosPessoais().getCedulaDeIdentidade().getNumero(), cedulaDeIdentidade.getNumero());
		assertEquals(usuario.getDadosPessoais().getCedulaDeIdentidade().getTipo(), cedulaDeIdentidade.getTipo());
	}
}
