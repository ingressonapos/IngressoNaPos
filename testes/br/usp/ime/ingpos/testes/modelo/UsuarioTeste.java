package br.usp.ime.ingpos.testes.modelo;

import java.util.List;

import org.junit.Test;

import br.usp.ime.ingpos.modelo.Perfil;
import br.usp.ime.ingpos.modelo.Usuario;
import br.usp.ime.ingpos.modelo.dao.PerfilDao;
import br.usp.ime.ingpos.modelo.dao.UsuarioDao;
import br.usp.ime.ingpos.seguranca.Criptografia;
import br.usp.ime.ingpos.testes.BancoDeDadosTestCase;
import br.usp.ime.ingpos.testes.services.RegistroNovoUsuarioServiceTeste;

public class UsuarioTeste
    extends
        BancoDeDadosTestCase
{
    public UsuarioTeste(
        String name )
    {
        super( name );
    }

    @Test
    public void testCriarOuAtualizarUsuario()
    {
        final UsuarioDao usuarioDao = new UsuarioDao( getSessionCreator() );
        final PerfilDao perfilDao = new PerfilDao( getSessionCreator() );

        final String email = RegistroNovoUsuarioServiceTeste.EMAIL;
        final String senha = Criptografia.md5( RegistroNovoUsuarioServiceTeste.SENHA );

        Usuario usuario = usuarioDao.findByEmailAndPassword( email, senha );
        if( usuario == null ) {
            usuario = new Usuario();
            usuario.setEmail( email );
            usuario.setSenha( Criptografia.md5( senha ) );

            final List<Perfil> perfilCandidatoList = perfilDao.procurarPorDescricao( Perfil.DESCRICAO_CANDIDATO );
            final Perfil perfil;
            if( perfilCandidatoList != null && ! perfilCandidatoList.isEmpty() ) {
                perfil = perfilCandidatoList.get( 0 );
            } else {
                perfil = new Perfil();
                perfil.setDescricao( Perfil.DESCRICAO_CANDIDATO );
                perfilDao.save( perfil );
            }

            usuario.setAtivo( true );
            usuario.setPerfil( perfil );
        }

        usuarioDao.saveOrUpdate( usuario );

        assertTrue( usuario.getUsuarioID() > 0 );

    }

    @Test
    public void testBuscarTodosUsuarios()
    {
        final UsuarioDao usuarioDao = new UsuarioDao( getSessionCreator() );
        assertTrue( ! usuarioDao.findAll().isEmpty() );
    }

    @Test
    public void testProcurarPorEmail()
    {
        final UsuarioDao usuarioDao = new UsuarioDao( getSessionCreator() );
        final String email = RegistroNovoUsuarioServiceTeste.EMAIL;

        assertNotNull( ( usuarioDao.procurarPorEmail( email ) ) );

    }

    @Test
    public void testProcurarPorEmailESenha()
    {
        final UsuarioDao usuarioDao = new UsuarioDao( getSessionCreator() );
        final String email = RegistroNovoUsuarioServiceTeste.EMAIL;
        final String senha = RegistroNovoUsuarioServiceTeste.SENHA;

        assertNotNull( usuarioDao.findByEmailAndPassword( email, Criptografia.md5( senha ) ) );
    }
}
