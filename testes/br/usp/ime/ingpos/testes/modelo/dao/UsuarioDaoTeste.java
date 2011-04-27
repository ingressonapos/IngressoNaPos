package br.usp.ime.ingpos.testes.modelo.dao;

import java.util.List;

import org.junit.Test;

import br.usp.ime.ingpos.modelo.Usuario;
import br.usp.ime.ingpos.modelo.dao.UsuarioDao;
import br.usp.ime.ingpos.testes.BancoDeDadosTestCase;

public class UsuarioDaoTeste
    extends
        BancoDeDadosTestCase
{
    public UsuarioDaoTeste(
        String name )
    {
        super( name );
    }

    @Test
    public void testControleDeSessao()
    {
        final UsuarioDao usuarioDao = new UsuarioDao( getSessionCreator() );

        try {

            List<Usuario> usuarios = usuarioDao.findAll();
            assertTrue( usuarios.size() >= 0 );

        } catch( Exception e ) {
            e.printStackTrace();
            assertTrue( false );
        }

    }

}
