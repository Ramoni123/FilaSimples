import java.util.Scanner;

public class Executor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FilaSimples fila = new FilaSimples(10); // Capacidade inicial de 10
        boolean continuar = true;

        while (continuar) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Adicionar elemento");
            System.out.println("2 - Remover elemento");
            System.out.println("3 - Remover todas ocorrências de um elemento");
            System.out.println("4 - Listar elementos");
            System.out.println("5 - Confirmar elemento");
            System.out.println("6 - Maior elemento");
            System.out.println("7 - Menor elemento");
            System.out.println("8 - Média dos elementos");
            System.out.println("9 - Quantidade de elementos");
            System.out.println("10 - Aumentar capacidade");
            System.out.println("11 - Sair");

            int escolha = scanner.nextInt();
            switch (escolha) {
                case 1:
                    System.out.print("Digite o elemento a ser adicionado: ");
                    int elemento = scanner.nextInt();
                    fila.enfileirar(elemento);
                    break;
                case 2:
                    try {
                        int removido = fila.desenfileirar();
                        System.out.println("Elemento removido: " + removido);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.print("Digite o elemento a ser removido: ");
                    int elemRemover = scanner.nextInt();
                    fila.removerTodasOcorrencias(elemRemover);
                    System.out.println("Todas ocorrências de " + elemRemover + " foram removidas.");
                    break;
                case 4:
                    System.out.print("Elementos na fila: ");
                    fila.listar();
                    break;
                case 5:
                    System.out.print("Digite o elemento a ser buscado: ");
                    int elemBuscar = scanner.nextInt();
                    boolean encontrado = fila.buscar(elemBuscar);
                    System.out.println("Elemento " + (encontrado ? "encontrado." : "não encontrado."));
                    break;
                case 6:
                    try {
                        System.out.println("Maior elemento: " + fila.maior());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 7:
                    try {
                        System.out.println("Menor elemento: " + fila.menor());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 8:
                    try {
                        System.out.println("Média dos elementos: " + fila.media());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 9:
                    System.out.println("Quantidade de elementos: " + fila.quantidade());
                    break;
                case 10:
                    System.out.print("Digite a nova capacidade: ");
                    int novaCapacidade = scanner.nextInt();
                    try {
                        fila.aumentarCapacidade(novaCapacidade);
                        System.out.println("Capacidade aumentada para " + novaCapacidade + ".");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 11:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Erro ao pausar a execução");
            }
        }

        scanner.close();
    }
}