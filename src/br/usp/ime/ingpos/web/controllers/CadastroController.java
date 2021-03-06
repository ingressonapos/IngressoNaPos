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
import br.com.caelum.vraptor.view.Results;
import br.usp.ime.ingpos.modelo.AreaDeInteresse;
import br.usp.ime.ingpos.modelo.CartaDeRecomendacao;
import br.usp.ime.ingpos.modelo.DadosPessoais;
import br.usp.ime.ingpos.modelo.Endereco;
import br.usp.ime.ingpos.modelo.Inscricao;
import br.usp.ime.ingpos.modelo.ProcessoSeletivo;
import br.usp.ime.ingpos.modelo.TipoCedulaDeIdentidade;
import br.usp.ime.ingpos.modelo.TipoEstadoCivil;
import br.usp.ime.ingpos.modelo.TipoPais;
import br.usp.ime.ingpos.modelo.TipoProcessoSeletivo;
import br.usp.ime.ingpos.services.CartaDeRecomendacaoService;
import br.usp.ime.ingpos.services.CurriculoService;
import br.usp.ime.ingpos.services.InscricaoService;
import br.usp.ime.ingpos.services.ProcessoSeletivoService;
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
    private final ProcessoSeletivoService processoSeletivoService;
    private final InscricaoService inscricaoService;
    private DadosPessoais dadosPessoais;

    public CadastroController(
        final Result result,
        final Validator validator,
        final UsuarioSessao usuarioSessao,
        final UsuarioService usuarioService,
        final CartaDeRecomendacaoService cartaDeRecomendacaoService,
        final ProcessoSeletivoService processoSeletivoService,
        final InscricaoService inscricaoService,
        final CurriculoService curriculoService )
    {
        this.result = result;
        this.validador = validator;
        this.usuarioSessao = usuarioSessao;
        this.usuarioService = usuarioService;
        this.cartaDeRecomendacaoService = cartaDeRecomendacaoService;
        this.curriculoService = curriculoService;
        this.processoSeletivoService = processoSeletivoService;
        this.inscricaoService = inscricaoService;
    }

    private void configurarResultDadosPessoais()
    {
        if( this.dadosPessoais == null )
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
                    
                    that( !endereco.getLogradouro().equals(""), "erro_tipo_logradouro_permanente", "erro_campo_nulo" );
                    
                    that( !endereco.getNumero().equals(""), "erro_tipo_numero_permanente", "erro_campo_nulo" );
                    
                    that( !endereco.getCep().getCep().equals(""), "erro_tipo_cep_permanente", "erro_campo_nulo" );
                    
                    that( !endereco.getCidade().equals(""), "erro_tipo_cidade_permanente", "erro_campo_nulo" );
                    
                    that( !endereco.getEstado().equals(""), "erro_tipo_estado_permanente", "erro_campo_nulo" );
                    
                    that( !endereco.getTelefone().getCodTelefone().equals(""), "erro_tipo_telefone", "erro_campo_nulo" );

                    if (dadosPessoais.getNacionalidade().equals(TipoPais.BRASIL))
                    {
                     that( !dadosPessoais.getCpf().equals("") ,"erro_tipo_cpf", "erro_campo_nulo" );
                    
                     that( DadosPessoais.isValidoCpf( dadosPessoais.getCpf() ), "erro_tipo_cpf", "erro_cpf_invalido" );
                    
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
	    List<AreaDeInteresse> areasDeInteresse = new ArrayList<AreaDeInteresse>();
	    areasDeInteresse.add(new AreaDeInteresse(
	    "banco_de_dados", false));
	    areasDeInteresse.add(new AreaDeInteresse(
	    "bioinformatica", false));
	    areasDeInteresse.add(new AreaDeInteresse(
	    "combinatoria", false));
	    areasDeInteresse.add(new AreaDeInteresse(
	    "combinatoria_grafos", false));
	    areasDeInteresse.add(new AreaDeInteresse(
	    "computacao_grafica", false));
	    areasDeInteresse.add(new AreaDeInteresse(
	    "computacao_paralela", false));
	    areasDeInteresse.add(new AreaDeInteresse(
	    "computacao_musical", false));
	    areasDeInteresse.add(new AreaDeInteresse(
	    "criptografia", false));
	    areasDeInteresse.add(new AreaDeInteresse(
	    "engenharia_software", false));
	    areasDeInteresse.add(new AreaDeInteresse(
	    "inteligencia_artificial", false));
	    areasDeInteresse.add(new AreaDeInteresse(
	    "linguagens_programacao", false));
	    areasDeInteresse.add(new AreaDeInteresse(
	    "logica_computacional", false));
	    areasDeInteresse.add(new AreaDeInteresse(
	    "otimizacao_combinatoria", false));
	    areasDeInteresse.add(new AreaDeInteresse(
	    "otimizacao_continua", false));
	    areasDeInteresse.add(new AreaDeInteresse(
	    "sistemas_distribuidos", false));
	    areasDeInteresse.add(new AreaDeInteresse(
	    "sistemas_tutores_inteligentes", false));
	    areasDeInteresse.add(new AreaDeInteresse(
	    "teoria_automatos", false));
	    areasDeInteresse.add(new AreaDeInteresse(
	    "visao_computacional", false));
	    
	    List<String> professores = new ArrayList<String>();
	    professores.add("alair_pereira_do_lago");
	    professores.add("alan_mitchell_durham");
	    professores.add("alfredo_goldman_vel_lejbman");
	    professores.add("ana_cristina_vieira_de_melo");
	    professores.add("andre_fujita");
	    professores.add("daniel_macedo_batista");
	    professores.add("fabio_kon");

	    result.include("areasDeInteresse", areasDeInteresse);
	    result.include("professores", professores);
    }
    
    @Post
    @Path("/cadastro/dadosVaga")
    @Transactional
    public void dadosVaga(final Inscricao inscricao, final TipoProcessoSeletivo tipoPos, final List<String> listaAreasMaiorAfinidade, final List<String> listaAreasMenorAfinidade, final Boolean outraMaiorAfinidade, final Boolean outraMenorAfinidade) {
    	List<AreaDeInteresse> areasDeInteresse = new ArrayList<AreaDeInteresse>();

    	ProcessoSeletivo processoSeletivo = new ProcessoSeletivo();
    	processoSeletivo.setTipoProcessoSeletivo(tipoPos);
    	
    	processoSeletivoService.atualizarProcessoSeletivo(processoSeletivo);
    	
    	inscricao.setProcessoSeletivo(processoSeletivo);
    	
    	for (int i = 0; i < listaAreasMaiorAfinidade.size(); i++)
    	{
    		if(listaAreasMaiorAfinidade.get(i) == null)
    			break;
    		
    		areasDeInteresse.add(new AreaDeInteresse(listaAreasMaiorAfinidade.get(i), true));
    	}
    	
    	inscricao.setAreasDeInteresseMaiorAfinidade(areasDeInteresse);
    	
    	areasDeInteresse = new ArrayList<AreaDeInteresse>();
    	
    	for (int i = 0; i < listaAreasMenorAfinidade.size(); i++)
    	{
    		if(listaAreasMenorAfinidade.get(i) == null)
    			break;
    		
    		areasDeInteresse.add(new AreaDeInteresse(listaAreasMaiorAfinidade.get(i), true));
    	}
    	
    	inscricao.setAreasDeInteresseMenorAfinidade(areasDeInteresse);
    	
    	inscricaoService.atualizarProcessoSeletivo(inscricao);
    	
    	result.use(Results.logic()).redirectTo(IndexController.class).index();
    }
}
