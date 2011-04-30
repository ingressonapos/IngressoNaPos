package br.usp.ime.ingpos.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.RequestScoped;
import br.usp.ime.ingpos.modelo.CartaDeRecomendacao;
import br.usp.ime.ingpos.modelo.Email;
import br.usp.ime.ingpos.modelo.Usuario;
import br.usp.ime.ingpos.modelo.dao.CartaDeRecomendacaoDAO;
import br.usp.ime.ingpos.seguranca.Criptografia;
import br.usp.ime.ingpos.web.controllers.UsuarioSessao;

@RequestScoped
@Component
public class CartaDeRecomendacaoService
{
    private final CartaDeRecomendacaoDAO cartaDeRecomendacaoDAO;
    private final UsuarioSessao usuarioSessao;
    private final EmailService emailService;
    private final HttpServletRequest httpServletRequest;

    public CartaDeRecomendacaoService(
        final CartaDeRecomendacaoDAO cartaDeRecomendacaoDAO,
        final UsuarioSessao usuarioSessao,
        final EmailService emailService,
        final HttpServletRequest httpServletRequest )
    {
        this.cartaDeRecomendacaoDAO = cartaDeRecomendacaoDAO;
        this.usuarioSessao = usuarioSessao;
        this.emailService = emailService;
        this.httpServletRequest = httpServletRequest;
    }

    public void salvarOuAtualizar(
        final CartaDeRecomendacao cartaDeRecomendacao )
    {
        cartaDeRecomendacaoDAO.saveOrUpdate( cartaDeRecomendacao );
    }

    public void solicitarRecomendacao(
        final CartaDeRecomendacao cartaDeRecomendacao )
    {
        cartaDeRecomendacao.setUsuario( usuarioSessao.getUsuario() );

        String hash = Criptografia.md5( cartaDeRecomendacao.getEmail()
            + usuarioSessao.getUsuario().getEmail() );
        cartaDeRecomendacao.setHash( hash );

        final CartaDeRecomendacao cartaDeRecomendacaoExiste = cartaDeRecomendacaoDAO.procurarPorHash( hash );
        if( cartaDeRecomendacaoExiste == null ) {
            cartaDeRecomendacaoDAO.save( cartaDeRecomendacao );
        }

        try {
            emailService.enviarEmail( Email.construirEmail(
                construirConteudoCartaRecomendacao( cartaDeRecomendacao ),
                usuarioSessao.getUsuario().getEmail(), cartaDeRecomendacao.getEmail(),
                "Carta de Recomendação" ) );
        } catch( EmailException e ) {

        }
    }

    public CartaDeRecomendacao procurarPorHash(
        final String hash )
    {
        return cartaDeRecomendacaoDAO.procurarPorHash( hash );
    }

    public List<CartaDeRecomendacao> procurarPorUsuario(
        final Usuario usuario )
    {
        return cartaDeRecomendacaoDAO.procurarPorUsuario( usuario );
    }

    private String construirConteudoCartaRecomendacao(
        CartaDeRecomendacao cartaDeRecomendacao )
    {
        final StringBuilder conteudoBuilder = new StringBuilder();

        // TODO: Melhorar a mensagem para o professor
        conteudoBuilder.append( "O candidato " );
        conteudoBuilder.append( "<b>" );
        conteudoBuilder.append( cartaDeRecomendacao.getUsuario().getDadosPessoais().getNomeCompleto() );
        conteudoBuilder.append( "</b>" );
        conteudoBuilder.append( " está participando do processo de seleção de Pós-Graduação do IME-USP," );
        conteudoBuilder.append( " e vem por meio desta solicitar sua carta de recomendação. <br/ ><br/ >" );
        conteudoBuilder.append( "Por favor, " );
        conteudoBuilder.append( "<a href='" );
        conteudoBuilder.append( getUrlRecomendacao() );
        conteudoBuilder.append( "/" );
        conteudoBuilder.append( cartaDeRecomendacao.getHash() );
        conteudoBuilder.append( "'> clique aqui</a>" );
        conteudoBuilder.append( " para preencher a recomendação. <br/ ><br/ >" );

        conteudoBuilder.append( "Atenciosamente, <br/ >" );
        conteudoBuilder.append( "Comissão de Pós-Graduação do IME-USP" );

        return conteudoBuilder.toString();
    }

    private String getUrlRecomendacao()
    {
        final String urlRegistro;
        if( httpServletRequest == null ) {
            // TODO: Verificar como remover esta url para efeito de testes
            urlRegistro = "http://localhost:8080/Ingresso-na-Pos/cadastro/solicitarRecomendacao";
        } else {
            urlRegistro = httpServletRequest.getRequestURL().toString();
        }

        return urlRegistro;
    }
}
