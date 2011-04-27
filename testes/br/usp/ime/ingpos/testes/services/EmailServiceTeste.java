package br.usp.ime.ingpos.testes.services;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import org.junit.Test;

import br.usp.ime.ingpos.modelo.Email;
import br.usp.ime.ingpos.services.EmailException;
import br.usp.ime.ingpos.services.EmailService;
import br.usp.ime.ingpos.testes.IngPosTestCase;

public class EmailServiceTeste
    extends
        IngPosTestCase
{

    public EmailServiceTeste(
        String name )
    {
        super( name );
    }

    @Test
    public void testarEnviarEmail()
    {
        try {
            final String assunto = "Assunto";
            final String conteudo = "Conteudo";
            final String destinatario = "ingressonaposxp@gmail.com";
            final String remetente = "ingressonaposxp@gmail.com";

            final Email email = new Email();
            email.setAssunto( assunto );
            email.setConteudo( conteudo );
            email.setEmailRemetente( remetente );
            email.setEmailDestinatario( destinatario );

            final EmailService emailService = new EmailService( construirSessionParaTeste() );
            emailService.enviarEmail( email );
        } catch( EmailException e ) {
            e.printStackTrace();
        }
    }

    @Test
    public void testarConfirmacaoEnvioDeEmail()
    {
        // TODO: efetuar teste para ler do email do destinatario e verificar se
        // o email enviado chegou
        assertTrue( false );
    }

    public static Session construirSessionParaTeste()
    {
        final Properties props = new Properties();
        final int smtpServerPort = 465;
        final String userName = "ingressonaposxp@gmail.com";
        final String password = "@b@c@xix";

        props.put( "mail.smtp.host", "smtp.gmail.com" );
        props.put( "mail.smtp.port", Integer.toString( smtpServerPort ) );
        props.put( "mail.smtp.user", "ingressonaposxp" );
        props.put( "mail.smtp.ssl.enable", "true" );

        props.put( "mail.smtp.auth", "true" );
        props.put( "mail.smtp.starttls.enable", "true" );
        props.put( "mail.smtp.socketFactory.port", Integer.toString( smtpServerPort ) );
        props.put( "mail.smtp.ssl.socketFactory.port", Integer.toString( smtpServerPort ) );

        Session session = Session.getDefaultInstance( props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication( userName, password );
            }
        } );

        return session;
    }

}
