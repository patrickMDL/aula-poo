/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg01.geradorprova;

/**
 *
 * @author 5678056
 */
public class Prova {

    private String data;
    private String local;
    private String nomeDisciplina;
    private int peso = 10;
    Objetiva[] a;
    Discursiva[] b;
    private int nQuestoes;

    public Prova(String nomeDaProva) {
        this.nomeDisciplina = nomeDaProva;
    }

    public String obtemDetalhes() {
        String retorno = "";
        retorno = retorno + "Nome: " + this.getNomeDisciplina() + "\n";
        retorno = retorno + "local: " + this.getLocal() + "\n";
        retorno = retorno + "Data: " + this.getData() + "\n";
        retorno = retorno + "Peso: " + this.getPeso() + "\n";
        return retorno;

    }
    
    public String imprimeProva(){
        String retorno ="";
        retorno = retorno + "Nome: " + this.getNomeDisciplina() + "\n";
        retorno = retorno + "local: " + this.getLocal() + "\n";
        retorno = retorno + "Data: " + this.getData() + "\n";
        retorno = retorno + "Peso: " + this.getPeso() + "\n";
        
        for(int i=0; i<nQuestoes; i++){ //Objetiva
            retorno = retorno + this.a[i].getPergunta()+ "\n";
            retorno = retorno + this.a[i].getPeso()+ "\n";
            for(int j=0; j<5; j++)
                retorno = retorno + this.a[i].getOpcoes()[j]+ "\n";
            retorno = retorno + this.a[i].getRespostaCorreta()+ "\n";
            
        }
        for(int i=0; i<nQuestoes; i++){ //Discursiva
            retorno = retorno + this.b[i].getPergunta() + "\n";
            retorno = retorno + this.b[i].getPeso() + "\n";
            retorno = retorno + this.b[i].getCriteriosCorrecao()+ "\n" ;
            
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
     * @param peso the peso to set
     */
    public void setPeso(int peso) {
        this.peso = peso;
    }

    /**
     * @return the nQuestoes
     */
    public int getnQuestoes() {
        return nQuestoes;
    }

    /**
     * @param nQuestoes the nQuestoes to set
     */
    public void setnQuestoes(int nQuestoes) {
        this.nQuestoes = nQuestoes;
    }
}
