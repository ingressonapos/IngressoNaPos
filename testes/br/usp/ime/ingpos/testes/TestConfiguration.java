package br.usp.ime.ingpos.testes;

import java.util.ArrayList;
import java.util.List;

import br.usp.ime.ingpos.testes.modelo.UsuarioTest;

public class TestConfiguration
{
    private final List<Class<?>> allTests = new ArrayList<Class<?>>();
    {
        allTests.add( AuditTest.class );
        allTests.add( UsuarioTest.class );
    }

    public List<Class<?>> getAllTests()
    {
        return allTests;
    }
}
