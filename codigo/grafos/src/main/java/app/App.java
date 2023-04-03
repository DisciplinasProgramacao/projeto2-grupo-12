package app;

/**
 * Hello world!
 */
public final class App {
    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        
        GrafoMutavel g = new GrafoNaoDirecionado("Teste");
            
        

        String nomeArquivo = "D:\\Projetos Java\\LPM\\projeto2-grupo-12\\codigo\\grafos\\graph-test-100.txt";

        g.carregar(nomeArquivo);
    }
}
