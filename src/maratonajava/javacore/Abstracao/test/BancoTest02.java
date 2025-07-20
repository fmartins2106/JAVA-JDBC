package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class BancoTest02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco02 banco02 = new Banco02();
        while (true){
            System.out.println("[1] Criar uma conta.");
            System.out.println("[2] Lista de contas.");
            System.out.println("[3] Depositar.");
            System.out.println("[4] Sacar.");
            System.out.println("[5] BloquearConta.");
            System.out.println("[6] Encerrar conta.");
            System.out.println("[7] Desbloquear conta.");
            System.out.println("[8] Sair.");
            int opcao = 0;
            try {
                System.out.print("Digite uma das opções acima:");
                opcao =Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
            switch (opcao){
                case 1:
                    cadastroConta(scanner,banco02);
                    break;
                case 2:
                    banco02.listaContas(scanner);
                    break;
                case 3:
                    banco02.realizarDeposito(scanner);
                    break;
                case 4:
                    banco02.realizarSaque(scanner);
                    break;
                case 5:
                    banco02.alterarDadosConta(scanner,"bloquear");
                    break;
                case 6:
                    banco02.alterarDadosConta(scanner,"encerrar");
                    break;
                case 7:
                    banco02.desbloquearConta(scanner);
                    break;
                case 8:
                    System.out.println(">>>Finalizando programa...");
                    return;
                default:
                    System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void cadastroConta(Scanner scanner, Banco02 banco02){
        String nome = Banco02.validandoNome(scanner,banco02);
        String cpf = Banco02.validandoCpf(scanner,banco02);
        int numeroConta = Banco02.validandoConta(scanner, banco02);
        Cliente02.TipoConta tipoDeConta = Banco02.validandoTipoDeConta(scanner);
        Cliente02 cliente02 = new Cliente02(nome,cpf);
        Conta02 conta02;
        if (tipoDeConta == Cliente02.TipoConta.CORRENTE){
            conta02 = new ContaCorrente02(cliente02,numeroConta,0.0,tipoDeConta,Cliente02.StatusConta.ATIVA);
        }else {
            conta02 = new ContaPoupanca02(cliente02,numeroConta,0.0,tipoDeConta, Cliente02.StatusConta.ATIVA);
        }
        banco02.addConta(conta02);
        System.out.println("Conta criada com sucesso.");
    }
}
