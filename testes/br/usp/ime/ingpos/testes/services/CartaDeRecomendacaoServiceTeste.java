package br.usp.ime.ingpos.testes.services;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.vraptor.util.test.MockLocalization;
import br.usp.ime.ingpos.modelo.CartaDeRecomendacao;
import br.usp.ime.ingpos.modelo.Usuario;
import br.usp.ime.ingpos.modelo.dao.CartaDeRecomendacaoDAO;
import br.usp.ime.ingpos.modelo.dao.UsuarioDao;
import br.usp.ime.ingpos.seguranca.Criptografia;
import br.usp.ime.ingpos.services.CartaDeRecomendacaoService;
import br.usp.ime.ingpos.services.EmailException;
import br.usp.ime.ingpos.services.EmailService;
import br.usp.ime.ingpos.services.UsuarioService;
import br.usp.ime.ingpos.testes.BancoDeDadosTestCase;
import br.usp.ime.ingpos.web.controllers.UsuarioSessao;

public class CartaDeRecomendacaoServiceTeste
    extends
        BancoDeDadosTestCase
{

    public CartaDeRecomendacaoServiceTeste(
        String name )
    {
        super( name );
    }

    @Test
    public void testSolicitarRecomendacao()
    {
        try {
            final UsuarioService usuarioService = new UsuarioService( new UsuarioDao(
                getSessionCreator() ), new UsuarioSessao() );

            final EmailService emailSevice = new EmailService(
                EmailServiceTeste.construirSessionParaTeste() );

            final Usuario usuario = usuarioService.procurarPorEmail( RegistroNovoUsuarioServiceTeste.EMAIL );

            assertNotNull( usuario );

            final UsuarioSessao usuarioSessao = new UsuarioSessao();
            usuarioSessao.setUsuario( usuario );

            final CartaDeRecomendacaoService cartaDeRecomendacaoService = new CartaDeRecomendacaoService(
                new CartaDeRecomendacaoDAO( getSessionCreator() ),
                usuarioSessao,
                emailSevice,
                null,
                new MockLocalization() );

            final CartaDeRecomendacao cartaDeRecomendacao = new CartaDeRecomendacao();

            cartaDeRecomendacao.setUsuario( usuario );
            cartaDeRecomendacao.setNome( "Professor Alfredo" );
            cartaDeRecomendacao.setEmail( RegistroNovoUsuarioServiceTeste.EMAIL );
            cartaDeRecomendacaoService.solicitarRecomendacao( cartaDeRecomendacao );

            String hash = Criptografia.md5( cartaDeRecomendacao.getEmail() + usuario.getEmail() );
            CartaDeRecomendacao cartasDeRecomendacaoExistente = cartaDeRecomendacaoService.procurarPorHash( hash );
            Assert.assertNotNull( cartasDeRecomendacaoExistente );

            Assert.assertEquals( cartaDeRecomendacao.getEmail(),
                cartasDeRecomendacaoExistente.getEmail() );
            Assert.assertEquals( cartaDeRecomendacao.getNome(),
                cartasDeRecomendacaoExistente.getNome() );
            Assert.assertEquals( cartaDeRecomendacao.getUsuario(),
                cartasDeRecomendacaoExistente.getUsuario() );

        } catch( EmailException e ) {
            assertTrue( false );
            e.printStackTrace();
        }
    }

    @Test
    public void testProcurarCartasDeRecomendacaoPorUsuario()
    {
        try {
            final UsuarioService usuarioService = new UsuarioService( new UsuarioDao(
                getSessionCreator() ), new UsuarioSessao() );

            final EmailService emailSevice = new EmailService(
                EmailServiceTeste.construirSessionParaTeste() );

            final Usuario usuario = usuarioService.procurarPorEmail( RegistroNovoUsuarioServiceTeste.EMAIL );

            assertNotNull( usuario );

            final UsuarioSessao usuarioSessao = new UsuarioSessao();
            usuarioSessao.setUsuario( usuario );

            final CartaDeRecomendacaoService cartaDeRecomendacaoService = new CartaDeRecomendacaoService(
                new CartaDeRecomendacaoDAO( getSessionCreator() ),
                usuarioSessao,
                emailSevice,
                null,
                new MockLocalization() );

            List<CartaDeRecomendacao> cartas = cartaDeRecomendacaoService.procurarPorUsuario( usuario );
            assertNotNull( cartas );
            assertNotNull( cartas.size() > 0 );

        } catch( EmailException e ) {
            assertTrue( false );
            e.printStackTrace();
        }
    }

    @Test
    public void testReenviarCartaDeRecomendacao()
    {
        try {
            final UsuarioService usuarioService = new UsuarioService( new UsuarioDao(
                getSessionCreator() ), new UsuarioSessao() );

            final EmailService emailSevice = new EmailService(
                EmailServiceTeste.construirSessionParaTeste() );

            final Usuario usuario = usuarioService.procurarPorEmail( RegistroNovoUsuarioServiceTeste.EMAIL );
            assertNotNull( usuario );

            final UsuarioSessao usuarioSessao = new UsuarioSessao();
            usuarioSessao.setUsuario( usuario );

            final CartaDeRecomendacaoService cartaDeRecomendacaoService = new CartaDeRecomendacaoService(
                new CartaDeRecomendacaoDAO( getSessionCreator() ),
                usuarioSessao,
                emailSevice,
                null,
                new MockLocalization() );

            final List<CartaDeRecomendacao> cartas = cartaDeRecomendacaoService.procurarPorUsuario( usuario );
            
            assertNotNull( cartas );
            assertTrue( cartas.size() > 0 );
            
            cartaDeRecomendacaoService.reenviarRecomendacao( cartas.get( 0 ) );
                        

        } catch( EmailException e ) {
            assertTrue( false );
            e.printStackTrace();
        }
    }
}
