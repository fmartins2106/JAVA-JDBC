package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class BancoTest15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco15 banco15 = new Banco15();
        while (true){
            System.out.println("[1] Cadastro conta.");
            System.out.println("[2] Lista de contas.");
            System.out.println("[3] Depositar.");
            System.out.println("[4] Sacar.");
            System.out.println("[5] Bloquear conta.");
            System.out.println("[6] Desbloquear conta.");
            System.out.println("[7] Cancelar conta.");
            System.out.println("[8] Sair.");
            try {
                System.out.print("Digite uma da opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        cadastroConta(scanner,banco15);
                        break;
                    case 2:
                        banco15.listaContas();
                        break;
                    case 3:
                        banco15.depositar(scanner,banco15);
                        break;
                    case 4:
                        banco15.saque(scanner,banco15);
                        break;
                    case 5:
                        banco15.alterarConta(scanner,banco15,"bloquear");
                        break;
                    case 6:
                        banco15.desbloquearConta(scanner,banco15);
                        break;
                    case 7:
                        banco15.alterarConta(scanner,banco15,"encerrar");
                        break;
                    case 8:
                        System.out.println(">>>Finalizar conta.");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opções válida.");
            }
        }
    }

    public static void cadastroConta(Scanner scanner, Banco15 banco15){
        String nome = Banco15.validandoNome(scanner,banco15);
        String cpf = Banco15.validandoCpf(scanner,banco15);
        int numeroConta = Banco15.validandoNumeroConta(scanner,banco15);
        Cliente15.TipoConta15 tipoConta15 = Banco15.validandoTipoConta(scanner,banco15);
        Cliente15 cliente15 = new Cliente15(nome,cpf);
        Conta15 conta15;
        if (tipoConta15 == Cliente15.TipoConta15.CORRENTE){
            conta15 = new ContaCorrente15(cliente15,numeroConta,0.0,tipoConta15, Cliente15.StatusConta15.ATIVA);
            banco15.addContas(conta15);
            System.out.println("Conta corrente cadastrada com sucesso.");
        }else {
            conta15 = new ContaPoupanca15(cliente15,numeroConta,0.0,tipoConta15, Cliente15.StatusConta15.ATIVA);
            banco15.addContas(conta15);
            System.out.println("Conta poupança cadastrada com sucesso.");
        }
    }

}
