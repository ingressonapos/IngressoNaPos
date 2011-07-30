package br.usp.ime.ingpos.vraptor.providers;

import br.com.caelum.vraptor.ComponentRegistry;
import br.com.caelum.vraptor.ioc.spring.SpringProvider;
import br.com.caelum.vraptor.util.hibernate.SessionCreator;
import br.usp.ime.ingpos.modelo.dao.AnnotationSessionFactoryCreator;

/**
 * Esta classe é referenciada na configuração do vraptor para prover
 * customizações na aplicação com relação à configuração do mesmo.
 */
public class ApplicationCustomProvider
    extends
        SpringProvider
{

    @Override
    protected void registerCustomComponents(
        final ComponentRegistry registry )
    {
        // Cria Session's
        registry.register( SessionCreator.class, SessionCreator.class );

        // Cria SessionFactory para configuções de anotations
        registry.register( AnnotationSessionFactoryCreator.class,
            AnnotationSessionFactoryCreator.class );
    }

}
