package br.usp.ime.ingpos.testes;

import org.junit.After;
import org.junit.Before;

import br.com.caelum.vraptor.util.hibernate.SessionCreator;
import br.usp.ime.ingpos.modelo.dao.AnnotationSessionFactoryCreator;

public abstract class BancoDeDadosTestCase
    extends
        IngPosTestCase
{
    private static AnnotationSessionFactoryCreator criadorDeFabricaDeSessoes;
    private static SessionCreator sessionCreator;

    public BancoDeDadosTestCase(
        final String name )
    {
        super( name );
    }

    @Before
    protected void setUp()
        throws Exception
    {
        super.setUp();

        if( criadorDeFabricaDeSessoes == null ) {
            criadorDeFabricaDeSessoes = new AnnotationSessionFactoryCreator();
            criadorDeFabricaDeSessoes.create();
        }
        if( sessionCreator == null ) {
            sessionCreator = new SessionCreator( criadorDeFabricaDeSessoes.getInstance() );
            sessionCreator.create();
        }

        sessionCreator.getInstance().beginTransaction();
    }

    @After
    protected void tearDown()
        throws Exception
    {
        super.tearDown();

        sessionCreator.getInstance().getTransaction().commit();
        // criadorDeFabricaDeSessoes.destroy();
        // sessionCreator = null;
        // criadorDeFabricaDeSessoes = null;
    }

    public final SessionCreator getSessionCreator()
    {
        return sessionCreator;
    }

}
