package br.usp.ime.ingpos.modelo.dao;

import java.util.List;

import br.com.caelum.vraptor.util.hibernate.SessionCreator;
import br.usp.ime.ingpos.modelo.Bolsa;

public class BolsaDAO
    extends
        AbstractDaoImpl<Long,Bolsa>
{

    private static final long serialVersionUID = 1L;

    protected BolsaDAO(
        SessionCreator sessionCreator )
    {
        super( sessionCreator );
    }

    public void inserirBolsa(
        Bolsa bolsa )
    {
        save( bolsa );
    }

    public void deletarBolsa(
        Bolsa bolsa )
    {
        delete( bolsa );
    }

    public void atualizarBolsa(
        Bolsa bolsa )
    {
        saveOrUpdate( bolsa );
    }

    public List<Bolsa> procurarTodasBolsas()
    {
        return findAll();
    }

}
