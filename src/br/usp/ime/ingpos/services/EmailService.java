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

import br.usp.ime.ingpos.modelo.Email;



public class EmailService
{

    Context initCtx;
    Context envCtx; 
    Session session = null;
    Email email;
    Transport transporte;
    
    public EmailService(
        Email email ) throws NamingException, NoSuchProviderException
    {
        this.email = email;
        initCtx = new InitialContext();
        envCtx = (Context) initCtx.lookup("java:comp/env");
        session =  (Session) envCtx.lookup("mail/Session");
        transporte = session.getTransport("smtp");
    }

    public void enviarEmail() throws AddressException, MessagingException

    {
        
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress( email.getEmailRemetente() ));
      
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(email.getEmailDestinatario()));
        message.setSubject(email.getAssunto());
        message.setContent(email.getConteudo(), "text/plain");
        message.setSentDate( new java.util.Date() );
        
        transporte.connect( email.getHostNome(),  email.getEmailRemetente(), email.getSenha() );
        
        transporte.sendMessage(message, message.getAllRecipients());
        transporte.close();
    }
}