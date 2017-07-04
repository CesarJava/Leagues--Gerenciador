/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifei.leagues.controle.dao;

import br.edu.unifei.leagues.modelo.Campeoes;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Cesaros
 */
public class CampeoesDao extends GenericoDao<Campeoes, String> {

    public CampeoesDao(EntityManager em) {
        super(em);
    }

    public List<String> findAllNomes() {
        return em.createQuery(
                "select c.nome from Campeoes c"
        ).getResultList();
    }
    
    public List<String> findAllJogadores(String camp) {
        return em.createQuery(
                "select j.nome from Jogador j where j.campeoesMaisJogados.nome='"+camp+"'"
        ).getResultList();
    }

    
    
    
    
    
    

}
