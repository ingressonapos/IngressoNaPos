package br.usp.ime.ingpos.services;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.RequestScoped;
import br.usp.ime.ingpos.modelo.Curriculo;
import br.usp.ime.ingpos.modelo.DadosPessoais;
import br.usp.ime.ingpos.modelo.Email;
import br.usp.ime.ingpos.modelo.Endereco;
import br.usp.ime.ingpos.modelo.Perfil;
import br.usp.ime.ingpos.modelo.RegistroNovoUsuario;
import br.usp.ime.ingpos.modelo.Usuario;
import br.usp.ime.ingpos.modelo.dao.PerfilDao;
import br.usp.ime.ingpos.modelo.dao.RegistroNovoUsuarioDao;

@RequestScoped
@Component
public class RegistroNovoUsuarioService
{
    public static enum RegistroResultado
    {
        SUCESSO,
        NOME_OU_EMAIL_JA_EXISTENTE,
        CHAVE_ATIVACAO_NAO_EXISTE,
        USUARIO_JA_ATIVADO,
        ERRO_ENVIAR_EMAIL
    }

    private final RegistroNovoUsuarioDao registroNovoUsuarioDAO;
    private final UsuarioService usuarioService;
    private final PerfilDao perfilDao;
    private final EmailService emailService;
    private final HttpServletRequest httpServletRequest;

    public RegistroNovoUsuarioService(
        final RegistroNovoUsuarioDao registroNovoUsuarioDAO,
        final PerfilDao perfilDao,
        final UsuarioService usuarioService,
        final EmailService emailService,
        final HttpServletRequest httpServletRequest )
    {
        this.registroNovoUsuarioDAO = registroNovoUsuarioDAO;
        this.perfilDao = perfilDao;
        this.usuarioService = usuarioService;
        this.emailService = emailService;
        this.httpServletRequest = httpServletRequest;
    }

    private String getUrlRegistro()
    {
        final String urlRegistro;
        if( httpServletRequest == null ) {
            // TODO: Verificar como remover esta url para efeito de testes
            urlRegistro = "http://localhost:8080/Ingresso-na-Pos/registro";
        } else {
            urlRegistro = httpServletRequest.getRequestURL().toString();
        }

        return urlRegistro;
    }

    public RegistroResultado registrar(
        final RegistroNovoUsuario registroNovoUsuario )
    {
        RegistroResultado resultado;

        final RegistroNovoUsuario registroNovoUsuarioExistente = registroNovoUsuarioDAO.procurarPorEmail(
            registroNovoUsuario.getEmail() );

        if( registroNovoUsuarioExistente != null ) {
            resultado = RegistroResultado.NOME_OU_EMAIL_JA_EXISTENTE;
        } else {

            try {
                registroNovoUsuario.setDataHoraRegistro( new Date() );
                registroNovoUsuario.definirChaveAtivacao();

                emailService.enviarEmail( construirEmailRegistro( registroNovoUsuario ) );

                registroNovoUsuarioDAO.save( registroNovoUsuario );

                resultado = RegistroResultado.SUCESSO;

            } catch( EmailException e ) {
                resultado = RegistroResultado.ERRO_ENVIAR_EMAIL;
            }
        }

        return resultado;
    }

    private Email construirEmailRegistro(
        RegistroNovoUsuario registroNovoUsuario )
    {
        final StringBuilder conteudoBuilder = new StringBuilder();
        conteudoBuilder.append( "Por favor, clique no link para confirmar.<br /><br />" );
        conteudoBuilder.append( "<a href='" );
        conteudoBuilder.append( getUrlRegistro() );
        conteudoBuilder.append( "/ativacao/" );
        conteudoBuilder.append( registroNovoUsuario.getChaveAtivacao() );
        conteudoBuilder.append( "'>clique aqui</a>" );

        Email email = new Email();
        email.setEmailRemetente( "ingressonaposxp@gmail.com" );
        email.setAssunto( "Confirmação" );
        email.setConteudo( conteudoBuilder.toString() );
        email.setEmailDestinatario( registroNovoUsuario.getEmail() );

        return email;
    }

    public RegistroResultado ativar(
        String chaveAtivacao )
    {

        final RegistroResultado resultado;
        final RegistroNovoUsuario registroNovoUsuario = registroNovoUsuarioDAO.procurarPorChaveAtivacao( chaveAtivacao );

        if( registroNovoUsuario == null ) {
            resultado = RegistroResultado.CHAVE_ATIVACAO_NAO_EXISTE;
        } else {
            // TODO: Modificar a obtencao do perfil de candidato, fazer isto
            // utilizando tipo especifico e nao pela descricao
            final List<Perfil> perfilCandidatoList = perfilDao.procurarPorDescricao( Perfil.DESCRICAO_CANDIDATO );
            final Perfil perfil;
            if( perfilCandidatoList != null && ! perfilCandidatoList.isEmpty() ) {
                perfil = perfilCandidatoList.get( 0 );
            } else {
                perfil = new Perfil();
                perfil.setDescricao( Perfil.DESCRICAO_CANDIDATO );
                perfilDao.save( perfil );
            }

            Usuario novoUsuario = usuarioService.procurarPorEmail( registroNovoUsuario.getEmail() );
            if( novoUsuario != null ) {
                resultado = RegistroResultado.USUARIO_JA_ATIVADO;
            } else {
                novoUsuario = new Usuario();
                novoUsuario.setEmail( registroNovoUsuario.getEmail() );
                novoUsuario.setSenha( registroNovoUsuario.getSenha() );
                
                final DadosPessoais dadosPessoais = novoUsuario.getDadosPessoais();

                dadosPessoais.setEnderecoCorrespondencia( new Endereco() );
                dadosPessoais.setEnderecoPermanente( new Endereco() );
                dadosPessoais.setNomeCompleto( registroNovoUsuario.getNomeCompleto() );
                novoUsuario.setAtivo( true );
                novoUsuario.setCurriculo( new Curriculo() );
                novoUsuario.setPerfil( perfil );

                usuarioService.salvar( novoUsuario );

                resultado = RegistroResultado.SUCESSO;
            }
        }
        return resultado;
    }

}
