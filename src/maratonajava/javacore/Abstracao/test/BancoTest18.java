package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class BancoTest18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco18 banco18 = new Banco18();
        while (true){
            System.out.println("[1] Cadastro conta.");
            System.out.println("[2] Lista de contas.");
            System.out.println("[3] Deposito.");
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
                        cadastroConta(scanner,banco18);
                        break;
                    case 2:
                        banco18.listarContas();
                        break;
                    case 3:
                        banco18.depositar(scanner);
                        break;
                    case 4:
                        banco18.sacar(scanner);
                        break;
                    case 5:
                        banco18.alterarConta(scanner,"bloquear");
                        break;
                    case 6:
                        banco18.desbloquearConta(scanner);
                        break;
                    case 7:
                        banco18.alterarConta(scanner,"cancelar");
                        break;
                    case 8:
                        System.out.println(">>>>Finalizando programa.");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void cadastroConta(Scanner scanner, Banco18 banco18){
        String nome = Banco18.validandoNome(scanner);
        String cpf = Banco18.validandoCpf(scanner);
        int numeroConta = Banco18.validandoNumeroConta(scanner);
        Cliente18.TipoConta18 tipoConta18 = Banco18.validandoTipoConta(scanner);
        Cliente18 cliente18 = new Cliente18(nome,cpf);
        Conta18 conta18;
        if (tipoConta18 == Cliente18.TipoConta18.CORRENTE){
            conta18 = new ContaCorrente18(cliente18,numeroConta,0.0,tipoConta18, Cliente18.StatusConta18.ATIVA);
            banco18.addConta(conta18);
            System.out.println("Conta corrente criada com sucesso.");
        }else {
            conta18 = new ContaPoupanca18(cliente18,numeroConta,0.0,tipoConta18, Cliente18.StatusConta18.ATIVA);
            banco18.addConta(conta18);
            System.out.println("Conta poupança criada com sucesso.");
        }
    }
}
