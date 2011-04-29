package br.usp.ime.ingpos.services;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.RequestScoped;
import br.usp.ime.ingpos.modelo.dao.DadosPessoaisDAO;

@RequestScoped
@Component
public class DadosPessoaisService {
	private final DadosPessoaisDAO dadosPessoaisDAO;

    public DadosPessoaisService(
        final DadosPessoaisDAO dadosPessoaisDAO )
    {
        this.dadosPessoaisDAO = dadosPessoaisDAO;
    }
    
    
}
