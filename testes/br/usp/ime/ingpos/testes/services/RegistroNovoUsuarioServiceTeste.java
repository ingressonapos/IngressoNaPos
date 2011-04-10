package br.usp.ime.ingpos.testes.services;

import org.junit.Test;

import br.usp.ime.ingpos.modelo.RegistroNovoUsuario;
import br.usp.ime.ingpos.modelo.dao.PerfilDao;
import br.usp.ime.ingpos.modelo.dao.RegistroNovoUsuarioDao;
import br.usp.ime.ingpos.modelo.dao.UsuarioDao;
import br.usp.ime.ingpos.services.RegistroNovoUsuarioService;
import br.usp.ime.ingpos.services.RegistroNovoUsuarioService.RegistroResultado;
import br.usp.ime.ingpos.services.UsuarioService;
import br.usp.ime.ingpos.testes.BancoDeDadosTestCase;
import br.usp.ime.ingpos.web.controllers.UsuarioSessao;

public class RegistroNovoUsuarioServiceTeste
    extends
        BancoDeDadosTestCase
{

    private static final String CPF = "123456789";
    private static final String EMAIL = "teste@teste.com";

    public RegistroNovoUsuarioServiceTeste(
        String name )
    {
        super( name );
    }

    @Test
    public void testeRegistrar()
    {
        final RegistroNovoUsuarioService registroNovoUsuarioService = new RegistroNovoUsuarioService(
            new RegistroNovoUsuarioDao( getSessionCreator() ),
            new PerfilDao( getSessionCreator() ),
            new UsuarioService( new UsuarioDao( getSessionCreator() ), new UsuarioSessao() ) );

        RegistroNovoUsuario registroNovoUsuario = new RegistroNovoUsuario();
        registroNovoUsuario.setEmail( EMAIL );
        registroNovoUsuario.setCpf( CPF );
        registroNovoUsuario.setSenha( "12345" );
        registroNovoUsuario.setConfirmacaoSenha( "12345" );

        RegistroResultado resultado = registroNovoUsuarioService.registrar( registroNovoUsuario );

        assertTrue( resultado == RegistroResultado.SUCESSO
            || resultado == RegistroResultado.CPF_OU_EMAIL_JA_EXISTENTEM );

    }

    @Test
    public void testeAtivar()
    {
        final RegistroNovoUsuarioDao registroNovoUsuarioDao = new RegistroNovoUsuarioDao(
            getSessionCreator() );

        final RegistroNovoUsuarioService registroNovoUsuarioService = new RegistroNovoUsuarioService(
            registroNovoUsuarioDao,
            new PerfilDao( getSessionCreator() ),
            new UsuarioService( new UsuarioDao( getSessionCreator() ), new UsuarioSessao() ) );

        final RegistroNovoUsuario registroNovoUsuario = registroNovoUsuarioDao.procurarPorEmailOuCpf(
            EMAIL, CPF );

        assertNotNull( registroNovoUsuario );

        final RegistroResultado resultado;
        if( registroNovoUsuario == null ) {
            resultado = null;
        } else {
            resultado = registroNovoUsuarioService.ativar( registroNovoUsuario.getChaveAtivacao() );
        }

        assertTrue( resultado == RegistroResultado.SUCESSO
            || resultado == RegistroResultado.CHAVE_ATIVACAO_NAO_EXISTE );

    }
}
