package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class BancoTest21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco21 banco21 = new Banco21();
        while (true){
            try {
                System.out.println("[1] Cadastro conta.");
                System.out.println("[2] Lista de contas.");
                System.out.println("[3] Depósito.");
                System.out.println("[4] Saque.");
                System.out.println("[5] Bloquear conta.");
                System.out.println("[6] Cancelar conta.");
                System.out.println("[7] Desbloquear conta.");
                System.out.println("[8] Sair.");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        cadastroConta(scanner,banco21);
                        break;
                    case 2:
                        banco21.listaContasCadastradas();
                        break;
                    case 3:
                        banco21.validandoDeposito(scanner);
                        break;
                    case 4:
                        banco21.validandoSaque(scanner);
                        break;
                    case 5:
                        banco21.validandoAlteracaoStatusConta(scanner,"bloquear");
                        break;
                    case 6:
                        banco21.validandoAlteracaoStatusConta(scanner,"encerrar");
                        break;
                    case 7:
                        banco21.validandoDesbloqueioConta(scanner);
                        break;
                    case 8:
                        System.out.println(">>>Finalizando Programa.");
                        return;
                    default:
                        System.out.println("Digite um valor válido.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void cadastroConta(Scanner scanner, Banco21 banco21){
        String nome = Banco21.validacaoNome(scanner);
        String cpf = Banco21.validandoCpf(scanner);
        int numeroConta = Banco21.validandoNumeroConta(scanner);
        Cliente21.TipoConta21 tipoConta21 = Banco21.validandoTipoConta(scanner);
        Cliente21 cliente21 = new Cliente21(nome,cpf);
        Conta21 conta21;
        if (tipoConta21 == Cliente21.TipoConta21.CORRENTE){
            conta21 = new ContaCorrente21(cliente21,numeroConta,0.0,tipoConta21, Cliente21.StatusConta21.ATIVA);
            banco21.addConta(conta21);
        }else {
            conta21 = new ContaPoupanca21(cliente21,numeroConta,0.0,tipoConta21, Cliente21.StatusConta21.ATIVA);
            banco21.addConta(conta21);
        }
        System.out.println("Conta cadastrada com sucesso.");
    }
}
