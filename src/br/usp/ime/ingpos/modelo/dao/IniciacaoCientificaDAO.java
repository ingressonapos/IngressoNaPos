package br.usp.ime.ingpos.modelo.dao;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.util.hibernate.SessionCreator;
import br.usp.ime.ingpos.modelo.IniciacaoCientifica;

@Component
public class IniciacaoCientificaDAO
    extends
        AbstractDaoImpl<Long,IniciacaoCientifica>
{

    public IniciacaoCientificaDAO(
        final SessionCreator session )
    {
        super( session );
    }

    public void inserirIniciacaoCientifica(
        IniciacaoCientifica iniciacaoCientifica )
    {
        save( iniciacaoCientifica );
    }

    public void deletarIniciacaoCientifica(
        IniciacaoCientifica iniciacaoCientifica )
    {
        delete( iniciacaoCientifica );
    }

    public void atualizarIniciacaoCientifica(
        IniciacaoCientifica iniciacaoCientifica )
    {
        saveOrUpdate( iniciacaoCientifica );
    }

    public List<IniciacaoCientifica> procurarTodosIniciacaoCientifica()
    {
        return findAll();
    }

    public IniciacaoCientifica procurarIniciacaoCientificaById(
        Long iniciacaoCientificaId )
    {
        List<IniciacaoCientifica> iniciacoesCientificas = findByCriteria( Restrictions.eq( "iniciacaoCientificaId", iniciacaoCientificaId ) );
        if( iniciacoesCientificas.isEmpty() ) {
            return null;
        } else {
            return iniciacoesCientificas.get( 0 );
        }
    }

}
