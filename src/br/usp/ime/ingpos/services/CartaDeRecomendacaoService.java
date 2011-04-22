package br.usp.ime.ingpos.services;

import java.util.List;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.RequestScoped;
import br.usp.ime.ingpos.modelo.CartaDeRecomendacao;
import br.usp.ime.ingpos.modelo.Usuario;
import br.usp.ime.ingpos.modelo.dao.CartaDeRecomendacaoDAO;
import br.usp.ime.ingpos.seguranca.Criptografia;
import br.usp.ime.ingpos.web.controllers.UsuarioSessao;

@RequestScoped
@Component
public class CartaDeRecomendacaoService
{
    private CartaDeRecomendacaoDAO cartaDeRecomendacaoDAO;
    private UsuarioSessao usuarioSessao;
    
    public CartaDeRecomendacaoService(
        final CartaDeRecomendacaoDAO cartaDeRecomendacaoDAO, final UsuarioSessao usuarioSessao )
    {
        this.cartaDeRecomendacaoDAO = cartaDeRecomendacaoDAO;
        this.usuarioSessao = usuarioSessao;
    }

    public void salvar(final CartaDeRecomendacao cartaDeRecomendacao) {
        cartaDeRecomendacaoDAO.saveOrUpdate(cartaDeRecomendacao);
    }

    public void criar(final CartaDeRecomendacao cartaDeRecomendacao) {
        cartaDeRecomendacao.setUsuario( usuarioSessao.getUsuario() );
        String hash = Criptografia.md5( cartaDeRecomendacao.getEmail() + usuarioSessao.getUsuario().getDadosPessoais().getEmail() );
        cartaDeRecomendacao.setHash( hash );
        cartaDeRecomendacaoDAO.save( cartaDeRecomendacao);
    }
    
    public List<CartaDeRecomendacao> procurarPorHash(final String hash) {
        return cartaDeRecomendacaoDAO.procurarPorHash( hash );
    }
}
