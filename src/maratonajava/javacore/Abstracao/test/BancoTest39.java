package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class BancoTest39 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco39 banco39 = new Banco39();
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
                        cadastroConta(scanner,banco39);
                        break;
                    case 2:
                        banco39.listarContasCadastradas();
                        break;
                    case 3:
                        banco39.depositar(scanner);
                        break;
                    case 4:
                        banco39.sacar(scanner);
                        break;
                    case 5:
                        banco39.bloquearConta(scanner);
                        break;
                    case 6:
                        banco39.desbloquearConta(scanner);
                        break;
                    case 7:
                        banco39.cancelarConta(scanner);
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

    public static void cadastroConta(Scanner scanner, Banco39 banco39){
        String nome = Banco39.validandoNome(scanner);
        String cpf = Banco39.validandoCpf(scanner);
        int numeroConta = Banco39.validandoNumeroConta(scanner);
        Conta39.TipoConta39 tipoConta39 = Banco39.validandoTipoConta(scanner);
        Cliente39 cliente39 = new Cliente39(nome,cpf);
        Conta39 conta39;
        if (tipoConta39 == Conta39.TipoConta39.CORRENTE){
            conta39 = new ContaCorrente39(cliente39,numeroConta,0.00,tipoConta39, Conta39.StatusConta39.ATIVA);
        }else {
            conta39 = new ContaPoupanca39(cliente39,numeroConta,0.00,tipoConta39, Conta39.StatusConta39.ATIVA);
        }
        banco39.addConta(conta39);
    }
}
