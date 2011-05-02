package br.usp.ime.ingpos.web.controllers;

import java.util.List;

import org.springframework.util.StringUtils;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.Validations;
import br.usp.ime.ingpos.modelo.CartaDeRecomendacao;
import br.usp.ime.ingpos.modelo.Curriculo;
import br.usp.ime.ingpos.modelo.DadosPessoais;
import br.usp.ime.ingpos.modelo.TipoCedulaDeIdentidade;
import br.usp.ime.ingpos.modelo.TipoEstadoCivil;
import br.usp.ime.ingpos.modelo.TipoPais;
import br.usp.ime.ingpos.services.CartaDeRecomendacaoService;
import br.usp.ime.ingpos.services.UsuarioService;
import br.usp.ime.ingpos.web.interceptors.Transactional;

@Resource
public class CadastroController
{
    private static final String DADOS_PESSOAIS = "dadosPessoais";
    private static final String CARTAS_DE_RECOMENDACAO = "cartasDeRecomendacao";
    private static final String TIPOS_ESTADO_CIVIL = "tiposEstadoCivil";
    private static final String TIPOS_CEDULA_IDENTIDADE = "tiposCedulaIdentidade";
    private static final String TIPOS_PAIS = "tiposPais";

    private final UsuarioSessao usuarioSessao;
    private final Result result;
    private final UsuarioService usuarioService;
    private final CartaDeRecomendacaoService cartaDeRecomendacaoService;
    private final Validator validador;

    public CadastroController(
        final Result result,
        final Validator validator,
        final UsuarioSessao usuarioSessao,
        final UsuarioService usuarioService,
        final CartaDeRecomendacaoService cartaDeRecomendacaoService )
    {
        this.result = result;
        this.validador = validator;
        this.usuarioSessao = usuarioSessao;
        this.usuarioService = usuarioService;
        this.cartaDeRecomendacaoService = cartaDeRecomendacaoService;
    }

    private void configurarResultDadosPessoais()
    {
        result.include( DADOS_PESSOAIS, usuarioSessao.getUsuario().getDadosPessoais() );
        result.include( TIPOS_ESTADO_CIVIL, TipoEstadoCivil.getTiposEstadoCivil() );
        result.include( TIPOS_CEDULA_IDENTIDADE, TipoCedulaDeIdentidade.getTiposCedulaIdentidade() );
        result.include( TIPOS_PAIS, TipoPais.getTiposPais() );
    }

    @Get
    @Path( "/cadastro/dadosPessoais" )
    public void dadosPessoais()
    {
        configurarResultDadosPessoais();
    }

