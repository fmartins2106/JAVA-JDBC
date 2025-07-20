package academy.devdojo.maratonajava.introducao;

import java.util.Scanner;
import java.util.Random;

public class exemploDeComoOrganizarVariosCodigos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Jogo de Par ou Ímpar
        jogarParOuImpar(scanner, random);

        // Cadastro de pessoas
        cadastrarPessoas(scanner);

        // Análise de compras
        analisarCompra(scanner);

        // Caixa eletrônico
        simularCaixaEletronico(scanner);

        scanner.close();
    }

    // Jogo de Par ou Ímpar
    public static void jogarParOuImpar(Scanner scanner, Random random) {
        while (true) {
            System.out.print("Digite um número: ");
            int jogador = scanner.nextInt();
            scanner.nextLine();  // Limpar o buffer do scanner

            System.out.print("Você quer PAR ou IMPAR? [Digite P ou I]: ");
            String pi = scanner.nextLine().trim().toLowerCase();

            // Verificação de entrada válida (P ou I)
            while (!pi.equals("p") && !pi.equals("i")) {
                System.out.print("ERRO! Digite P ou I para continuar! Você quer Par(P) ou Impar(I)?: ");
                pi = scanner.nextLine().trim().toLowerCase();
            }

            // Jogo
            int computador = random.nextInt(10) + 1;
            int soma = computador + jogador;

            // Verificação de quem ganhou
            if (soma % 2 == 0 && pi.equals("p")) {
                System.out.printf("Você escolheu %s, jogou %d e o computador jogou %d = %d. Você ganhou!%n", pi, jogador, computador, soma);
            } else if (soma % 2 != 0 && pi.equals("i")) {
                System.out.printf("Você escolheu %s, jogou %d e o computador jogou %d = %d. Você ganhou!%n", pi, jogador, computador, soma);
            } else if (soma % 2 == 0 && pi.equals("i")) {
                System.out.printf("Você escolheu %s, jogou %d e o computador jogou %d = %d. Você perdeu!%n", pi, jogador, computador, soma);
            } else if (soma % 2 != 0 && pi.equals("p")) {
                System.out.printf("Você escolheu %s, jogou %d e o computador jogou %d = %d. Você perdeu!%n", pi, jogador, computador, soma);
            }

            // Pergunta se o jogador quer jogar novamente
            System.out.print("Quer jogar novamente? (S/N): ");
            String jogarNovamente = scanner.nextLine().trim().toLowerCase();
            if (!jogarNovamente.equals("s")) {
                break;  // Se o jogador não quiser jogar mais, sai do loop
            }
        }
    }

    // Cadastro de pessoas
    public static void cadastrarPessoas(Scanner scanner) {
        int totalHomens = 0;
        int mulheresMenos20 = 0;
        int totalMaior18 = 0;

        System.out.println("Vamos cadastrar pessoas!");
        while (true) {
            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("Idade: ");
            int idadePessoa = scanner.nextInt();
            scanner.nextLine();  // Limpar o buffer do scanner

            System.out.print("Sexo? [M/F]: ");
            char sexoPessoa = scanner.nextLine().trim().toLowerCase().charAt(0);

            // Verifica se o sexo é válido
            while (sexoPessoa != 'f' && sexoPessoa != 'm') {
                System.out.println("ERRO! Digite M ou F para cadastrar o sexo!");
                System.out.print("Sexo?: ");
                sexoPessoa = scanner.nextLine().trim().toLowerCase().charAt(0);
            }

            System.out.print("Quer continuar? [S/N]: ");
            String seguir = scanner.nextLine().trim().toLowerCase();

            // Verifica se a entrada para continuar é válida
            while (!seguir.equals("s") && !seguir.equals("n")) {
                System.out.print("ERRO! Digite S ou N para continuar! Quer continuar?: ");
                seguir = scanner.nextLine().trim().toLowerCase();
            }

            // Contabiliza as pessoas conforme a condição
            if (idadePessoa >= 18) {
                totalMaior18++;
            }
            if (sexoPessoa == 'm') {
                totalHomens++;
            }
            if (sexoPessoa == 'f' && idadePessoa <= 20) {
                mulheresMenos20++;
            }

            // Exibe os resultados e sai se o usuário não quiser continuar
            if (seguir.equals("n")) {
                System.out.printf("O total de pessoas maiores de idade: %d%n", totalMaior18);
                System.out.printf("Pessoas sexo Masculino: %d%n", totalHomens);
                System.out.printf("Mulheres com menos de 20 anos: %d%n", mulheresMenos20);
                break;
            }
        }
    }

    // Análise de compras
    public static void analisarCompra(Scanner scanner) {
        System.out.println("Vamos verificar a sua compra");
        double totalCompra = 0;
        int totalMaisMil = 0;
        double menorValor = Double.POSITIVE_INFINITY;
        String menorNomeProduto = "";

        while (true) {
            System.out.print("Digite o nome do produto: ");
            String nomeProduto = scanner.nextLine();

            System.out.print("Digite o valor do produto: R$");
            double valorProduto = scanner.nextDouble();
            scanner.nextLine();  // Limpar o buffer do scanner

            if (valorProduto > 0) {
                totalCompra += valorProduto;
            }
            if (valorProduto >= 1000) {
                totalMaisMil++;
            }
            if (valorProduto < menorValor) {
                menorValor = valorProduto;
                menorNomeProduto = nomeProduto;
            }

            // Pergunta se o usuário deseja continuar comprando
            System.out.print("Quer continuar? [S/N]: ");
            String continuar = scanner.nextLine().trim().toLowerCase();
            while (!continuar.equals("s") && !continuar.equals("n")) {
                System.out.println("Erro, digite S ou N para continuar!");
                System.out.print("Quer continuar?: ");
                continuar = scanner.nextLine().trim().toLowerCase();
            }

            // Exibe as informações da compra e sai se o usuário não quiser continuar
            if (continuar.equals("n")) {
                System.out.println("O total da compra: R$" + totalCompra);
                System.out.println("Compras acima de R$1000: " + totalMaisMil);
                System.out.println("Menor produto comprado: " + menorNomeProduto + " de R$" + menorValor);
                break;
            }
        }
    }

    // Simulação de caixa eletrônico
    public static void simularCaixaEletronico(Scanner scanner) {
        System.out.println("Vamos simular um caixa eletrônico");
        System.out.print("Digite quanto quer sacar: R$");
        int saque = scanner.nextInt();
        int total = saque;
        int ced = 50;
        int totalCed = 0;

        // Processa o saque em cédulas
        while (true) {
            if (saque >= ced) {
                saque -= ced;
                totalCed++;
            } else {
                if (totalCed > 0) {
                    System.out.println("Total de " + totalCed + " de R$" + ced);
                }
                if (ced == 50) {
                    ced = 20;
                } else if (ced == 20) {
                    ced = 10;
                } else if (ced == 10) {
                    ced = 5;
                } else if (ced == 5) {
                    ced = 1;
                }
                totalCed = 0;
                if (saque <= 0) {
                    break;
                }
            }
        }
    }
}
