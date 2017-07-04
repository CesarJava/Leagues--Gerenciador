/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifei.leagues.controle.bean;

import br.edu.unifei.leagues.controle.dao.FonteDados;
import br.edu.unifei.leagues.controle.dao.JogoDao;
import br.edu.unifei.leagues.controle.dao.TimesDao;
import br.edu.unifei.leagues.modelo.Jogo;
import br.edu.unifei.leagues.modelo.Times;
import java.util.ArrayList;
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
public class JogoBean {
    
    private final EntityManager em = FonteDados.createEntityManager();
    private final TimesDao tdao = new TimesDao(em);
    private final JogoDao jdao = new JogoDao(em);
    private Jogo jogo = new Jogo();
    private List<String> listaTimes = tdao.findAllTimes();
    private List<Integer> listaJogos = jdao.findAllJogos();
    private String time1;
    private String time2;
    private String timeVencedor;
    private boolean habilitaChave = false;
    private boolean habilitaEdicao = false;
    private int numero;
    private String msgChave;
    
    
    public String inserir(){
        try {
            jdao.create(jogo);
        } catch (EntityExistsException e) {
            msgChave = "chave duplicada";
            return "";
        }
        
        Times t1 = tdao.find(time1);
        Times t2 = tdao.find(time2);
        
        jdao.update(jogo);
        return "/index";
        
    }
    
    public String buscar(){
        jogo = jdao.find(numero);
        return "";
    }
    
    public String alterar(){
        Times t1 = tdao.find(time1);
        Times t2 = tdao.find(time2);
        Times tVencedor = tdao.find(timeVencedor);
        jogo.setTime1(t1);
        jogo.setTime2(t2);
        jogo.setVencedor(tVencedor);
        
        jdao.update(jogo);
        return "/index";
        
        
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

    public List<String> getListaTimes() {
        return listaTimes;
    }

    public void setListaTimes(List<String> listaTimes) {
        this.listaTimes = listaTimes;
    }

    public List<Integer> getListaJogos() {
        return listaJogos;
    }

    public void setListaJogos(List<Integer> listaJogos) {
        this.listaJogos = listaJogos;
    }

    public String getTime1() {
        return time1;
    }

    public void setTime1(String time1) {
        this.time1 = time1;
    }

    public String getTime2() {
        return time2;
    }

    public void setTime2(String time2) {
        this.time2 = time2;
    }

    public String getTimeVencedor() {
        return timeVencedor;
    }

    public void setTimeVencedor(String timeVencedor) {
        this.timeVencedor = timeVencedor;
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

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getMsgChave() {
        return msgChave;
    }

    public void setMsgChave(String msgChave) {
        this.msgChave = msgChave;
    }
    
    
    
    
    
}
