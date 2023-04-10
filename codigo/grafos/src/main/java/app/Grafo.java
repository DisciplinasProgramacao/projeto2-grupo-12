package app;

/** 
 * MIT License
 *
 * Copyright(c) 2021-23 João Caram <caram@pucminas.br>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

/**
 * Classe básica para um Grafo simples não direcionado.
 */
public abstract class Grafo {
    public String nome;
    protected ABB<Vertice> vertices;

    public Grafo grafoCompleto(int ordem) {
        Grafo grafoCompleto = grafoCompleto(ordem);
        return grafoCompleto;
    }

    /**
     * Construtor. Cria um grafo vazio com um nome escolhido pelo usuário. Em caso
     * de nome não informado
     * (string vazia), recebe o nome genérico "Grafo"
     */
    public Grafo(String nome) {

        if (nome.length() == 0)
            this.nome = "Grafo";
        else
            this.nome = nome;
        this.vertices = new ABB<>();
    }

    /**
     * Retorna o nome do grafo (string), caso seja necessário em outras
     * classes/sistemas
     * 
     * @return O nome do grafo (uma string)
     */
    public String nome() {
        return this.nome;
    }

    /**
     * Adiciona um vértice com o id especificado. Ignora a ação e retorna false se
     * já existir
     * um vértice com este id
     * 
     * @param id O identificador do vértice a ser criado/adicionado
     * @return TRUE se houve a inclusão do vértice, FALSE se já existia vértice com
     *         este id
     */
    public boolean addVertice(int id) {
        Vertice novo = new Vertice(id);
        return this.vertices.add(id, novo);
    }

    public Vertice removeVertice(int id) {
        return null;
    }

    public Vertice existeVertice(int idVertice) {
        for (int i = 0; i < vertices.size(); i++) {
            Vertice vertice = vertices.find(i);
            if (vertice.getId() == idVertice) {

                return vertice;
            }
        }

        return null;
    }

    /**
     * Adiciona uma aresta entre dois vértices do grafo, caso os dois vértices
     * existam no grafo.
     * Caso a aresta já exista, ou algum dos vértices não existir, o comando é
     * ignorado e retorna FALSE.
     * 
     * @param origem  Vértice de origem
     * @param destino Vértice de destino
     * @param peso    Peso da aresta
     * @return TRUE se foi inserida, FALSE caso contrário
     */
    public boolean addAresta(int origem, int destino, int peso) {
        boolean adicionou = false;
        Vertice saida = this.existeVertice(origem);
        Vertice chegada = this.existeVertice(destino);
        if (saida != null && chegada != null) {
            adicionou = (saida.addAresta(destino, peso) && chegada.addAresta(origem, peso));
        }
        return adicionou;

    }

    public boolean addAresta(int origem, int destino) {
        boolean adicionou = false;
        Vertice saida = this.existeVertice(origem);
        Vertice chegada = this.existeVertice(destino);
        if (saida != null && chegada != null) {
            adicionou = (saida.addAresta(destino) && chegada.addAresta(origem));
        }
        return adicionou;

    }

    public Aresta removeAresta(int origem, int destino) {
        return null;
    }

    public Aresta existeAresta(int verticeA, int verticeB) {
        Aresta aresta = new Aresta(1, verticeB);
        Aresta vArestas[];
        vArestas = new Aresta[tamanho()];
        vArestas = vertices.find(0).getArestas().allElements(vArestas);
        for (int i = 0; i < vArestas.length; i++) {
            if (aresta.destino() == (verticeB)) {
                return aresta;
            }
            vArestas = vertices.find(i).getArestas().allElements(vArestas);
        }
        return null;
    }

    public boolean completo() {
        int numVertices = vertices.size();

        for (int i = 1; i < numVertices; i++) {
            if (vertices.find(i).grau() != ordem() - 1)
                return false;
        }
        return true;
    }

    public Grafo subGrafo(Lista<Integer> vertices) {
        Grafo subgrafo = new GrafoNaoDirecionado("Subgrafo de " + this.nome);
        for (int i = 0; i < vertices.size(); i++) {
            for (int j = 0; j < vertices.size(); j++) {
                subgrafo.addAresta(i, j);
            }
        }

        return subgrafo;
    }

    public int tamanho() {
        return (ordem() * (ordem() - 1)) / 2;
    }

    public int ordem() {
        return vertices.size();
    }

    public void dfs(int idVerticeInicio) {

        Lista<Vertice> listaV = new Lista<Vertice>();
        Lista<Aresta> listaA = new Lista<Aresta>();
        Vertice v = vertices.find(idVerticeInicio);
        Aresta vArestas[];
        vArestas = new Aresta[tamanho()];
        listaV.add(v);
        Vertice verticeAtual = v;
        for (int i = 0; i < vertices.size(); i++) {
            if (verticeAtual.vizinhos().size() == 0) {
                i++;
            } else {
                vArestas = vertices.find(0).getArestas().allElements(vArestas);

                for (int j = 0; j < vArestas.length && vArestas != null; j++) {
                    Aresta a = existeAresta(verticeAtual.getId(), i);
                    if (!a.visitada()) {
                        a.visitar();
                        listaA.add(a);
                    }
                    vArestas = vertices.find(i).getArestas().allElements(vArestas);
                }
                verticeAtual = listaV.remove(i);
                if (!verticeAtual.visitado()) {
                    verticeAtual.visitar();
                }
            }

        }
    }

    public void bfs(int idVerticeInicio) {

        Lista<Vertice> lista = new Lista<Vertice>();
        Vertice v = vertices.find(idVerticeInicio);
        Lista<Integer> ListaVizinhos = new Lista<Integer>();
        Integer[] LVizinhosInt = new Integer[ListaVizinhos.size()];
        v.visitar();
        lista.add(v);

        while (!lista.equals(null)) {
            lista.remove(v.getId());
            ListaVizinhos = v.vizinhos();
            LVizinhosInt = ListaVizinhos.allElements(LVizinhosInt);
            for (int i = 0; i < v.vizinhos().size(); i++) {
                if (!vertices.find(LVizinhosInt[i]).visitado()) {
                    vertices.find(LVizinhosInt[i]).visitar();
                    lista.add(vertices.find(LVizinhosInt[i]));
                }
            }
        }
    }
}
