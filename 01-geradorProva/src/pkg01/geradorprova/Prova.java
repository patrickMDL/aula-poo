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
    private String nome;
    private int peso = 10;

    public Prova(String nomeDaProva) {
        this.nome = nomeDaProva;
    }

    public String obtemDetalhes() {
        String retorno = "";
        retorno = retorno + "Nome: " + this.getNome() + "\n";
        retorno = retorno + "local: " + this.getLocal() + "\n";
        retorno = retorno + "Data: " + this.getData() + "\n";
        retorno = retorno + "Peso: " + this.getPeso() + "\n";
        return retorno;

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
}
