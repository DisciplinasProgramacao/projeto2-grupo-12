package app;

public class GrafoDirecionado extends GrafoMutavel {


    

    public GrafoDirecionado(String nome) {

        super(nome);
    }

    @Override
    public boolean addAresta(int origem, int destino, int peso) {

        throw new UnsupportedOperationException("Unimplemented method 'addAresta'");
    }

    @Override
    public Aresta removeAresta(int origem, int destino) {

        throw new UnsupportedOperationException("Unimplemented method 'removeAresta'");
    }
    
}