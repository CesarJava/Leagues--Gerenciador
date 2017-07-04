/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifei.leagues.controle.bean;

import br.edu.unifei.leagues.controle.dao.CampeoesDao;
import br.edu.unifei.leagues.controle.dao.EquipamentoDao;
import br.edu.unifei.leagues.controle.dao.FonteDados;
import br.edu.unifei.leagues.controle.dao.JogadorDao;
import br.edu.unifei.leagues.controle.dao.TimesDao;
import br.edu.unifei.leagues.modelo.Campeoes;
import br.edu.unifei.leagues.modelo.Equipamento;
import br.edu.unifei.leagues.modelo.Jogador;
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
public class JogadorBean {

    private final EntityManager em = FonteDados.createEntityManager();
    private final JogadorDao jdao = new JogadorDao(em);
    private final CampeoesDao cdao = new CampeoesDao(em);
    private final EquipamentoDao edao = new EquipamentoDao(em);
    private final TimesDao tdao = new TimesDao(em);
    private Jogador jogador = new Jogador();
    private List<String> listaEquip = edao.findAllEquipamentos();
    private List<String> listaCamp = cdao.findAllNomes();
    private List<String> listaTimes = tdao.findAllTimes();
    private List<String> listaNomes = jdao.findAllJogadores();
    private List<String> equipsSelecionados = new ArrayList<>();
    private List<String> campeoesSelecionados = new ArrayList<>();
    private boolean habilitaChave = false;
    private boolean habilitaEdicao = false;
    private String timeSelecionado;
    private String msgChave;
    private String nome;

    public String inserir() {
        try {
            jdao.create(jogador);
        } catch (EntityExistsException e) {
            msgChave = "chave duplicada";
            return "";
        }

        for (String equi : equipsSelecionados) {
            Equipamento eq = edao.find(equi);
            jogador.getEquips().add(eq);
        }
        for (String camp : campeoesSelecionados) {
            Campeoes c = cdao.find(camp);
            jogador.getCampeoesMaisJogados().add(c);
        }

        if (timeSelecionado == "Sem Time") {
            jogador.setTime(null);
        } else {
            Times t = tdao.find(timeSelecionado);
            jogador.setTime(t);
        }

        jdao.update(jogador);
        return "/index";
    }

    public String buscar() {
        jogador = jdao.find(nome);
        return "";
    }

    public String alterar() {
        if(jogador.getTime() != null){
        Times tAnt = jogador.getTime();
        jogador.getTime().getJogadores().remove(jogador);
        tdao.update(tAnt);
        }
        
        if (timeSelecionado.equals("Sem Time")) {
            jogador.setTime(null);
        } else {
            Times t = tdao.find(timeSelecionado);
            jogador.setTime(t);
            t.addJogador(jogador);
            tdao.update(t);
        }
        jdao.update(jogador);
        

        jogador.getCampeoesMaisJogados().clear();
        for (String camp : campeoesSelecionados) {
            Campeoes c = cdao.find(camp);
            jogador.getCampeoesMaisJogados().add(c);
        }
        jogador.getEquips().clear();
        for (String eq : equipsSelecionados) {
            Equipamento e = edao.find(eq);
            jogador.getEquips().add(e);
        }

        jdao.update(jogador);
        return "/index";
    }

    public String excluir() {        
        Times tAnt = jogador.getTime();
        tAnt.getJogadores().remove(jogador);
        tdao.update(tAnt);
        jdao.removeEntity(jogador);
        return "/index";
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public List<String> getListaEquip() {
        return listaEquip;
    }

    public void setListaEquip(List<String> listaEquip) {
        this.listaEquip = listaEquip;
    }

    public List<String> getListaCamp() {
        return listaCamp;
    }

    public void setListaCamp(List<String> listaCamp) {
        this.listaCamp = listaCamp;
    }

    public List<String> getEquipsSelecionados() {
        return equipsSelecionados;
    }

    public void setEquipsSelecionados(List<String> equipsSelecionados) {
        this.equipsSelecionados = equipsSelecionados;
    }

    public List<String> getCampeoesSelecionados() {
        return campeoesSelecionados;
    }

    public void setCampeoesSelecionados(List<String> campeoesSelecionados) {
        this.campeoesSelecionados = campeoesSelecionados;
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

    public String getTimeSelecionado() {
        return timeSelecionado;
    }

    public void setTimeSelecionado(String timeSelecionado) {
        this.timeSelecionado = timeSelecionado;
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

    public List<String> getListaTimes() {
        return listaTimes;
    }

    public void setListaTimes(List<String> listaTimes) {
        this.listaTimes = listaTimes;
    }

    public List<String> getListaNomes() {
        return listaNomes;
    }

    public void setListaNomes(List<String> listaNomes) {
        this.listaNomes = listaNomes;
    }

}
