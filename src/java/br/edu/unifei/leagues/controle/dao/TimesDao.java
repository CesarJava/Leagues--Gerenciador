/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifei.leagues.controle.dao;

import br.edu.unifei.leagues.modelo.Times;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Cesaros
 */
public class TimesDao extends GenericoDao<Times, String> {

    public TimesDao(EntityManager em) {
        super(em);
    }

    public List<String> findAllTimes() {
        return em.createQuery(
                "select t.nome from Times t"
        ).getResultList();
    }

    public List<String> findAllJogadoresTime(String time) {
        return em.createQuery(
                "select j.nome from Jogador j where j.time.nome'" + time + "'"
        ).getResultList();
    }

    public List<String> findAllPatrocinadores(String time) {
        return em.createQuery(
                "select p.nome from Patrocinador p,Times t where t.patrocinadores=p and t.nome=" + time + "'"
        ).getResultList();
    }

}
