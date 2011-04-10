package br.usp.ime.ingpos.modelo.dao;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.util.hibernate.SessionCreator;
import br.usp.ime.ingpos.modelo.CedulaDeIdentidade;
import br.usp.ime.ingpos.modelo.DadosPessoais;


public class DadosPessoaisDAO  extends AbstractDaoImpl<Integer, DadosPessoais>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DadosPessoaisDAO(final SessionCreator session) {
		super(session);
	}

	public void inserirDadosPessoais(DadosPessoais dadosPessoais) {
		save(dadosPessoais);
	}

	public void deletarDadosPessoais(DadosPessoais dadosPessoais) {
		delete(dadosPessoais);
	}

	public void atualizarDadosPessoais(DadosPessoais dadosPessoais) {
		update(dadosPessoais);
	}

	public List<DadosPessoais> procurarTodosDadosPessoais() {
		return findAll();
	}

	public DadosPessoais procurarDadosPessoaisPorEmail(String email) {
		
		final List<DadosPessoais> dadosPessoais = findByCriteria(Restrictions.eq("email", email));
		
        if( dadosPessoais.isEmpty() ) {
            return null;
        } else {
            return dadosPessoais.get( 0 );
        }	
	}
	
	public DadosPessoais procurarDadosPessoaisPorFraseSenha(String fraseSenha) {
        
        final List<DadosPessoais> dadosPessoais = findByCriteria(Restrictions.eq("fraseSenha", fraseSenha));
        
        if( dadosPessoais.isEmpty() ) {
            return null;
        } else {
            return dadosPessoais.get( 0 );
        }   
    }
	
	public DadosPessoais procurarDadosPessoaisPorCpf(String cpf) {
		
		final List<DadosPessoais> dadosPessoais = findByCriteria(Restrictions.eq("cpf", cpf));
		
        if( dadosPessoais.isEmpty() ) {
            return null;
        } else {
            return dadosPessoais.get( 0 );
        }
	}

	public DadosPessoais procurarDadosPessoaisPorCedulaDeIdentidade(CedulaDeIdentidade cedulaDeIdentidade) {
		
		final List<DadosPessoais> dadosPessoais = findByCriteria(Restrictions.eq("cedulaDeIdentidade", cedulaDeIdentidade));
		
        if( dadosPessoais.isEmpty() ) {
            return null;
        } else {
            return dadosPessoais.get( 0 );
        }
	}
}