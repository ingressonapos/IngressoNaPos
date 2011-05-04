package br.usp.ime.ingpos.modelo.dao;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.RequestScoped;
import br.com.caelum.vraptor.util.hibernate.SessionCreator;
import br.usp.ime.ingpos.modelo.Curriculo;
import br.usp.ime.ingpos.modelo.Usuario;

@Component
@RequestScoped
public class CurriculoDAO
    extends
        AbstractDaoImpl<Long,Curriculo>
{

    public CurriculoDAO(
        final SessionCreator session )
    {
        super( session );
    }

    public void deletarCurriculo(
        Curriculo curriculo )
    {
        delete( curriculo );
    }

    public void atualizarCurriculo(
        Curriculo curriculo )
    {
        saveOrUpdate( curriculo );
    }

    public List<Curriculo> procurarTodosCurriculos()
    {
        return findAll();
    }
    
}
