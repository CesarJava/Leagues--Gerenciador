/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifei.leagues.controle.dao;

import br.edu.unifei.leagues.modelo.Equipamento;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Cesaros
 */
public class EquipamentoDao extends GenericoDao<Equipamento,String>{
    
    public EquipamentoDao(EntityManager em) {
        super(em);
    }
    
    public List<String> findAllEquipamentos() {
        return em.createQuery(
                "select e.nome from Equipamento e"
        ).getResultList();
    }
    
}
