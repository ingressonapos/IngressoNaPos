package br.usp.ime.ingpos.web.interceptors;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Usado para garantir que um determinado recurso interceptado seja executado em
 * um escopo de transação.
 */
@Retention( RetentionPolicy.RUNTIME )
@Target( {
    ElementType.METHOD, ElementType.TYPE
} )
public @interface Transactional
{

}
