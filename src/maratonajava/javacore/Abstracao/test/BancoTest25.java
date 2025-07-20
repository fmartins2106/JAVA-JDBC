package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class BancoTest25 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco25 banco25 = new Banco25();
        while (true){
            System.out.println("[1] Cadastro conta.");
            System.out.println("[2] Lista de contas cadastradas.");
            System.out.println("[3] Depósito.");
            System.out.println("[4] Saque.");
            System.out.println("[5] Bloquear conta.");
            System.out.println("[6] Desbloquear conta.");
            System.out.println("[7] Cancelar conta.");
            System.out.println("[8] Sair.");
            System.out.print("Digite uma das opções acima:");
            int opcao = Integer.parseInt(scanner.nextLine());
            switch (opcao){
                case 1:
                    cadastroConta(scanner,banco25);
                    break;
                case 2:
                    banco25.listarContas();
                    break;
                case 3:
                    banco25.validandoDeposito(scanner);
                    break;
                case 4:
                    banco25.validandoSaque(scanner);
                    break;
                case 5:
                    banco25.AlterandoStatusConta(scanner,"bloquear");
                    break;
                case 6:
                    banco25.AlterandoStatusConta(scanner,"desbloquear");
                    break;
                case 7:
                    banco25.AlterandoStatusConta(scanner,"cancelar");
                    break;
                case 8:
                    System.out.println(">>>Finalizando sistema.");
                    return;
                default:
                    System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void cadastroConta(Scanner scanner, Banco25 banco25){
        String nome = Banco25.validandoNome(scanner);
        String cpf = Banco25.validandoCpf(scanner);
        int numeroConta = Banco25.validandoNumeroConta(scanner);
        Conta25.TipoConta25 tipoConta25 = Banco25.validandoTipoConta(scanner);
        Cliente25 cliente25 = new Cliente25(nome,cpf);
        Conta25 conta25;
        if (tipoConta25 == Conta25.TipoConta25.CORRENTE){
            conta25 = new ContaCorrente25(cliente25,numeroConta,0.0,tipoConta25, Conta25.StatusConta25.ATIVA);
            banco25.addConta(conta25);
        }else {
            conta25 = new ContaPoupanca25(cliente25,numeroConta,0.0,tipoConta25, Conta25.StatusConta25.ATIVA);
            banco25.addConta(conta25);
        }
    }
}
