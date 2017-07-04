/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifei.leagues.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Cesaros
 */
@Entity
public class Jogador extends Pessoa {

    private String rota;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Campeoes> campeoesMaisJogados = new ArrayList<Campeoes>();

    @ManyToOne(cascade = CascadeType.ALL)
    private Times time;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Equipamento> equips = new ArrayList<Equipamento>();

    public String getRota() {
        return rota;
    }

    public void setRota(String rota) {
        this.rota = rota;
    }

    public List<Campeoes> getCampeoesMaisJogados() {
        return campeoesMaisJogados;
    }

    public void setCampeoesMaisJogados(List<Campeoes> campeoesMaisJogados) {
        this.campeoesMaisJogados = campeoesMaisJogados;
    }

    public Times getTime() {
        return time;
    }

    public void setTime(Times time) {
        this.time = time;
    }

    public List<Equipamento> getEquips() {
        return equips;
    }

    public void setEquips(List<Equipamento> equips) {
        this.equips = equips;
    }

    public int sizeOfCampeoes() {
        return campeoesMaisJogados.size();
    }

    public int sizeOfEquipamentos() {
        return equips.size();
    }

    public Iterator<Campeoes> iteratorCampeoes() {
        return campeoesMaisJogados.iterator();
    }

    public boolean addCampeao(Campeoes j) {
        return campeoesMaisJogados.add(j);
    }

    public Campeoes removeCampeao(int idx) {
        return campeoesMaisJogados.remove(idx);
    }

    public Iterator<Equipamento> iteratorEquipamento() {
        return equips.iterator();
    }

    public boolean addEquipamento(Equipamento j) {
        return equips.add(j);
    }

    public Equipamento removeEquipamento(int idx) {
        return equips.remove(idx);
    }

}
