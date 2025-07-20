package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class BancoTest06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco06 banco06 = new Banco06();
        while (true){
            System.out.println("[1] Cadastro de conta.");
            System.out.println("[2] Lista de contas cadastradas.");
            System.out.println("[3] Depositar.");
            System.out.println("[4] Sacar.");
            System.out.println("[5] Bloquear conta.");
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
                    cadastroConta(scanner,banco06);
                    break;
                case 2:
                    banco06.listaContas();
                    break;
                case 3:
                    banco06.realizarDeposito(scanner);
                case 4:
                    banco06.realizarSaque(scanner);
                    break;
                case 5:
                    banco06.alterarDados(scanner,"bloquear");
                    break;
                case 6:
                    banco06.desbloquearConta(scanner);
                    break;
                case 7:
                    banco06.alterarDados(scanner, "encerrar");
                    break;
                case 8:
                    System.out.println(">>>Finalizando programa...");
                    return;
                default:
                    System.out.println("Digite um valor válido.");

            }
        }
    }

    public static void cadastroConta(Scanner scanner, Banco06 banco06){
        String nome = Banco06.validandoNome(scanner,banco06);
        String cpf = Banco06.validandoCpf(scanner,banco06);
        int numeroConta = Banco06.validandoContaCorrente(scanner,banco06);
        Cliente06.TipoDaConta tipoDaConta = Banco06.validandoTipoDaConta(scanner,banco06);
        Cliente06 cliente06 = new Cliente06(nome,cpf);
        Conta06 conta06;
        if (tipoDaConta == Cliente06.TipoDaConta.CORRENTE){
            conta06 = new ContaCorrente06(cliente06,numeroConta,0.0, tipoDaConta, Cliente06.StatusDaConta.ATIVA);
        }else {
            conta06 = new ContaPoupanca06(cliente06,numeroConta,0.0, tipoDaConta, Cliente06.StatusDaConta.ATIVA);
        }
        banco06.addConta(conta06);
        System.out.println("Conta cadastrada com sucesso.");
    }
}
