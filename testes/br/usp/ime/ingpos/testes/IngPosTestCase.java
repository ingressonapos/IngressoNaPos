package br.usp.ime.ingpos.testes;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;

import br.com.caelum.vraptor.util.hibernate.SessionCreator;
import br.usp.ime.ingpos.modelo.dao.AnnotationSessionFactoryCreator;

public abstract class IngPosTestCase
    extends
        junit.framework.TestCase
{
    private AnnotationSessionFactoryCreator criadorDeFabricaDeSessoes;
    private SessionCreator sessionCreator;

    public IngPosTestCase(
        final String name )
    {
        super( name );
    }

    Transaction transaction;

    @Before
    protected void setUp()
        throws Exception
    {
        super.setUp();

        criadorDeFabricaDeSessoes = new AnnotationSessionFactoryCreator();
        criadorDeFabricaDeSessoes.create();

        sessionCreator = new SessionCreator( criadorDeFabricaDeSessoes.getInstance() );
        sessionCreator.create();

        transaction = sessionCreator.getInstance().beginTransaction();
    }

    @After
    protected void tearDown()
        throws Exception
    {
        super.tearDown();

        sessionCreator.getInstance().getTransaction().commit();
        criadorDeFabricaDeSessoes.destroy();
    }

    public final SessionCreator getSessionCreator()
    {
        return sessionCreator;
    }

    public final Test getRuntimeSuite()
    {
        return new TestSuite( getClass() );
    }

}
