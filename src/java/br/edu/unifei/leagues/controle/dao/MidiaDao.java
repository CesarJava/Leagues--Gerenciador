/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifei.leagues.controle.dao;

import br.edu.unifei.leagues.modelo.Midia;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Cesaros
 */

public class MidiaDao extends GenericoDao<Midia,String> {
    
    public MidiaDao(EntityManager em) {
        super(em);
    }
    
    public List<String> findAllMidias() {
        return em.createQuery(
                "select m.nome from Midia m"
        ).getResultList();
    }
    
    
}
