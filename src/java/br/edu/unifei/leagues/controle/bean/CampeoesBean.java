/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifei.leagues.controle.bean;

import br.edu.unifei.leagues.controle.dao.CampeoesDao;
import br.edu.unifei.leagues.controle.dao.FonteDados;
import br.edu.unifei.leagues.modelo.Campeoes;
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
public class CampeoesBean {
   

    private final EntityManager em = FonteDados.createEntityManager();
    private final CampeoesDao cdao = new CampeoesDao(em);
    private Campeoes campeao = new Campeoes();  
    private boolean habilitaChave = false;
    private boolean habilitaEdicao = false;
    private String msgChave;
    private String nome;

    public String inserir() {
        try {
            cdao.create(campeao);
            msgChave = null;
        } catch (EntityExistsException e) {
            msgChave = "chave duplicada";
            return "";
        }

        /**
         * for(String nome:jogadoresSelecionados){ Jogador j = jdao.find(nome);
         * campeao.getJogador().add(j); j.addCampeao(campeao); jdao.update(j); }
         cdao.update(campeao);
         */
        return "/index";
    }

    public String buscar() {
        campeao = cdao.find(nome);
        //jogadoresSelecionados = jdao.findAllCampeoesFavoritos(nome);
        //for(String s : jogadoresSelecionados){
        //System.out.println(campeao.getNome());
        //}
        return "";
    }

    public String alterar() {

        /* for(Jogador j : campeao.getJogador()){
           int count=0;
           Iterator<Campeoes> lista = j.iteratorCampeoes();
           while(lista.hasNext()){
               count ++;
               if(lista.next().getNome() == campeao.getNome()){
                   j.removeCampeao(count);
                   break;
               }
               
           }
           jdao.update(j);
        }  
        campeao.getJogador().clear();
        for(String nome:jogadoresSelecionados){
            Jogador j = jdao.find(nome);
            campeao.getJogador().add(j);
            j.addCampeao(campeao);
            jdao.update(j);
        }*/
        
        
        cdao.update(campeao);
        return "/index";
    }
    

    public Campeoes getCampeao() {
        return campeao;
    }

    public void setCampeao(Campeoes campeao) {
        this.campeao = campeao;
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

    

}
