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
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Cesaros
 */
@Entity
public class Campeonato implements Serializable {

    @Id
    private String nome;
    private String paisOrigem;

    @OneToOne
    private LocalEvento localEvento;

    @OneToMany
    private List<Jogo> jogos = new ArrayList<Jogo>();

    @OneToMany
    private List<Midia> midias = new ArrayList<Midia>();

    @OneToMany
    private List<Staff> funcionarios = new ArrayList<Staff>();
    
    @OneToMany
    private List<Times> times = new ArrayList<Times>();
    
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPaisOrigem() {
        return paisOrigem;
    }

    public void setPaisOrigem(String paisOrigem) {
        this.paisOrigem = paisOrigem;
    }

    public LocalEvento getLocalEvento() {
        return localEvento;
    }

    public void setLocalEvento(LocalEvento localEvento) {
        this.localEvento = localEvento;
    }

    public List<Jogo> getJogos() {
        return jogos;
    }

    public void setJogos(List<Jogo> jogos) {
        this.jogos = jogos;
    }

    public List<Midia> getMidia() {
        return midias;
    }

    public void setMidia(List<Midia> midia) {
        this.midias = midia;
    }

    public List<Staff> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Staff> funcionarios) {
        this.funcionarios = funcionarios;
    }
    
    public List<Times> getTimes() {
        return times;
    }

    public void setTimes(List<Times> times) {
        this.times = times;
    }

    public int sizeOfJogo() {
        return jogos.size();
    }

    public int sizeOfMidia() {
        return midias.size();
    }
    
    public int sizeOfFuncionarios() {
        return funcionarios.size();
    }
    
    public int sizeOfTimes()
    {
        return times.size();
    }
    
    public Iterator<Jogo> iteratorJogo() {
        return jogos.iterator();
    }

    public boolean addJogo(Jogo j) {
        return jogos.add(j);
    }

    public Jogo removeJogo(int idx) {
        return jogos.remove(idx);
    }
    
    public Iterator<Midia> iteratorMidia() {
        return midias.iterator();
    }

    public boolean addMidia(Midia j) {
        return midias.add(j);
    }

    public Midia removeMidia(int idx) {
        return midias.remove(idx);
    }
    
    public Iterator<Staff> iteratorFuncionario() {
        return funcionarios.iterator();
    }

    public boolean addFuncionario(Staff j) {
        return funcionarios.add(j);
    }

    public Staff removeFuncionario(int idx) {
        return funcionarios.remove(idx);
    }
    
    public Iterator<Times> iteratorTime() {
        return times.iterator();
    }

    public boolean addTime(Times j) {
        return times.add(j);
    }

    public Times removeTime(int idx) {
        return times.remove(idx);
    }

   

    

    
    
    
    

}
