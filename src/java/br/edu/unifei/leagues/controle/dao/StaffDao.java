/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifei.leagues.controle.dao;

import br.edu.unifei.leagues.modelo.Staff;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Cesaros
 */
public class StaffDao extends GenericoDao<Staff,String> {
    
    public StaffDao(EntityManager em) {
        super(em);
    }
    
    public List<String> findAllFuncionarios() {
        return em.createQuery(
                "select f.nome from Staff f"
        ).getResultList();
    }
}
