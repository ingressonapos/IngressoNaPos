package br.usp.ime.ingpos.services;

import java.util.List;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.RequestScoped;
import br.usp.ime.ingpos.modelo.Candidato;
import br.usp.ime.ingpos.modelo.dao.CandidatoDAO;

@RequestScoped
@Component
public class CandidatoService
{

    private final CandidatoDAO candidatoDAO;
    
    public CandidatoService(CandidatoDAO candidatoDAO) {
        this.candidatoDAO = candidatoDAO;
    }
    
    public void salvar(final Candidato candidato) {
        candidatoDAO.save( candidato );
    }
    
    public List<Candidato> listaTodos() {
        return candidatoDAO.findAll();
    }
    
}
