package br.usp.ime.ingpos.modelo.dao;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.RequestScoped;
import br.com.caelum.vraptor.util.hibernate.SessionCreator;
import br.usp.ime.ingpos.modelo.Bolsa;
import br.usp.ime.ingpos.modelo.CartaDeRecomendacao;
import br.usp.ime.ingpos.modelo.Usuario;

@RequestScoped
@Component
public class CartaDeRecomendacaoDAO
extends
AbstractDaoImpl<Long,CartaDeRecomendacao>
{

    public CartaDeRecomendacaoDAO(
        SessionCreator sessionCreator )
    {
        super( sessionCreator );
    }
    
    public void inserirCartaDeRecomendacao(
        CartaDeRecomendacao cartaDeRecomendacao )
    {
        save( cartaDeRecomendacao );
    }

    public void atualizarCartaDeRecomendacao(
        CartaDeRecomendacao cartaDeRecomendacao )
    {
        saveOrUpdate( cartaDeRecomendacao );
    }

    public List<CartaDeRecomendacao> procurarPorHash(String hash)
    {
        final List<CartaDeRecomendacao> cartasDeRecomendacao = findByCriteria( Restrictions.eq( "hash",
            hash ) );
        return cartasDeRecomendacao;
        
    }

}
