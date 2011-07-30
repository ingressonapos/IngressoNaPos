package br.usp.ime.ingpos.testes.modelo;

import org.junit.Test;

import br.usp.ime.ingpos.modelo.dao.UsuarioDao;
import br.usp.ime.ingpos.testes.IngPosTestCase;

public class UsuarioTest
    extends
        IngPosTestCase
{
    public UsuarioTest(
        String name )
    {
        super( name );
    }

    @Test
    public void testUsuarioId()
    {
        final UsuarioDao usuarioDao = new UsuarioDao( getSessionCreator() );
        assertTrue( ! usuarioDao.findAll().isEmpty() );
    }
}
