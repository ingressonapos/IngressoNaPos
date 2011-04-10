package br.usp.ime.ingpos.modelo.dao;

import java.util.List;

import br.com.caelum.vraptor.util.hibernate.SessionCreator;
import br.usp.ime.ingpos.modelo.IniciacaoCientifica;

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

}
