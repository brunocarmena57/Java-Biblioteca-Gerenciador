import java.util.Scanner;
import java.util.*;
import java.io.*;

public class App {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.cadastrar();

        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        while (continuar) {
            System.out.println("Menu:");
            System.out.println("1. Cadastrar novo usuário");
            System.out.println("2. Realizar empréstimo");
            System.out.println("3. Realizar devolução");
            System.out.println("4. Consultar acervo e usuários");
            System.out.println("5. Gerar relatórios");
            System.out.println("6. Salvar dados em arquivo");
            System.out.println("7. Carregar dados de arquivo");
            System.out.println("8. Sair");

            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do usuário:");
                    String nome = scanner.nextLine();

                    System.out.println("Digite o telefone do usuário:");
                    String telefone = scanner.nextLine();

                    System.out.println("Digite o endereço do usuário:");
                    String endereco = scanner.nextLine();

                    System.out.println("Digite o email do usuário:");
                    String email = scanner.nextLine();

                    biblioteca.cadastrarUsuario(nome, telefone, endereco, email);
                break;
                case 2:
                    try {
                        Usuario usuario = biblioteca.getUsuarios().get(0);
                        ItemBiblioteca item = biblioteca.getItens().get(0);
                        biblioteca.realizarEmprestimo(usuario, item);
                    } catch (Exception e) {
                        System.out.println("Erro ao realizar empréstimo: " + e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        Usuario usuario = biblioteca.getUsuarios().get(0);
                        ItemBiblioteca item = biblioteca.getItens().get(0);
                        biblioteca.realizarDevolucao(usuario, item);
                    } catch (Exception e) {
                        System.out.println("Erro ao realizar devolução: " + e.getMessage());
                    }
                    break;
                case 4:
                    biblioteca.consultar();
                    break;
                case 5:
                    biblioteca.gerarRelatorios();
                    break;
                case 6:
                    biblioteca.salvarDadosEmArquivo("dados_biblioteca.dat");
                    break;
                case 7:
                    Biblioteca biblioteca2 = new Biblioteca();
                    biblioteca2.carregarDadosDeArquivo("dados_biblioteca.dat");
                    biblioteca2.consultar();
                    biblioteca2.gerarRelatorios();
                    break;
                case 8:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }

        scanner.close();
    }
}
