/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifei.leagues.controle.bean;

import br.edu.unifei.leagues.controle.dao.CoachDao;
import br.edu.unifei.leagues.controle.dao.FonteDados;
import br.edu.unifei.leagues.controle.dao.JogadorDao;
import br.edu.unifei.leagues.controle.dao.PatrocinadorDao;
import br.edu.unifei.leagues.controle.dao.TimesDao;
import br.edu.unifei.leagues.modelo.Coach;
import br.edu.unifei.leagues.modelo.Jogador;
import br.edu.unifei.leagues.modelo.Patrocinador;
import br.edu.unifei.leagues.modelo.Times;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import org.hibernate.EntityMode;

/**
 *
 * @author Cesaros
 */
@ManagedBean
@ViewScoped
public class TimesBean {

    private final EntityManager em = FonteDados.createEntityManager();
    private final TimesDao tdao = new TimesDao(em);
    private final PatrocinadorDao pdao = new PatrocinadorDao(em);
    private final JogadorDao jdao = new JogadorDao(em);
    private final CoachDao cdao = new CoachDao(em);
    private Times time = new Times();
    private Times timeAnt = new Times();
    private List<String> listaJogadores = jdao.findAllJogadores();
    private List<String> listaPatrocinadores = pdao.findAllPatrocinadores();
    private List<String> listaCoachs = cdao.findAllCoachs();
    private List<String> listaTimes = tdao.findAllTimes();
    private List<String> jogadoresSelecionados = new ArrayList<>();
    private List<String> patrocinadoresSelecinados = new ArrayList<>();
    private String coachSelecionado;
    private boolean habilitaChave = false;
    private boolean habilitaEdicao = false;
    private String msgChave;
    private String nome;

    public String inserir() {
        try {
            tdao.create(time);
        } catch (EntityExistsException e) {
            msgChave = "chave duplicada";
            return "";
        }

        if (jogadoresSelecionados != null) {
            for (String jog : jogadoresSelecionados) {
                Jogador j = jdao.find(jog);
                if (j.getTime() != null && j.getTime() != time) {
                    j.getTime().getJogadores().remove(j);
                    tdao.update(j.getTime());
                    time.getJogadores().add(j);
                    
                }
                j.setTime(time);
                jdao.update(j);
                
            }
        }

        if (patrocinadoresSelecinados != null) {
            for (String pat : patrocinadoresSelecinados) {
                Patrocinador p = pdao.find(pat);
                time.getPatrocinadores().add(p);
            }
        }
        if (coachSelecionado != null) {
            Coach c = cdao.find(coachSelecionado);
            if (c.getTimexAtual() != null) {
                timeAnt = c.getTimexAtual();
                timeAnt.setTreinador(null);
                tdao.update(timeAnt);
                c.setTimeAnterior(c.getTimexAtual());
            }
            c.setTimexAtual(time);
            cdao.update(c);
            time.setTreinador(c);
        } else {
            //time
        }

        tdao.update(time);
        return "/index";

    }

    public String buscar() {

        time = tdao.find(nome);
        return "";
    }

    public String excluir() {

        for (Jogador jog : time.getJogadores()) {
            jog.setTime(null);
            jdao.update(jog);
        }

        time.getJogadores().clear();

        if (time.getTreinador() != null) {
            Coach c = cdao.find(time.getTreinador().getNome());
            if (c.getTimeAnterior() != null) {
                c.setTimeAnterior(c.getTimexAtual());
            }
            c.setTimexAtual(null);
            cdao.update(c);
        }

        time.setTreinador(null);
        tdao.update(time);
        tdao.removeEntity(time);
        return "/index";
    }

    public String alterar() {
        
        if (jogadoresSelecionados != null) {
            for (String jog : jogadoresSelecionados) {
                Jogador j = jdao.find(jog);
                if (j.getTime() != null ) {
                    j.getTime().getJogadores().remove(j);
                    tdao.update(j.getTime());
                }
                j.setTime(time);
                jdao.update(j);
                time.getJogadores().add(j);
            }
        }

        if (patrocinadoresSelecinados != null) {
            time.getPatrocinadores().clear();
            for (String pat : patrocinadoresSelecinados) {
                Patrocinador p = pdao.find(pat);
                time.getPatrocinadores().add(p);
            }
        } else {
            time.getPatrocinadores().clear();
        }

        if (coachSelecionado != null) {
            Coach c = cdao.find(coachSelecionado);
            if (c.getTimexAtual()!= null && c.getTimexAtual()!= time) {
                timeAnt = c.getTimexAtual();
                timeAnt.setTreinador(null);
                tdao.update(timeAnt);
                c.setTimeAnterior(c.getTimexAtual());
            }
            c.setTimexAtual(time);
            cdao.update(c);
            time.setTreinador(c);
        } else {
            time.setTreinador(null);
        }

        tdao.update(time);

        return "/index";
    }

    public Times getTime() {
        return time;
    }

    public void setTime(Times time) {
        this.time = time;
    }

    public List<String> getListaJogadores() {
        return listaJogadores;
    }

    public void setListaJogadores(List<String> listaJogadores) {
        this.listaJogadores = listaJogadores;
    }

    public List<String> getListaPatrocinadores() {
        return listaPatrocinadores;
    }

    public void setListaPatrocinadores(List<String> listaPatrocinadores) {
        this.listaPatrocinadores = listaPatrocinadores;
    }

    public List<String> getListaCoachs() {
        return listaCoachs;
    }

    public void setListaCoachs(List<String> listaCoachs) {
        this.listaCoachs = listaCoachs;
    }

    public List<String> getJogadoresSelecionados() {
        return jogadoresSelecionados;
    }

    public void setJogadoresSelecionados(List<String> jogadoresSelecionados) {
        this.jogadoresSelecionados = jogadoresSelecionados;
    }

    public List<String> getPatrocinadoresSelecinados() {
        return patrocinadoresSelecinados;
    }

    public void setPatrocinadoresSelecinados(List<String> patrocinadoresSelecinados) {
        this.patrocinadoresSelecinados = patrocinadoresSelecinados;
    }

    public String getCoachSelecionado() {
        return coachSelecionado;
    }

    public void setCoachSelecionado(String coachSelecionado) {
        this.coachSelecionado = coachSelecionado;
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

    public List<String> getListaTimes() {
        return listaTimes;
    }

    public void setListaTimes(List<String> listaTimes) {
        this.listaTimes = listaTimes;
    }

}
