/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg01.geradorprova;
import java.awt.HeadlessException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.PrintWriter;


/**
 *
 * @author 5678056
 */
public class GeradorProva {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArrayList<Questao> qList = new ArrayList<Questao>();
        
        String disciplina = JOptionPane.showInputDialog("Digite o nome da disciplina: ");
        Prova prova = new Prova(disciplina);
        
        prova.setData(JOptionPane.showInputDialog("Digite a data da prova"));
        while(true){
            try{
                prova.setPeso(Integer.parseInt(JOptionPane.showInputDialog("Digite o peso da prova: ")));
                if(prova.getPeso()<=0)
                    throw new IllegalArgumentException();
                break;
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, e.getMessage() + "\nDigite novemente.");
                continue;
            }catch(IllegalArgumentException a){
                JOptionPane.showMessageDialog(null, "Peso precisa ser maior que zero." + "\nDigite novamente");
            }
        }
        String continuar = new String ();
        ArrayList<Questao> aux = new ArrayList<Questao>();
        do{
            String opcao = new String();        
            do{
                opcao = JOptionPane.showInputDialog("Digite D para Discursiva ou O para Objetiva: ");
                if(opcao.compareTo("O")!=0 && opcao.compareTo("o")!=0 && 
                        opcao.compareTo("D")!=0 && opcao.compareTo("d")!=0) 
                        JOptionPane.showInputDialog(null, "Tipo de questao nao identificado.");
                
            }while(opcao.compareTo("O")!=0 && opcao.compareTo("o")!=0 && 
                       opcao.compareTo("D")!=0 && opcao.compareTo("d")!=0);
            if(opcao.compareTo("O")==0 || opcao.compareTo("o")==0){
                Objetiva aux2 = new Objetiva();
                aux2.setPergunta(JOptionPane.showInputDialog("Digite a questão objetiva: "));
                while(true){
                    try{
                        aux2.setPeso(Double.parseDouble(JOptionPane.showInputDialog("Digite o peso da questão: ")));
                        break;
                    }catch(Exception a){
                        JOptionPane.showInputDialog(null, a.getMessage()+ "Digite novamente.");
                    }
                }
                String[] alternativas = new String[5];
                for(int i=0; i<5; i++){
                    alternativas[i] = JOptionPane.showInputDialog("Digite a alternativa "+(i+1)+": ");
                }
                aux2.setOpcoes(alternativas);
                
                while(true){
                    try{
                        aux2.setRespostaCorreta((Integer.parseInt(JOptionPane.showInputDialog("Digite a alternativa correta: "))));
                        if(aux2.getRespostaCorreta()<1 || aux2.getRespostaCorreta()>5)
                            throw new IllegalArgumentException();
                        break;
                    }catch(NumberFormatException a){
                        JOptionPane.showInputDialog(null, a.getMessage() + "\nDigite novamente.");
                    }catch(IllegalArgumentException e){
                        JOptionPane.showInputDialog(null, "Alternativa correta precisa estar entre 0 e 4." 
                                + "\nDigite novamente.");
                    }
                }
                aux.add(aux2);
            }else{
                Discursiva aux2 = new Discursiva();
                aux2.setPergunta(JOptionPane.showInputDialog("Digite a questão discursiva: "));
                while(true){
                    try{
                        aux2.setPeso(Double.parseDouble(JOptionPane.showInputDialog("Digite o peso da questão: ")));
                        break;
                    }
                    catch(Exception a){
                        JOptionPane.showMessageDialog(null, a.getMessage() + "\nDigite novamente. ");
                    }
                }
                aux2.setCriteriosCorrecao(JOptionPane.showInputDialog("Digite o critério de correção: "));
                aux.add(aux2);
                
        }
            continuar = JOptionPane.showInputDialog("Deseja adicionar mais uma questão? ");
        
        }while (continuar.compareTo("S")==0 || continuar.compareTo("s")==0 || 
                continuar.compareTo("sim")==0 || continuar.compareTo("Sim")==0 ||
                continuar.compareTo("SIM")==0);
        String nomeArquivo = JOptionPane.showInputDialog("Digite o nome que deseja salvar o arquivo: "); 
        prova.setQuestoes(aux);
        
        while (true){
            try{
                nomeArquivo = JOptionPane.showInputDialog("Digite o nome do arquivo: ");
                FileReader leitor = new FileReader(nomeArquivo+".txt");
                String opcao = JOptionPane.showInputDialog("Arquivo ja existe. \nDeseja sobreescreve-lo: S/N");
                if(opcao.compareTo("s")==0 || opcao.compareTo("S")==0)
                    throw new Exception();
                continue;
            }catch(Exception e){
                break;
            }
        }
        try{
            File arquivo = new File(nomeArquivo+".txt");
            FileWriter escritor = new FileWriter(arquivo);
            PrintWriter saida;
            saida = new PrintWriter(escritor);
            saida.println(prova.obtemProvaImpressao());
            saida.close();
            JOptionPane.showMessageDialog(null, "Arquivo salvo com sucesso.");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Falha ao salvar em arquivo.");

        }
    }
    
}
