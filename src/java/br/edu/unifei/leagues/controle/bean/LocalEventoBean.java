/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifei.leagues.controle.bean;

import br.edu.unifei.leagues.controle.dao.FonteDados;
import br.edu.unifei.leagues.controle.dao.LocalEventoDao;
import br.edu.unifei.leagues.modelo.LocalEvento;
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
public class LocalEventoBean {
    private final EntityManager em = FonteDados.createEntityManager();
    private final LocalEventoDao ledao = new LocalEventoDao(em);
    private LocalEvento local = new LocalEvento();
    private boolean habilitaChave = false;
    private boolean habilitaEdicao = false;
    private String msgChave;
    private String nome;
    
    
    public String inserir(){
        try {
            ledao.create(local);
            msgChave = null;
        } catch (EntityExistsException e) {
            msgChave = "chave duplicada";
            return "";
        }
        
        return "/index";
        
    }
    
    public String buscar(){
        local = ledao.find(nome);
        return "";
    }

    public LocalEvento getLocal() {
        return local;
    }

    public void setLocal(LocalEvento local) {
        this.local = local;
    }

    public String getMsgChave() {
        return msgChave;
    }

    public void setMsgChave(String msgChave) {
        this.msgChave = msgChave;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
    
    
    
    
}
