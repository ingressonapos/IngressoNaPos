package br.usp.ime.ingpos.testes.modelo;

import org.junit.Test;

import br.usp.ime.ingpos.modelo.DadosPessoais;
import br.usp.ime.ingpos.testes.BancoDeDadosTestCase;

public class DadosPessoaisTeste
    extends
        BancoDeDadosTestCase
{
    public DadosPessoaisTeste(
        String name )
    {
        super( name );
    }

    @Test
    public void testIsValidoCpf()
    {
        assertEquals(true, DadosPessoais.isValidoCpf("389.569.378-26"));
        assertEquals(true, DadosPessoais.isValidoCpf("38956937826"));
        assertEquals(false, DadosPessoais.isValidoCpf("0"));
        assertEquals(false, DadosPessoais.isValidoCpf("000.000.000-00"));
        assertEquals(false, DadosPessoais.isValidoCpf("111.111.111-11"));
        assertEquals(false, DadosPessoais.isValidoCpf("11111111111"));
        assertEquals(false, DadosPessoais.isValidoCpf(null));
        assertEquals(false, DadosPessoais.isValidoCpf("teste"));
    }
}
