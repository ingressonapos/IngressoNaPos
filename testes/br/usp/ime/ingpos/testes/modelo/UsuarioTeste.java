package br.usp.ime.ingpos.testes.modelo;

import java.util.List;

import org.junit.Test;

import br.usp.ime.ingpos.modelo.DadosPessoais;
import br.usp.ime.ingpos.modelo.Perfil;
import br.usp.ime.ingpos.modelo.Usuario;
import br.usp.ime.ingpos.modelo.dao.PerfilDao;
import br.usp.ime.ingpos.modelo.dao.UsuarioDao;
import br.usp.ime.ingpos.seguranca.Criptografia;
import br.usp.ime.ingpos.testes.BancoDeDadosTestCase;

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

        final String email = "teste";
        final String senha = Criptografia.md5( "12345" );

        Usuario usuario = usuarioDao.findByEmailAndPassword( email, senha );
        if( usuario == null ) {
            usuario = new Usuario();
        }

        final String descPerfil = "Admnistrador";
        final Perfil perfil;
        final List<Perfil> perfis = perfilDao.procurarPorDescricao( descPerfil );
        if( perfis != null && ! perfis.isEmpty() ) {
            perfil = perfis.get( 0 );
        } else {
            perfil = new Perfil();
            perfil.setDescricao( descPerfil );

            perfilDao.save( perfil );
        }

        final DadosPessoais dadosPessoais = usuario.getDadosPessoais();

        dadosPessoais.setNomeCompleto( "teste" );
        dadosPessoais.setEmail( email );
        dadosPessoais.setSenha( senha );

        usuario.setAtivo( true );
        usuario.setPerfil( perfil );

        usuarioDao.saveOrUpdate( usuario );

        assertTrue( usuario.getUsuarioID() > 0 );

    }

    @Test
    public void testBuscarTodosUsuarios()
    {
        final UsuarioDao usuarioDao = new UsuarioDao( getSessionCreator() );
        assertTrue( ! usuarioDao.findAll().isEmpty() );
    }

}
