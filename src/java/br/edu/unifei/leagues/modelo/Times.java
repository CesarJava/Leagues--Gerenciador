/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifei.leagues.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author Cesaros
 */


@Entity
public class Times implements Serializable {
    
    @Id
    private String nome;
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<Jogador> jogadores = new ArrayList<Jogador>();
    
    @OneToOne//(orphanRemoval = true)//(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Coach treinador;
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<Patrocinador> patrocinadores = new ArrayList<Patrocinador>();
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(List<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    public Coach getTreinador() {
        return treinador;
    }

    public void setTreinador(Coach treinador) {
        this.treinador = treinador;
    }

    public List<Patrocinador> getPatrocinadores() {
        return patrocinadores;
    }

    public void setPatrocinadores(List<Patrocinador> patrocinadores) {
        this.patrocinadores = patrocinadores;
    }

    public int sizeOfJogador()
    {
        return jogadores.size();
    }
    
    public int sizeOfPatrocinador()
    {
        return patrocinadores.size();
    }
    
    public Iterator<Jogador> iteratorJogador() {
        return jogadores.iterator();
    }

    public boolean addJogador(Jogador j) {
        return jogadores.add(j);
    }

    public Jogador removeJogador(int idx) {
        return jogadores.remove(idx);
    }
    
    public Iterator<Patrocinador> iteratorPatrocinador() {
        return patrocinadores.iterator();
    }

    public boolean addPatrocinador(Patrocinador j) {
        return patrocinadores.add(j);
    }

    public Patrocinador removePatrocinador(int idx) {
        return patrocinadores.remove(idx);
    }
    
    
    
    
    
}