    @Post
    @Path( "/cadastro/dadosPessoais" )
    @Transactional
    public void dadosPessoais(
        DadosPessoais dadosPessoais )
    {
        String cpfSomenteNumeros = dadosPessoais.getCpf().replaceAll( "\\.", "" );
        cpfSomenteNumeros = cpfSomenteNumeros.replaceAll( "-", "" );
        dadosPessoais.setCpf( cpfSomenteNumeros );

        String telefoneSomenteNumeros = dadosPessoais.getEnderecoPermanente().getTelefone().getCodTelefone();
        telefoneSomenteNumeros = telefoneSomenteNumeros.replaceAll( "\\(", " " );
        telefoneSomenteNumeros = telefoneSomenteNumeros.replaceAll( "\\)", " " );
        telefoneSomenteNumeros = telefoneSomenteNumeros.replaceAll( "\\+", "" );
        telefoneSomenteNumeros = telefoneSomenteNumeros.replaceAll( "-", "" );
        String[] telefoneSeparado = telefoneSomenteNumeros.split( " " );
        dadosPessoais.getEnderecoPermanente().getTelefone().setCodPais( telefoneSeparado[ 0 ] );
        dadosPessoais.getEnderecoPermanente().getTelefone().setCodDDD( telefoneSeparado[ 2 ] );
        dadosPessoais.getEnderecoPermanente().getTelefone().setCodTelefone( telefoneSeparado[ 4 ] );

        telefoneSomenteNumeros = dadosPessoais.getEnderecoCorrespondencia().getTelefone().getCodTelefone();
        telefoneSomenteNumeros = telefoneSomenteNumeros.replaceAll( "\\(", " " );
        telefoneSomenteNumeros = telefoneSomenteNumeros.replaceAll( "\\)", " " );
        telefoneSomenteNumeros = telefoneSomenteNumeros.replaceAll( "\\+", "" );
        telefoneSomenteNumeros = telefoneSomenteNumeros.replaceAll( "-", "" );
        telefoneSeparado = telefoneSomenteNumeros.split( " " );
        dadosPessoais.getEnderecoCorrespondencia().getTelefone().setCodPais( telefoneSeparado[ 0 ] );
        dadosPessoais.getEnderecoCorrespondencia().getTelefone().setCodDDD( telefoneSeparado[ 2 ] );
        dadosPessoais.getEnderecoCorrespondencia().getTelefone().setCodTelefone(
            telefoneSeparado[ 4 ] );

        String cepSomenteNumeros = dadosPessoais.getEnderecoPermanente().getCep().getCep();
        cepSomenteNumeros = cepSomenteNumeros.replaceAll( "-", "" );
        dadosPessoais.getEnderecoPermanente().getCep().setCep( cepSomenteNumeros );

        cepSomenteNumeros = dadosPessoais.getEnderecoCorrespondencia().getCep().getCep();
        cepSomenteNumeros = cepSomenteNumeros.replaceAll( "-", "" );
        dadosPessoais.getEnderecoCorrespondencia().getCep().setCep( cepSomenteNumeros );

        usuarioService.cadastrarDadosPessoais( usuarioSessao.getUsuario(), dadosPessoais );
        result.forwardTo( IndexController.class ).index();
    }

    @Get
    @Path( "/cadastro/dadosCurriculo" )
    public void dadosCurriculo()
    {
    }

    @Post
    @Path( "/cadastro/dadosCurriculo" )
    public void dadosCurriculo(
        Curriculo curriculo )
    {

        result.forwardTo( IndexController.class ).index();
    }

    @Get
    @Path( "/cadastro/solicitarRecomendacao" )
    public void solicitarRecomendacao()
    {
        final List<CartaDeRecomendacao> cartasDeRecomendacao = cartaDeRecomendacaoService.procurarPorUsuario( usuarioSessao.getUsuario() );
        result.include( CARTAS_DE_RECOMENDACAO, cartasDeRecomendacao );
    }

    @Post
    @Path( "/cadastro/solicitarRecomendacao" )
    @Transactional
    public void solicitarRecomendacao(
        final CartaDeRecomendacao cartaDeRecomendacao )
    {
        validador.checking( new Validations() {
            {
                that( StringUtils.hasText( cartaDeRecomendacao.getNome() ),
                    "cadastro_recomendacao_nome", "erro_carta_recomendacao_nome_vazio" );

                that( StringUtils.hasText( cartaDeRecomendacao.getEmail() ),
                    "cadastro_recomendacao_email", "erro_carta_recomendacao_email_vazio" );
            }
        } );

        validador.onErrorForwardTo( getClass() ).solicitarRecomendacao();

        cartaDeRecomendacaoService.solicitarRecomendacao( cartaDeRecomendacao );

        result.forwardTo( CadastroController.class ).solicitarRecomendacao();
    }

    @Get
    @Path( "/cadastro/reenviarRecomendacao/{cartaDeRecomendacao.cartaDeRecomendacaoID}" )
    public void reenviarRecomendacao(
        final CartaDeRecomendacao cartaDeRecomendacao )
    {
        cartaDeRecomendacaoService.reenviarRecomendacao( cartaDeRecomendacao );
        result.forwardTo( CadastroController.class ).solicitarRecomendacao();
    }
}
