package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class BancoTest01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco01 banco01 = new Banco01();
        while (true){
            System.out.println("[1] Criar conta.");
            System.out.println("[2] Lista Contas.");
            System.out.println("[3] Depositar.");
            System.out.println("[4] Sacar.");
            System.out.println("[5] BloquearConta.");
            System.out.println("[6] Encerrar conta.");
            System.out.println("[7] Desbloquear a conta.");
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
                    cadastroConta(scanner,banco01);
                    break;
                case 2:
                    banco01.listaContas(scanner);
                    break;
                case 3:
                    banco01.realizarDeposito(scanner);
                    break;
                case 4:
                    banco01.realizarSaque(scanner);
                    break;
                case 5:
                    banco01.alterarDadosConta(scanner,"bloquear");
                    break;
                case 6:
                    banco01.alterarDadosConta(scanner, "encerrar");
                    break;
                case 7:
                    banco01.desbloquearConta(scanner);
                    break;
                case 8:
                    System.out.println(">>Finalizando o programa....");
                    return;
                default:
                    System.out.println("Digite uma opção válida.");
            }
        }
    }
    public static void cadastroConta(Scanner scanner, Banco01 banco01){
        String nome = Banco01.validandoNome(scanner, banco01);
        String cpf = Banco01.validandoCpf(scanner,banco01);
        int numeroConta = Banco01.validandoConta(scanner,banco01);
        Cliente01.TipoDeConta tipoDeConta = Banco01.validandoTipoDeConta(scanner);
        Cliente01 cliente01 = new Cliente01(nome,cpf);
        Conta01 conta01;
        if (tipoDeConta == Cliente01.TipoDeConta.CORRENTE){
            conta01 = new ContaCorrente01(cliente01,numeroConta, 0.0, tipoDeConta, Cliente01.StatusConta.ATIVA);
        }else {
            conta01 = new ContaPoupanca01(cliente01, numeroConta, 0.0, tipoDeConta, Cliente01.StatusConta.ATIVA);
        }
        banco01.addConta(conta01);
        System.out.println("Conta criada com sucesso.");
    }
}
