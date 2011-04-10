package br.usp.ime.ingpos.modelo.dao;

import java.util.List;

import br.com.caelum.vraptor.util.hibernate.SessionCreator;
import br.usp.ime.ingpos.modelo.Curriculo;

public class CurriculoDAO
    extends
        AbstractDaoImpl<Integer,Curriculo>
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
