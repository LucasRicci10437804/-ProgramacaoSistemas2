import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppStreaming {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Midia> midias = new ArrayList<>();
        int opcao;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("(1) Adicionar novo Filme");
            System.out.println("(2) Adicionar nova Série");
            System.out.println("(3) Listar todas as mídias");
            System.out.println("(4) Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); // consumir quebra de linha

            switch (opcao) {
                case 1:
                    System.out.print("Título do filme: ");
                    String tituloFilme = sc.nextLine();
                    System.out.print("Duração (min): ");
                    long duracaoFilme = sc.nextLong();
                    Filme filme = new Filme(tituloFilme, duracaoFilme);
                    midias.add(filme);
                    break;

                case 2:
                    System.out.print("Título da série: ");
                    String tituloSerie = sc.nextLine();
                    Serie serie = new Serie(tituloSerie);

                    // adicionar 2 temporadas
                    for (int t = 1; t <= 2; t++) {
                        Temporada temporada = new Temporada(t);

                        // adicionar 2 episódios
                        for (int e = 1; e <= 2; e++) {
                            System.out.print("Título do episódio " + e + " da temporada " + t + ": ");
                            String tituloEp = sc.nextLine();
                            System.out.print("Duração (min): ");
                            long duracaoEp = sc.nextLong();
                            sc.nextLine(); // consumir quebra de linha
                            Episodio episodio = new Episodio(tituloEp, duracaoEp);
                            temporada.adicionar(episodio);
                        }
                        serie.adicionar(temporada);
                    }
                    midias.add(serie);
                    break;

                case 3:
                    System.out.println("\n--- MÍDIAS CADASTRADAS ---");
                    for (Midia m : midias) {
                        System.out.println(m.info());
                    }
                    break;

                case 4:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 4);

        sc.close();
    }
}
