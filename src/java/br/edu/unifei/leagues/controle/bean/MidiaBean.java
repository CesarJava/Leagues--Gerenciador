/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifei.leagues.controle.bean;

import br.edu.unifei.leagues.controle.dao.FonteDados;
import br.edu.unifei.leagues.controle.dao.MidiaDao;
import br.edu.unifei.leagues.modelo.Midia;
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
public class MidiaBean {
    
    
    private final EntityManager em = FonteDados.createEntityManager();
    private final MidiaDao mdao = new MidiaDao(em);
    private List<String> listaMidias = mdao.findAllMidias();
    private Midia midia = new Midia();
    private boolean habilitaChave = false;
    private boolean habilitaEdicao = false;
    private String msgChave;
    private String nome;
    
    public String inserir(){
        try {
            mdao.create(midia);
            msgChave = null;
        } catch (EntityExistsException e) {
            msgChave = "chave duplicada";
            return "";
        }
        return "/index";
    }
    
    public String buscar(){
        midia = mdao.find(nome);
        return "";
    }
    
    public String excluir() {
        mdao.removeEntity(midia);
        return "/index";
    }

    public Midia getMidia() {
        return midia;
    }

    public void setMidia(Midia midia) {
        this.midia = midia;
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

    public List<String> getListaMidias() {
        return listaMidias;
    }

    public void setListaMidias(List<String> listaMidias) {
        this.listaMidias = listaMidias;
    }
}
