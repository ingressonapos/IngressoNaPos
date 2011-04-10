package br.usp.ime.ingpos.testes.services;

import org.junit.Test;

import br.usp.ime.ingpos.modelo.dao.UsuarioDao;
import br.usp.ime.ingpos.services.UsuarioService;
import br.usp.ime.ingpos.testes.BancoDeDadosTestCase;
import br.usp.ime.ingpos.web.controllers.UsuarioSessao;

public class UsuarioServiceTeste
    extends
        BancoDeDadosTestCase
{

    public UsuarioServiceTeste(
        String name )
    {
        super( name );
    }

    @Test
    public void testAutenticar()
    {
        final UsuarioService usuarioService = new UsuarioService( new UsuarioDao(
            getSessionCreator() ), new UsuarioSessao() );

        assertTrue( usuarioService.autenticar( "teste", "12345" ) );
    }
    
    @Test
    public void testRegistrar()
    {
        final UsuarioService usuarioService = new UsuarioService( new UsuarioDao(
            getSessionCreator() ), new UsuarioSessao() );

        assertTrue( usuarioService.autenticar( "teste", "12345" ) );
    }

}
