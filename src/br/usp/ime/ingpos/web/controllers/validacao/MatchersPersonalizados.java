package br.usp.ime.ingpos.web.controllers.validacao;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class MatchersPersonalizados
{

    private static TypeSafeMatcher<String> EMPTY = new TypeSafeMatcher<String>() {

        @Override
        protected void describeMismatchSafely(
            String item,
            Description mismatchDescription )
        {
            mismatchDescription.appendText( " " + item );
        }

        @Override
        protected boolean matchesSafely(
            String item )
        {
            return item != null && ! item.equals( "" );
        }

        public void describeTo(
            Description description )
        {
            description.appendText( " not empty" );
        }

    };

    /**
     * Verifica se uma string é não nula e não vazia.
     * 
     * @return
     */
    public static TypeSafeMatcher<String> notEmpty()
    {
        return EMPTY;
    }

}
