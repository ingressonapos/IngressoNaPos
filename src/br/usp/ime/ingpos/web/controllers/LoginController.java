package br.usp.ime.ingpos.web.controllers;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.Validations;
import br.com.caelum.vraptor.view.Results;
import br.usp.ime.ingpos.modelo.DadosPessoais;
import br.usp.ime.ingpos.services.UsuarioService;
import br.usp.ime.ingpos.web.interceptors.Transactional;

/**
 * Controlador de requisiçõe. É responsável por executar lógica de
 * redirecionamento, incluindo desvios para páginas e definição de mensagens de
 * erro.
 */

@Resource
public class LoginController
{
    private final Result result;
    private final UsuarioService usuarioService;
    private final Validator validador;

    public LoginController(
        final Result result,
        final Validator validador,
        final UsuarioService usuarioService )

    {
        this.result = result;
        this.validador = validador;
        this.usuarioService = usuarioService;
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
        DadosPessoais usuario )
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

}
