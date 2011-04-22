package br.usp.ime.ingpos.web.controllers;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.usp.ime.ingpos.modelo.CartaDeRecomendacao;
import br.usp.ime.ingpos.modelo.DadosPessoais;
import br.usp.ime.ingpos.modelo.TipoCedulaDeIdentidade;
import br.usp.ime.ingpos.modelo.TipoEstadoCivil;
import br.usp.ime.ingpos.seguranca.Criptografia;
import br.usp.ime.ingpos.services.CartaDeRecomendacaoService;

@Resource
public class CadastroController
{
    private static final String TIPOS_ESTADO_CIVIL = "tiposEstadoCivil";
    private static final String TIPOS_CEDULA_IDENTIDADE = "tiposCedulaIdentidade";
    private final UsuarioSessao usuarioSessao;

    private final Result result;
    private CartaDeRecomendacaoService cartaDeRecomendacaoService;
    public CadastroController(
        final Result result,
        final UsuarioSessao usuarioSessao,
        final CartaDeRecomendacaoService cartaDeRecomendacaoService)
    {
        this.result = result;
        this.usuarioSessao = usuarioSessao;
        this.cartaDeRecomendacaoService = cartaDeRecomendacaoService;
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
    
    @Get @Post
    @Path( "/cadastro/solicitarRecomendacao" )
    public void solicitarRecomendacao(CartaDeRecomendacao cartaDeRecomendacao)
    {
        if(cartaDeRecomendacao != null) {
            cartaDeRecomendacaoService.criar( cartaDeRecomendacao );
        }
    }

}
