/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg01.geradorprova;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author marcelo
 */
public class GeradorProva {

    public static void main(String[] args) {
        
        String disciplina = JOptionPane.showInputDialog("Digite a DISCIPLINA da prova");
        String local = JOptionPane.showInputDialog("Digite o LOCAL da prova");
        String data = JOptionPane.showInputDialog("Digite a DATA da prova");
        int peso = Integer.parseInt( JOptionPane.showInputDialog("Digite o PESO da prova") );
        
        Prova x = new Prova(disciplina);
        x.setLocal(local);
        x.setData(data);
        x.setPeso(peso);
        
        int qtdDiscursivas = Integer.parseInt( JOptionPane.showInputDialog(""
                + "Digite a qtde. de questões discursivas") );
        Discursiva[] listaQuestoesDiscursivas = new Discursiva[qtdDiscursivas];
        for(int i = 0; i < qtdDiscursivas; i++){
            String pergunta = JOptionPane.showInputDialog("Digite a PERGUNTA ("+(i+1)+")");
            String criterioCorrecao = JOptionPane.showInputDialog("Digite o CRITÉRIO DE CORREÇÃO ("+(i+1)+")");;
            int pesoQuestao = Integer.parseInt( JOptionPane.showInputDialog("Digite o PESO ("+(i+1)+")") );
            
            Discursiva qD = new Discursiva();
            qD.setPergunta(pergunta);
            qD.setCriteriosCorrecao(criterioCorrecao);
            qD.setPeso(pesoQuestao);
            
            listaQuestoesDiscursivas[i] = qD;
        }
        x.setQuestoesDiscursivas(listaQuestoesDiscursivas);
        
        int qtdObjetivas = Integer.parseInt( JOptionPane.showInputDialog(""
                + "Digite a qtde. de questões objetivas") );
        Objetiva[] listaQuestoesObjetivas = new Objetiva[qtdObjetivas];
        for(int i = 0; i < qtdObjetivas; i++){
            String pergunta = JOptionPane.showInputDialog("Digite a PERGUNTA ("+(i+1)+")");
            int pesoQuestao = Integer.parseInt( JOptionPane.showInputDialog("Digite o PESO ("+(i+1)+")") );
            
            String[] alternativas = new String[5];
            for(int j = 0; j < 5; j++){
                alternativas[j] = JOptionPane.showInputDialog("Digite a alternativa "+(j+1)+" da questão ("+(i+1)+")");
            }
            int correta = Integer.parseInt( JOptionPane.showInputDialog("Digite a alternativa correta ("+(i+1)+")") );
            
            Objetiva qO = new Objetiva();
            qO.setPergunta(pergunta);
            qO.setPeso(pesoQuestao);
            qO.setOpcoes(alternativas);
            qO.setRespostaCorreta(correta);

            listaQuestoesObjetivas[i] = qO;
        }
        x.setQuestoesObjetivas(listaQuestoesObjetivas);
        
        
        String provaString = x.obtemProvaImpressao();
        System.out.println(provaString);
        
       
    }
    
}
