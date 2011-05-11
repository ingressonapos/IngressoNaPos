package br.usp.ime.ingpos.services;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.RequestScoped;
import br.com.caelum.vraptor.ioc.SessionScoped;
import br.usp.ime.ingpos.modelo.Curriculo;
import br.usp.ime.ingpos.modelo.FormacaoAcademica;
import br.usp.ime.ingpos.modelo.IniciacaoCientifica;
import br.usp.ime.ingpos.modelo.PosComp;
import br.usp.ime.ingpos.modelo.Usuario;
import br.usp.ime.ingpos.modelo.dao.CurriculoDAO;
import br.usp.ime.ingpos.modelo.dao.FormacaoAcademicaDAO;
import br.usp.ime.ingpos.modelo.dao.UsuarioDao;
import br.usp.ime.ingpos.web.controllers.UsuarioSessao;

@RequestScoped
@Component
public class CurriculoService
{
    private CurriculoDAO curriculoDAO;
    private FormacaoAcademicaDAO formacaoAcademicaDAO;
    private UsuarioSessao usuarioSessao;

    public CurriculoService(
        final CurriculoDAO curriculoDAO,
        final FormacaoAcademicaDAO formacaoAcademicaDAO,
        final UsuarioSessao usuarioSessao )
    {
        this.curriculoDAO = curriculoDAO;
        this.usuarioSessao = usuarioSessao;
        this.formacaoAcademicaDAO = formacaoAcademicaDAO;
    }

    public Curriculo getCurriculo()
    {
        return usuarioSessao.getUsuario().getCurriculo();
    }

    public void cadastraCurriculo(
        Curriculo curriculo )
    {
        curriculoDAO.saveOrUpdate( curriculo );
    }

    public Curriculo procuraCurriculo(
        Usuario usuario )
    {
        return usuario.getCurriculo();
    }

    public void salvaFormacaoAcademica(
        Usuario usuario,
        UsuarioDao usuarioDao,
        FormacaoAcademica formacaoAcademica )
    {
        if( usuario.getCurriculo() == null )
            usuario.setCurriculo( new Curriculo() );
        usuario.getCurriculo().adicionaFormacaoAcademica( formacaoAcademica );
        usuarioDao.saveOrUpdate( usuario );

    }

    public void salvaIniciacaoCientifica(
        Usuario usuario,
        UsuarioDao usuarioDao,
        IniciacaoCientifica iniciacaoCientifica )
    {
        if( usuario.getCurriculo() == null )
            usuario.setCurriculo( new Curriculo() );
        usuario.getCurriculo().adicionaIniciacaoCientifica( iniciacaoCientifica );
        usuarioDao.saveOrUpdate( usuario );

    }

    public void salvaPosComp(
        Usuario usuario,
        UsuarioDao usuarioDao,
        PosComp posComp )
    {
        if( usuario.getCurriculo() == null )
            usuario.setCurriculo( new Curriculo() );
        usuario.getCurriculo().setPosComp( posComp );
        usuarioDao.saveOrUpdate( usuario );

    }

    public void removerFormacaoAcademica(
        Usuario usuario,
        UsuarioDao usuarioDao,
        FormacaoAcademica formacaoAcademica )
    {

    }

    public FormacaoAcademica procuraFormacao(
        Usuario usuario,
        UsuarioDao usuarioDao,
        FormacaoAcademica formacaoAcademica )
    {
        if(formacaoAcademica.getFormacaoAcademicaId() == null)
            return null;
       return this.formacaoAcademicaDAO.procurarFormacaoAcademicaById(formacaoAcademica.getFormacaoAcademicaId());
        
    }

}
