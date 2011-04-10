package br.usp.ime.ingpos.web.interceptors;

import java.lang.reflect.Method;
import java.util.Arrays;

import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.ioc.RequestScoped;
import br.com.caelum.vraptor.resource.ResourceMethod;
import br.com.caelum.vraptor.view.Results;
import br.usp.ime.ingpos.web.controllers.CadastroController;
import br.usp.ime.ingpos.web.controllers.LoginController;
import br.usp.ime.ingpos.web.controllers.UsuarioSessao;

@Intercepts
@RequestScoped
public class LoginInterceptor
    implements
        Interceptor
{

    private Result result;
    private UsuarioSessao usuarioSessao;

    public LoginInterceptor(
        Result result,
        UsuarioSessao usuarioSessao )
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
            final Method metodoRegistro = CadastroController.class.getMethod( CadastroController.NOME_METODO_REGISTRO );
            final boolean resultado;
            if( metodoRegistro.equals( method.getMethod() ) ) {
                resultado = true;
            } else {
                resultado = false;
            }
            return resultado;
        } catch( SecurityException e ) {
            throw new IllegalStateException( "" );
        } catch( NoSuchMethodException e ) {
            throw new IllegalStateException( "" );
        }

    }

}
