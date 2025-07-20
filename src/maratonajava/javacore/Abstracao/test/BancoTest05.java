package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class BancoTest05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco05 banco05 = new Banco05();
        while (true){
            System.out.println("[1] Cadastro de conta.");
            System.out.println("[2] Lista de contas cadastradas.");
            System.out.println("[3] Depositar.");
            System.out.println("[4] Sacar.");
            System.out.println("[5] Bloquear Conta.");
            System.out.println("[6] Desbloquear Conta.");
            System.out.println("[7] Encerrar Conta.");
            System.out.println("[8] Sair.");
            int opcao = 0;
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite uma opçõa válida.");
            }
            switch (opcao){
                case 1:
                    cadastroConta(scanner,banco05);
                    break;
                case 2:
                    banco05.listaContas();
                    break;
                case 3:
                    banco05.realizadoDepositos(scanner);
                    break;
                case 4:
                    banco05.realizarSaque(scanner);
                    break;
                case 5:
                    banco05.alterandoDadosConta(scanner,"bloquear");
                    break;
                case 6:
                    banco05.desbloquearConta(scanner);
                    break;
                case 7:
                    banco05.alterandoDadosConta(scanner,"encerrar");
                    break;
                case 8:
                    System.out.println(">>>Finalizando o programa.");
                    return;
                default:
                    System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void cadastroConta(Scanner scanner, Banco05 banco05){
        String nome = Banco05.validandoNome(scanner, banco05);
        String cpf = Banco05.validandoCpf(scanner, banco05);
        int numeroConta = Banco05.validandoNumeroConta(scanner,banco05);
        Cliente05.Tipo tipoConta = Banco05.validandoTipoConta(scanner,banco05);
        Cliente05 cliente05 = new Cliente05(nome,cpf);
        Conta05 conta05;
        if (tipoConta == Cliente05.Tipo.CORRENTE){
            conta05 = new ContaCorrente05(cliente05,numeroConta,0.0, Cliente05.Status.ATIVA,tipoConta);
        }else {
            conta05 = new ContaPoupanca05(cliente05,numeroConta,0.0, Cliente05.Status.ATIVA, tipoConta);
        }
        banco05.addContas(conta05);
        System.out.println("Conta criada com sucesso.");
    }
}
