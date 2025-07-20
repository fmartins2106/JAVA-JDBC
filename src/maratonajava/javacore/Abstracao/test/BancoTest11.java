package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class BancoTest11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco11 banco11 = new Banco11();
        while (true){
            System.out.println("[1] Cadastro de conta.");
            System.out.println("[2] Lista de conta.");
            System.out.println("[3] Deposito.");
            System.out.println("[4] Saque.");
            System.out.println("[5] Bloquear conta.");
            System.out.println("[6] Cancelar conta.");
            System.out.println("[7] Desbloquear conta.");
            System.out.println("[8] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        cadastroConta(scanner,banco11);
                        break;
                    case 2:
                        banco11.listarConta();
                        break;
                    case 3:
                        banco11.depositar(scanner);
                        break;
                    case 4:
                        banco11.sacar(scanner);
                        break;
                    case 5:
                        banco11.alterarConta(scanner,"bloquear");
                        break;
                    case 6:
                        banco11.alterarConta(scanner,"encerrar");
                        break;
                    case 7:
                        banco11.desbloquearConta(scanner);
                        break;
                    case 8:
                        System.out.println(">>>Finalizando programa...");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }
    public static void cadastroConta(Scanner scanner, Banco11 banco11){
        String nome = Banco11.validandoNome(scanner,banco11);
        String cpf = Banco11.validandoCpf(scanner,banco11);
        int numeroConta = Banco11.validandoConta(scanner,banco11);
        Cliente11.TipoConta11 tipoConta11 = Banco11.validandoTipoConta(scanner);
        Cliente11 cliente11 = new Cliente11(nome,cpf);
        Conta11 conta11;
        if (tipoConta11 == Cliente11.TipoConta11.CORRENTE){
            conta11 = new ContaCorrente11(cliente11,numeroConta,0.0, tipoConta11, Cliente11.StatusConta11.ATIVA);
            banco11.addContas(conta11);
        }else {
            conta11 = new ContaPoupanca11(cliente11,numeroConta,0.0, tipoConta11, Cliente11.StatusConta11.ATIVA);
            banco11.addContas(conta11);
        }
    }
}
