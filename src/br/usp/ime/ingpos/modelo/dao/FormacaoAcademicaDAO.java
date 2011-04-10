package br.usp.ime.ingpos.modelo.dao;

import java.util.List;

import br.com.caelum.vraptor.util.hibernate.SessionCreator;
import br.usp.ime.ingpos.modelo.FormacaoAcademica;

public class FormacaoAcademicaDAO
    extends
        AbstractDaoImpl<Long,FormacaoAcademica>
{

    public FormacaoAcademicaDAO(
        final SessionCreator session )
    {
        super( session );
    }

    public void inserirFormacaoAcademica(
        FormacaoAcademica formacaoAcademica )
    {
        save( formacaoAcademica );
    }

    public void deletarFormacaoAcademica(
        FormacaoAcademica formacaoAcademica )
    {
        delete( formacaoAcademica );
    }

    public void atualizarFormacaoAcademica(
        FormacaoAcademica formacaoAcademica )
    {
        saveOrUpdate( formacaoAcademica );
    }

    public List<FormacaoAcademica> procurarFormacaoAcademica()
    {
        return findAll();
    }
}
