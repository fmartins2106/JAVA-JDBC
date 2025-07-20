package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class BancoTest14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco14 banco14 = new Banco14();
        while (true){
            System.out.println("[1] Cadastro de conta.");
            System.out.println("[2] Lista de contas.");
            System.out.println("[3] Deposito.");
            System.out.println("[4] Saque.");
            System.out.println("[5] Bloquear pessoa.");
            System.out.println("[6] Desbloquear pessoa.");
            System.out.println("[7] Encerrar conta.");
            System.out.println("[8] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        cadastroConta(scanner,banco14);
                        break;
                    case 2:
                        banco14.listaConta();
                        break;
                    case 3:
                        banco14.validacaoDeposito(scanner);
                        break;
                    case 4:
                        banco14.saque(scanner);
                        break;
                    case 5:
                        banco14.alterarConta(scanner,"bloquear");
                        break;
                    case 6:
                        banco14.desbloquearConta(scanner);
                        break;
                    case 7:
                        banco14.alterarConta(scanner,"encerrar");
                        break;
                    case 8:
                        System.out.println(">>>Finalizando o programa.");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException w){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void cadastroConta(Scanner scanner, Banco14 banco14){
        String nome = Banco14.validacaoNome(scanner,banco14);
        String cpf = Banco14.validandoCpf(scanner,banco14);
        int numeroConta = Banco14.validandoNumeroConta(scanner,banco14);
        Cliente14.TipoConta14 tipoConta14 = Banco14.validandoTipoConta(scanner);
        Cliente14 cliente14 = new Cliente14(nome,cpf);
        Conta14 conta14;
        if (tipoConta14 == Cliente14.TipoConta14.CORRENTE){
            conta14 = new ContaCorrente14(cliente14,numeroConta,0.0, tipoConta14, Cliente14.StatusConta14.ATIVA);
            banco14.addConta(conta14);
        }else {
            conta14 = new ContaPoupanca14(cliente14,numeroConta,0.0,tipoConta14, Cliente14.StatusConta14.ATIVA);
            banco14.addConta(conta14);
        }
        System.out.println("Conta criada com sucesso.");
    }
}
