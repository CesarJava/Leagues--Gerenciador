/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifei.leagues.controle.bean;

import br.edu.unifei.leagues.controle.dao.CoachDao;
import br.edu.unifei.leagues.controle.dao.FonteDados;
import br.edu.unifei.leagues.controle.dao.TimesDao;
import br.edu.unifei.leagues.modelo.Coach;
import br.edu.unifei.leagues.modelo.Times;
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
public class CoachBean {

    private final EntityManager em = FonteDados.createEntityManager();
    private final CoachDao cdao = new CoachDao(em);
    private final TimesDao tdao = new TimesDao(em);
    private Coach coach = new Coach();
    private Coach coachNulo = new Coach();
    private Times tAtual = new Times();
    private Times tAnterior = new Times();
    private List<String> listaTimes = tdao.findAllTimes();
    private List<String> listaCoachs = cdao.findAllCoachs();
    private boolean habilitaChave = false;
    private boolean habilitaEdicao = false;
    private String timeAtual;
    private String timeAntigo;
    private String nome;
    /*public String create(){
        
    }*/

    private String msgChave;

    public String inserir() {
        try {
            cdao.create(coach);
        } catch (EntityExistsException e) {
            msgChave = "chave duplicada";
            return "";
        }

        if (timeAtual.equals("Sem Time") == false ) {
            tAtual = tdao.find(timeAtual);
            if (tAtual.getTreinador() != null) {
                tAtual.getTreinador().setTimeAnterior(tAtual);
                tAtual.getTreinador().setTimexAtual(null);
                cdao.update(tAtual.getTreinador());
            }
            tAtual.setTreinador(coach);
            tdao.update(tAtual);
            coach.setTimexAtual(tAtual);

        } else {
            coach.setTimexAtual(null);
        }

        if (timeAntigo.equals("Sem Time") == false ) {
            tAnterior = tdao.find(timeAntigo);
            coach.setTimeAnterior(tAnterior);
        } else {
            coach.setTimeAnterior(null);
        }
        try {
            cdao.update(coach);
        } catch (EntityExistsException e) {
            return null;
        }
        return "/index";
    }

    public String buscar() {
        coach = cdao.find(nome);
        return "";
    }

    public String alterar() {
        if(coach.getTimexAtual() != null){
        tAnterior = coach.getTimexAtual();
        tAnterior.setTreinador(null);
        tdao.update(tAnterior);        
        coach.setTimeAnterior(tAnterior);
        }else{
            coach.setTimeAnterior(null);
        }
        
        if (timeAtual.equals("Sem Time") == true) {
            coach.setTimexAtual(null);
        } else {
            tAtual = tdao.find(timeAtual);
            if (tAtual.getTreinador() != null) {
                tAtual.getTreinador().setTimeAnterior(tAtual);
                tAtual.getTreinador().setTimexAtual(null);
                cdao.update(tAtual.getTreinador());
            }
            tAtual.setTreinador(coach);
            tdao.update(tAtual);

            coach.setTimexAtual(tAtual);
        }

        cdao.update(coach);
        return "/index";
    }

    public String excluir() {
        if(coach.getTimexAtual() != null ){
        coach.getTimexAtual().setTreinador(null);
        tdao.update(coach.getTimexAtual());
        coach.setTimexAtual(null);
        cdao.update(coach);
        }
        cdao.removeEntity(coach);
        return "/index";
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public String getTimeAtual() {
        return timeAtual;
    }

    public void setTimeAtual(String timeAtual) {
        this.timeAtual = timeAtual;
    }

    public String getTimeAntigo() {
        return timeAntigo;
    }

    public void setTimeAntigo(String timeAntigo) {
        this.timeAntigo = timeAntigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMsgChave() {
        return msgChave;
    }

    public void setMsgChave(String msgChave) {
        this.msgChave = msgChave;
    }

    public List<String> getListaTimes() {
        return listaTimes;
    }

    public void setListaTimes(List<String> listaTimes) {
        this.listaTimes = listaTimes;
    }

    public List<String> getListaCoachs() {
        return listaCoachs;
    }

    public void setListaCoachs(List<String> listaCoachs) {
        this.listaCoachs = listaCoachs;
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
