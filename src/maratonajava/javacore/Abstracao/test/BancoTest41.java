package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class BancoTest41 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco41 banco41 = new Banco41();

        while (true){
            try {
                System.out.println("[1] Cadastro conta.");
                System.out.println("[2] Listar contas cadastradas.");
                System.out.println("[3] Depósito.");
                System.out.println("[4] Saque.");
                System.out.println("[5] Bloquear conta.");
                System.out.println("[6] Desbloquear conta.");
                System.out.println("[7] Cancelar conta.");
                System.out.println("[8] Sair.");
                System.out.print("Digite uma das opções acima:");
                int opcao  = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao){
                    case 1:
                        cadastroConta(scanner,banco41);
                        break;
                    case 2:
                        banco41.listarContas();
                        break;
                    case 3:
                        banco41.depositar(scanner);
                        break;
                    case 4:
                        banco41.sacar(scanner);
                        break;
                    case 5:
                        banco41.alterarConta(scanner,"bloquear");
                        break;
                    case 6:
                        banco41.alterarConta(scanner,"desbloquear");
                        break;
                    case 7:
                        banco41.cancelarConta(scanner);
                        break;
                    case 8:
                        System.out.println(">>>Finalizando sistema.");
                        return;
                    default:
                        System.out.println("Digite uma opção válida. Tente novamente.");
                }
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite uma opção válida.");
            }
        }
    }

    public static void cadastroConta(Scanner scanner, Banco41 banco41){
        String nome = Banco41.validandoNome(scanner);
        String cpf = Banco41.validandoCpf(scanner);
        int numeroConta = Banco41.validacaoNumeroConta(scanner);
        Conta41.TipoConta41 tipoConta41 = Banco41.validandoTipoConta41(scanner);
        Cliente41 cliente41 = new Cliente41(nome,cpf);
        Conta41 conta41;
        if (tipoConta41 == Conta41.TipoConta41.CORRENTE){
            conta41 = new ContaCorrente41(cliente41,numeroConta,0.00,tipoConta41, Conta41.StatusConta41.ATIVA);
        }else {
            conta41 = new ContaPoupanca41(cliente41,numeroConta,0.00,tipoConta41, Conta41.StatusConta41.ATIVA);
        }
        banco41.addConta(conta41);
    }
}
