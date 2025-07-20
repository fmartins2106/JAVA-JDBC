package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class BancoTest04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco04 banco04 = new Banco04();
        while (true){
            System.out.println("[1] Cadastro de conta.");
            System.out.println("[2] Lista de conta.");
            System.out.println("[3] Depositar.");
            System.out.println("[4] Sacar.");
            System.out.println("[5] Bloquear conta.");
            System.out.println("[6] Desbloquear Conta.");
            System.out.println("[7] Encerrar conta.");
            System.out.println("[8] Sair.");
            int opcao = 0;
            try {
                System.out.print("Digite uma das opção acima: ");
                opcao = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
            switch (opcao){
                case 1:
                    cadastroConta(scanner,banco04);
                    break;
                case 2:
                    banco04.listaContas();
                    break;
                case 3:
                    banco04.realizarDeposito(scanner);
                    break;
                case 4:
                    banco04.realizarSaque(scanner);
                    break;
                case 5:
                    banco04.alterarDadosConta(scanner,"bloquear");
                    break;
                case 6:
                    banco04.desbloquearConta(scanner);
                case 7:
                    banco04.alterarDadosConta(scanner,"encerrar");
                    break;
                case 8:
                    System.out.println(">>>Finalizando programa...");
                    return;
                default:
                    System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void cadastroConta(Scanner scanner, Banco04 banco04){
        String nome = Banco04.validandoNome(scanner,banco04);
        String cpf = Banco04.validandoCpf(scanner,banco04);
        int numeroConta = Banco04.validandoNumeroConta(scanner,banco04);
        Cliente04.TipoConta tipoConta = Banco04.validandoTipoConta(scanner);
        Cliente04 cliente04 = new Cliente04(nome,cpf);
        Conta04 conta04;
        if (tipoConta == Cliente04.TipoConta.CORRENTE){
            conta04 = new ContaCorrente04(cliente04,numeroConta,0.0,tipoConta,Cliente04.StatusConta.ATIVA);
        }else {
            conta04 = new ContaPoupanca04(cliente04,numeroConta,0.0,tipoConta, Cliente04.StatusConta.ATIVA);
        }
        banco04.addDadosConta(conta04);
        System.out.println("Conta cadastrada com sucesso.");
    }
}
