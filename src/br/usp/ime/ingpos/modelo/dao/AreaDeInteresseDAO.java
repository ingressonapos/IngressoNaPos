package br.usp.ime.ingpos.modelo.dao;

import br.com.caelum.vraptor.util.hibernate.SessionCreator;
import br.usp.ime.ingpos.modelo.AreaDeInteresse;

public class AreaDeInteresseDAO extends AbstractDaoImpl<Long,AreaDeInteresse>{

	public AreaDeInteresseDAO(SessionCreator sessionCreator) {
		super(sessionCreator);
	}
	
	public void inserirAreaDeInteresse(
			AreaDeInteresse areaDeInteresse )
	{
	    save( areaDeInteresse );
	}

	public void atualizarAreaDeInteresse( AreaDeInteresse areaDeInteresse )
	{
	    saveOrUpdate( areaDeInteresse );
	}
	
	public void deletarAreaDeInteresse(
			AreaDeInteresse areaDeInteresse )
	{
	    delete( areaDeInteresse );
	}
}