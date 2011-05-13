package br.usp.ime.ingpos.services;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.RequestScoped;
import br.usp.ime.ingpos.modelo.Inscricao;
import br.usp.ime.ingpos.modelo.dao.InscricaoDAO;

@RequestScoped
@Component
public class InscricaoService {
	private InscricaoDAO inscricaoDAO;

	public InscricaoService(final InscricaoDAO inscricaoDAO) {
		this.inscricaoDAO = inscricaoDAO;
	}

	public void atualizarProcessoSeletivo(final Inscricao inscricao) {
		inscricaoDAO.saveOrUpdate(inscricao);
	}
}
