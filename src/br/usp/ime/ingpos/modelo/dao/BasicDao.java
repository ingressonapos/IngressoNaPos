package br.usp.ime.ingpos.modelo.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.Criterion;

/**
 * Representa a base para opera��es de acesso � dados.
 * 
 * @param <ID> identificador da entidade.
 * @param <T> entidade a ser acessada.
 */
public interface BasicDao<ID extends Serializable, T>
    extends
        Serializable
{

    void save(
        T... objs );

    void delete(
        T... ts );

    void update(
        T... ts );

    T findById(
        ID id );

    List<T> findAll();

    List<T> findByCriteria(
        Criterion... criterion );

    List<T> findByExample(
        T exampleInstance,
        String... excludeProperty );

}