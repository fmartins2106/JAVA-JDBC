package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class BancoTest37 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco37 banco37 = new Banco37();
        while (true){
            System.out.println("[1] Cadastro de conta.");
            System.out.println("[2] Lista de contas cadastradas.");
            System.out.println("[3] Depósito.");
            System.out.println("[4] Sacar.");
            System.out.println("[5] Bloquear conta.");
            System.out.println("[6] Desbloquear conta.");
            System.out.println("[7] Cancelar conta.");
            System.out.println("[8] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao){
                    case 1:
                        cadastroConta(scanner,banco37);
                        break;
                    case 2:
                        banco37.listarContasCadastradas();
                        break;
                    case 3:
                        banco37.depositar(scanner);
                        break;
                    case 4:
                        banco37.sacar(scanner);
                        break;
                    case 5:
                        banco37.alterarStatusConta(scanner,"bloquear");
                        break;
                    case 6:
                        banco37.alterarStatusConta(scanner,"desbloquear");
                        break;
                    case 7:
                        banco37.alterarStatusConta(scanner,"cancelar");
                        break;
                    case 8:
                        System.out.println(">>>>Finalizando programa.");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void cadastroConta(Scanner scanner, Banco37 banco37){
        String nome = Banco37.validandoNome(scanner);
        String cpf = Banco37.validandoCpf(scanner);
        int numeroConta = Banco37.validandoNumeroConta(scanner);
        Cliente37 cliente37 = new Cliente37(nome,cpf);
        Conta37.TipoConta37 tipoConta37 = Banco37.validandoTipoConta(scanner);
        Conta37 conta37;
        if (tipoConta37 == Conta37.TipoConta37.CORRENTE){
            conta37 = new ContaCorrente37(cliente37,numeroConta,0.00,tipoConta37, Conta37.StatusConta37.ATIVA);
             banco37.addConta(conta37);
        }else {
            conta37 = new ContaPoupanca37(cliente37,numeroConta,0.00,tipoConta37, Conta37.StatusConta37.ATIVA);
            banco37.addConta(conta37);
        }
    }
}
