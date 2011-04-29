package br.usp.ime.ingpos.testes.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import br.usp.ime.ingpos.modelo.Bolsa;
import br.usp.ime.ingpos.modelo.Curriculo;
import br.usp.ime.ingpos.modelo.FormacaoAcademica;
import br.usp.ime.ingpos.modelo.IniciacaoCientifica;
import br.usp.ime.ingpos.modelo.PosComp;
import br.usp.ime.ingpos.modelo.Usuario;
import br.usp.ime.ingpos.modelo.dao.CurriculoDAO;
import br.usp.ime.ingpos.services.CurriculoService;
import br.usp.ime.ingpos.testes.BancoDeDadosTestCase;
import br.usp.ime.ingpos.web.controllers.UsuarioSessao;

public class CurriculoServiceTeste extends BancoDeDadosTestCase {

	public CurriculoServiceTeste(String name) {
		super(name);
	}
	
	public Bolsa instanciaBolsa(){
		Bolsa bolsas = new Bolsa();
		bolsas.setTipoBolsa("Monitoria");
		bolsas.setNomeInstituicao("IME");
		bolsas.setDuracao(12);
		bolsas.setNomeOrientador("Alfredo");
		bolsas.setNomeProjeto("Ingresso na Pos");
		return bolsas;
	}
	
	public PosComp instanciaPosComp(){
		PosComp posComp = new PosComp();
		posComp.setArquivoPosComp("entrada");
		posComp.setNotaLogica(100);
		posComp.setNotaMatematica(100);
		posComp.setNotaTecnologia(100);
		return posComp;
	}
	
	public FormacaoAcademica instanciaFormacao(){
		FormacaoAcademica formacaoAcademica =  new FormacaoAcademica();
		formacaoAcademica.setInstituicao("IME");
		formacaoAcademica.setIngressoData( new Date( 2001 / 12 / 10 ));
		formacaoAcademica.setNomeOrientador("Obama");
		formacaoAcademica.setTerminoData(new Date( 2002 / 12 / 10 ));
		formacaoAcademica.setTitulo("Mestre");
		formacaoAcademica.setTituloDissert("Pombas e o MAC");
		return formacaoAcademica;
	}
	
	public IniciacaoCientifica instanciaIniciacao(){
		IniciacaoCientifica iniciacaoCientifica = new IniciacaoCientifica();
		iniciacaoCientifica.setNomeInstituicao("IF");
		iniciacaoCientifica.setNomeOrientador("Homer");
		iniciacaoCientifica.setTemaProjeto("Duff e a teoria das cordas");
		return iniciacaoCientifica;
	}
	
	@Test
	public void testeCadastrarCurriculo(){
		
		Usuario usuario;
		CurriculoDAO curriculoDAO = new CurriculoDAO(getSessionCreator());
		UsuarioSessao usuarioSessao = new UsuarioSessao();
		CurriculoService curriculoService = new CurriculoService(curriculoDAO, usuarioSessao);
		
		Curriculo curriculo = new Curriculo();
		
		Set<Bolsa> bolsas = null;
		Set<FormacaoAcademica> formacaoAcademicas = null;
		Set<IniciacaoCientifica> iniciacaoCientificas = null;
		Bolsa bolsa1 = instanciaBolsa();
		FormacaoAcademica formacaoAcademica1 = instanciaFormacao();
		IniciacaoCientifica iniciacaoCientifica1 = instanciaIniciacao();
		PosComp posComp = instanciaPosComp();
		bolsas.add(bolsa1);
		formacaoAcademicas.add(formacaoAcademica1);
		iniciacaoCientificas.add(iniciacaoCientifica1);
		
		curriculo.setBolsas(bolsas);
		curriculo.setPosComp(posComp);
		curriculo.setFormacaoAcademica(formacaoAcademicas);
		curriculo.setIniciacaoCientifica(iniciacaoCientificas);

		curriculoService.cadastraCurriculo(curriculo);
		
		
	}
	

}
