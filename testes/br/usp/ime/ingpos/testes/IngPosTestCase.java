package br.usp.ime.ingpos.testes;

import junit.framework.Test;
import junit.framework.TestSuite;

public abstract class IngPosTestCase
    extends
        junit.framework.TestCase
{
    public IngPosTestCase(
        final String name )
    {
        super( name );
    }

    public final Test getRuntimeSuite()
    {
        return new TestSuite( getClass() );
    }
}
