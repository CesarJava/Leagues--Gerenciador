/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifei.leagues.controle.bean;

import br.edu.unifei.leagues.controle.dao.FonteDados;
import br.edu.unifei.leagues.controle.dao.StaffDao;
import br.edu.unifei.leagues.modelo.Staff;
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
public class StaffBean {
    private final EntityManager em = FonteDados.createEntityManager();
    private final StaffDao fdao = new StaffDao(em);
    private Staff funcionario = new Staff();
    private boolean habilitaChave = false;
    private boolean habilitaEdicao = false;
    private String msgChave;
    private String nome;
    
    public String inserir(){
        try {
            fdao.create(funcionario);
            msgChave = null;
        } catch (EntityExistsException e) {
            msgChave = "chave duplicada";
            return "";
        }
        
        return "/index";
    }
    
    public String buscar(){
        funcionario = fdao.find(nome);
        return "";
        
    }

    public Staff getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Staff funcionario) {
        this.funcionario = funcionario;
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
