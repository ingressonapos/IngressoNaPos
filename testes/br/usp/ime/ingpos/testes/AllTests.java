package br.usp.ime.ingpos.testes;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

import junit.framework.TestSuite;
import junit.textui.TestRunner;

/**
 * Executa todos os testes do sistema Ingresso na Pos.
 */
public class AllTests

{
    private final static TestSuite suite = new TestSuite();
    static {

        final TestConfiguration testConf = new TestConfiguration();
        for( Class<?> suiteClass : testConf.getAllTests() ) {
            try {
                final Constructor<?> constructor = suiteClass.getConstructor( String.class );
                final BancoDeDadosTestCase testCase = (BancoDeDadosTestCase) constructor.newInstance( suiteClass.getName() );
                suite.addTest( testCase.getRuntimeSuite() );
            } catch( IllegalArgumentException e ) {
                e.printStackTrace();
            } catch( InstantiationException e ) {
                e.printStackTrace();
            } catch( IllegalAccessException e ) {
                e.printStackTrace();
            } catch( InvocationTargetException e ) {
                e.printStackTrace();
            } catch( SecurityException e ) {
                e.printStackTrace();
            } catch( NoSuchMethodException e ) {
                e.printStackTrace();
            }
        }
    }

    public static void main(
        String args[] )
    {
        new AllTests().testAll();
    }

    @Test
    public void testAll()
    {
        TestRunner.run( AllTests.suite );
    }

}
