/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifei.leagues.controle.dao;

import br.edu.unifei.leagues.modelo.Patrocinador;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Cesaros
 */

public class PatrocinadorDao extends GenericoDao<Patrocinador,String> {
    
    public PatrocinadorDao(EntityManager em) {
        super(em);
    }
    
    public List<String> findAllPatrocinadores() {
        return em.createQuery(
                "select p.nome from Patrocinador p"
        ).getResultList();
    }
    
}
