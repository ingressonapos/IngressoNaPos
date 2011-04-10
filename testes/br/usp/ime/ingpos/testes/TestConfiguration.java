package br.usp.ime.ingpos.testes;

import java.util.ArrayList;
import java.util.List;

import br.usp.ime.ingpos.testes.modelo.UsuarioTeste;
import br.usp.ime.ingpos.testes.seguranca.TestaCriptografia;
import br.usp.ime.ingpos.testes.services.UsuarioServiceTeste;

public class TestConfiguration
{
    private final List<Class<?>> allTests = new ArrayList<Class<?>>();
    {
        allTests.add( TestaCriptografia.class );
        allTests.add( UsuarioTeste.class );
        allTests.add( UsuarioServiceTeste.class );
    }

    public List<Class<?>> getAllTests()
    {
        return allTests;
    }
}
