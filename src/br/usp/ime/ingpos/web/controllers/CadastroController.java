package br.usp.ime.ingpos.web.controllers;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.usp.ime.ingpos.modelo.DadosPessoais;
import br.usp.ime.ingpos.modelo.TipoCedulaDeIdentidade;
import br.usp.ime.ingpos.modelo.TipoEstadoCivil;

@Resource
public class CadastroController
{
    private static final String TIPOS_ESTADO_CIVIL = "tiposEstadoCivil";
    private static final String TIPOS_CEDULA_IDENTIDADE = "tiposCedulaIdentidade";

    private final Result result;

    public CadastroController(
        final Result result )
    {
        this.result = result;
    }

    private void configurarResultDadosUsuario()
    {
        result.include( TIPOS_ESTADO_CIVIL, TipoEstadoCivil.getTiposEstadoCivil() );
        result.include( TIPOS_CEDULA_IDENTIDADE, TipoCedulaDeIdentidade.getTiposCedulaIdentidade() );
    }

    @Get
    @Path( "/cadastro/dadosUsuario" )
    public void dadosUsuario()
    {
        configurarResultDadosUsuario();
    }

    @Post
    @Path( "/cadastro/dadosUsuario" )
    public void dadosUsuario(
        DadosPessoais dadosPessoais )
    {
        configurarResultDadosUsuario();
    }

    @Get
    @Path( "/cadastro/dadosCurriculo" )
    public void dadosCurriculo()
    {
    }

}
