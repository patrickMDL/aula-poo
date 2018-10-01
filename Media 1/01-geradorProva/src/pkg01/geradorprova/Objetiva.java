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
final class Objetiva extends Questao{
    
    private String[] opcoes;
    private int respostaCorreta;
    
    public Objetiva(){
        this.opcoes = new String[5];
    }
    
    @Override
    public String retornaQuestao(){
        String retorno="";
        retorno += "(" + this.getPeso() + ") - " + this.getPergunta() + "\r\n";
        String[] aux = this.getOpcoes();
        char letra = 'a';
        for (int i=0; i<5; i++){
            retorno += letra + ") " + aux[i] + "\r\n";
            letra++;
        }
        return retorno;
    }
    
    /**
     * @return the opcoes
     */
    public String[] getOpcoes() {
        return opcoes;
    }

    /**
     * @param opcoes the opcoes to set
     */
    public void setOpcoes(String[] opcoes) {
        this.opcoes = opcoes;
    }

    /**
     * @return the respostaCorreta
     */
    public int getRespostaCorreta() {
        return respostaCorreta;
    }

    /**
     * @param respostaCorreta the respostaCorreta to set
     */
    public void setRespostaCorreta(int respostaCorreta) {
        this.respostaCorreta = respostaCorreta;
    }
    
    
}
