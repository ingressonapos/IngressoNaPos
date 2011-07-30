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
        AbstractDaoImpl<Integer,Usuario>
{
    /**
     * 
     */
    private static final long serialVersionUID = - 6800278642830717614L;

    public UsuarioDao(
        final SessionCreator sessionCreator )
    {
        super( sessionCreator );
    }

    public Usuario findByLoginAndPassword(
        final String login,
        final String senha )
    {
        final List<Usuario> usuarios = findByCriteria( Restrictions.and(
            Restrictions.eq( "login", login ), Restrictions.eq( "senha", senha ) ) );

        if( usuarios.size() > 1 ) {
            throw new IllegalStateException( "User within same login and password exists" );
        }

        if( usuarios.isEmpty() ) {
            return null;
        } else {
            return usuarios.get( 0 );
        }
    }
}
