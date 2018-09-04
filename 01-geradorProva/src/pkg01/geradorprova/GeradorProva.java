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
        
        
        String nome = JOptionPane.showInputDialog("Digite o nome da disciplina: ");
        String data= JOptionPane.showInputDialog("Digite a data da prova");
        String local=JOptionPane.showInputDialog("Digite o local da prova");
        int peso = Integer.parseInt(JOptionPane.showInputDialog(""
                + "Digite o peso da prova "));

        Prova x = new Prova(nome);
        x.setData(data);
        x.setLocal(local);
        x.setPeso(peso);

        int n = Integer.parseInt(JOptionPane.showInputDialog(""
                + "Digite o qtd de questoes discursivas"));
        
        //Solicitar informacoes questoes discursivas;
        Discursiva[] listaQuestoesDiscursivas;
        listaQuestoesDiscursivas = new Discursiva[n];
        for (int i=0; i<n; i++){
            int pesoQuestao = Integer.parseInt(JOptionPane.showInputDialog("" + "Digite o peso da pergunta"));
            String pergunta=JOptionPane.showInputDialog("Digite a pergunta:");
            String correcao=JOptionPane.showInputDialog("Digite o Critério de Correção:");
            Discursiva qD = new Discursiva();
            qD.setPergunta(pergunta);
            qD.setCriteriosCorrecao(correcao);
            qD.setPeso(pesoQuestao);

            listaQuestoesDiscursivas[i]=qD;
        }
        x.setQuestoesDiscursivas(listaQuestoesDiscursivas);
        int n2 = Integer.parseInt(JOptionPane.showInputDialog(""
                + "Digite o qtd de questoes objetivas"));
        Objetiva[] listaObjetiva;
        listaObjetiva = new Objetiva[n];
        for (int i=0; i<n2; i++){
            int pesoQuestao = Integer.parseInt(JOptionPane.showInputDialog("" + "Digite o peso da pergunta"));
            String pergunta=JOptionPane.showInputDialog("Digite a pergunta:");
            String[] alternativa = new String[5];
            for(int j=0; j<5; j++){
                alternativa[j]=JOptionPane.showInputDialog("Digite a alternativa " +(j+1)+" da questão");
            }
            int opcaocorreta=Integer.parseInt(JOptionPane.showInputDialog("Digite a resposta correta:"));
            Objetiva oQ =new Objetiva();
            oQ.setOpcoes(alternativa);
            oQ.setPergunta(pergunta);
            oQ.setPeso(pesoQuestao);
            oQ.setRespostaCorreta(opcaocorreta);
            
           listaObjetiva[i]=oQ;
        }
        x.setQuestoesObjetivas(listaObjetiva);
        String provaString = x.obtemProvaImpressao();
        System.out.println(provaString);
        
        
    }
    
}
