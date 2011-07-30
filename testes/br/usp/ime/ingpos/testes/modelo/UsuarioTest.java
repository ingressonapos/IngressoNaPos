package br.usp.ime.ingpos.testes.modelo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.usp.ime.ingpos.modelo.Usuario;
import br.usp.ime.ingpos.testes.IngPosTestCase;

public class UsuarioTest
    extends
        IngPosTestCase
{
    private Usuario usuario;

    public UsuarioTest(
        String name )
    {
        super( name );
    }

    @Before
    public void setUp()
        throws Exception
    {
        usuario = new Usuario();
    }

    @After
    public void tearDown()
        throws Exception
    {
        usuario = null;
    }

    @Test
    public void testUsuarioId()
    {
        final Long usuarioID = 1L;
        usuario.setUsuarioID( usuarioID );
        assertNotNull( usuario.getUsuarioID() );
    }

}
