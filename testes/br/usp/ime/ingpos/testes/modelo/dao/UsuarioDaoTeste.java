package br.usp.ime.ingpos.testes.modelo.dao;

import org.junit.Test;

import br.usp.ime.ingpos.modelo.dao.UsuarioDao;
import br.usp.ime.ingpos.seguranca.Criptografia;
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
    public void testprocurarPorEmail()
    {
        final UsuarioDao usuarioDao = new UsuarioDao( getSessionCreator() );
        final String email = "teste";

        assertNotNull( ( usuarioDao.procurarPorEmail( email ) ) );

    }

    @Test
    public void testFindByEmailAndPassword()
    {
        final UsuarioDao usuarioDao = new UsuarioDao( getSessionCreator() );
        final String email = "teste";
        final String senha = "12345";

        assertNotNull( usuarioDao.findByEmailAndPassword( email, Criptografia.md5( senha ) ) );

    }
}
