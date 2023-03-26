package app;

import java.io.BufferedReader;
import java.io.FileReader;

public abstract class GrafoMutavel extends Grafo {

    private ABB<Vertice> vertices;  // *Duvida

    public GrafoMutavel(String nome){

        super(nome);
    }

    // Implementar *Duvida

    public boolean addVertice(int id){
        Vertice novo = new Vertice(id);
        return this.vertices.add(id, novo);
    }

    // Implementar *Duvida

    public Vertice removeVertice(int id){
        
        return this.vertices.remove(id);
    }

    public abstract boolean addAresta(int origem, int destino, int peso);       // *Duvida

    public abstract Aresta removeAresta(int origem, int destino);               //  *Duvida

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
