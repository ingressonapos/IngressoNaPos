package br.usp.ime.ingpos.modelo.dao;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.RequestScoped;
import br.com.caelum.vraptor.util.hibernate.SessionCreator;
import br.usp.ime.ingpos.modelo.Inscricao;

@RequestScoped
@Component
public class InscricaoDAO extends
	AbstractDaoImpl<Long,Inscricao> {

	protected InscricaoDAO(SessionCreator sessionCreator) {
		super(sessionCreator);
	}
	
	public void atualizarInscricao(
			Inscricao inscricao )
	{
	    saveOrUpdate( inscricao );
	}
}
