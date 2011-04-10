package br.usp.ime.ingpos.web.controllers;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.Validations;
import br.usp.ime.ingpos.modelo.DadosPessoais;

@Resource
public class RegistroController
{
    public static final String NOME_METODO_REGISTRO = "registro";
    private static final int SENHA_MINIMO_CARACTERES = 6;
    
    private final Validator validador;

    public RegistroController(
        final Result resultado,
        final Validator validador )
    {
        this.validador = validador;
    }

    @Get
    @Path( "/registro" )
    public void registro()
    {

    }

    @Post
    @Path( "/registro" )
    public void registro(
        final DadosPessoais dadosPessoais,
        final String confirmacaoSenha )
    {
        validador.checking( new Validations() {
            {
                if( dadosPessoais != null ) {
                    that( DadosPessoais.isValidoCpf( dadosPessoais.getCpf() ), "erro_tipo_cpf",
                        "erro_cpf_invalido" );

                    that( dadosPessoais.getSenha().length() >= SENHA_MINIMO_CARACTERES,
                        "erro_tipo_senha", "erro_senha_tamanho_invalido", SENHA_MINIMO_CARACTERES );

                    that( confirmacaoSenha != null
                        && confirmacaoSenha.length() >= SENHA_MINIMO_CARACTERES,
                        "erro_tipo_confirmacao_senha", "erro_senha_confirmacao_tamanho_invalido",
                        SENHA_MINIMO_CARACTERES );
                    that(
                        confirmacaoSenha != null
                            && confirmacaoSenha.equals( dadosPessoais.getSenha() ),
                        "erro_tipo_confirmacao_senha", "erro_confirmacao_senha_divergente" );
                }
            }
        } );
        validador.onErrorForwardTo( RegistroController.class ).registro();

        // TODO Gerar URL "criptografada"
        // TODO Envio de E-mail
        // TODO Serviço de Ativação por recebimento da URL (cadastro/ativação)
        // TODO alterar o modelo Usuario/DadosPesoais com a data/hora

    }

    @Post
    @Path( "/registro/ativacao" )
    public void ativacao(
        String hashAtivacao )
    {
        // O hash será encriptado e enviado com o ID user. Ao receber o link,
        // busca o ID,
        // e encripta as infos e verifica a igualdade

    }

}
