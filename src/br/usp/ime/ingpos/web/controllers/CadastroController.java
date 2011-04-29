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
import br.usp.ime.ingpos.modelo.TipoPais;
import br.usp.ime.ingpos.services.CartaDeRecomendacaoService;
import br.usp.ime.ingpos.services.UsuarioService;
import br.usp.ime.ingpos.web.interceptors.Transactional;

@Resource
public class CadastroController
{

    private static final String DADOS_PESSOAIS = "dadosPessoais";
    private static final String TIPOS_ESTADO_CIVIL = "tiposEstadoCivil";
    private static final String TIPOS_CEDULA_IDENTIDADE = "tiposCedulaIdentidade";
    private static final String TIPOS_PAIS = "tiposPais";

    private final UsuarioSessao usuarioSessao;
    private final Result result;
    private final UsuarioService usuarioService;
    private final CartaDeRecomendacaoService cartaDeRecomendacaoService;
    
    public CadastroController(
        final Result result,
        final UsuarioSessao usuarioSessao,
        final UsuarioService usuarioService,
        final CartaDeRecomendacaoService cartaDeRecomendacaoService )
    {
        this.result = result;
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
        telefoneSomenteNumeros = telefoneSomenteNumeros.replaceAll("\\(", " ");
        telefoneSomenteNumeros = telefoneSomenteNumeros.replaceAll("\\)", " ");
        telefoneSomenteNumeros = telefoneSomenteNumeros.replaceAll("\\+", "");
        telefoneSomenteNumeros = telefoneSomenteNumeros.replaceAll("-", "");
        String[] telefoneSeparado = telefoneSomenteNumeros.split(" ");
        dadosPessoais.getEnderecoPermanente().getTelefone().setCodPais(telefoneSeparado[0]);
        dadosPessoais.getEnderecoPermanente().getTelefone().setCodDDD(telefoneSeparado[2]);
        dadosPessoais.getEnderecoPermanente().getTelefone().setCodTelefone(telefoneSeparado[4]);
        
        telefoneSomenteNumeros = dadosPessoais.getEnderecoCorrespondencia().getTelefone().getCodTelefone();
        telefoneSomenteNumeros = telefoneSomenteNumeros.replaceAll("\\(", " ");
        telefoneSomenteNumeros = telefoneSomenteNumeros.replaceAll("\\)", " ");
        telefoneSomenteNumeros = telefoneSomenteNumeros.replaceAll("\\+", "");
        telefoneSomenteNumeros = telefoneSomenteNumeros.replaceAll("-", "");
        telefoneSeparado = telefoneSomenteNumeros.split(" ");
        dadosPessoais.getEnderecoCorrespondencia().getTelefone().setCodPais(telefoneSeparado[0]);
        dadosPessoais.getEnderecoCorrespondencia().getTelefone().setCodDDD(telefoneSeparado[2]);
        dadosPessoais.getEnderecoCorrespondencia().getTelefone().setCodTelefone(telefoneSeparado[4]);
        
        String cepSomenteNumeros = dadosPessoais.getEnderecoPermanente().getCep().getCep();
        cepSomenteNumeros = cepSomenteNumeros.replaceAll("-", "");
        dadosPessoais.getEnderecoPermanente().getCep().setCep(cepSomenteNumeros);
        
        cepSomenteNumeros = dadosPessoais.getEnderecoCorrespondencia().getCep().getCep();
        cepSomenteNumeros = cepSomenteNumeros.replaceAll("-", "");
        dadosPessoais.getEnderecoCorrespondencia().getCep().setCep(cepSomenteNumeros);
        
        usuarioService.cadastrarDadosPessoais( usuarioSessao.getUsuario(), dadosPessoais );
        result.forwardTo( IndexController.class ).index();
    }

    @Get
    @Path( "/cadastro/dadosCurriculo" )
    public void dadosCurriculo()
    {
    }

    @Get
    @Post
    @Path( "/cadastro/solicitarRecomendacao" )
    public void solicitarRecomendacao(
        CartaDeRecomendacao cartaDeRecomendacao )
    {
        if( cartaDeRecomendacao != null ) {
            cartaDeRecomendacaoService.solicitarRecomendacao( cartaDeRecomendacao );
        }
    }

}
