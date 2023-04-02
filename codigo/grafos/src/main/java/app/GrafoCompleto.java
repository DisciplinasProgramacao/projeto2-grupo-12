package app;

public class GrafoCompleto extends Grafo {

    public GrafoCompleto(String nome) {
        super(nome);
    }

    public Grafo grafoCompleto(int ordem) {
        int numVertices = ordem;
        Grafo g = new Grafo("GrafoCompleto") {
        };

        for (int i = 0; i < numVertices; i++) {
            g.addVertice(i);
            for (int j = 0; j < numVertices; j++) {
                if (i != j) {
                   g.addAresta(i, j);
                } 
            }
        }
        return g;
    }

}
