package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class BancoTest29 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco29 banco29 = new Banco29();
        while (true){
            System.out.println("[1] Cadastro conta.");
            System.out.println("[2] Lista de contas cadastradas.");
            System.out.println("[3] Depósito.");
            System.out.println("[4] Saque.");
            System.out.println("[5] Bloquear conta.");
            System.out.println("[6] Desbloquear conta.");
            System.out.println("[7] Cancelar conta.");
            System.out.println("[8] Sair.");
            System.out.print("Digite uma das opções acima:");
            int opcao = Integer.parseInt(scanner.nextLine());
            switch (opcao){
                case 1:
                    cadastroConta(scanner,banco29);
                    break;
                case 2:
                    banco29.listarContasCadastradas();
                    break;
                case 3:
                    banco29.validandoDeposito(scanner);
                    break;
                case 4:
                    banco29.validandoSaque(scanner);
                    break;
                case 5:
                    banco29.bloquearConta(scanner);
                    break;
                case 6:
                    banco29.desbloquearConta(scanner);
                    break;
                case 7:
                    banco29.cancelarConta(scanner);
                    break;
                case 8:
                    System.out.println(">>>>>Finalizando programa...");
                    return;
                default:
                    System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void cadastroConta(Scanner scanner,Banco29 banco29){
        String nome = Banco29.validandoNome(scanner);
        String cpf = Banco29.validandoCpf(scanner);
        int numeroConta = Banco29.validandoNumeroConta(scanner);
        Conta29.TipoConta29 tipoConta29 = Banco29.validandoTipoConta(scanner);
        Cliente29 cliente29 = new Cliente29(nome,cpf);
        Conta29 conta29;
        if (tipoConta29 == Conta29.TipoConta29.CORRENTE){
            conta29 = new ContaCorrente29(cliente29,numeroConta,0.00,tipoConta29, Conta29.StatusConta29.ATIVA);
        }else {
            conta29  = new ContaPoupanca29(cliente29,numeroConta,0.00, tipoConta29, Conta29.StatusConta29.ATIVA);
        }
        banco29.addContas(conta29);
        System.out.println("Conta cadastrada com sucesso.");
    }
}
