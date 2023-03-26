package app;

import java.io.BufferedReader;
import java.io.FileReader;

public abstract class GrafoMutavel extends Grafo {


    public GrafoMutavel(String nome){

        super(nome);
    }

    // Implementar
    public boolean addVertice(int id) {

       return true; 
    }

    // Implementar
    public Vertice removeVertice(int id){
        return null;
    }

    public abstract boolean addAresta(int origem, int destino, int peso);

    public abstract Aresta removeAresta(int origem, int destino);

    public void carregar(String nomeArquivo){

        Lista linhasArquivo = new Lista<>();

        try {
            FileReader reader = new FileReader(nomeArquivo);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                linhasArquivo.add(line);
                System.out.println(line);
            }

            reader.close();
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }


    // Implementar
    public void salvar(String nomeArquivo) {

    }

    
    
}
