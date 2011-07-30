package br.usp.ime.ingpos.web.controllers;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
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

    public LoginController(
        final Result result,
        final UsuarioService usuarioService )
    {
        this.result = result;
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
        br.usp.ime.ingpos.modelo.Usuario usuario )
    {
        try {
            final boolean success = usuarioService.autenticar( usuario.getLogin(),
                usuario.getSenha() );

            if( success ) {
                result.redirectTo( IndexController.class ).index();
            } else {
                result.use( Results.logic() ).redirectTo( getClass() ).login();
            }

        } catch( Exception e ) {
            // TODO: Log error
            e.printStackTrace();
            result.use( Results.logic() ).redirectTo( getClass() ).login();
        }
    }

    @Get
    @Path( "/logout" )
    public void logout()
    {
        usuarioService.deautenticate();

        result.redirectTo( getClass() ).login();
    }

}
