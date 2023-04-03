package app;

public class GrafoNaoDirecionado extends GrafoMutavel {



    public GrafoNaoDirecionado(String nome) {

        super(nome);
    }

    //Implementar

    @Override
    public boolean addAresta(int origem, int destino, int peso) {
   
        throw new UnsupportedOperationException("Unimplemented method 'addAresta'");
    }

    //Implementar

    @Override
    public Aresta removeAresta(int origem, int destino) {

        throw new UnsupportedOperationException("Unimplemented method 'removeAresta'");
    }
    
}
