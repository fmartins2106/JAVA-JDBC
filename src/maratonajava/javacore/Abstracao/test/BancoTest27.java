package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class BancoTest27 {
    public static void main(String[] args) {
        Banco27 banco27 = new Banco27();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("[1] Cadastro de conta.");
            System.out.println("[2] Lista de contas cadastradas.");
            System.out.println("[3] Depósito.");
            System.out.println("[4] Saque.");
            System.out.println("[5] Bloquear conta.");
            System.out.println("[6] Desbloquear conta.");
            System.out.println("[7] Cancelar conta.");
            System.out.println("[8] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        cadastroConta(scanner,banco27);
                        break;
                    case 2:
                        banco27.listarContas();
                        break;
                    case 3:
                        banco27.validandoDeposito(scanner);
                        break;
                    case 4:
                        banco27.validandoSaque(scanner);
                        break;
                    case 5:
                        banco27.alterarDadosConta(scanner,"bloquear");
                        break;
                    case 6:
                        banco27.alterarDadosConta(scanner,"desbloquear");
                        break;
                    case 7:
                        banco27.alterarDadosConta(scanner,"cancelar");
                        break;
                    case 8:
                        System.out.println(">>>Finalizando programa...");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite uma opção válida.");
            }
        }
    }

    public static void cadastroConta(Scanner scanner, Banco27 banco27){
        String nome = Banco27.validandoNome(scanner);
        String cpf = Banco27.validandoCpf(scanner);
        int numeroConta = Banco27.validandoNumeroConta(scanner);
        Conta27.TipoConta27 tipoConta27 = Banco27.validandoTipoConta27(scanner);
        Cliente27 cliente27 = new Cliente27(nome,cpf);
        Conta27 conta27;
        if (tipoConta27 == Conta27.TipoConta27.CORRENTE){
            conta27 = new ContaCorrente27(cliente27,numeroConta,0.0,tipoConta27, Conta27.StatusConta27.ATIVA);
            banco27.addConta(conta27);
        }else {
            conta27 = new ContaPoupanca27(cliente27,numeroConta,0.0,tipoConta27, Conta27.StatusConta27.ATIVA);
            banco27.addConta(conta27);
        }
        System.out.println("Conta registrada com sucesso.");
    }

}
