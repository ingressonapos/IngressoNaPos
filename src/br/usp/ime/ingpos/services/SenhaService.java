package br.usp.ime.ingpos.services;

import java.util.Random;

import javax.naming.Context;
import javax.naming.InitialContext;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.RequestScoped;
import br.usp.ime.ingpos.modelo.Email;
import br.usp.ime.ingpos.modelo.Usuario;
import br.usp.ime.ingpos.modelo.dao.UsuarioDao;
import br.usp.ime.ingpos.seguranca.Criptografia;

@RequestScoped
@Component
public class SenhaService
{

    private final static String palavra = "0123456789abcdefghijklmnopqrstuvwxyz!@#$%";
    private final static int tamanhoDaSenha = 7;
    UsuarioDao usuarioDao;
    EmailService emailService;

    public SenhaService(
        UsuarioDao usuarioDao,
        EmailService emailService )
    {
        this.usuarioDao = usuarioDao;
        this.emailService = emailService;
    }

    private String gerarSenha(
        int tamanhoDaSenha )
    {

        int posicao;
        Random rand = new Random( System.currentTimeMillis() );
        StringBuffer senha = new StringBuffer();
        for( int i = 0; i < tamanhoDaSenha; i++ ) {
            posicao = rand.nextInt( palavra.length() );
            senha.append( palavra.charAt( posicao ) );
        }
        return senha.toString();
    }

    private Email construirEmail(
        String enderecoMail,
        String senhaGerada )
    {
        final StringBuilder conteudo = new StringBuilder();
        conteudo.append( "A sua senha temporária é: " + senhaGerada
            + ". Por favor, altere-a quanto antes possivel." );

        Email email = new Email();
        email.setAssunto( "Pós-graduação em ciência da computação IME-USP  " );
        email.setEmailDestinatario( enderecoMail );
        email.setConteudo( conteudo.toString() );
        email.setEmailRemetente( "ingressonaposxp@gmail.com" );
        return email;
    }

    private boolean atualizarSenha(
        String email,
        String senhaGerada )
    {
        Usuario usuario = usuarioDao.procurarPorEmail( email );

        if( usuario != null ) {
            usuario.setSenha( Criptografia.md5( senhaGerada ) );
            usuarioDao.saveOrUpdate( usuario );
            return true;
        } else {
            return false;
        }
    }

    public boolean enviarEmailSucedido(
        String email )
    {

        try {
            final String senhaGerada = gerarSenha( tamanhoDaSenha );
            if( atualizarSenha( email, senhaGerada ) ) {
                emailService.enviarEmail( construirEmail( email, senhaGerada ) );
                return true;
            } else {
                return false;
            }
        } catch( EmailException e ) {
            return false;
        }
    }
}