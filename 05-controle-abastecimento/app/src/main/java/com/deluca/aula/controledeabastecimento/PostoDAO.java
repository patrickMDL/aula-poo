package com.deluca.aula.controledeabastecimento;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class PostoDAO {
    private static ArrayList<Posto> AL_CACHE = new ArrayList<>();

    private static final String NOME_ARQUIVO = "posto1.txt";

    private static boolean salvarNovo(Context c, Posto aSerSalvo){
        aSerSalvo.setId(AL_CACHE.size());
        AL_CACHE.add(aSerSalvo);

        String postoEmString = "";
        postoEmString += aSerSalvo.getPosto() + ";";
        postoEmString += aSerSalvo.getData() + ";";
        postoEmString += aSerSalvo.getLitros() + ";";
        postoEmString += aSerSalvo.getKilometros() + "\n" ;

        File refArquivo = new File (c.getFilesDir().getPath() + NOME_ARQUIVO);
        try{
            FileWriter escritor = new FileWriter(refArquivo, true);
            escritor.write(postoEmString);
            escritor.close();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    private static boolean salvarEdicao(Context c, Posto aSerSalvo){
        AL_CACHE.set(aSerSalvo.getId(), aSerSalvo);
        File refArquivo = new File(c.getFilesDir().getPath() + NOME_ARQUIVO);
        try{
            FileReader leitor = new FileReader(refArquivo);
            BufferedReader leitorDeLinha = new BufferedReader(leitor);

            String linhaPosto=null;

            String conteudoNovo = "";

            int numeroLinha =0;
            while ((linhaPosto = leitorDeLinha.readLine())!=null){
                if (aSerSalvo.getId()==numeroLinha){
                    String postoEmString = "";
                    postoEmString += aSerSalvo.getPosto() + ";";
                    postoEmString += aSerSalvo.getData() + ";";
                    postoEmString += aSerSalvo.getLitros() + ";";
                    postoEmString += aSerSalvo.getKilometros() + ";";

                    conteudoNovo += postoEmString;
                }else{
                    conteudoNovo+=linhaPosto + "\n";
                }
                numeroLinha++;
            }
            leitor.close();

            FileWriter escritor = new FileWriter(refArquivo, false);
            escritor.write(conteudoNovo);
            escritor.close();

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean salvar (Context c, Posto aSerSalvo){
        if(aSerSalvo.getId() == -1){
            Toast.makeText(c, "Salvo.", Toast.LENGTH_SHORT);
            return salvarNovo(c, aSerSalvo);
        }else{
            Toast.makeText(c,"Editado.", Toast.LENGTH_SHORT);
            return salvarEdicao(c, aSerSalvo);
        }
    }

    public static boolean excluir (Context c, Posto aSerExcluido){
        File refArquivo = new File (c.getFilesDir().getPath() + NOME_ARQUIVO);

        try{
            FileReader leitor = new FileReader( refArquivo);
            BufferedReader leitorDeLinha = new BufferedReader(leitor);

            String linhaPosto = null;

            String conteudoNovo = "";
            int numeroLinha = 0;

            while((linhaPosto = leitorDeLinha.readLine())!= null){
                if (aSerExcluido.getId() != numeroLinha){
                    conteudoNovo +=linhaPosto + "\n";
                }
                numeroLinha++;
            }
            leitor.close();

            FileWriter escritor = new FileWriter(refArquivo, false);
            escritor.write(conteudoNovo);
            escritor.close();

            getLista(c);

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static ArrayList<Posto> getLista(Context c){
        AL_CACHE =  new ArrayList<>();

        File refArquivo = new File(c.getFilesDir().getPath() + NOME_ARQUIVO);

        try{
            FileReader leitor = new FileReader (refArquivo);
            BufferedReader leitorDeLinha = new BufferedReader(leitor);

            String linhaPosto = null;

            int numeroLinha=0;
            while ((linhaPosto = leitorDeLinha.readLine())!= null){

                String[] partesDaLinha = linhaPosto.split(";");

                Posto daVez = new Posto();
                daVez.setId(numeroLinha);
                daVez.setPosto(partesDaLinha[0]);
                daVez.setData(partesDaLinha[1]);
                daVez.setLitros(Double.parseDouble(partesDaLinha[2]));
                daVez.setKilometros(Double.parseDouble(partesDaLinha[3]));
                AL_CACHE.add(daVez);
                numeroLinha++;
            }


        }catch (Exception e){
            e.printStackTrace();
        }
        return AL_CACHE;
    }

}
