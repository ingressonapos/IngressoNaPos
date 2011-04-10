package br.usp.ime.ingpos.web.controllers;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.usp.ime.ingpos.modelo.DadosPessoais;
import br.usp.ime.ingpos.modelo.TipoCedulaDeIdentidade;
import br.usp.ime.ingpos.modelo.TipoEstadoCivil;

@Resource
public class CadastroController
{
    public static final String NOME_METODO_REGISTRO = "registro";

    private static final String TIPOS_ESTADO_CIVIL = "tiposEstadoCivil";
    private static final String TIPOS_CEDULA_IDENTIDADE = "tiposCedulaIdentidade";

    private final Result result;

    public CadastroController(
        final Result result )
    {
        this.result = result;
    }

    private void configurarResultDadosUsuario()
    {
        result.include( TIPOS_ESTADO_CIVIL, TipoEstadoCivil.getTiposEstadoCivil() );
        result.include( TIPOS_CEDULA_IDENTIDADE, TipoCedulaDeIdentidade.getTiposCedulaIdentidade() );
    }

    @Get
    @Path( "/cadastro/dadosUsuario" )
    public void dadosUsuario()
    {
        configurarResultDadosUsuario();
    }

    @Post
    @Path( "/cadastro/dadosUsuario" )
    public void dadosUsuario(
        DadosPessoais dadosPessoais )
    {
        configurarResultDadosUsuario();
    }

    @Get
    @Path( "/cadastro/dadosCurriculo" )
    public void dadosCurriculo()
    {
    }

    @Get
    @Path( "cadastro/registro" )
    public void registro()
    {

    }

    @Post
    @Path( "cadastro/registro" )
    public void registro(
        final DadosPessoais dadosPessoais,
        final String confirmacaoSenha )
    {
        System.out.println( dadosPessoais.getCpf() );
        System.out.println( dadosPessoais.getSenha() );
        System.out.println( confirmacaoSenha );

        // TODO Validação(senha e confirm. senha)
        // TODO Gerar URL "criptografada"
        // TODO Envio de E-mail
        // TODO Serviço de Ativação por recebimento da URL (cadastro/ativação)
        // TODO alterar o modelo Usuario/DadosPesoais com a data/hora

    }

    @Post
    @Path( "cadastro/ativacao" )
    public void ativacao(
        String hashAtivacao )
    {
        // O hash será encriptado e enviado com o ID user. Ao receber o link,
        // busca o ID,
        // e encripta as infos e verifica a igualdade

    }

}
