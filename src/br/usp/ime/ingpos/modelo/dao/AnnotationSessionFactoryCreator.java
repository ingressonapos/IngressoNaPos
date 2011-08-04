package br.usp.ime.ingpos.modelo.dao;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;
import br.usp.ime.ingpos.modelo.CEP;
import br.usp.ime.ingpos.modelo.Curriculo;
import br.usp.ime.ingpos.modelo.DadosPessoais;
import br.usp.ime.ingpos.modelo.Endereco;
import br.usp.ime.ingpos.modelo.Perfil;
import br.usp.ime.ingpos.modelo.Telefone;
import br.usp.ime.ingpos.modelo.Usuario;

@ApplicationScoped
@Component
public class AnnotationSessionFactoryCreator
    implements
        ComponentFactory<SessionFactory>
{
    private SessionFactory factory;

    public AnnotationSessionFactoryCreator()
    {
    }

    @PostConstruct
    public void create()
    {

        final AnnotationConfiguration cfg = new AnnotationConfiguration();
        cfg.addAnnotatedClass( CEP.class );
        cfg.addAnnotatedClass( Endereco.class );
        cfg.addAnnotatedClass( Perfil.class );
        cfg.addAnnotatedClass( Usuario.class );
        cfg.addAnnotatedClass( Curriculo.class );
        cfg.addAnnotatedClass( DadosPessoais.class );


        factory = cfg.buildSessionFactory();

    }

    public SessionFactory getInstance()
    {
        return factory;
    }

    @PreDestroy
    public void destroy()
    {
        factory.close();
    }
}
