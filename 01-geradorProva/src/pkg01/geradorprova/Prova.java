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
    private Discursiva[] questoesDiscursivas;
    private Objetiva[] questoesObjetivas;
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
    public String obtemProvaImpressao(){
        String retorno = this.obtemDetalhes();
        
        for(int i = 0; i < this.getQuestoesDiscursivas().length; i++){
            retorno += "=================== \n";
            retorno += "(peso: "+this.getQuestoesDiscursivas()[i].getPeso()+") ";
            retorno += this.getQuestoesDiscursivas()[i].getPergunta()+"\n";
            retorno += "____________________________________________________\n";
            retorno += "____________________________________________________\n";
            retorno += "____________________________________________________\n";
            retorno += "Critérios correção: "+this.getQuestoesDiscursivas()[i].getCriteriosCorrecao()+"\n";
        }
        
        for(int i = 0; i < this.getQuestoesObjetivas().length; i++){
            retorno += "=================== \n";
            retorno += "(peso: "+this.getQuestoesObjetivas()[i].getPeso()+") ";
            retorno += this.getQuestoesObjetivas()[i].getPergunta()+"\n";
            for(int j = 0; j < this.getQuestoesObjetivas()[i].getOpcoes().length; j++){
                retorno += (j+1)+") "+this.getQuestoesObjetivas()[i].getOpcoes()[j]+"\n";
            }
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
