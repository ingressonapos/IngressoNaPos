package br.usp.ime.ingpos.services;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.RequestScoped;
import br.usp.ime.ingpos.modelo.Curriculo;
import br.usp.ime.ingpos.modelo.dao.CurriculoDAO;
import br.usp.ime.ingpos.web.controllers.UsuarioSessao;

@RequestScoped
@Component
public class CurriculoService
{
    private CurriculoDAO curriculoDAO;
    private UsuarioSessao usuarioSessao;

    public CurriculoService(
        final CurriculoDAO curriculoDAO,
        final UsuarioSessao usuarioSessao )
    {
        this.curriculoDAO = curriculoDAO;
        this.usuarioSessao = usuarioSessao;
    }

    public Curriculo getCurriculo()
    {
        if( usuarioSessao.getUsuario().getCurriculo() == null ) {

        }
        return usuarioSessao.getUsuario().getCurriculo();
    }
    
    public void cadastraCurriculo(Curriculo curriculo){
    	curriculoDAO.saveOrUpdate(curriculo);
    }
}
