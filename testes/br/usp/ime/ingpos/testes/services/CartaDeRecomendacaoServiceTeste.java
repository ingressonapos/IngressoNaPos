package br.usp.ime.ingpos.testes.services;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

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

            if( usuarioService.listaTodos().size() > 0 ) {

                final Usuario usuario = usuarioService.listaTodos().get( 0 );
                final UsuarioSessao usuarioSessao = new UsuarioSessao();
                usuarioSessao.setUsuario( usuario );

                final CartaDeRecomendacaoService cartaDeRecomendacaoService = new CartaDeRecomendacaoService(
                    new CartaDeRecomendacaoDAO( getSessionCreator() ),
                    usuarioSessao,
                    emailSevice,
                    null );

                final CartaDeRecomendacao cartaDeRecomendacao = new CartaDeRecomendacao();

                cartaDeRecomendacao.setUsuario( usuario );
                cartaDeRecomendacao.setNome( "Professor Alfredo" );
                cartaDeRecomendacao.setEmail( "ingressonaposxp@gmail.com" );
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
            }

        } catch( EmailException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
    }

}
