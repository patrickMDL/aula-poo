package com.deluca.aula.controledeabastecimento;

import android.content.Context;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystemAlreadyExistsException;
import java.util.ArrayList;

public class PostoDao {
    private static ArrayList<Posto> AL_CACHE = new ArrayList<Posto>();

    private static final String NOME_ARQUIVO="postos2.txt";

    private static boolean salvarNovo(Context c, Posto objeto){
        AL_CACHE.add(objeto);

        String salvar = "";
        salvar += objeto.getKm() + ";" ;
        salvar += objeto.getLitros() + ";";
        salvar += objeto.getData() + ";";
        salvar += objeto.getPosto() + "\n";

        File refArquivo = new File(c.getFilesDir().getPath() + NOME_ARQUIVO);
        try{
            FileWriter escritor = new FileWriter(refArquivo, true);
            escritor.write(salvar);
            escritor.close();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    private static boolean salvarEdicao (Context c, Posto aSerSalva){
        AL_CACHE.set(aSerSalva.getId(), aSerSalva);

        File refArquivo = new File (c.getFilesDir().getPath() + NOME_ARQUIVO);

        try{
            FileReader leitor = new FileReader(refArquivo);
            BufferedReader leitorDeLinha = new BufferedReader(leitor);

            String linhaPosto = null;

            String conteudoNovo = "";
            int numeroLinha =0;
            while((linhaPosto = leitorDeLinha.readLine()) != null) {
                if( aSerSalva.getId() == numeroLinha  ){
                    //essa linha tem que ser atualizada
                    String postoEmString = "";
                    postoEmString += aSerSalva.getPosto() + ";";
                    postoEmString += aSerSalva.getData() + ";";
                    postoEmString += aSerSalva.getId() + ";";
                    postoEmString += aSerSalva.getKm() + ";";
                    postoEmString += aSerSalva.getLitros() + "\n";
                }else{
                    //essa nao precisa fazer nada
                    conteudoNovo += linhaPosto + "\n";
                }
                numeroLinha++;
            }
            leitor.close();

            FileWriter escritor = new FileWriter(refArquivo, false);
            escritor.write( conteudoNovo );
            escritor.close();

        }catch (IOException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean salvar(Context c, Posto aSerSalva){
        if(aSerSalva.getId() == -1){
            Toast.makeText(c, "Salvo.", Toast.LENGTH_SHORT).show();
            return salvarNovo(c, aSerSalva);
        }else{
            Toast.makeText(c, "Editado.", Toast.LENGTH_SHORT).show();
            return salvarEdicao(c, aSerSalva);
        }
    }

    public static boolean excluir(Context c, Posto aSerExcluida){
        File refArquivo = new File( c.getFilesDir().getPath() + NOME_ARQUIVO );

        try {
            FileReader leitor = new FileReader(refArquivo);
            BufferedReader leitorDeLinha = new BufferedReader(leitor);

            String linhaPosto = null;

            String conteudoNovo = "";
            int numeroLinha = 0;
            while((linhaPosto = leitorDeLinha.readLine()) != null) {
                if( aSerExcluida.getId() != numeroLinha  ){
                    conteudoNovo += linhaPosto + "\n";
                }
                numeroLinha++;
            }
            leitor.close();

            FileWriter escritor = new FileWriter(refArquivo, false);
            escritor.write( conteudoNovo );
            escritor.close();

            getLista(c);

        }catch(IOException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static ArrayList<Posto> getLista(Context c){
        AL_CACHE = new ArrayList<>();

        File refArquivo = new File( c.getFilesDir().getPath() + NOME_ARQUIVO );

        try {
            FileReader leitor = new FileReader(refArquivo);
            BufferedReader leitorDeLinha = new BufferedReader(leitor);

            String linhaPosto = null;

            int numeroLinha = 0;
            while((linhaPosto = leitorDeLinha.readLine()) != null){

                String[] partesDaLinha = linhaPosto.split(";");
                Posto daVez = new Posto();
                daVez.setId( numeroLinha );
                daVez.setData( partesDaLinha[0] );
                daVez.setKm(Double.parseDouble( partesDaLinha[1] ));
                daVez.setLitros(Double.parseDouble( partesDaLinha[2] ));
                daVez.setPosto( partesDaLinha[3] );
                AL_CACHE.add(daVez);
                numeroLinha++;
            }


        } catch (IOException e) {
            e.printStackTrace();

        }
        return AL_CACHE;
    }

}
