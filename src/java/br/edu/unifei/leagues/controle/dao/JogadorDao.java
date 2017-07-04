/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.unifei.leagues.controle.dao;

import br.edu.unifei.leagues.modelo.Jogador;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Cesaros
 */
public class JogadorDao extends GenericoDao<Jogador, String> {

    public JogadorDao(EntityManager em) {
        super(em);
    }

    public List<String> findAllJogadores() {
        return em.createQuery(
                "select j.nome from Jogador j"
        ).getResultList();
    }

    public List<String> findAllCampeoesFavoritos(String jogador) {
        return em.createQuery(
                "select c.nome  from Campeoes c,Jogador j where j.campeoesMaisJogados=c and  j.nome='" + jogador + "'"
        ).getResultList();
    }

    public List<String> findAllEquipamento(String jogador) {
        return em.createQuery(
                "select e.nome from Equipamento e,Jogador j where j.equips=e and j.nome='" + jogador + "'"
        ).getResultList();
    }

}
