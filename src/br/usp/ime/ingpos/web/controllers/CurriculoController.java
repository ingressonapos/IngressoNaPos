package br.usp.ime.ingpos.web.controllers;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.Validations;
import br.usp.ime.ingpos.modelo.Curriculo;
import br.usp.ime.ingpos.modelo.FormacaoAcademica;
import br.usp.ime.ingpos.modelo.IniciacaoCientifica;
import br.usp.ime.ingpos.modelo.TipoDeFormacao;
import br.usp.ime.ingpos.services.CartaDeRecomendacaoService;
import br.usp.ime.ingpos.services.CurriculoService;
import br.usp.ime.ingpos.web.interceptors.Transactional;

@Resource
public class CurriculoController
{

    private final Result result;
    private final Validator validador;
    private final CurriculoService curriculoService;

    public CurriculoController(
        final Result result,
        final Validator validator,
        final CartaDeRecomendacaoService cartaDeRecomendacaoService,
        final CurriculoService curriculoService )
    {
        this.result = result;
        this.validador = validator;
        this.curriculoService = curriculoService;
    }

    private void carregarDadosDaPagina()
    {
        result.include( "tiposDeFormacao", TipoDeFormacao.getTiposDeFormacao() );

        final Curriculo curriculo = curriculoService.getCurriculo();
        if( curriculo != null ) {
            final List<FormacaoAcademica> formacoesAcademicas = new ArrayList<FormacaoAcademica>();
            formacoesAcademicas.addAll( curriculo.getFormacoesAcademicas() );
            final List<IniciacaoCientifica> iniciacoesCientificas = new ArrayList<IniciacaoCientifica>();
            iniciacoesCientificas.addAll( curriculo.getIniciacoesCientificas());

            result.include( "curriculo", curriculo );
            result.include( "formacoesAcademicas", formacoesAcademicas );
            result.include( "iniciacoesCientificas" , iniciacoesCientificas);
        }
    }

    @Get
    @Path( "/curriculo/dadosCurriculo" )
    public void dadosCurriculo()
    {
        carregarDadosDaPagina();
    }

    @Post
    @Path( "/curriculo/dadosCurriculo" )
    @Transactional
    public void dadosCurriculo(
        Curriculo curriculo )
    {
        curriculoService.atualizarCurriculo( curriculo );
        result.forwardTo( IndexController.class ).index();
    }

    @Get
    @Path( "/curriculo/editarFormacaoAcademica/{formacaoAcademica.formacaoAcademicaId}" )
    public void editarFormacaoAcademica(
        FormacaoAcademica formacaoAcademica )
    {
        result.include(
            "formacaoAcademica",
            curriculoService.getFormacaoAcademicaParaEdicao( formacaoAcademica.getFormacaoAcademicaId() ) );

        result.forwardTo( getClass() ).dadosCurriculo();
    }

    @Get
    @Path( "/curriculo/removerFormacaoAcademica/{formacaoAcademica.formacaoAcademicaId}" )
    @Transactional
    public void removerFormacaoAcademica(
        FormacaoAcademica formacaoAcademica )
    {
        curriculoService.removerFormacaoAcademica( formacaoAcademica.getFormacaoAcademicaId() );
        result.forwardTo( getClass() ).dadosCurriculo();
    }

    @Post
    @Path( "/curriculo/adicionaFormacaoAcademica" )
    @Transactional
    public void adicionaFormacaoAcademica(
        final FormacaoAcademica formacaoAcademica )
    {
        validador.checking( new Validations() {
            {
                that( formacaoAcademica.getTipoDeFormacao() != null,
                    "cadastro_curriculo_tipo_formacao",
                    "cadastro_curriculo_tipo_formacao_erro_vazio" );

                // TODO: incluir outras validacoes
            }
        } );

        validador.onErrorForwardTo( getClass() ).dadosCurriculo();

        curriculoService.adicionaFormacaoAcademica( formacaoAcademica );
        result.forwardTo( getClass() ).dadosCurriculo();
    }

    @Get
    @Path( "/curriculo/editarIniciacaoCientifica/{IniciacaoCientifica.iniciacaoCientificaId}" )
    public void editarIniciacaoCientifica(
        IniciacaoCientifica iniciacaoCientifica )
    {
        result.include(
            "iniciacaoCientifica",
            curriculoService.getIniciacaoCientificaParaEdicao( iniciacaoCientifica.getIniciacaocientificaId() ) );

        result.forwardTo( getClass() ).dadosCurriculo();
    }

    @Get
    @Path( "/curriculo/removerIniciacaoCientifica/{IniciacaoCientifica.iniciacaoCientificaId}" )
    @Transactional
    public void removerIniciacaoCientifia(
        IniciacaoCientifica iniciacaoCientifica )
    {
        curriculoService.removerIniciacaoCientifica( iniciacaoCientifica.getIniciacaocientificaId() );
        result.forwardTo( getClass() ).dadosCurriculo();
    }

    @Post
    @Path( "/curriculo/adicionaIniciacaoCientifica" )
    @Transactional
    public void adicionaIniciacaoCientifica(
        final IniciacaoCientifica iniciacaoCientifica )
    {
        // validador.checking( new Validations() {
        // {
        // that( formacaoAcademica.getTipoDeFormacao() != null,
        // "cadastro_curriculo_tipo_formacao",
        // "cadastro_curriculo_tipo_formacao_erro_vazio" );
        //
        // // TODO: incluir outras validacoes
        // }
        // } );

        validador.onErrorForwardTo( getClass() ).dadosCurriculo();

        curriculoService.adicionaIniciacaoCientifica( iniciacaoCientifica );
        result.forwardTo( getClass() ).dadosCurriculo();
    }
}
