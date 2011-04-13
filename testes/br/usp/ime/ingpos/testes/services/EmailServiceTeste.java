package br.usp.ime.ingpos.testes.services;

import java.util.List;

import javax.mail.Message;
import javax.mail.MessagingException;

import org.junit.Test;
import org.jvnet.mock_javamail.Mailbox;

import br.usp.ime.ingpos.modelo.Email;
import br.usp.ime.ingpos.services.EmailService;
import br.usp.ime.ingpos.testes.IngPosTestCase;

public class EmailServiceTeste
    extends
        IngPosTestCase
{

    Email email;
    EmailService eService;

    public EmailServiceTeste(
        String name )
    {
        super( name );
        // TODO Auto-generated constructor stub
        email = new Email();
        email.setAssunto( "Teste" );
        email.setConteudo( "Teste conteudo" );
        email.setEmailDestinatario( "greganati@hotmail.com" );
        email.setEmailRemetente( "ingressoNaPosXP@gmail.com" );
        email.setPorta( "587" );
        email.setSenha( "@b@c@xix" );
        email.setHostNome( "smtp.gmail.com" );
        email.setUsuario( "ingressoNaPosXP" );
        eService = new EmailService( email );
    }

    @Test
    public void testEnviouCerto()
        throws MessagingException
    {

        eService.enviarEmail();

        List<Message> entradaList = Mailbox.get( "greganati@hotmail.com" );
        assertTrue( entradaList.size() == 1 );
    }

    public void testNaoEnviouParaEsteEmail()
        throws MessagingException
    {

        eService.enviarEmail();

        List<Message> entradaList = Mailbox.get( "abc@def.ghi" );
        assertFalse( entradaList.size() == 1 );
    }

}
