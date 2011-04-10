package br.usp.ime.ingpos.testes.seguranca;

import org.junit.Assert;
import org.junit.Test;

import br.usp.ime.ingpos.seguranca.Criptografia;
import br.usp.ime.ingpos.testes.IngPosTestCase;

public class TestaCriptografia
    extends
        IngPosTestCase
{
    public TestaCriptografia(
        String name )
    {
        super( name );
    }

    @Test
    public void testaBranco()
    {
        String texto = "";
        String h = "d41d8cd98f00b204e9800998ecf8427e";
        Assert.assertEquals( h, Criptografia.md5( texto ) );
    }

    @Test
    public void testaNulo()
    {
        String texto = null;
        String h = null;
        Assert.assertEquals( h, Criptografia.md5( texto ) );
    }

    @Test
    public void testageral()
    {
        String texto = "12345";
        String h = "827ccb0eea8a706c4c34a16891f84e7b";
        Assert.assertEquals( h, Criptografia.md5( texto ) );

        texto = "teste";
        h = "698dc19d489c4e4db73e28a713eab07b";
        Assert.assertEquals( h, Criptografia.md5( texto ) );

        texto = "#@^*()!";
        h = "7ab2566248b1ee9e1bcb8fa0923f3eff";
        Assert.assertEquals( h, Criptografia.md5( texto ) );

        texto = "#@^*()!Teste1234";
        h = "95e15f2be1b1f97eb33d5c17e302bac3";
        Assert.assertEquals( h, Criptografia.md5( texto ) );

    }

}
