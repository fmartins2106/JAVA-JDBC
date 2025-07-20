package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class BancoTest35 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco35 banco35 = new Banco35();
        while (true){
            try {
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
                        cadastroConta(scanner,banco35);
                        break;
                    case 2:
                        banco35.listarContasCadastradas();
                        break;
                    case 3:
                        banco35.depositar(scanner);
                        break;
                    case 4:
                        banco35.sacar(scanner);
                        break;
                    case 5:
                        banco35.bloquearConta(scanner);
                        break;
                    case 6:
                        banco35.desbloquearConta(scanner);
                        break;
                    case 7:
                        banco35.cancelarConta(scanner);
                        break;
                    case 8:
                        System.out.println(">>>Finalizando programa.");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void cadastroConta(Scanner scanner, Banco35 banco35){
        String nome = Banco35.validandoNome(scanner);
        String cpf = Banco35.validandoCpf(scanner);
        int numeroConta = Banco35.validandoNumeroConta(scanner);
        Conta35.TipoConta35 tipoConta35 = Banco35.validandoTipoConta(scanner);
        Cliente35 cliente35 = new Cliente35(nome,cpf);
        Conta35 conta35;
        if (tipoConta35 == Conta35.TipoConta35.CORRENTE){
            conta35 = new ContaCorrente35(cliente35,numeroConta,0.00,tipoConta35, Conta35.StatusConta35.ATIVA);
        }else {
            conta35 = new ContaPoupanca35(cliente35,numeroConta,0.00,tipoConta35, Conta35.StatusConta35.ATIVA);
        }
        banco35.addConta(conta35);
    }
}
