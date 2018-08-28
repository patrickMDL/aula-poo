/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg01.geradorprova;

import javax.swing.JOptionPane;

/**
 *
 * @author 5678056
 */
public class GeradorProva {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Prova x=new Prova("POO");
        x.setData("2018-08 -28");
        x.setLocal("Lab 3 - Bloco B6");

        //Forma didática
        String retornoDoMetodo = x.obtemDetalhes();
        System.out.println(retornoDoMetodo);
        
        //Forma resumida
        System.out.println(x.obtemDetalhes());
        
        Objetiva o= new Objetiva();
        String[] opcoes = new String[5];
        opcoes[0]="a";
        opcoes[1]="b";
        opcoes[2]="c";
        opcoes[3]="d";
        opcoes[4]="5";
        o.setOpcoes(opcoes);
        o.setPeso(2);
        o.setPergunta("Qual o melhor time?");
        o.setRespostaCorreta(2);
        
        Discursiva d = new Discursiva();
        d.setPergunta("Qual o melhor time do cblol?");
        d.setPeso(2);
        d.setCriteriosCorrecao("Explicação Plausível");
        
    }
    
}
