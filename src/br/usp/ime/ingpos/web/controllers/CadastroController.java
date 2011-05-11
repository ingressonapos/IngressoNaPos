package br.usp.ime.ingpos.web.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.Validations;
import br.usp.ime.ingpos.modelo.AreaDeInteresse;
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
                	
                    that( !dadosPessoais.getCpf().equals("") ,"erro_tipo_cpf", "erro_campo_nulo" );
                    
                    that( DadosPessoais.isValidoCpf( dadosPessoais.getCpf() ), "erro_tipo_cpf", "erro_cpf_invalido" );
                    
                    that( !endereco.getLogradouro().equals(""), "erro_tipo_logradouro_permanente", "erro_campo_nulo" );
                    
                    that( !endereco.getNumero().equals(""), "erro_tipo_numero_permanente", "erro_campo_nulo" );
                    
                    that( !endereco.getCep().getCep().equals(""), "erro_tipo_cep_permanente", "erro_campo_nulo" );
                    
                    that( !endereco.getCidade().equals(""), "erro_tipo_cidade_permanente", "erro_campo_nulo" );
                    
                    that( !endereco.getEstado().equals(""), "erro_tipo_estado_permanente", "erro_campo_nulo" );
                    
                    that( !endereco.getTelefone().getCodTelefone().equals(""), "erro_tipo_telefone", "erro_campo_nulo" );

                    if (dadosPessoais.getNacionalidade().equals(TipoPais.BRASIL))
                    {
                    	that( !(endereco.getCep().getCep().length() != 9 && !endereco.getCep().getCep().equals("")),
                    			"erro_tipo_cep_permanente", "erro_cep_invalido" );
                    	
                    	that( !(endereco.getTelefone().getCodTelefone().length() != 14 && !endereco.getTelefone().equals("")),
                    			"erro_tipo_telefone", "erro_telefone_invalido");
                    }
                    
                    endereco = dadosPessoais.getEnderecoCorrespondencia();
                    
                }
            }
        } );
    	
    	this.dadosPessoais = dadosPessoais; //mantem os dados já preenchidos
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
	
	        if(dadosPessoais.getEnderecoCorrespondencia().getTelefone().equals(""))
	        {
		        telefoneSomenteNumeros = dadosPessoais.getEnderecoCorrespondencia().getTelefone().getCodTelefone();
		        telefoneSomenteNumeros = telefoneSomenteNumeros.replaceAll( "\\(", "" );
		        telefoneSomenteNumeros = telefoneSomenteNumeros.replaceAll( "\\)", " " );
		        telefoneSomenteNumeros = telefoneSomenteNumeros.replaceAll( "-", "" );
		        telefoneSeparado = telefoneSomenteNumeros.split( " " );
		        dadosPessoais.getEnderecoCorrespondencia().getTelefone().setCodDDD( telefoneSeparado[ 0 ] );
		        dadosPessoais.getEnderecoCorrespondencia().getTelefone().setCodTelefone(
		            telefoneSeparado[ 2 ] );
	        }
	
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
    
    @Get
	@Path("/cadastro/dadosVaga")
	public void dadosVaga() {
		List<AreaDeInteresse> areasDeInteresseMaiorAfinidade = new ArrayList<AreaDeInteresse>();
		areasDeInteresseMaiorAfinidade.add(new AreaDeInteresse(
				"banco_de_dados", false));

		// <input type="checkbox" name="areaInteresse1" value="banco_de_dados"
		// id="banco_de_dados5" onclick="alteraCheckbox('banco_de_dados', 1)">
		// <fmt:message key="banco_de_dados"/><br>
		// <input type="checkbox" name="areaInteresse1" value="bioinformatica"
		// id="bioinformatica1" onclick="alteraCheckbox('bioinformatica', 1)">
		// <fmt:message key="bioinformatica"/><br>
		// <input type="checkbox" name="areaInteresse1" value="combinatoria"
		// id="combinatoria1" onclick="alteraCheckbox('combinatoria', 1)">
		// <fmt:message key="combinatoria"/><br>
		// <input type="checkbox" name="areaInteresse1"
		// value="combinatoria_grafos" id="combinatoria_grafos1"
		// onclick="alteraCheckbox('combinatoria_grafos', 1)">
		// <fmt:message key="combinatoria_grafos"/><br>
		// <input type="checkbox" name="areaInteresse1"
		// value="computacao_grafica" id="computacao_grafica1"
		// onclick="alteraCheckbox('computacao_grafica', 1)">
		// <fmt:message key="computacao_grafica"/><br>
		// <input type="checkbox" name="areaInteresse1"
		// value="computacao_paralela" id="computacao_paralela1"
		// onclick="alteraCheckbox('computacao_paralela', 1)">
		// <fmt:message key="computacao_paralela"/><br>
		// <input type="checkbox" name="areaInteresse1"
		// value="computacao_musical" id="computacao_musical1"
		// onclick="alteraCheckbox('computacao_musical', 1)">
		// <fmt:message key="computacao_musical"/><br>
		// <input type="checkbox" name="areaInteresse1" value="criptografia"
		// id="criptografia1" onclick="alteraCheckbox('criptografia', 1)">
		// <fmt:message key="criptografia"/><br>
		// <input type="checkbox" name="areaInteresse1"
		// value="engenharia_software" id="engenharia_software1"
		// onclick="alteraCheckbox('engenharia_software', 1)">
		// <fmt:message key="engenharia_software"/><br>
		// <input type="checkbox" name="areaInteresse1"
		// value="inteligencia_artificial" id="inteligencia_artificial1"
		// onclick="alteraCheckbox('inteligencia_artificial', 1)">
		// <fmt:message key="inteligencia_artificial"/><br>
		// <input type="checkbox" name="areaInteresse1"
		// value="linguagens_programacao" id="linguagens_programacao1"
		// onclick="alteraCheckbox('linguagens_programacao', 1)">
		// <fmt:message key="linguagens_programacao"/><br>
		// <input type="checkbox" name="areaInteresse1"
		// value="logica_computacional" id="logica_computacional1"
		// onclick="alteraCheckbox('logica_computacional', 1)">
		// <fmt:message key="logica_computacional"/><br>
		// <input type="checkbox" name="areaInteresse1"
		// value="otimizacao_combinatoria" id="otimizacao_combinatoria1"
		// onclick="alteraCheckbox('otimizacao_combinatoria', 1)">
		// <fmt:message key="otimizacao_combinatoria"/><br>
		// <input type="checkbox" name="areaInteresse1"
		// value="otimizacao_continua" id="otimizacao_continua1"
		// onclick="alteraCheckbox('otimizacao_continua', 1)">
		// <fmt:message key="otimizacao_continua"/><br>
		// <input type="checkbox" name="areaInteresse1"
		// value="sistemas_distribuidos" id="sistemas_distribuidos1"
		// onclick="alteraCheckbox('sistemas_distribuidos', 1)">
		// <fmt:message key="sistemas_distribuidos"/><br>
		// <input type="checkbox" name="areaInteresse1"
		// value="sistemas_tutores_inteligentes"
		// id="sistemas_tutores_inteligentes1"
		// onclick="alteraCheckbox('sistemas_tutores_inteligentes', 1)">
		// <fmt:message key="sistemas_tutores_inteligentes"/><br>
		// <input type="checkbox" name="areaInteresse1" value="teoria_automatos"
		// id="teoria_automatos1"
		// onclick="alteraCheckbox('teoria_automatos', 1)">
		// <fmt:message key="teoria_automatos"/><br>
		// <input type="checkbox" name="areaInteresse1"
		// value="visao_computacional" id="visao_computacional1"
		// onclick="alteraCheckbox('visao_computacional', 1)">
		// <fmt:message key="visao_computacional"/><br>
		// <input type="checkbox" name="areaInteresse1" value="nao_sei">
		// <fmt:message key="cadastro_vaga_nao_sei"/><br>
		// <input type="checkbox" name="areaInteresse1" value="outra">
		// <fmt:message key="outra"/><br>

		result.include("areasDeInteresseMaiorAfinidade",
				areasDeInteresseMaiorAfinidade);
	}

    //	@Post
    //	@Path("/cadastro/dadosVaga")
    //	public void dadosVaga() {
    //	}
}
