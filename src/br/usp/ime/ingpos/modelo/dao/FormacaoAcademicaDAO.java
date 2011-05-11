package br.usp.ime.ingpos.modelo.dao;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.util.hibernate.SessionCreator;
import br.usp.ime.ingpos.modelo.FormacaoAcademica;

@Component
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

    public FormacaoAcademica procurarFormacaoAcademicaById(
        Long formacaoAcademicaId )
    {
        List<FormacaoAcademica> formacoesAcademicas = findByCriteria( Restrictions.eq( "formacaoAcademicaId", formacaoAcademicaId ) );
        if( formacoesAcademicas.isEmpty() ) {
            return null;
        } else {
            return formacoesAcademicas.get( 0 );
        }
        
    }
}
