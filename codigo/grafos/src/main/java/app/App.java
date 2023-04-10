package app;

import java.util.Scanner;


public final class App {
    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {

        menu();


        //System.out.println(g.completo());
        
        //String nomeArquivo = "D:\\Projetos Java\\LPM\\projeto2-grupo-12\\codigo\\grafos\\graph-test-100.txt";
        // g.carregar(nomeArquivo);
    }

    public static void menu() {

        

        int op;
        do {

            System.out.println("Selecione uma opção:");
            System.out.println("1 - Fazer um grafo completo");
            System.out.println("0 - Sair");
            op = entrada.nextInt();
            switch (op) {
                case 1:
                    System.out.println("Opção 1 selecionada.");
                    criarGrafoCompleto();
                    break;
              
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (op  != 0);
    }

    public static void subMenu(GrafoCompleto g){

       

        int op;
        do {

            System.out.println("Você gostaria de testar se esse grafo realmente é completo?");
            System.out.println("1 - Sim");
            System.out.println("2 - Não");
            op = entrada.nextInt();
            switch (op) {
                case 1:
                    System.out.println("Opção 1 selecionada.");
                    if(g.completo()) {
                        System.out.println("Esse grafo é completo.");
                    } else {
                        System.out.println("Esse grafo não é completo.");
                    }
                    break;
                case 2:
                    
                    break;
              
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (op  != 2);

    }

    public static void criarGrafoCompleto() {

        System.out.println("Digite o nome do Grafo:");
        String nome = entrada.nextLine();

        entrada.nextLine();

        System.out.println("Digite o número de vértices:");
        int nVertices = entrada.nextInt();

        
        GrafoCompleto g = new GrafoCompleto(nome, nVertices);

        subMenu(g);
    }
}
