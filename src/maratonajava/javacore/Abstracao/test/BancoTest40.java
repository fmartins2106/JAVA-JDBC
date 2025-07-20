package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class BancoTest40 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco40 banco40 = new Banco40();
        while (true){
            try {
                System.out.println("[1] Cadastrar conta.");
                System.out.println("[2] Listar contas cadastradas.");
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
                        cadastroConta(scanner,banco40);
                        break;
                    case 2:
                        banco40.listarContas();
                        break;
                    case 3:
                        banco40.realizarDeposito(scanner);
                        break;
                    case 4:
                        banco40.realizarSaque(scanner);
                        break;
                    case 5:
                        banco40.bloquearConta(scanner);
                        break;
                    case 6:
                        banco40.desbloquearConta(scanner);
                        break;
                    case 7:
                        banco40.cancelarConta(scanner);
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

    public static void cadastroConta(Scanner scanner, Banco40 banco40){
        String nome = Banco40.validandoNome(scanner);
        String cpf = Banco40.validandoCpf(scanner);
        int numeroConta = Banco40.validandoNumeroConta(scanner);
        Conta40.TipoConta40 tipoConta40 = Banco40.validandoTipoConta(scanner);
        Cliente40 cliente40 = new Cliente40(nome,cpf);
        Conta40 conta40;
        if (tipoConta40 == Conta40.TipoConta40.CORRENTE){
            conta40 = new ContaCorrente40(cliente40,numeroConta,0.00,tipoConta40, Conta40.StatusConta40.ATIVA);
        }else {
            conta40 = new ContaPoupanca40(cliente40,numeroConta,0.00,tipoConta40, Conta40.StatusConta40.ATIVA);
        }
        banco40.addConta(conta40);
    }

}
