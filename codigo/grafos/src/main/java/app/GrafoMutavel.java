package app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public abstract class GrafoMutavel extends Grafo {

    private ABB<Vertice> vertices; // *Duvida

    public GrafoMutavel(String nome) {

        super(nome);
    }

    /**
     * Adiciona um vértice com o id especificado. Ignora a ação e retorna false se
     * já existir um vértice com este id
     * 
     * @param id O identificador do vértice a ser criado/adicionado
     * @return TRUE se houve a inclusão do vértice, FALSE se já existia vértice com
     *         este id
     */
    public boolean addVertice(int id) {
        Vertice novo = new Vertice(id);
        return this.vertices.add(id, novo);
    }

    /**
     * Remove um vértice com o id especificado. Ignora a ação e retorna false se
     * já existir um vértice com este id
     * 
     * @param id O identificador do vértice a ser criado/adicionado
     * @return TRUE se houve a inclusão do vértice, FALSE se já existia vértice com
     *         este id
     */
    public Vertice removeVertice(int id) {

        return this.vertices.remove(id);
    }

    public abstract boolean addAresta(int origem, int destino, int peso); // *Duvida

    public abstract Aresta removeAresta(int origem, int destino); // *Duvida

    /**
     * Carrega o grafo de um arquivo .txt na memória
     * 
     * @param nomeArquivo Nome do arquivo que se deseja retirar a informação
     */
    public void carregar(String nomeArquivo) {

        Lista<String> linhasArquivo = new Lista<String>();

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

    /**
     * Salva as informações de um grafo em um arquivo .txt
     * @param nomeArquivo
     * @throws Exception Se não existir o arquivo
     */
    public void salvar(String nomeArquivo) throws Exception {

        int numVertices = this.vertices.size();
        int somaGraus = 0;
        Vertice[] arrVertices = new Vertice[numVertices]; // Criando um array de V de tamanho igual a quantidade de V
        arrVertices = this.vertices.allElements(arrVertices); // preenchendo o array com todos os V

        for (Vertice v : arrVertices) {
            somaGraus += v.grau(); // somando todos os graus de todos os V
        }

        int numArestas = somaGraus / 2; // dividindo a soma por 2, para obter o numero de arestas

        BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo));

        writer.write(numVertices);
        writer.write(" " + numArestas);

        for (int i = 0; i < numArestas; i++) {
            Aresta[] arrArestas = new Aresta[arrVertices[i].getArestas().size()]; // para cada V, criar um array de
                                                                                  // tamanho igual ao numero de arestas
                                                                                  // que aquele V possui
            arrArestas = arrVertices[i].getArestas().allElements(arrArestas); // preenchendo o array com todos as
                                                                              // arestas daquele V
            for (int j = 0; j < arrVertices[i].getArestas().size(); j++) {
                writer.write("\n       " + arrVertices[i] + "      " + arrArestas[j].destino()); // salvando no arquivo
                                                                                                 // o V e o destino da
                                                                                                 // aresta
            }

        }

        writer.close();

    }

}
