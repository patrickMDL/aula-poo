/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg01.geradorprova;

import java.util.ArrayList;

/**
 *
 * @author 5678056
 */
public class Prova {

    

    private String data;
    private String local;
    private String nomeDisciplina;
    private int peso = 10;
    private ArrayList<Questao> questoes = new ArrayList<Questao>();

    public Prova(String nomeDaProva) {
        this.nomeDisciplina = nomeDaProva;
        this.peso = 10;
    }

    public String obtemDetalhes() {
        String retorno = "";
        retorno += ("Disciplina: " +this.nomeDisciplina + "\r\n");
        retorno += ("Peso: " + this.peso + "\r\n");
        retorno += ("Data: " + this.data + "\r\n");
        retorno += ("Aluno: __________________________________________\r\n");
        retorno += ("======================================================\r\n");
        return retorno;

    }
    public String obtemProvaImpressao(){
        String retorno = obtemDetalhes();
        int cont=1;
        for(int i=0; i<this.questoes.size(); i++){
            retorno+=(cont+this.questoes.get(i).retornaQuestao()+"\r\n");
            cont++;
        }
        return retorno;
    }
    
    public void setNomeDisciplina(String nome){
        this.nomeDisciplina=nome;
    }
    
    public String getNomeDisciplina(){
        return nomeDisciplina;
    }
    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return the local
     */
    public String getLocal() {
        return local;
    }

    /**
     * @param local the local to set
     */
    public void setLocal(String local) {
        this.local = local;
    }

    /**
     * @return the peso
     */
    public int getPeso() {
        return peso;
    }
/**
     * @return the questoes
     */
    public ArrayList getQuestoes() {
        return questoes;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(int peso) {
        this.peso = peso;
    }
    
    /**
     * @param questoes the questoes to set
     */
    public void setQuestoes(ArrayList<Questao> questoes) {
        this.questoes = questoes;
    }


    
}
