package br.usp.ime.ingpos.testes.services;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Before;

import br.usp.ime.ingpos.modelo.ProcessoSeletivo;
import br.usp.ime.ingpos.modelo.dao.ProcessoSeletivoDao;
import br.usp.ime.ingpos.services.ProcessoSeletivoService;
import br.usp.ime.ingpos.testes.BancoDeDadosTestCase;

public class ProcessoSeletivoServiceTeste
    extends
        BancoDeDadosTestCase
{

    public ProcessoSeletivoServiceTeste(
        final String nome )
    {
        super( nome );
    }

    private ProcessoSeletivoService processoSeletivoService;
    private Date dataDeAbertura;
    private Date dataLimiteDeInscricao;

    @Before
    protected void setUp()
        throws Exception
    {
        super.setUp();

        processoSeletivoService = new ProcessoSeletivoService( new ProcessoSeletivoDao(
            getSessionCreator() ) );

        final GregorianCalendar calendario = new GregorianCalendar();

        calendario.add( GregorianCalendar.DATE, - 60 );
        dataDeAbertura = calendario.getTime();

        calendario.add( GregorianCalendar.DATE, 120 );
        dataLimiteDeInscricao = calendario.getTime();
    }

    public void testAtualizarProcessoSeletivo()
    {
        final ProcessoSeletivo processoSeletivo = new ProcessoSeletivo();
        processoSeletivo.setDescricao( "Proceso seletivo 1º sem 2011" );
        processoSeletivo.setDataDeAbertura( dataDeAbertura );
        processoSeletivo.setDataLimiteDeInscricao( dataLimiteDeInscricao );

        processoSeletivoService.atualizarProcessoSeletivo( processoSeletivo );

        assertNotNull( processoSeletivo.getProcessoSeletivoId() );
    }

    public void testBuscarTodosProcessosSeletivos()
    {
        final List<ProcessoSeletivo> processosSeletivos = processoSeletivoService.buscarTodosProcessosSeletivos();

        assertNotNull( processosSeletivos );
        assertFalse( processosSeletivos.isEmpty() );
    }

    public void testBuscarProcessosSeletivosPorData()
    {
        final List<ProcessoSeletivo> processosSeletivos = processoSeletivoService.buscarProcessosSeletivosPorData( new Date() );

        assertNotNull( processosSeletivos );
        assertFalse( processosSeletivos.isEmpty() );
    }

    public void testBuscarProcessoSeletivoVigente()
    {
        final List<ProcessoSeletivo> processosSeletivosVigentes = processoSeletivoService.buscarProcessosSeletivosVigentes();

        assertNotNull( processosSeletivosVigentes );
        assertFalse( processosSeletivosVigentes.isEmpty() );
    }
}
