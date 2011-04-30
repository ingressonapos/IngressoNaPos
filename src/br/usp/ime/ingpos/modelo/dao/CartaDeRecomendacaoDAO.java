package br.usp.ime.ingpos.modelo.dao;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.RequestScoped;
import br.com.caelum.vraptor.util.hibernate.SessionCreator;
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

    public CartaDeRecomendacao procurarPorHash(
        final String hash )
    {
        final List<CartaDeRecomendacao> cartList = findByCriteria( Restrictions.eq( "hash", hash ) );

        if( cartList.size() > 1 ) {
            throw new IllegalStateException(
                "Existem dois ou mais cartas de recomendacao com mesmo hash (mesmo aluno e professor)" );
        }

        if( cartList.isEmpty() ) {
            return null;
        } else {
            return cartList.get( 0 );
        }
    }

    public List<CartaDeRecomendacao> procurarPorUsuario(
        final Usuario usuario )
    {
        return findByCriteria( Restrictions.eq( "usuario", usuario ) );
    }
}
