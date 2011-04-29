package br.usp.ime.ingpos.web.controllers;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.Validations;
import br.com.caelum.vraptor.view.Results;
import br.usp.ime.ingpos.modelo.Usuario;
import br.usp.ime.ingpos.services.SenhaService;
import br.usp.ime.ingpos.services.UsuarioService;
import br.usp.ime.ingpos.web.interceptors.Transactional;

/**
 * Controlador de requisi��e. � respons�vel por executar l�gica de
 * redirecionamento, incluindo desvios para p�ginas e defini��o de mensagens de
 * erro.
 */

@Resource
public class LoginController
{
    private final Result result;
    private final UsuarioService usuarioService;
    private final Validator validador;
    private final SenhaService senhaService;

    public LoginController(
        final Result result,
        final Validator validador,
        final UsuarioService usuarioService,
        final SenhaService senhaService )

    {
        this.result = result;
        this.validador = validador;
        this.usuarioService = usuarioService;
        this.senhaService = senhaService;
    }

    @Get
    @Path( "/login" )
    public void login()
    {
    }

    @Post
    @Path( "/login" )
    @Transactional
    public void login(
        Usuario usuario )
    {
        try {
            final boolean success = usuarioService.autenticar( usuario.getEmail(),
                usuario.getSenha() );

            if( success ) {
                result.redirectTo( IndexController.class ).index();
            } else {
                result.use( Results.logic() ).redirectTo( getClass() ).erro();
            }

        } catch( Exception e ) {
            // TODO: Log error
            e.printStackTrace();
            result.use( Results.logic() ).redirectTo( getClass() ).login();
        }
    }

    @Get
    @Path( "/login/erro" )
    public void erro()
    {
        validador.checking( new Validations() {
            {
                that( false, "erro_tipo_login", "erro_msg_login_invalido" );
            }
        } );
        validador.onErrorForwardTo( getClass() ).login();

        // validador.add( new ValidationMessage( "erro_msg_login_invalido",
        // "erro_tipo_login" ) );
        // validador.onErrorUsePageOf( getClass() ).login();
    }

    @Get
    @Path( "/logout" )
    public void logout()
    {
        usuarioService.deautenticate();

        result.redirectTo( getClass() ).login();
    }

    @Get
    @Path( "/login/forgot" )
    public void forgot()
    {
    }

    @Post
    @Path( "/login/forgot" )
    @Transactional
    public void forgot(
        String email )
    {
        if( senhaService.enviarEmailSucedido( email ) ) {
            result.include( "messages", "E-mail foi enviado com sucesso!" );
            result.redirectTo( getClass() ).forgot();
        } else {
            validador.checking( new Validations() {
                {
                    that( false, "erro_tipo_email", "email_doesnt_exist_user" );
                }
            } );
            validador.onErrorForwardTo( getClass() ).forgot();
        }
    }

}