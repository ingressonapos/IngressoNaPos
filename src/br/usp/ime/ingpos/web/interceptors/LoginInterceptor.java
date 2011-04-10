package br.usp.ime.ingpos.web.interceptors;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.ioc.RequestScoped;
import br.com.caelum.vraptor.resource.ResourceMethod;
import br.com.caelum.vraptor.view.Results;
import br.usp.ime.ingpos.web.controllers.LoginController;
import br.usp.ime.ingpos.web.controllers.RegistroController;
import br.usp.ime.ingpos.web.controllers.UsuarioSessao;

@Intercepts
@RequestScoped
public class LoginInterceptor
    implements
        Interceptor
{

    private final Result result;
    private final UsuarioSessao usuarioSessao;

    private final Set<String> metodosIrrestritosRegistro = new HashSet<String>(
        Arrays.<String> asList( RegistroController.METODOS_ACESSO_IRRESTRITO ) );

    public LoginInterceptor(
        final Result result,
        final UsuarioSessao usuarioSessao )
    {
        this.result = result;
        this.usuarioSessao = usuarioSessao;
    }

    public boolean accepts(
        ResourceMethod method )
    {
        return ! Arrays.<Class<?>> asList( LoginController.class ).contains(
            method.getMethod().getDeclaringClass() );
    }

    public void intercept(
        InterceptorStack stack,
        ResourceMethod method,
        Object resourceInstance )
    {
        if( usuarioSessao.isUsuarioAutenticado() ) {
            stack.next( method, resourceInstance );
        } else if( desejaAcessarRegistro( method ) ) {
            stack.next( method, resourceInstance );
        } else {
            result.use( Results.logic() ).redirectTo( LoginController.class ).login();
        }
    }

    private boolean desejaAcessarRegistro(
        final ResourceMethod method )
    {
        try {
            final boolean resultado;

            if( metodosIrrestritosRegistro.contains( method.getMethod().getName() ) ) {
                resultado = true;
            } else {
                resultado = false;
            }
            return resultado;
        } catch( SecurityException e ) {
            throw new IllegalStateException(
                "Invalid method name " + method.getMethod().getName(),
                e );
        }

    }

}
