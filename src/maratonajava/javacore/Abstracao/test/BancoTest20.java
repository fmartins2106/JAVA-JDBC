package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class BancoTest20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco20 banco20 = new Banco20();
        while (true){
            System.out.println("[1] Cadastro conta.");
            System.out.println("[2] Lista conta.");
            System.out.println("[3] Depósito.");
            System.out.println("[4] Saque.");
            System.out.println("[5] Bloquear conta.");
            System.out.println("[6] Desbloquear conta.");
            System.out.println("[7] Cancelar conta.");
            System.out.println("[8] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                Integer opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        cadastroConta(scanner,banco20);
                        break;
                    case 2:
                        banco20.listarConta();
                        break;
                    case 3:
                        banco20.validandoDepositoConta(scanner);
                        break;
                    case 4:
                        banco20.validandoSaqueConta(scanner);
                        break;
                    case 5:
                        banco20.alterarDados(scanner,"bloquear");
                        break;
                    case 6:
                        banco20.validandoDesbloqueioConta(scanner);
                        break;
                    case 7:
                        banco20.alterarDados(scanner,"cancelar");
                        break;
                    case 8:
                        System.out.println(">>>>Finalizando programa...");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }
    public static void cadastroConta(Scanner scanner, Banco20 banco20){
        String nome = Banco20.validandoNome(scanner);
        String cpf = Banco20.validandoCpf(scanner);
        int numeroConta = Banco20.validandoNumeroConta(scanner);
        Cliente20.TipoConta20 tipoConta20 = Banco20.validandoTipoConta(scanner);
        Cliente20 cliente20 = new Cliente20(nome,cpf);
        Conta20 conta20;
        if (tipoConta20 == Cliente20.TipoConta20.CORRENTE){
            conta20 = new ContaCorrente20(cliente20,numeroConta,0.00,tipoConta20, Cliente20.StatusConta20.ATIVA);
            banco20.addConta(conta20);
        }else {
            conta20 = new ContaPoupanca20(cliente20,numeroConta,0.00, tipoConta20, Cliente20.StatusConta20.ATIVA);
            banco20.addConta(conta20);
        }
        System.out.println("Conta cadastrada com sucesso.");
    }
}
