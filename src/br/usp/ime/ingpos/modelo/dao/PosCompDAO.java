package br.usp.ime.ingpos.modelo.dao;

import java.util.List;

import br.com.caelum.vraptor.util.hibernate.SessionCreator;
import br.usp.ime.ingpos.modelo.PosComp;

public class PosCompDAO
    extends
        AbstractDaoImpl<Long,PosComp>
{

    public PosCompDAO(
        final SessionCreator session )
    {
        super( session );
    }

    public void inserirPosComp(
        PosComp posComp )
    {
        save( posComp );
    }

    public void deletarPosComp(
        PosComp posComp )
    {
        delete( posComp );
    }

    public void atualizarPosComp(
        PosComp posComp )
    {
        saveOrUpdate( posComp );
    }

    public List<PosComp> procurarTodosPosComp()
    {
        return findAll();
    }

}
