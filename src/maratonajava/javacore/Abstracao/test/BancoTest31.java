package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class BancoTest31 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco31 banco31 = new Banco31();
        while (true){
            System.out.println("[1] Cadastro conta.");
            System.out.println("[2] Lista de contas cadastradas.");
            System.out.println("[3] Depósito.");
            System.out.println("[4] Saque.");
            System.out.println("[5] Bloquear.");
            System.out.println("[6] Desbloquear.");
            System.out.println("[7] Cancelar.");
            System.out.println("[8] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        cadastroConta(scanner,banco31);
                        break;
                    case 2:
                        banco31.listarContasCadastradas();
                        break;
                    case 3:
                        banco31.validandoDeposito(scanner);
                        break;
                    case 4:
                        banco31.validandoSaque(scanner);
                        break;
                    case 5:
                        banco31.alterarConta(scanner,"bloquear");
                        break;
                    case 6:
                        banco31.alterarConta(scanner,"desbloquear");
                        break;
                    case 7:
                        banco31.alterarConta(scanner,"cancelar");
                        break;
                    case 8:
                        System.out.println("<Finalizando programa>");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static void cadastroConta(Scanner scanner, Banco31 banco31){
        String nome = Banco31.validandoNome(scanner);
        String cpf = Banco31.validandoCpf(scanner);
        int numeroConta = Banco31.validandoNumeroConta(scanner);
        Cliente31 cliente31 = new Cliente31(nome,cpf);
        Conta31.TipoConta31 tipoConta31 = Banco31.validandoTipoConta(scanner);
        Conta31 conta31;
        if (tipoConta31 == Conta31.TipoConta31.CORRENTE){
            conta31 = new ContaCorrente31(cliente31,numeroConta,0.00,tipoConta31, Conta31.StatusConta31.ATIVA);
            banco31.addConta(conta31);
        }else {
            conta31 = new ContaPoupanca31(cliente31,numeroConta,0.00,tipoConta31, Conta31.StatusConta31.ATIVA);
            banco31.addConta(conta31);
        }
    }
}
