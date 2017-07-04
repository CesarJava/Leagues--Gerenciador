/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package br.edu.unifei.leagues.controle.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

/**
 *
 * @author Cesaros
 */



public abstract class GenericoDao<E, K> {

    protected final EntityManager em;
    private final Class<E> clazz
            = (Class<E>) ((ParameterizedType) this.getClass().
            getGenericSuperclass()).getActualTypeArguments()[0];

    public GenericoDao(EntityManager em) {
        this.em = em;
    }

    public void create(E obj) throws EntityExistsException {
        em.getTransaction().begin();
        try {
            em.persist(obj);
            em.flush();
            em.getTransaction().commit();
        } catch (PersistenceException e) {
            em.getTransaction().rollback();
            throw new EntityExistsException(e);
        }
    }

    public void update(E obj) {
        em.getTransaction().begin();
        em.merge(obj);
        em.getTransaction().commit();
    }

    public E find(K chave) {
        
        return em.find(clazz, chave);
        
    }

    public void removeEntity(E obj) {
        em.getTransaction().begin();
        em.remove(obj);
        em.getTransaction().commit();
    }

    public void removeKey(K chave) {
        em.getTransaction().begin();
        E obj = find(chave);
        em.remove(obj);
        em.getTransaction().commit();
    }

    public List<E> findAll() {
        
        return em.createQuery(
            "from " + clazz.getSimpleName()
            ).getResultList();
        
        
    }

    public long getCount() {
        
        return (long) em.createQuery( 
                "select count(*) from " + clazz.getSimpleName()
                ).getSingleResult();
    }

}
