package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class BancoTest12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco12 banco12 = new Banco12();
        while (true){
            System.out.println("[1] Cadastro conta.");
            System.out.println("[2] Lista de contas.");
            System.out.println("[3] Deposito.");
            System.out.println("[4] Saque.");
            System.out.println("[5] Bloquear conta.");
            System.out.println("[6] Cancelar conta.");
            System.out.println("[7] desbloquear conta.");
            System.out.println("[8] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        cadastroConta(scanner,banco12);
                        break;
                    case 2:
                        banco12.listaConta();
                        break;
                    case 3:
                        banco12.depositar(scanner,banco12);
                        break;
                    case 4:
                        banco12.saque(scanner,banco12);
                        break;
                    case 5:
                        banco12.alterarConta(scanner,"bloquear");
                        break;
                    case 6:
                        banco12.desbloquearConta(scanner);
                        break;
                    case 7:
                        banco12.alterarConta(scanner,"encerrar");
                        break;
                    case 8:
                        System.out.println(">>>Finalizando programa...");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");

                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void cadastroConta(Scanner scanner, Banco12 banco12){
        String nome = Banco12.validandoNome(scanner,banco12);
        String cpf = Banco12.validandoCpf(scanner,banco12);
        int numeroConta = Banco12.validandoNumeroConta(scanner,banco12);
        Cliente12 cliente12 = new Cliente12(nome,cpf);
        Cliente12.TipoConta12 tipoConta12 = Banco12.validandoTipoConta(scanner);
        Conta12 conta12;
        if (tipoConta12 == Cliente12.TipoConta12.CORRENTE){
            conta12 = new ContaCorrente12(cliente12,numeroConta,0.0, tipoConta12, Cliente12.StatusConta12.ATIVA);
            banco12.addConta(conta12);
        }else {
            conta12 = new ContaPoupanca12(cliente12,numeroConta,0.0, tipoConta12, Cliente12.StatusConta12.ATIVA);
            banco12.addConta(conta12);
        }
    }


}
