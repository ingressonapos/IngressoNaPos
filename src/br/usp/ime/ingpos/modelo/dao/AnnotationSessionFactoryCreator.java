package br.usp.ime.ingpos.modelo.dao;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;
import br.usp.ime.ingpos.modelo.AreaDeInteresse;
import br.usp.ime.ingpos.modelo.Bolsa;
import br.usp.ime.ingpos.modelo.Candidato;
import br.usp.ime.ingpos.modelo.CartaDeRecomendacao;
import br.usp.ime.ingpos.modelo.Curriculo;
import br.usp.ime.ingpos.modelo.Endereco;
import br.usp.ime.ingpos.modelo.FormacaoAcademica;
import br.usp.ime.ingpos.modelo.IniciacaoCientifica;
import br.usp.ime.ingpos.modelo.Inscricao;
import br.usp.ime.ingpos.modelo.Perfil;
import br.usp.ime.ingpos.modelo.PosComp;
import br.usp.ime.ingpos.modelo.ProcessoSeletivo;
import br.usp.ime.ingpos.modelo.RegistroNovoUsuario;
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

        cfg.addAnnotatedClass( Endereco.class );
        cfg.addAnnotatedClass( Perfil.class );
        cfg.addAnnotatedClass( Usuario.class );
        cfg.addAnnotatedClass( Curriculo.class );
        cfg.addAnnotatedClass( Bolsa.class );
        cfg.addAnnotatedClass( FormacaoAcademica.class );
        cfg.addAnnotatedClass( PosComp.class );
        cfg.addAnnotatedClass( IniciacaoCientifica.class );
        cfg.addAnnotatedClass( RegistroNovoUsuario.class );
        cfg.addAnnotatedClass( CartaDeRecomendacao.class );
        cfg.addAnnotatedClass( ProcessoSeletivo.class );
        cfg.addAnnotatedClass( Candidato.class );
        cfg.addAnnotatedClass( Inscricao.class );
        cfg.addAnnotatedClass( AreaDeInteresse.class );

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
