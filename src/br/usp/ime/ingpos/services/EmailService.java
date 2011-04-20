package br.usp.ime.ingpos.services;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;
import br.usp.ime.ingpos.modelo.Email;

@Component
@SessionScoped
public class EmailService
{
    private static final String SMTP_PROTOCOL = "smtp";

    private final Session session;
    private final Transport transporte;

    public EmailService()
        throws EmailException
    {
        try {
            final Context initCtx = new InitialContext();
            final Context envCtx = (Context) initCtx.lookup( "java:comp/env" );
            this.session = (Session) envCtx.lookup( "mail/Session" );
            this.transporte = session.getTransport( "smtp" );
        } catch( NamingException e ) {
            throw new EmailException( e );
        } catch( NoSuchProviderException e ) {
            throw new EmailException( e );
        }
    }

    public EmailService(
        final Session session )
        throws EmailException
    {
        try {
            this.session = session;
            this.transporte = session.getTransport( SMTP_PROTOCOL );
        } catch( NoSuchProviderException e ) {
            throw new EmailException( e );
        }
    }

    public void enviarEmail(
        final Email email )
        throws EmailException
    {
        try {
            final Message message = new MimeMessage( session );
            message.setFrom( new InternetAddress( email.getEmailRemetente() ) );

            message.setRecipient( Message.RecipientType.TO,
                new InternetAddress( email.getEmailDestinatario() ) );
            message.setSubject( email.getAssunto() );
            message.setContent( email.getConteudo(), "text/html" );
            message.setSentDate( new java.util.Date() );

            transporte.connect( email.getHostNome(), email.getEmailRemetente(), email.getSenha() );

            transporte.sendMessage( message, message.getAllRecipients() );
            transporte.close();
        } catch( AddressException e ) {
            throw new EmailException( e );
        } catch( MessagingException e ) {
            throw new EmailException( e );
        }
    }
}