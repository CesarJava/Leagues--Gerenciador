/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifei.leagues.controle.dao;

import br.edu.unifei.leagues.modelo.Jogo;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Cesaros
 */
public class JogoDao extends GenericoDao<Jogo,Integer>{
    
    public JogoDao(EntityManager em) {
        super(em);
    }
    
    public List<Integer> findAllJogos() {
        return em.createQuery(
                "select j.numero from Jogo j"
        ).getResultList();
    }
    
     public List<Integer> findAllJogosdoTime(String time) {
        return em.createQuery(
                "select j.numero from Jogo j where j.time1.nome='"+time+"'or j.time2.nome='"+time+"'"
        ).getResultList();
    }
    
    
}
