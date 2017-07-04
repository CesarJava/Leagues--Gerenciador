/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifei.leagues.controle.dao;

import br.edu.unifei.leagues.modelo.Campeonato;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Cesaros
 */
public class CampeonatoDao extends GenericoDao<Campeonato, String> {

    public CampeonatoDao(EntityManager em) {
        super(em);
    }

    public List<String> findAllCampeonatos() {
        return em.createQuery(
                "select c.nome from Campeonato c"
        ).getResultList();
    }

    public List<Integer> findAllJogos(String camp) {
        return em.createQuery(
                "select j.numero from Jogo j where j.campeonato.nome='" + camp + "' "
        ).getResultList();
    }

    public List<String> findAllMidia(String camp) {
        return em.createQuery(
                "select m.nome  from Midia m,Campeonato c where c.midias=m and c.nome='"+camp+"'"
        ).getResultList();

    }
    
    public List<String> findAllFuncionarios(String camp) {
        return em.createQuery(
                "select f.nome from Staff f,Campeonato c where c.funcionarios=f and c.nome'" + camp + "'"
        ).getResultList();

    }
    
    public List<String> findAllTimes(String camp) {
        return em.createQuery(
                "select t.nome from Times t,Campeonato c where c.times=t and c.nome='" + camp + "'"
        ).getResultList();

    }
    

}
