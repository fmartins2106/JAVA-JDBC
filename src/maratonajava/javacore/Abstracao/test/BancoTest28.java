package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class BancoTest28 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco28 banco28 = new Banco28();

        while (true){
            System.out.println("[1] Cadastro conta.");
            System.out.println("[2] Lista de contas cadastradas.");
            System.out.println("[3] Pesquisa por número de conta.");
            System.out.println("[4] Depósito.");
            System.out.println("[5] Saque.");
            System.out.println("[6] Bloquear conta.");
            System.out.println("[7] Desbloquear conta.");
            System.out.println("[8] Cancelar conta.");
            System.out.println("[9] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        cadastroConta(scanner,banco28);
                        break;
                    case 2:
                        banco28.listarContasCadastradas();
                        break;
                    case 3:
                        banco28.exibirDadosPesquisaNumeroConta(scanner);
                        break;
                    case 4:
                        banco28.validandoDeposito(scanner);
                        break;
                    case 5:
                        banco28.validandoSaque(scanner);
                        break;
                    case 6:
                        banco28.alterarStatusConta(scanner,"bloquear");
                        break;
                    case 7:
                        banco28.alterarStatusConta(scanner,"desbloquear");
                        break;
                    case 8:
                        banco28.alterarStatusConta(scanner,"cancelar");
                        break;
                    case 9:
                        System.out.println(">>>Finalizando programa...");
                        return;
                    default:
                        System.out.println("Digite uma opção válido.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void cadastroConta(Scanner scanner, Banco28 banco28){
        String nome = Banco28.validandoNome(scanner);
        String cpf = Banco28.validandoCpf(scanner);
        int numeroConta = Banco28.validandoNumeroConta(scanner);
        Conta28.TipoConta28 tipoConta28 = Banco28.validandoTipoConta(scanner);
        Cliente28 cliente28 = new Cliente28(nome,cpf);
        Conta28 conta28;
        if (tipoConta28 == Conta28.TipoConta28.CORRENTE){
            conta28 = new ContaCorrente28(cliente28,numeroConta,0.00,tipoConta28, Conta28.StatusConta28.ATIVA);
            banco28.addConta(conta28);
        }else {
            conta28 = new ContaPoupanca28(cliente28,numeroConta,0.00,tipoConta28, Conta28.StatusConta28.ATIVA);
            banco28.addConta(conta28);
        }
    }
}
