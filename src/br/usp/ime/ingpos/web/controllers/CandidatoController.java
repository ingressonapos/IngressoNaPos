package br.usp.ime.ingpos.web.controllers;

import java.util.List;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.usp.ime.ingpos.modelo.Usuario;
import br.usp.ime.ingpos.services.CandidatoService;
import br.usp.ime.ingpos.services.UsuarioService;

/**
 * Controlador de requisi��e. � respons�vel por executar l�gica de
 * redirecionamento, incluindo desvios para p�ginas e defini��o de mensagens de
 * erro.
 */

@Resource
public class CandidatoController
{
    private final Result result;
    private final UsuarioService usuarioService;
    private final Validator validador;
    private final CandidatoService candidatoService;

    public CandidatoController(
        final Result result,
        final Validator validador,
        final UsuarioService usuarioService,
        final CandidatoService candidatoService )

    {
        this.result = result;
        this.validador = validador;
        this.usuarioService = usuarioService;
        this.candidatoService = candidatoService;
    }

    @Get
    @Path( "/candidato/lista" )
    public void listaCandidatos()
    {
        List<Usuario> listaDeCandidatos = usuarioService.listaCandidatos();
        result.include( "listaDeCandidatos", listaDeCandidatos );

    }
}