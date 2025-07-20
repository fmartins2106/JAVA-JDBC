package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class BancoTest36 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco36 banco36 = new Banco36();
        while (true){
            try {
                System.out.println("[1] Cadastro de conta.");
                System.out.println("[2] Lista de contas cadastradas.");
                System.out.println("[3] Depósito.");
                System.out.println("[4] Sacar.");
                System.out.println("[5] Bloquear.");
                System.out.println("[6] Desbloquear.");
                System.out.println("[7] Cancelar.");
                System.out.println("[8] Sair.");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao){
                    case 1:
                        cadastroConta(scanner,banco36);
                        break;
                    case 2:
                        banco36.listarContas();
                        break;
                    case 3:
                        banco36.depositar(scanner);
                        break;
                    case 4:
                        banco36.sacar(scanner);
                        break;
                    case 5:
                        banco36.alterarDadosConta(scanner,"bloquear");
                        break;
                    case 6:
                        banco36.alterarDadosConta(scanner,"desbloquear");
                        break;
                    case 7:
                        banco36.alterarDadosConta(scanner,"cancelar");
                        break;
                    case 8:
                        System.out.println(">>>Finalizando sistema.");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void cadastroConta(Scanner scanner,Banco36 banco36){
        String nome = Banco36.validandoNome(scanner);
        String cpf = Banco36.validandoCpf(scanner);
        int numeroConta = Banco36.validandoNumeroConta(scanner);
        Conta36.TipoConta36 tipoConta36 = Banco36.validandoTipoConta(scanner);
        Cliente36 cliente36 = new Cliente36(nome,cpf);
        Conta36 conta36;
        if (tipoConta36 == Conta36.TipoConta36.CORRENTE){
            conta36 = new ContaCorrente36(cliente36,numeroConta,0.00,tipoConta36, Conta36.StatusConta36.ATIVA);
        }else {
            conta36 = new ContaPoupanca36(cliente36,numeroConta,0.00,tipoConta36, Conta36.StatusConta36.ATIVA);
        }
        banco36.addConta(conta36);
    }

}
