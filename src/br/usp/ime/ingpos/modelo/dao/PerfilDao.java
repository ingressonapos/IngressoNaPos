package br.usp.ime.ingpos.modelo.dao;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.RequestScoped;
import br.com.caelum.vraptor.util.hibernate.SessionCreator;
import br.usp.ime.ingpos.modelo.Perfil;

@RequestScoped
@Component
public class PerfilDao
    extends
        AbstractDaoImpl<Long,Perfil>
{
    public PerfilDao(
        final SessionCreator sessionCreator )
    {
        super( sessionCreator );
    }

    public List<Perfil> procurarPorDescricao(
        String descricao )
    {
        return findByCriteria( Restrictions.like( "descricao", descricao ) );
    }
}
