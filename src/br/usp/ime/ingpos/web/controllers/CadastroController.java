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
import br.usp.ime.ingpos.modelo.Endereco;
import br.usp.ime.ingpos.modelo.TipoCedulaDeIdentidade;
import br.usp.ime.ingpos.modelo.TipoEstadoCivil;
import br.usp.ime.ingpos.modelo.TipoPais;
import br.usp.ime.ingpos.services.CartaDeRecomendacaoService;
import br.usp.ime.ingpos.services.CurriculoService;
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
    private final CurriculoService curriculoService;
    private DadosPessoais dadosPessoais;

    public CadastroController(
        final Result result,
        final Validator validator,
        final UsuarioSessao usuarioSessao,
        final UsuarioService usuarioService,
        final CartaDeRecomendacaoService cartaDeRecomendacaoService,
        final CurriculoService curriculoService)
    {
        this.result = result;
        this.validador = validator;
        this.usuarioSessao = usuarioSessao;
        this.usuarioService = usuarioService;
        this.cartaDeRecomendacaoService = cartaDeRecomendacaoService;
        this.curriculoService = curriculoService;
    }

    private void configurarResultDadosPessoais()
    {
    	if (this.dadosPessoais == null)
    		result.include( DADOS_PESSOAIS, usuarioSessao.getUsuario().getDadosPessoais() );
    	else
    		result.include( DADOS_PESSOAIS, this.dadosPessoais );
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
        final DadosPessoais dadosPessoais )
    {
    	validador.checking( new Validations() {
            {
                if( dadosPessoais != null ) {
                	Endereco endereco = dadosPessoais.getEnderecoPermanente();
                	
                	that( !dadosPessoais.getNomeCompleto().equals(""), "erro_tipo_nome", "erro_campo_nulo" );
                	
                	that( dadosPessoais.getDataDeNascimento() != null, "erro_tipo_data_nascimento", "erro_campo_nulo");
                	
                	that( !dadosPessoais.getCedulaDeIdentidade().getNumero().equals(""), "erro_tipo_identidade", "erro_campo_nulo");
                	
                    that( dadosPessoais.getCpf().equals("") || DadosPessoais.isValidoCpf( dadosPessoais.getCpf() ),
                        "erro_tipo_cpf", "erro_cpf_invalido" );
                    
                    that( endereco.getLogradouro().equals(""), "erro_tipo_logradouro_permanente", "erro_campo_nulo" );
                    
                    that( endereco.getNumero().equals(""), "erro_tipo_numero_permanente", "erro_campo_nulo" );
                    
                    that( endereco.getCep().getCep().equals(""), "erro_tipo_cep_permanente", "erro_campo_nulo" );
                    
                    that( endereco.getCidade().equals(""), "erro_tipo_cidade_permanente", "erro_campo_nulo" );
                    
                    that( endereco.getEstado().equals(""), "erro_tipo_estado_permanente", "erro_campo_nulo" );
                    
                    that( endereco.getTelefone().getCodTelefone().equals(""), "erro_tipo_telefone", "erro_campo_nulo" );

                    if (dadosPessoais.getNacionalidade().equals(TipoPais.BRASIL))
                    {
                    	that( endereco.getCep().getCep().length() != 9 && !endereco.getCep().getCep().equals(""),
                    			"erro_tipo_cep_permanente", "erro_cep_invalido" );
                    	
                    	that( endereco.getTelefone().getCodTelefone().length() != 14 && !endereco.getTelefone().equals(""),
                    			"erro_tipo_telefone", "erro_telefone_invalido");
                    }
                    
                    endereco = dadosPessoais.getEnderecoCorrespondencia();
                    
                    if (!endereco.getCep().getCep().equals(""))
                    	that( endereco.getCep().getCep().length() != 9,
                    			"erro_tipo_cep_correspondencia", "erro_cep_invalido" );
                    
                    if (!endereco.getTelefone().getCodTelefone().equals(""))
                    	that( endereco.getTelefone().getCodTelefone().length() != 14,
                    			"erro_tipo_telefone_correspondencia", "erro_telefone_invalido");
                }
            }
        } );
    	
    	this.dadosPessoais = dadosPessoais; /*mantem os dados já preenchidos*/
        validador.onErrorForwardTo( getClass() ).dadosPessoais();
        this.dadosPessoais = null;
    	
        if (dadosPessoais.getNacionalidade().equals(TipoPais.BRASIL))
        {
	        String cpfSomenteNumeros = dadosPessoais.getCpf().replaceAll( "\\.", "" );
	        cpfSomenteNumeros = cpfSomenteNumeros.replaceAll( "-", "" );
	        dadosPessoais.setCpf( cpfSomenteNumeros );
	
	        String telefoneSomenteNumeros = dadosPessoais.getEnderecoPermanente().getTelefone().getCodTelefone();
	        telefoneSomenteNumeros = telefoneSomenteNumeros.replaceAll( "\\(", "" );
	        telefoneSomenteNumeros = telefoneSomenteNumeros.replaceAll( "\\)", " " );
	        telefoneSomenteNumeros = telefoneSomenteNumeros.replaceAll( "-", "" );
	        String[] telefoneSeparado = telefoneSomenteNumeros.split( " " );
	        dadosPessoais.getEnderecoPermanente().getTelefone().setCodDDD( telefoneSeparado[ 0 ] );
	        dadosPessoais.getEnderecoPermanente().getTelefone().setCodTelefone(
	            telefoneSeparado[ 2 ] );
	
	        telefoneSomenteNumeros = dadosPessoais.getEnderecoCorrespondencia().getTelefone().getCodTelefone();
	        telefoneSomenteNumeros = telefoneSomenteNumeros.replaceAll( "\\(", "" );
	        telefoneSomenteNumeros = telefoneSomenteNumeros.replaceAll( "\\)", " " );
	        telefoneSomenteNumeros = telefoneSomenteNumeros.replaceAll( "-", "" );
	        telefoneSeparado = telefoneSomenteNumeros.split( " " );
	        dadosPessoais.getEnderecoCorrespondencia().getTelefone().setCodDDD( telefoneSeparado[ 0 ] );
	        dadosPessoais.getEnderecoCorrespondencia().getTelefone().setCodTelefone(
	            telefoneSeparado[ 2 ] );
	
	        String cepSomenteNumeros = dadosPessoais.getEnderecoPermanente().getCep().getCep();
	        cepSomenteNumeros = cepSomenteNumeros.replaceAll( "-", "" );
	        dadosPessoais.getEnderecoPermanente().getCep().setCep( cepSomenteNumeros );
	
	        cepSomenteNumeros = dadosPessoais.getEnderecoCorrespondencia().getCep().getCep();
	        cepSomenteNumeros = cepSomenteNumeros.replaceAll( "-", "" );
	        dadosPessoais.getEnderecoCorrespondencia().getCep().setCep( cepSomenteNumeros );
        }

        usuarioService.cadastrarDadosPessoais( usuarioSessao.getUsuario(), dadosPessoais );
        result.forwardTo( IndexController.class ).index();
    }

    @Get
    @Path( "/cadastro/dadosCurriculo" )
    public void dadosCurriculo()
    {
    	System.out.println("ip");
    }

    @Post
    @Path( "/cadastro/dadosCurriculo" )
    @Transactional
    public void dadosCurriculo(
        Curriculo curriculo )
    {
    	curriculoService.cadastraCurriculo(curriculo);
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
