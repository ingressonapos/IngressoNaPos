package br.usp.ime.ingpos.modelo.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.Criterion;

/**
 * Representa a base para operacoes de acesso a dados.
 * 
 * @param <ID> identificador da entidade.
 * @param <T> entidade a ser acessada.
 */
public interface BasicDao<ID extends Serializable, T>
{

    void save(
        T... objs );

    void delete(
        T... ts );

    void saveOrUpdate(
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