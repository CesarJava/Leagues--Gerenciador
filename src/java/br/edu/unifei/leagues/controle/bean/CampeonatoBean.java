/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifei.leagues.controle.bean;

import br.edu.unifei.leagues.controle.dao.CampeonatoDao;
import br.edu.unifei.leagues.controle.dao.FonteDados;
import br.edu.unifei.leagues.controle.dao.JogoDao;
import br.edu.unifei.leagues.controle.dao.LocalEventoDao;
import br.edu.unifei.leagues.controle.dao.MidiaDao;
import br.edu.unifei.leagues.controle.dao.StaffDao;
import br.edu.unifei.leagues.controle.dao.TimesDao;
import br.edu.unifei.leagues.modelo.Campeonato;
import br.edu.unifei.leagues.modelo.Jogo;
import br.edu.unifei.leagues.modelo.LocalEvento;
import br.edu.unifei.leagues.modelo.Midia;
import br.edu.unifei.leagues.modelo.Staff;
import br.edu.unifei.leagues.modelo.Times;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
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
public class CampeonatoBean {
    private final EntityManager em = FonteDados.createEntityManager();
    private final CampeonatoDao cdao = new CampeonatoDao(em);
    private final JogoDao jogodao = new JogoDao(em);
    private final MidiaDao mdao = new MidiaDao(em);
    private final TimesDao tdao = new TimesDao(em);
    private final StaffDao funcdao = new StaffDao(em);
    private final LocalEventoDao ldao = new LocalEventoDao(em);
    private Campeonato campeonato = new Campeonato();
   // private List<Integer> listaJogos = jogodao.findAllJogos();
    private List<String> listaMidias = mdao.findAllMidias();
    private List<String> listaLocais = ldao.findAllLocais();
    private List<String> listaTimes = tdao.findAllTimes();
    private List<String> listaFunc = funcdao.findAllFuncionarios();
    private List<String> listaCampoenatos = cdao.findAllCampeonatos();    
    //-------------------------------------------------------//
    //private List<Integer> jogosSelecionados = new ArrayList<>();
    private List<String> timesSelecionados = new ArrayList<>();
    private List<String> funcionariosSelecionados = new ArrayList<>();
    private List<String> midiasSelecionados = new ArrayList<>();
    //------------------------------------------------------//
    private boolean habilitaChave = false;
    private boolean habilitaEdicao = false;    
    private String msgChave;
    private String nome;
    private String local;
    
    public String inserir() {
        try {
            cdao.create(campeonato);
        } catch (EntityExistsException e) {
            msgChave = "chave duplicada";
            return "";
        }
        
        for (String midias : midiasSelecionados){
            Midia m = mdao.find(midias);
            campeonato.getMidia().add(m);            
        }
        
        for(String times : timesSelecionados){
            Times t = tdao.find(times);
            campeonato.getTimes().add(t);            
        }
        
        for(String func : funcionariosSelecionados){
            Staff f = funcdao.find(func);
            campeonato.getFuncionarios().add(f);
        }
        
          
        
        LocalEvento l = ldao.find(local);
        campeonato.setLocalEvento(l);      
        
        cdao.update(campeonato);

        return "/index";
    }
    
    public String buscar() {
        campeonato = cdao.find(nome);
        //jogadoresSelecionados = jdao.findAllCampeoesFavoritos(nome);
        //for(String s : jogadoresSelecionados){
        //System.out.println(campeonato.getNome());
        //}
        return "";
    }

    public Campeonato getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(Campeonato campeonato) {
        this.campeonato = campeonato;
    }

    public List<String> getListaMidias() {
        return listaMidias;
    }

    public void setListaMidias(List<String> listaMidias) {
        this.listaMidias = listaMidias;
    }

    public List<String> getListaTimes() {
        return listaTimes;
    }

    public void setListaTimes(List<String> listaTimes) {
        this.listaTimes = listaTimes;
    }

    public List<String> getListaFunc() {
        return listaFunc;
    }

    public void setListaFunc(List<String> listaFunc) {
        this.listaFunc = listaFunc;
    }

    public List<String> getListaCampoenatos() {
        return listaCampoenatos;
    }

    public void setListaCampoenatos(List<String> listaCampoenatos) {
        this.listaCampoenatos = listaCampoenatos;
    }

    public List<String> getTimesSelecionados() {
        return timesSelecionados;
    }

    public void setTimesSelecionados(List<String> timesSelecionados) {
        this.timesSelecionados = timesSelecionados;
    }

    public List<String> getFuncionariosSelecionados() {
        return funcionariosSelecionados;
    }

    public void setFuncionariosSelecionados(List<String> funcionariosSelecionados) {
        this.funcionariosSelecionados = funcionariosSelecionados;
    }

    public List<String> getMidiasSelecionados() {
        return midiasSelecionados;
    }

    public void setMidiasSelecionados(List<String> midiasSelecionados) {
        this.midiasSelecionados = midiasSelecionados;
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

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public List<String> getListaLocais() {
        return listaLocais;
    }

    public void setListaLocais(List<String> listalocais) {
        this.listaLocais = listalocais;
    }

   
    
    
    
    
}
