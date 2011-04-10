package br.usp.ime.ingpos.services;

import java.util.Date;
import java.util.List;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.RequestScoped;
import br.usp.ime.ingpos.modelo.Curriculo;
import br.usp.ime.ingpos.modelo.DadosPessoais;
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
        CPF_OU_EMAIL_JA_EXISTENTEM,
        CHAVE_ATIVACAO_NAO_EXISTE,
        USUARIO_JA_ATIVADO
    }

    private final RegistroNovoUsuarioDao registroNovoUsuarioDAO;
    private final UsuarioService usuarioService;
    private final PerfilDao perfilDao;

    public RegistroNovoUsuarioService(
        final RegistroNovoUsuarioDao registroNovoUsuarioDAO,
        final PerfilDao perfilDao,
        final UsuarioService usuarioService )
    {
        this.registroNovoUsuarioDAO = registroNovoUsuarioDAO;
        this.perfilDao = perfilDao;
        this.usuarioService = usuarioService;
    }

    public RegistroResultado registrar(
        final RegistroNovoUsuario registroNovoUsuario )
    {
        final RegistroResultado resultado;

        final RegistroNovoUsuario registroNovoUsuarioExistente = registroNovoUsuarioDAO.procurarPorEmailOuCpf(
            registroNovoUsuario.getEmail(), registroNovoUsuario.getCpf() );

        if( registroNovoUsuarioExistente != null ) {
            resultado = RegistroResultado.CPF_OU_EMAIL_JA_EXISTENTEM;
        } else {
            registroNovoUsuario.setDataHoraRegistro( new Date() );
            registroNovoUsuario.definirChaveAtivacao();

            final String chaveAtivacao = registroNovoUsuario.getChaveAtivacao();

            // TODO Gerar URL "criptografada"
            // TODO Envio de E-mail
            StringBuilder urlBuilder = new StringBuilder();
            urlBuilder.append( "http://localhost:8080/Ingresso-na-Pos/registro/ativacao/" );
            urlBuilder.append( chaveAtivacao );
            System.out.println( "Enviar email, url = " + urlBuilder.toString() );

            registroNovoUsuarioDAO.save( registroNovoUsuario );

            resultado = RegistroResultado.SUCESSO;
        }

        return resultado;
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
                final DadosPessoais dadosPessoais = novoUsuario.getDadosPessoais();

                dadosPessoais.setCpf( registroNovoUsuario.getCpf() );
                dadosPessoais.setEmail( registroNovoUsuario.getEmail() );
                dadosPessoais.setSenha( registroNovoUsuario.getSenha() );
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
