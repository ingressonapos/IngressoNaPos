package br.usp.ime.ingpos.testes.services;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import br.usp.ime.ingpos.modelo.Bolsa;
import br.usp.ime.ingpos.modelo.Curriculo;
import br.usp.ime.ingpos.modelo.FormacaoAcademica;
import br.usp.ime.ingpos.modelo.IniciacaoCientifica;
import br.usp.ime.ingpos.modelo.PosComp;
import br.usp.ime.ingpos.modelo.Usuario;
import br.usp.ime.ingpos.modelo.dao.CurriculoDAO;
import br.usp.ime.ingpos.modelo.dao.FormacaoAcademicaDAO;
import br.usp.ime.ingpos.modelo.dao.UsuarioDao;
import br.usp.ime.ingpos.services.CurriculoService;
import br.usp.ime.ingpos.testes.BancoDeDadosTestCase;
import br.usp.ime.ingpos.web.controllers.UsuarioSessao;

public class CurriculoServiceTeste
    extends
        BancoDeDadosTestCase
{

    private UsuarioDao usuarioDao;
    private Usuario usuario;
    private UsuarioSessao usuarioSessao;
    private CurriculoDAO curriculoDAO;
    private CurriculoService curriculoService;
    private Curriculo curriculo;
    private FormacaoAcademicaDAO formacaoAcademicaDAO;

    public CurriculoServiceTeste(
        String name )
    {
        super( name );
    }

    @Before
    protected void setUp()
        throws Exception
    {
        super.setUp();
        usuarioDao = new UsuarioDao( getSessionCreator() );
        usuario = usuarioDao.procurarPorEmail( RegistroNovoUsuarioServiceTeste.EMAIL );
        usuarioSessao = new UsuarioSessao();
        usuarioSessao.setUsuario( usuario );
        formacaoAcademicaDAO = new FormacaoAcademicaDAO( getSessionCreator() );
        curriculoDAO = new CurriculoDAO( getSessionCreator() );
        curriculoService = new CurriculoService( curriculoDAO, formacaoAcademicaDAO, usuarioSessao );
        curriculo = new Curriculo();
    };

    public Bolsa instanciaBolsa()
    {
        Bolsa bolsas = new Bolsa();
        bolsas.setTipoBolsa( "Monitoria" );
        bolsas.setNomeInstituicao( "IME" );
        bolsas.setIngressoData( new Date( 2001 / 12 / 10 ) );
        bolsas.setTerminoData( new Date( 2002 / 12 / 10 ) );
        bolsas.setNomeOrientador( "Alfredo" );
        bolsas.setNomeProjeto( "Ingresso na Pos" );
        return bolsas;
    }

    public PosComp instanciaPosComp()
    {
        PosComp posComp = new PosComp();
        posComp.setArquivoPosComp( "entrada" );
        posComp.setNotaLogica( 100 );
        posComp.setNotaMatematica( 100 );
        posComp.setNotaTecnologia( 100 );
        return posComp;
    }

    public FormacaoAcademica instanciaFormacao()
    {
        FormacaoAcademica formacaoAcademica = new FormacaoAcademica();
        formacaoAcademica.setInstituicao( "IME" );
        formacaoAcademica.setIngressoData( new Date( 2001 / 12 / 10 ) );
        formacaoAcademica.setNomeOrientador( "Obama" );
        formacaoAcademica.setTerminoData( new Date( 2002 / 12 / 10 ) );
        formacaoAcademica.setTitulo( "Mestre" );
        formacaoAcademica.setTituloDissert( "Pombas e o MAC" );
        return formacaoAcademica;
    }

    public IniciacaoCientifica instanciaIniciacao()
    {
        IniciacaoCientifica iniciacaoCientifica = new IniciacaoCientifica();
        iniciacaoCientifica.setNomeInstituicao( "IF" );
        iniciacaoCientifica.setNomeOrientador( "Homer" );
        iniciacaoCientifica.setTemaProjeto( "Duff e a teoria das cordas" );
        return iniciacaoCientifica;
    }

    @Test
    public void testeCadastrarCurriculo()
    {

        // Set<Bolsa> bolsas = new TreeSet<Bolsa>();
        // Set<FormacaoAcademica> formacaoAcademicas = new
        // TreeSet<FormacaoAcademica>();
        // Set<IniciacaoCientifica> iniciacaoCientificas = new
        // TreeSet<IniciacaoCientifica>();
        // Bolsa bolsa1 = instanciaBolsa();
        // FormacaoAcademica formacaoAcademica1 = instanciaFormacao();
        // IniciacaoCientifica iniciacaoCientifica1 = instanciaIniciacao();
        // PosComp posComp = instanciaPosComp();
        // bolsas.add(bolsa1);
        // formacaoAcademicas.add(formacaoAcademica1);
        // iniciacaoCientificas.add(iniciacaoCientifica1);
        //
        // curriculo.setBolsas(bolsas);
        // curriculo.setPosComp(posComp);
        // curriculo.setFormacaoAcademica(formacaoAcademicas);
        // curriculo.setIniciacaoCientifica(iniciacaoCientificas);
        // usuario.setCurriculo(curriculo);
        //
        // curriculoService.cadastraCurriculo(curriculo);

    }

    @Test
    public void testeSalvaFormacaoAcademica()
    {
        FormacaoAcademica formacaoAcademica = instanciaFormacao();
        curriculoService.salvaFormacaoAcademica( usuario, usuarioDao, formacaoAcademica );

        assertTrue( usuario.getCandidato().getCurriculo().getFormacoesAcademicas().contains(
            formacaoAcademica ) );
    }

    @Test
    public void testeProcuraFormacaoAcademicaNulo()
    {
        FormacaoAcademica formacaoAcademica = instanciaFormacao();
        assertEquals( null,
            curriculoService.procuraFormacao( usuario, usuarioDao, formacaoAcademica ) );
    }

    @Test
    public void testeRemoveFormacaoAcademica()
    {
        FormacaoAcademica formacaoAcademica = instanciaFormacao();
        curriculoService.removerFormacaoAcademica( usuario, usuarioDao, formacaoAcademica );

    }

    @Test
    public void testeSalvaIniciacaoCientifica()
    {
        IniciacaoCientifica iniciacaoCientifica = instanciaIniciacao();
        curriculoService.salvaIniciacaoCientifica( usuario, usuarioDao, iniciacaoCientifica );

        assertTrue( usuario.getCandidato().getCurriculo().getIniciacoesCientificas().contains(
            iniciacaoCientifica ) );
    }

    @Test
    public void testeSalvaPosComp()
    {
        PosComp posComp = instanciaPosComp();
        curriculoService.salvaPosComp( usuario, usuarioDao, posComp );

        assertEquals( posComp, usuario.getCandidato().getCurriculo().getPosComp() );
    }

}
