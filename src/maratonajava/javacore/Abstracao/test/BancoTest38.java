package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class BancoTest38 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco38 banco38 = new Banco38();
        while (true){
            try {
                System.out.println("[1] Cadastro conta.");
                System.out.println("[2] Lista de contas cadastradas.");
                System.out.println("[3] Depositar.");
                System.out.println("[4] Sacar.");
                System.out.println("[5] Bloquear conta.");
                System.out.println("[6] Desbloquear conta.");
                System.out.println("[7] Cancelar conta.");
                System.out.println("[8] Sair.");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao){
                    case 1:
                        cadastroConta(scanner,banco38);
                        break;
                    case 2:
                        banco38.listarContasCadastradas();
                        break;
                    case 3:
                        banco38.depositar(scanner);
                        break;
                    case 4:
                        banco38.sacar(scanner);
                        break;
                    case 5:
                        banco38.bloquearConta(scanner);
                        break;
                    case 6:
                        banco38.desbloquearConta(scanner);
                        break;
                    case 7:
                        banco38.cancelarConta(scanner);
                        break;
                    case 8:
                        System.out.println(">>>Finalizando programa.");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static void cadastroConta(Scanner scanner,Banco38 banco38){
        String nome = Banco38.validandoNome(scanner);
        String cpf = Banco38.validandoCpf(scanner);
        int numeroConta = Banco38.validandoNumeroConta(scanner);
        Conta38.TipoConta38 tipoConta38 = Banco38.validandoTipoConta(scanner);
        Cliente38 cliente38 = new Cliente38(nome,cpf);
        Conta38 conta38;
        if (tipoConta38 == Conta38.TipoConta38.CORRENTE){
            conta38 = new ContaCorrente38(cliente38,numeroConta,0.00,tipoConta38, Conta38.StatusConta38.ATIVA);
            banco38.addConta(conta38);
        }else {
            conta38 = new ContaPoupanca38(cliente38,numeroConta,0.00,tipoConta38, Conta38.StatusConta38.ATIVA);
            banco38.addConta(conta38);
        }
    }

}
