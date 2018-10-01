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
final class Discursiva extends Questao {
    private String criteriosCorrecao;

    
    @Override
    public String retornaQuestao(){
        String retorno = "";
        retorno+="(" + this.getPeso() + ") -" + this.getPergunta()+"\r\n";
        retorno+= "R:_______________________________________________\r\n";
        retorno+= "__________________________________________________\r\n";
        retorno+= "__________________________________________________\r\n";
        retorno+= "Critério de avaliação: " + this.getCriteriosCorrecao() + "\r\n";
        
        return retorno;
    }
    /**
     * @return the criteriosCorrecao
     */
    public String getCriteriosCorrecao() {
        return criteriosCorrecao;
    }

    /**
     * @param criteriosCorrecao the criteriosCorrecao to set
     */
    public void setCriteriosCorrecao(String criteriosCorrecao) {
        this.criteriosCorrecao = criteriosCorrecao;
    }
}
