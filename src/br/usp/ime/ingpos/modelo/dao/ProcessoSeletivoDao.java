package br.usp.ime.ingpos.modelo.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.RequestScoped;
import br.com.caelum.vraptor.util.hibernate.SessionCreator;
import br.usp.ime.ingpos.modelo.ProcessoSeletivo;
import br.usp.ime.ingpos.modelo.TipoProcessoSeletivo;

@RequestScoped
@Component
public class ProcessoSeletivoDao
    extends
        AbstractDaoImpl<Long,ProcessoSeletivo>
{
    public ProcessoSeletivoDao(
        final SessionCreator sessionCreator )
    {
        super( sessionCreator );
    }

    public List<ProcessoSeletivo> buscarProcessosSeletivosPorData(
        final Date data )
    {
        final List<ProcessoSeletivo> processosSeletivos = findByCriteria( Restrictions.and(
            Restrictions.le( "dataDeAbertura", data ),
            Restrictions.ge( "dataLimiteDeInscricao", data ) ) );

        return processosSeletivos;
    }

    public List<ProcessoSeletivo> buscarProcessosSeletivosVigentes()
    {
        final Date dataAtual = new Date();
        final List<ProcessoSeletivo> processosSeletivos = findByCriteria( Restrictions.and(
            Restrictions.le( "dataDeAbertura", dataAtual ),
            Restrictions.ge( "dataLimiteDeInscricao", dataAtual ) ) );

        return processosSeletivos;
    }
}
