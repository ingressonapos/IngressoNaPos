package br.usp.ime.ingpos.testes.services;

import org.junit.Test;

import br.usp.ime.ingpos.modelo.Usuario;
import br.usp.ime.ingpos.modelo.dao.UsuarioDao;
import br.usp.ime.ingpos.services.EmailException;
import br.usp.ime.ingpos.services.EmailService;
import br.usp.ime.ingpos.services.SenhaService;
import br.usp.ime.ingpos.services.UsuarioService;
import br.usp.ime.ingpos.testes.BancoDeDadosTestCase;
import br.usp.ime.ingpos.web.controllers.UsuarioSessao;

public class SenhaServiceTest
    extends
        BancoDeDadosTestCase
{

    private static String EMAIL = "turingxp@gmail.com";

    public SenhaServiceTest(
        String name )
    {
        super( name );
    }

    @Test
    public void testeAtualizarSenha()
    {

        final UsuarioDao usuarioDao = new UsuarioDao( getSessionCreator() );
        final UsuarioService usuarioService = new UsuarioService( usuarioDao, new UsuarioSessao() );
        Usuario usuario = usuarioService.procurarPorEmail( EMAIL );
        String senhaAnterior = usuario.getSenha();

        SenhaService senhaService = null;
        try {
            senhaService = new SenhaService(
                new UsuarioDao( getSessionCreator() ),
                new EmailService( EmailServiceTeste.construirSessionParaTeste() ) );
        } catch( EmailException e ) {
            assertTrue( false );
            e.printStackTrace();
        }
        assertTrue( senhaService.enviarEmailSucedido( EMAIL ) );

        usuario = usuarioService.procurarPorEmail( EMAIL );
        assertTrue( ! senhaAnterior.equals( usuario.getSenha() ) );
    }
}
