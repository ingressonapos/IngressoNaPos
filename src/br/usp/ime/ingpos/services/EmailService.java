package br.usp.ime.ingpos.services;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import br.usp.ime.ingpos.modelo.Email;

/*temos e-mail para usar:
 * login: ingressoNaPosXP@gmail.com
 * senha: @b@c@xix
 * porta: 587
 * hostname: smtp.gmail.com
 * usuario: ingressoNaPosXP
 */


public class EmailService
{
    private Properties props;
    private Authenticator autenticador;
    private Email email;
    private Session sessaoEmail;

    public EmailService(
        Email email )
    {

        this.email = email;
        props = new Properties();
        props.put( "mail.transport.protocol", "smtp" );
        props.put( "mail.smtp.port", email.getPorta() );
        props.put( "mail.smtp.host", email.getHostNome() );
        props.put( "mail.smtp.auth", "true" );
        props.put( "mail.smtp.starttls.enable", "true" );
        autenticador = new Autenticador();
        sessaoEmail = Session.getDefaultInstance( props, autenticador );
    }

    public void enviarEmail()
        throws AddressException,
            MessagingException
    {

        Transport transport;

        transport = sessaoEmail.getTransport();
        MimeMessage message = new MimeMessage( sessaoEmail );
        message.setSubject( email.getAssunto() );
        message.setContent( email.getConteudo(), "text/plain" );
        message.setFrom( new InternetAddress( email.getEmailRemetente() ) );
        message.addRecipient( Message.RecipientType.TO,
            new InternetAddress( email.getEmailDestinatario() ) );

        transport.connect();
        transport.sendMessage( message, message.getRecipients( Message.RecipientType.TO ) );
        transport.close();

    }

    private class Autenticador
        extends
            Authenticator
    {
        public PasswordAuthentication getPasswordAuthentication()
        {
            String username = email.getUsuario();
            String password = email.getSenha();
            return new PasswordAuthentication( username, password );
        }
    }
}
