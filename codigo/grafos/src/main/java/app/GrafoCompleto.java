package app;

import java.util.ArrayList;

public class GrafoCompleto extends Grafo{

    public GrafoCompleto(String nome) {
        super(nome);
        //this.ordem();
    }

    public Grafo grafoCompleto(int ordem){
        int numVertices = ordem;
        ArrayList<Integer> adjLista[] = new ArrayList[numVertices];
        for (int i = 0; i < numVertices; i++) {
            adjLista[i] = new ArrayList<Integer>();
            for (int j = 0; j < numVertices; j++) {
                if (i != j) {
                    adjLista[i].add(j);
                }
            }
        }
        Grafo g = new Grafo("GrafoCompleto"){
            
        };
        return g;
    }
    
   
}
