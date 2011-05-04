package br.usp.ime.ingpos.services;

import java.util.Date;
import java.util.List;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.RequestScoped;
import br.usp.ime.ingpos.modelo.ProcessoSeletivo;
import br.usp.ime.ingpos.modelo.dao.ProcessoSeletivoDao;

@RequestScoped
@Component
public class ProcessoSeletivoService
{

    final ProcessoSeletivoDao processoSeletivoDao;

    public ProcessoSeletivoService(
        final ProcessoSeletivoDao processoSeletivoDao )
    {
        this.processoSeletivoDao = processoSeletivoDao;
    }

    public void atualizarProcessoSeletivo(
        final ProcessoSeletivo processoSeletivo )
    {
        processoSeletivoDao.saveOrUpdate( processoSeletivo );
    }

    public List<ProcessoSeletivo> buscarTodosProcessosSeletivos()
    {
        return processoSeletivoDao.findAll();
    }

    public List<ProcessoSeletivo> buscarProcessosSeletivosVigentes()
    {
        final List<ProcessoSeletivo> processosSeletivos = processoSeletivoDao.buscarProcessosSeletivosVigentes();
        return processosSeletivos;
    }

    public List<ProcessoSeletivo> buscarProcessosSeletivosPorData(
        final Date data )
    {
        final List<ProcessoSeletivo> processosSeletivos = processoSeletivoDao.buscarProcessosSeletivosPorData( data );

        return processosSeletivos;
    }

}
