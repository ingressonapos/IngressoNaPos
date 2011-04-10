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
    public UsuarioDao(
        final SessionCreator sessionCreator )
    {
        super( sessionCreator );
    }

    public Usuario findByEmailAndPassword(
        final String email,
        final String senha )
    {
        final List<Usuario> usuarios = findByCriteria( Restrictions.and(
            Restrictions.eq( "dadosPessoais.email", email ),
            Restrictions.eq( "dadosPessoais.senha", senha ) ) );

        if( usuarios.size() > 1 ) {
            throw new IllegalStateException( "User within same email and password exists" );
        }

        if( usuarios.isEmpty() ) {
            return null;
        } else {
            return usuarios.get( 0 );
        }
    }
}
