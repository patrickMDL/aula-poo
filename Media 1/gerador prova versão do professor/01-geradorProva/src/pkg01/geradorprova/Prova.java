/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg01.geradorprova;

/**
 *
 * @author marcelo
 */
public class Prova {

    private String nome;
    private String local;
    private String data;
    private int peso;
    private Discursiva[] questoesDiscursivas;
    private Objetiva[] questoesObjetivas;

    public Prova(String nome) {
        this.nome = nome;
        this.peso = 10;
    }

    public String obtemDetalhes() {
        String retorno = "";
        retorno += "Nome: " + this.getNome() + "\n";
        retorno += "Local: " + this.getLocal() + "\n";
        retorno += "Data: " + this.getData() + "\n";
        retorno += "Peso: " + this.getPeso() + "\n";
        return retorno;
    }
    
    public String obtemProvaImpressao(){
        String retorno = this.obtemDetalhes();
        
        for(int i = 0; i < this.questoesDiscursivas.length; i++){
            retorno += "=================== \n";
            retorno += "(peso: "+this.questoesDiscursivas[i].getPeso()+") ";
            retorno += this.questoesDiscursivas[i].getPergunta()+"\n";
            retorno += "____________________________________________________\n";
            retorno += "____________________________________________________\n";
            retorno += "____________________________________________________\n";
            retorno += "Critérios correção: "+this.questoesDiscursivas[i].getCriteriosCorrecao()+"\n";
        }
        
        for(int i = 0; i < this.questoesObjetivas.length; i++){
            retorno += "=================== \n";
            retorno += "(peso: "+this.questoesObjetivas[i].getPeso()+") ";
            retorno += this.questoesObjetivas[i].getPergunta()+"\n";
            for(int j = 0; j < this.questoesObjetivas[i].getOpcoes().length; j++){
                retorno += (j+1)+") "+this.questoesObjetivas[i].getOpcoes()[j]+"\n";
            }
        }
        return retorno;
        
    }
    

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
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
     * @return the questoesDiscursivas
     */
    public Discursiva[] getQuestoesDiscursivas() {
        return questoesDiscursivas;
    }

    /**
     * @param questoesDiscursivas the questoesDiscursivas to set
     */
    public void setQuestoesDiscursivas(Discursiva[] questoesDiscursivas) {
        this.questoesDiscursivas = questoesDiscursivas;
    }

    /**
     * @return the questoesObjetivas
     */
    public Objetiva[] getQuestoesObjetivas() {
        return questoesObjetivas;
    }

    /**
     * @param questoesObjetivas the questoesObjetivas to set
     */
    public void setQuestoesObjetivas(Objetiva[] questoesObjetivas) {
        this.questoesObjetivas = questoesObjetivas;
    }

}
