package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class BancoTest33 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco33 banco33 = new Banco33();
        while (true){
            System.out.println("[1] Cadastro conta.");
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
                        cadastroConta(scanner,banco33);
                        break;
                    case 2:
                        banco33.listarContasCadastradas();
                        break;
                    case 3:
                        banco33.depositar(scanner);
                        break;
                    case 4:
                        banco33.sacar(scanner);
                        break;
                    case 5:
                        banco33.bloquearConta(scanner);
                        break;
                    case 6:
                        banco33.desbloquearConta(scanner);
                        break;
                    case 7:
                        banco33.cancelarConta(scanner);
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

    public static void cadastroConta(Scanner scanner, Banco33 banco33){
        String nome = Banco33.validandoNome(scanner);
        String cpf = Banco33.validadoCpf(scanner);
        int numeroConta = Banco33.validandoNumeroConta(scanner);
        Conta33.TipoConta33 tipoConta33 = Banco33.validandoTipoConta(scanner);
        Cliente33 cliente33 = new Cliente33(nome,cpf);
        Conta33 conta33;
        if (tipoConta33 == Conta33.TipoConta33.CORRENTE){
            conta33 = new ContaCorrente33(cliente33,numeroConta,0.00,tipoConta33, Conta33.StatusConta33.ATIVA);
            banco33.addConta(conta33);
        }else {
            conta33 = new ContaPoupanca33(cliente33,numeroConta,0.00,tipoConta33, Conta33.StatusConta33.ATIVA);
            banco33.addConta(conta33);
        }
        System.out.println("Conta cadastrada com sucesso.");
    }
}
