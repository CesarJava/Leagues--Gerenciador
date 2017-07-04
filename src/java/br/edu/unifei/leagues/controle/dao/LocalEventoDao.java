/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifei.leagues.controle.dao;

import br.edu.unifei.leagues.modelo.LocalEvento;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Cesaros
 */
public class LocalEventoDao extends GenericoDao<LocalEvento,String>{
    
    public LocalEventoDao(EntityManager em) {
        super(em);
    }
    
    public List<String> findAllLocais(){
        return em.createQuery(
                "select l.nome from LocalEvento l"
        ).getResultList();
    }
    
}
