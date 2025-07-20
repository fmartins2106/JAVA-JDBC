package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class BancoTest34 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco34 banco34 = new Banco34();
        while (true){
            System.out.println("[1] Cadastro Conta.");
            System.out.println("[2] Lista de contas cadastradas.");
            System.out.println("[3] Depósito.");
            System.out.println("[4] Saque.");
            System.out.println("[5] Bloquear conta.");
            System.out.println("[6] Desbloquear conta.");
            System.out.println("[7] Cancelar conta.");
            System.out.println("[8] Sair.");
            try {
                System.out.print("Digite um das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        cadastroConta(scanner,banco34);
                        break;
                    case 2:
                        banco34.listarContas();
                        break;
                    case 3:
                        banco34.depositar(scanner);
                        break;
                    case 4:
                        banco34.sacar(scanner);
                        break;
                    case 5:
                        banco34.alterarStatusConta(scanner,"bloquear");
                        break;
                    case 6:
                        banco34.alterarStatusConta(scanner,"desbloquear");
                        break;
                    case 7:
                        banco34.alterarStatusConta(scanner,"cancelar");
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

    public static void cadastroConta(Scanner scanner, Banco34 banco34){
        String nome = Banco34.validandoNome(scanner);
        String cpf = Banco34.validandoCpf(scanner);
        int numeroConta = Banco34.validandoNumeroConta(scanner);
        Conta34.TipoConta34 tipoConta34 = Banco34.validandoTipoConta(scanner);
        Cliente34 cliente34 = new Cliente34(nome,cpf);
        Conta34 conta34;
        if (tipoConta34 == Conta34.TipoConta34.CORRENTE){
            conta34 = new ContaCorrente34(cliente34,numeroConta,0.00,tipoConta34, Conta34.StatusConta34.ATIVA);
            banco34.addConta(conta34);
        }else {
            conta34 = new ContaPoupanca34(cliente34,numeroConta,0.00,tipoConta34, Conta34.StatusConta34.ATIVA);
            banco34.addConta(conta34);
        }
    }
}
