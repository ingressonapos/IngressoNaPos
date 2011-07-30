package br.usp.ime.ingpos.testes;

import org.junit.After;
import org.junit.Before;

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

    @Before
    protected void setUp()
        throws Exception
    {
        super.setUp();
        // SchemaExport ddlExport = new SchemaExport(
        // HibernateUtil.getConfiguration() );
        // ddlExport.create( false, true );
    }

    @After
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
        // SchemaExport ddlExport = new SchemaExport(
        // HibernateUtil.getConfiguration() );
        // ddlExport.drop( false, true );
    }

    public final Test getRuntimeSuite()
    {
        return new TestSuite( getClass() );
    }

}
