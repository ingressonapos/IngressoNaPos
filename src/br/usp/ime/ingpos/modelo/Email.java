package br.usp.ime.ingpos.modelo;

public class Email
{

    private String assunto;
    private String conteudo;
    private String hostNome;
    private String porta;
    private String usuario;
    private String senha;
    private String emailDestinatario;
    private String emailRemetente;

    public String getAssunto()
    {
        return assunto;
    }

    public void setAssunto(
        String assunto )
    {
        this.assunto = assunto;
    }

    public String getConteudo()
    {
        return conteudo;
    }

    public void setConteudo(
        String conteudo )
    {
        this.conteudo = conteudo;
    }

    public String getHostNome()
    {
        return hostNome;
    }

    public void setHostNome(
        String hostNome )
    {
        this.hostNome = hostNome;
    }

    public String getPorta()
    {
        return porta;
    }

    public void setPorta(
        String porta )
    {
        this.porta = porta;
    }

    public String getUsuario()
    {
        return usuario;
    }

    public void setUsuario(
        String usuario )
    {
        this.usuario = usuario;
    }

    public String getSenha()
    {
        return senha;
    }

    public void setSenha(
        String senha )
    {
        this.senha = senha;
    }

    public String getEmailDestinatario()
    {
        return emailDestinatario;
    }

    public void setEmailDestinatario(
        String emailDestinatario )
    {
        this.emailDestinatario = emailDestinatario;
    }

    public String getEmailRemetente()
    {
        return emailRemetente;
    }

    public void setEmailRemetente(
        String emailRemetente )
    {
        this.emailRemetente = emailRemetente;
    }
    
    public static Email construirEmail(
         String conteudo,
         String remetente,
         String destinatario,
         String assunto)
    {
        Email email = new Email();
        email.setEmailRemetente( remetente );
        email.setAssunto( assunto );
        email.setConteudo( conteudo );
        email.setEmailDestinatario( destinatario );

        return email;
    }
}