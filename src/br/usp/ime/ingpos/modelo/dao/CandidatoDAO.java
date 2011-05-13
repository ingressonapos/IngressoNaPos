package br.usp.ime.ingpos.modelo.dao;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.RequestScoped;
import br.com.caelum.vraptor.util.hibernate.SessionCreator;
import br.usp.ime.ingpos.modelo.Candidato;

@RequestScoped
@Component
public class CandidatoDAO extends AbstractDaoImpl<Long,Candidato>
{

    public CandidatoDAO(
        SessionCreator sessionCreator )
    {
        super( sessionCreator );
    }    

}
