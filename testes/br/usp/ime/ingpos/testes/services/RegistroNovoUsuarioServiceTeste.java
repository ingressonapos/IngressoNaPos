package br.usp.ime.ingpos.testes.services;

import org.junit.Test;

import br.usp.ime.ingpos.modelo.RegistroNovoUsuario;
import br.usp.ime.ingpos.modelo.dao.PerfilDao;
import br.usp.ime.ingpos.modelo.dao.RegistroNovoUsuarioDao;
import br.usp.ime.ingpos.modelo.dao.UsuarioDao;
import br.usp.ime.ingpos.services.EmailException;
import br.usp.ime.ingpos.services.EmailService;
import br.usp.ime.ingpos.services.RegistroNovoUsuarioService;
import br.usp.ime.ingpos.services.RegistroNovoUsuarioService.RegistroResultado;
import br.usp.ime.ingpos.services.UsuarioService;
import br.usp.ime.ingpos.testes.BancoDeDadosTestCase;
import br.usp.ime.ingpos.web.controllers.UsuarioSessao;

public class RegistroNovoUsuarioServiceTeste
    extends
        BancoDeDadosTestCase
{
    public static final String NOME = "Alfredo Goldman";
    public static final String EMAIL = "ingressonaposxp@gmail.com";
    public static final String SENHA = "123456";

    public RegistroNovoUsuarioServiceTeste(
        String name )
    {
        super( name );
    }

    @Test
    public void testeRegistrar()
    {
        try {

            RegistroNovoUsuarioService registroNovoUsuarioService = new RegistroNovoUsuarioService(
                new RegistroNovoUsuarioDao( getSessionCreator() ),
                new PerfilDao( getSessionCreator() ),
                new UsuarioService( new UsuarioDao( getSessionCreator() ), new UsuarioSessao() ),
                new EmailService( EmailServiceTeste.construirSessionParaTeste() ),
                null );

            RegistroNovoUsuario registroNovoUsuario = new RegistroNovoUsuario();
            registroNovoUsuario.setEmail( EMAIL );
            registroNovoUsuario.setNomeCompleto( NOME );
            registroNovoUsuario.setSenha( SENHA );
            registroNovoUsuario.setConfirmacaoSenha( SENHA );

            RegistroResultado resultado = registroNovoUsuarioService.registrar( registroNovoUsuario );

            assertTrue( resultado == RegistroResultado.SUCESSO
                || resultado == RegistroResultado.NOME_OU_EMAIL_JA_EXISTENTE );

        } catch( EmailException e ) {
            e.printStackTrace();
            assertTrue( false );
        }
    }

    @Test
    public void testeAtivar()
    {
        try {
            final RegistroNovoUsuarioDao registroNovoUsuarioDao = new RegistroNovoUsuarioDao(
                getSessionCreator() );

            final RegistroNovoUsuarioService registroNovoUsuarioService = new RegistroNovoUsuarioService(
                new RegistroNovoUsuarioDao( getSessionCreator() ),
                new PerfilDao( getSessionCreator() ),
                new UsuarioService( new UsuarioDao( getSessionCreator() ), new UsuarioSessao() ),
                new EmailService( EmailServiceTeste.construirSessionParaTeste() ),
                null );

            final RegistroNovoUsuario registroNovoUsuario = registroNovoUsuarioDao.procurarPorEmail(
                EMAIL );

            assertNotNull( registroNovoUsuario );

            final RegistroResultado resultado;
            if( registroNovoUsuario == null ) {
                resultado = null;
            } else {
                resultado = registroNovoUsuarioService.ativar( registroNovoUsuario.getChaveAtivacao() );
            }

            assertTrue( resultado == RegistroResultado.SUCESSO
                || resultado == RegistroResultado.CHAVE_ATIVACAO_NAO_EXISTE
                || resultado == RegistroResultado.USUARIO_JA_ATIVADO );

        } catch( EmailException e ) {
            e.printStackTrace();
            assertTrue( false );
        }
    }
}
