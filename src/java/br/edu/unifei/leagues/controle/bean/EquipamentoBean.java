/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifei.leagues.controle.bean;

import br.edu.unifei.leagues.controle.dao.EquipamentoDao;
import br.edu.unifei.leagues.controle.dao.FonteDados;
import br.edu.unifei.leagues.modelo.Equipamento;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;

/**
 *
 * @author Cesaros
 */
@ManagedBean
@ViewScoped
public class EquipamentoBean {
    private final EntityManager em = FonteDados.createEntityManager();
    private final EquipamentoDao edao = new EquipamentoDao(em);
    private List<String> listaEquips = edao.findAllEquipamentos();
    private Equipamento equip = new Equipamento();
    private boolean habilitaChave = false;
    private boolean habilitaEdicao = false;
    private String msgChave;
    private String nome;
    
    public String inserir(){
        try {
            edao.create(equip);
            msgChave = null;
        } catch (EntityExistsException e) {
            msgChave = "chave duplicada";
            return "";
        }
        return "/index";
    }
    
    public String buscar(){
        equip = edao.find(nome);
        return "";
    }
    
    public String excluir(){
        edao.removeEntity(equip);
        return "/index";
    }

    public Equipamento getEquip() {
        return equip;
    }

    public void setEquip(Equipamento equip) {
        this.equip = equip;
    }

    public String getMsgChave() {
        return msgChave;
    }

    public void setMsgChave(String msgChave) {
        this.msgChave = msgChave;
    }

    public boolean isHabilitaChave() {
        return habilitaChave;
    }

    public void setHabilitaChave(boolean habilitaChave) {
        this.habilitaChave = habilitaChave;
    }

    public boolean isHabilitaEdicao() {
        return habilitaEdicao;
    }

    public void setHabilitaEdicao(boolean habilitaEdicao) {
        this.habilitaEdicao = habilitaEdicao;
    }

    public List<String> getListaEquips() {
        return listaEquips;
    }

    public void setListaEquips(List<String> listaEquips) {
        this.listaEquips = listaEquips;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
