package br.usp.ime.ingpos.web.controllers;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.naming.NamingException;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.Validations;
import br.usp.ime.ingpos.modelo.DadosPessoais;
import br.usp.ime.ingpos.modelo.RegistroNovoUsuario;
import br.usp.ime.ingpos.services.RegistroNovoUsuarioService;
import br.usp.ime.ingpos.services.RegistroNovoUsuarioService.RegistroResultado;
import br.usp.ime.ingpos.web.interceptors.Transactional;

@Resource
public class RegistroController
{
    public static final String[] METODOS_ACESSO_IRRESTRITO = {
        "registro", "ativacao"
    };
    private static final int SENHA_MINIMO_CARACTERES = 6;

    private final Result resultado;
    private final Validator validador;
    private final RegistroNovoUsuarioService registroNovoUsuarioService;
    private RegistroNovoUsuario registroNovoUsuarioRequisicao;

    public RegistroController(
        final Result resultado,
        final Validator validador,
        final RegistroNovoUsuarioService registroNovoUsuarioService )
    {
        this.resultado = resultado;
        this.validador = validador;
        this.registroNovoUsuarioService = registroNovoUsuarioService;
    }

    @Get
    @Path( "/registro" )
    public void registro()
    {
        if( registroNovoUsuarioRequisicao != null ) {
            registroNovoUsuarioRequisicao.setSenha( "" );
            registroNovoUsuarioRequisicao.setConfirmacaoSenha( "" );
            resultado.include( "registroNovoUsuario", registroNovoUsuarioRequisicao );
        }
    }

    @Post
    @Path( "/registro" )
    @Transactional
    public void registro(
        final RegistroNovoUsuario registroNovoUsuario )
        throws AddressException,
            MessagingException,
            NamingException
    {
        validador.checking( new Validations() {
            {
                if( registroNovoUsuario != null ) {
                    that( DadosPessoais.isValidoCpf( registroNovoUsuario.getCpf() ),
                        "erro_tipo_cpf", "erro_cpf_invalido" );

                    that( registroNovoUsuario.getSenha().length() >= SENHA_MINIMO_CARACTERES,
                        "erro_tipo_senha", "erro_senha_tamanho_invalido", SENHA_MINIMO_CARACTERES );
                    that(
                        registroNovoUsuario.getSenha().equals(
                            registroNovoUsuario.getConfirmacaoSenha() ),
                        "erro_tipo_confirmacao_senha", "erro_confirmacao_senha_divergente" );
                }
            }
        } );

        registroNovoUsuarioRequisicao = registroNovoUsuario;
        validador.onErrorForwardTo( getClass() ).registro();

        final RegistroResultado registroResultado = registroNovoUsuarioService.registrar( registroNovoUsuario );

        switch( registroResultado ) {
            case SUCESSO:
                resultado.include( "messages", "registro_sucesso" );
                resultado.redirectTo( LoginController.class ).login();
                break;
            case CPF_OU_EMAIL_JA_EXISTENTE:
                validador.checking( new Validations() {
                    {
                        that( false, "registro_titulo", "registro_cpf_ou_email_ja_existem" );
                    }
                } );
                validador.onErrorUsePageOf( getClass() ).registro();

                break;
            case ERRO_ENVIAR_EMAIL:
                validador.checking( new Validations() {
                    {
                        that( false, "registro_titulo", "erro_enviar_email" );
                    }
                } );
                validador.onErrorUsePageOf( getClass() ).registro();
                break;
            default:
                throw new IllegalStateException( "Resultado nao esperado: " + registroResultado );
        }

    }

    @Get
    @Path( "/registro/ativacao/{chaveAtivacao}" )
    @Transactional
    public void ativacao(
        String chaveAtivacao )
    {
        final RegistroResultado registroResultado = registroNovoUsuarioService.ativar( chaveAtivacao );

        switch( registroResultado ) {
            case SUCESSO:
                resultado.include( "messages", "registro_ativacao_sucesso" );
                break;
            case USUARIO_JA_ATIVADO:
                resultado.include( "messages", "registro_ativacao_usuario_ja_ativado" );
                break;
            case CHAVE_ATIVACAO_NAO_EXISTE:
                resultado.include( "messages", "registro_ativacao_chave_ativacao_inexistente" );
                break;
            default:
                throw new IllegalStateException( "Resultado nao esperado: " + registroResultado );

        }

        resultado.redirectTo( LoginController.class ).login();
    }

}
