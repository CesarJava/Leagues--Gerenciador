/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifei.leagues.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author Cesaros
 */
@Entity   
public class Coach extends Pessoa{
   
  @OneToOne//(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  private Times timeAtual;
  
   //(cascade = CascadeType.ALL)
  @OneToOne
  private Times timeAnterior;

    public Times getTimexAtual() {
        return timeAtual;
    }

    public void setTimexAtual(Times timexAtual) {
        this.timeAtual = timexAtual;
    }

    public Times getTimeAnterior() {
        return timeAnterior;
    }

    public void setTimeAnterior(Times timeAnterior) {
        this.timeAnterior = timeAnterior;
    }
    
}
