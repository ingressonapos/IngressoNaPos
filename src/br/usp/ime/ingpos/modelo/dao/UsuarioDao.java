package br.usp.ime.ingpos.modelo.dao;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.RequestScoped;
import br.com.caelum.vraptor.util.hibernate.SessionCreator;
import br.usp.ime.ingpos.modelo.Usuario;

@RequestScoped
@Component
public class UsuarioDao
    extends
        AbstractDaoImpl<Long,Usuario>
{
    public UsuarioDao(
        final SessionCreator sessionCreator )
    {
        super( sessionCreator );
    }

    public Usuario procurarPorEmail(
        final String email )
    {
        final List<Usuario> usuarios = findByCriteria( Restrictions.eq( "email", email ) );

        if( usuarios.size() > 1 ) {
            throw new IllegalStateException( "Existem dois ou mais usuários com mesmo email" );
        }

        if( usuarios.isEmpty() ) {
            return null;
        } else {
            return usuarios.get( 0 );
        }
    }

    public Usuario findByEmailAndPassword(
        final String email,
        final String senha )
    {
        final List<Usuario> usuarios = findByCriteria( Restrictions.and(
            Restrictions.eq( "email", email ), Restrictions.eq( "senha", senha ) ) );

        if( usuarios.size() > 1 ) {
            throw new IllegalStateException(
                "Existem dois ou mais usuários com mesmo email e senha." );
        }

        if( usuarios.isEmpty() ) {
            return null;
        } else {
            return usuarios.get( 0 );
        }
    }
}
