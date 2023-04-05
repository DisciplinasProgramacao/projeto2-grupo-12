package app;

public class GrafoCompleto extends Grafo {

    public GrafoCompleto(String nome, int ordem) {
        super(nome);
        int numVertices = ordem;

        for (int i = 0; i < numVertices; i++) {
            Vertice v = new Vertice(i + 1);
            for (int j = 0; j < numVertices; j++) {
                if (i != j) {
                    v.addAresta(j + 1);
                }
            }
            super.vertices.add(v.getId(), v);
        }

    }
}
