package br.usp.ime.ingpos.testes.services;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.usp.ime.ingpos.modelo.CartaDeRecomendacao;
import br.usp.ime.ingpos.modelo.Usuario;
import br.usp.ime.ingpos.modelo.dao.CartaDeRecomendacaoDAO;
import br.usp.ime.ingpos.modelo.dao.UsuarioDao;
import br.usp.ime.ingpos.seguranca.Criptografia;
import br.usp.ime.ingpos.services.CartaDeRecomendacaoService;
import br.usp.ime.ingpos.services.UsuarioService;
import br.usp.ime.ingpos.testes.BancoDeDadosTestCase;
import br.usp.ime.ingpos.web.controllers.UsuarioSessao;

public class CartaDeRecomendacaoServiceTeste extends BancoDeDadosTestCase
{

    public CartaDeRecomendacaoServiceTeste(String name)
    {
        super(name);
    }
    
    @Test
    public void testCriar() {
        CartaDeRecomendacao cartaDeRecomendacao = new CartaDeRecomendacao();
        final UsuarioService usuarioService = new UsuarioService(
            new UsuarioDao(getSessionCreator()), new UsuarioSessao());
        
        if(usuarioService.listaTodos().size() > 0){
            Usuario usuario = usuarioService.listaTodos().get( 0 );
            UsuarioSessao usuarioSessao = new UsuarioSessao();
            usuarioSessao.setUsuario( usuario );
            final CartaDeRecomendacaoService cartaDeRecomendacaoService = new CartaDeRecomendacaoService(
                new CartaDeRecomendacaoDAO(getSessionCreator()), usuarioSessao);    
            cartaDeRecomendacao.setUsuario( usuario );
            cartaDeRecomendacao.setNome( "Teste" );
            cartaDeRecomendacao.setEmail( "teste@teste.com" );
            cartaDeRecomendacaoService.criar( cartaDeRecomendacao );
            
            String hash = Criptografia.md5( cartaDeRecomendacao.getEmail() + usuario.getDadosPessoais().getEmail() );
            List<CartaDeRecomendacao> cartasDeRecomendacao = cartaDeRecomendacaoService.procurarPorHash( hash );
            
            Assert.assertTrue( cartasDeRecomendacao.size() > 0 );
            
            CartaDeRecomendacao cartaDeRecomendacao2 = cartasDeRecomendacao.get( 0 );

            Assert.assertEquals( cartaDeRecomendacao.getEmail(), cartaDeRecomendacao2.getEmail() );
            Assert.assertEquals( cartaDeRecomendacao.getNome(), cartaDeRecomendacao2.getNome() );
            Assert.assertEquals( cartaDeRecomendacao.getUsuario(), cartaDeRecomendacao2.getUsuario());
        }
    }
    
}
