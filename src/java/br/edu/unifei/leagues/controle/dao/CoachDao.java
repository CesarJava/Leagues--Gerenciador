/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifei.leagues.controle.dao;

import br.edu.unifei.leagues.modelo.Coach;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Cesaros
 */
public class CoachDao extends GenericoDao<Coach,String>{
    
    public CoachDao(EntityManager em) {
        super(em);
    }
    
    public List<String> findAllCoachs() {
        return em.createQuery(
                "select c.nome from Coach c"
        ).getResultList();
    }
    
}
