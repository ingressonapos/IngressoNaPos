package br.usp.ime.ingpos.services;

import javax.print.attribute.standard.Finishings;

import org.springframework.beans.BeanUtils;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.RequestScoped;
import br.usp.ime.ingpos.modelo.Candidato;
import br.usp.ime.ingpos.modelo.Curriculo;
import br.usp.ime.ingpos.modelo.FormacaoAcademica;
import br.usp.ime.ingpos.modelo.IniciacaoCientifica;
import br.usp.ime.ingpos.modelo.Usuario;
import br.usp.ime.ingpos.modelo.dao.CandidatoDAO;
import br.usp.ime.ingpos.modelo.dao.CurriculoDAO;
import br.usp.ime.ingpos.modelo.dao.FormacaoAcademicaDAO;
import br.usp.ime.ingpos.modelo.dao.IniciacaoCientificaDAO;
import br.usp.ime.ingpos.modelo.dao.UsuarioDao;
import br.usp.ime.ingpos.web.controllers.UsuarioSessao;

@RequestScoped
@Component
public class CurriculoService
{
    private CurriculoDAO curriculoDAO;
    private FormacaoAcademicaDAO formacaoAcademicaDAO;
    private IniciacaoCientificaDAO iniciacaoCientificaDAO;
    private UsuarioSessao usuarioSessao;
    private UsuarioDao usuarioDao;
    private CandidatoDAO candidatoDao;

    public CurriculoService(
        final CurriculoDAO curriculoDAO,
        final CandidatoDAO candidatoDao,
        final FormacaoAcademicaDAO formacaoAcademicaDAO,
        final IniciacaoCientificaDAO iniciacaoCientificaDAO,
        final UsuarioSessao usuarioSessao,
        final UsuarioDao usuarioDao )
    {
        this.curriculoDAO = curriculoDAO;
        this.candidatoDao = candidatoDao;
        this.usuarioSessao = usuarioSessao;
        this.formacaoAcademicaDAO = formacaoAcademicaDAO;
        this.iniciacaoCientificaDAO = iniciacaoCientificaDAO;
        this.usuarioDao = usuarioDao;
    }

    public Curriculo getCurriculo()
    {
        final Usuario usuario = usuarioDao.findById( usuarioSessao.getUsuario().getUsuarioID() );
        return usuario.getCandidato().getCurriculo();
    }

    public void atualizarCurriculo(
        Curriculo curriculo )
    {
        Usuario usuario = usuarioDao.findById( usuarioSessao.getUsuario().getUsuarioID() );

        usuario.getCandidato().setCurriculo( curriculo );

        usuarioDao.saveOrUpdate( usuario );

        usuarioSessao.setUsuario( usuario );
    }

    public void adicionaFormacaoAcademica(
        FormacaoAcademica formacaoAcademica )
    {
        if( formacaoAcademica.getFormacaoAcademicaId() == null ) {
            final Usuario usuario = usuarioDao.findById( usuarioSessao.getUsuario().getUsuarioID() );
            Candidato candidato = usuario.getCandidato();
            Curriculo curriculo = candidato.getCurriculo();

            if( curriculo == null ) {
                curriculo = new Curriculo();
                candidato.setCurriculo( curriculo );
            }

            curriculo.adicionaFormacaoAcademica( formacaoAcademica );
            candidatoDao.saveOrUpdate( candidato );
        } else {
            FormacaoAcademica formacaoPersistente = this.getFormacaoAcademicaParaEdicao( formacaoAcademica.getFormacaoAcademicaId() );
            BeanUtils.copyProperties( formacaoAcademica, formacaoPersistente, new String[] {
                "formacaoAcademicaId"
            } );
            formacaoAcademicaDAO.saveOrUpdate( formacaoPersistente );
        }

    }

    public FormacaoAcademica getFormacaoAcademicaParaEdicao(
        final Long formacaoAcademicaId )
    {
        final FormacaoAcademica formacaoAcademica;

        // Nova formacao
        if( formacaoAcademicaId == null ) {
            formacaoAcademica = new FormacaoAcademica();
        } else {
            formacaoAcademica = formacaoAcademicaDAO.procurarFormacaoAcademicaById( formacaoAcademicaId );
        }
        return formacaoAcademica;
    }

    public void removerFormacaoAcademica(
        final Long formacaoAcademicaId )
    {
        final FormacaoAcademica formacaoPersistente = this.getFormacaoAcademicaParaEdicao( formacaoAcademicaId );
        final Usuario usuario = usuarioDao.findById( usuarioSessao.getUsuario().getUsuarioID() );
        final Candidato candidato = usuario.getCandidato();

        candidato.getCurriculo().removeFormacaoAcademica( formacaoPersistente );

        candidatoDao.saveOrUpdate( candidato );
        formacaoAcademicaDAO.delete( formacaoPersistente );
    }

    public IniciacaoCientifica getIniciacaoCientificaParaEdicao(
        final Long iniciacaocientificaId )
    {
        final IniciacaoCientifica iniciacaoCientifica;

        // Nova Iniciacao
        if( iniciacaocientificaId == null ) {
            iniciacaoCientifica = new IniciacaoCientifica();
        } else {
            iniciacaoCientifica = iniciacaoCientificaDAO.procurarIniciacaoCientificaById( iniciacaocientificaId );
        }
        return iniciacaoCientifica;
    }

    public void removerIniciacaoCientifica(
        final Long iniciacaocientificaId )
    {
        final IniciacaoCientifica iniciacaoCientificaPersistente = this.getIniciacaoCientificaParaEdicao( iniciacaocientificaId );
        final Usuario usuario = usuarioDao.findById( usuarioSessao.getUsuario().getUsuarioID() );
        final Candidato candidato = usuario.getCandidato();

        candidato.getCurriculo().removeIniciacaoCientifica( iniciacaoCientificaPersistente );

        candidatoDao.saveOrUpdate( candidato );
        iniciacaoCientificaDAO.delete( iniciacaoCientificaPersistente );
        
    }

    public void adicionaIniciacaoCientifica(
        IniciacaoCientifica iniciacaoCientifica )
    {
        if( iniciacaoCientifica.getIniciacaocientificaId() == null ) {
            final Usuario usuario = usuarioDao.findById( usuarioSessao.getUsuario().getUsuarioID() );
            Candidato candidato = usuario.getCandidato();
            Curriculo curriculo = candidato.getCurriculo();

            if( curriculo == null ) {
                curriculo = new Curriculo();
                candidato.setCurriculo( curriculo );
            }

            curriculo.adicionaIniciacaoCientifica( iniciacaoCientifica );
            candidatoDao.saveOrUpdate( candidato );
        } else {
            IniciacaoCientifica iniciacaoPersistente = this.getIniciacaoCientificaParaEdicao( iniciacaoCientifica.getIniciacaocientificaId() );
            BeanUtils.copyProperties( iniciacaoCientifica, iniciacaoPersistente, new String[] {
                "iniciacaoCientificaId"
            } );
            iniciacaoCientificaDAO.saveOrUpdate( iniciacaoPersistente);
        }
    }
}
