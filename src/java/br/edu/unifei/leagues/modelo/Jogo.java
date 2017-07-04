/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifei.leagues.modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Cesaros
 */
@Entity
public class Jogo implements Serializable{
    
    @Id
    @GeneratedValue
    private int numero;
    
    @ManyToOne
    private Campeonato campeonato;
    
    @OneToOne
    private Times time1;
    
    @OneToOne
    private Times time2;
    
    @OneToOne
    private Times vencedor;

    public int getNumero() {
        return numero;
    }

    public Campeonato getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(Campeonato campeonato) {
        this.campeonato = campeonato;
    }

    public Times getTime1() {
        return time1;
    }

    public void setTime1(Times time1) {
        this.time1 = time1;
    }

    public Times getTime2() {
        return time2;
    }

    public void setTime2(Times time2) {
        this.time2 = time2;
    }

    public Times getVencedor() {
        return vencedor;
    }

    public void setVencedor(Times vencedor) {
        this.vencedor = vencedor;
    }
    
    
    
}
