/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifei.leagues.modelo;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 *
 * @author Cesaros
 */
@Entity
public class Staff extends Pessoa{
    
    private String funcao;

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
    
       
}
