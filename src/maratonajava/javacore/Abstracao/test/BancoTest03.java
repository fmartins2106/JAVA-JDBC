package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class BancoTest03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco03 banco03 = new Banco03();
        while (true){
            System.out.println("[1] Cadastro de conta.");
            System.out.println("[2] Lista de contas.");
            System.out.println("[3] Depositar.");
            System.out.println("[4] Sacar.");
            System.out.println("[5] Bloquear a conta.");
            System.out.println("[6] Desbloquear conta.");
            System.out.println("[7] Encerrar conta.");
            System.out.println("[8] Sair.");
            int opcao = 0;
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
            switch (opcao){
                case 1:
                    cadastroConta(scanner,banco03);
                    break;
                case 2:
                    banco03.listarContas(scanner);
                    break;
                case 3:
                    banco03.realizarDeposito(scanner);
                    break;
                case 4:
                    banco03.realisarSaque(scanner);
                    break;
                case 5:
                    banco03.alterarDadosConta(scanner,"bloquear");
                    break;
                case 6:
                    banco03.desbloquearConta(scanner);
                    break;
                case 7:
                    banco03.alterarDadosConta(scanner,"encerrar");
                    break;
                case 8:
                    System.out.println(">>>finalizando programa...");
                    return;
                default:
                    System.out.println("Digite uma opção válida.");

            }
        }
    }

    public static void cadastroConta(Scanner scanner, Banco03 banco03){
        String nome = Banco03.validandoNome(scanner,banco03);
        String cpf = Banco03.validandoCpf(scanner,banco03);
        int numeroConta = Banco03.validandoNumeroConta(scanner,banco03);
        Cliente03.TipoConta tipoDeConta = Banco03.validandoTipoConta(scanner);
        Cliente03 cliente03 = new Cliente03(nome,cpf);
        Conta03 conta03;
        if (tipoDeConta == Cliente03.TipoConta.CORRENTE){
            conta03 = new ContaCorrente03(cliente03,numeroConta,0.0, tipoDeConta, Cliente03.StatusConta.ATIVA);
        }else {
            conta03 = new ContaPoupanca03(cliente03,numeroConta,0.0, tipoDeConta, Cliente03.StatusConta.ATIVA);
        }
        banco03.addContas(conta03);
        System.out.println("Conta criada com sucesso.");
    }
}
