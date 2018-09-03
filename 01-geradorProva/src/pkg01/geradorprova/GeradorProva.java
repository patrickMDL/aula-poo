/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg01.geradorprova;
import java.util.Scanner;

/**
 *
 * @author 5678056
 */
public class GeradorProva {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner dado = new Scanner (System.in); //Ler os dados e passar para as variaveis;
        String nome=null, data=null, local=null;
        int pesoProva,pesoDiscursiva=0, pesoObjetiva=0, n=0;
        System.out.println("Digite o nome da disciplina: ");
        nome=dado.nextLine();
        System.out.println("Digite a data da prova: ");
        data=dado.nextLine();
        System.out.println("Digite o local da prova: ");
        local=dado.nextLine();
        System.out.println("Digite o peso da prova:");
        pesoProva=dado.nextInt();
        
        Prova x = new Prova(nome);
        x.setData(data);
        x.setLocal(local);
        x.setPeso(pesoProva);
        x.setnQuestoes(n);
        
        String lixo=null;//para receber lixo do nextInt '/n' ;
        lixo=dado.nextLine();//Serve para limpar e nao dar erro no proximo nextLine;
        
        System.out.println("Numero de questoes discursivas: ");
        n=dado.nextInt(); 
        lixo=dado.nextLine(); //Serve para limpar e nao dar erro no proximo nextLine;
        
        Discursiva[] d=new Discursiva[n];
        String perguntaDiscursiva = null, correcao=null;
        //Solicitar informacoes questoes discursivas;
        for (int i=0; i<n; i++){
            System.out.println("Peso da pergunta: ");
            pesoDiscursiva=dado.nextInt();
            lixo=dado.nextLine(); //Serve para limpar e nao dar erro no proximo nextLine;
            System.out.println("Digite a pergunta: ");
            perguntaDiscursiva=dado.nextLine();
            System.out.println("Digite o criterio de correcao: ");
            correcao=dado.nextLine();
            
            d[i].setPeso(pesoDiscursiva);
            d[i].setCriteriosCorrecao(correcao);
            d[i].setPergunta(perguntaDiscursiva);
        }
        x.b=d;
        String[] opcoes= new String[5];
        String perguntaObjetiva=null;
        Objetiva[] o=new Objetiva[n];
        int opcaocerta=0;
        for (int i=0; i<n; i++){
            System.out.println("Peso da pergunta: ");
            pesoObjetiva=dado.nextInt();
            lixo=dado.nextLine(); //Serve para limpar e nao dar erro no proximo nextLine;
            System.out.println("Digite a pergunta: ");
            perguntaObjetiva=dado.nextLine();
            System.out.println("Alternativa a: ");
            opcoes[0]=dado.nextLine();
            System.out.println("Alternativa b: ");
            opcoes[1]=dado.nextLine();
            System.out.println("Alternativa c: ");
            opcoes[2]=dado.nextLine();
            System.out.println("Alternativa d: ");
            opcoes[3]=dado.nextLine();
            System.out.println("Alternativa e: ");
            opcoes[4]=dado.nextLine();
            System.out.println("Digite a opcao correta: ");
            opcaocerta=dado.nextInt();
            lixo=dado.nextLine(); //Serve para limpar e nao dar erro no proximo nextLine;

        }
        x.a=o;
        
        //Prova x=new Prova();

        //Forma didática
        //String retornoDoMetodo = x.obtemDetalhes();
        //System.out.println(retornoDoMetodo);
        
        //Forma resumida
        //System.out.println(x.obtemDetalhes());
        
        
        
        
    }
    
}
