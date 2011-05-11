package br.usp.ime.ingpos.services;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.RequestScoped;
import br.usp.ime.ingpos.modelo.Curriculo;
import br.usp.ime.ingpos.modelo.FormacaoAcademica;
import br.usp.ime.ingpos.modelo.IniciacaoCientifica;
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
    private UsuarioDao usuarioDao;

    public CurriculoService(
        final CurriculoDAO curriculoDAO,
        final FormacaoAcademicaDAO formacaoAcademicaDAO,
        final UsuarioSessao usuarioSessao,
        final UsuarioDao usuarioDao )
    {
        this.curriculoDAO = curriculoDAO;
        this.usuarioSessao = usuarioSessao;
        this.formacaoAcademicaDAO = formacaoAcademicaDAO;
        this.usuarioDao = usuarioDao;
    }

    public Curriculo getCurriculo()
    {
        return usuarioSessao.getUsuario().getCurriculo();
    }

    public void atualizarCurriculo(
        Curriculo curriculo )
    {
        Usuario usuario = usuarioDao.findById( usuarioSessao.getUsuario().getUsuarioID() );

        usuario.setCurriculo( curriculo );

        usuarioDao.saveOrUpdate( usuario );

        usuarioSessao.setUsuario( usuario );
    }

    public void adicionaFormacaoAcademica(
        FormacaoAcademica formacaoAcademica )
    {
        final Usuario usuario = usuarioDao.findById( usuarioSessao.getUsuario().getUsuarioID() );
        Curriculo curriculo = usuario.getCurriculo();

        if( curriculo == null ) {
            curriculo = new Curriculo();
            usuario.setCurriculo( curriculo );
        }

        curriculo.adicionaFormacaoAcademica( formacaoAcademica );

        usuarioDao.saveOrUpdate( usuario );

        usuarioSessao.setUsuario( usuario );
    }

    public void removerFormacaoAcademica(
        Usuario usuario,
        FormacaoAcademica formacaoAcademica )
    {

    }

    public void adicionaIniciacaoCientifica(
        Usuario usuario,
        IniciacaoCientifica iniciacaoCientifica )
    {
        if( usuario.getCurriculo() == null )
            usuario.setCurriculo( new Curriculo() );
        usuario.getCurriculo().adicionaIniciacaoCientifica( iniciacaoCientifica );
        usuarioDao.saveOrUpdate( usuario );

        usuarioSessao.setUsuario( usuario );
    }

    public FormacaoAcademica procuraFormacaoPorId(
        Long formacaoAcademicaId )
    {
        if( formacaoAcademicaId == null )
            return null;

        return this.formacaoAcademicaDAO.procurarFormacaoAcademicaById( formacaoAcademicaId );
    }

}
