package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class BancoTest30 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco30 banco30 = new Banco30();
        while (true){
            System.out.println("[1] Cadastro conta.");
            System.out.println("[2] Lista de contas.");
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
                    cadastroConta(scanner,banco30);
                    break;
                case 2:
                    banco30.listarConta();
                    break;
                case 3:
                    banco30.validandoDeposito(scanner);
                    break;
                case 4:
                    banco30.validandoSaque(scanner);
                    break;
                case 5:
                    banco30.alterandoStatusConta(scanner,"bloquear");
                    break;
                case 6:
                    banco30.alterandoStatusConta(scanner,"desbloquear");
                    break;
                case 7:
                    banco30.alterandoStatusConta(scanner,"cancelar");
                    break;
                case 8:
                    System.out.println(">>>Finalizando programa.");
                    return;
                default:
                    System.out.println("Digite um valor válido.");
            }
        }
    }

    public static void cadastroConta(Scanner scanner, Banco30 banco30){
        String nome = Banco30.validandoNome(scanner);
        String cpf = Banco30.validandoCpf(scanner);
        int numeroConta = Banco30.validandoNumeroConta(scanner);
        Conta30.TipoConta30 tipoConta30 = Banco30.validandoTipoConta(scanner);
        Cliente30 cliente30 = new Cliente30(nome,cpf);
        if (tipoConta30 == Conta30.TipoConta30.CORRENTE){
            Conta30 conta30 = new ContaCorrente30(cliente30,numeroConta,0.00,tipoConta30, Conta30.StatusConta30.ATIVA);
            banco30.addConta(conta30);
        }else {
            Conta30 conta30 = new ContaPoupanca30(cliente30,numeroConta,0.00,tipoConta30, Conta30.StatusConta30.ATIVA);
            banco30.addConta(conta30);
        }
    }
}
