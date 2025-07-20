package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class BancoTest32 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco32 banco32 = new Banco32();

        while (true){
            System.out.println("[1] Cadastro conta.");
            System.out.println("[2] Lista de contas cadastradas.");
            System.out.println("[3] Depósito.");
            System.out.println("[4] Saque.");
            System.out.println("[5] Excluir dados.");
            System.out.println("[6] Bloquear conta.");
            System.out.println("[7] Desbloquear conta.");
            System.out.println("[8] Cancelar conta.");
            System.out.println("[9] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        cadastroConta(scanner,banco32);
                        break;
                    case 2:
                        banco32.listarContas();
                        break;
                    case 3:
                        banco32.validandoDeposito(scanner);
                        break;
                    case 4:
                        banco32.validandoSaque(scanner);
                        break;
                    case 5:
                        banco32.excluirDadosConta(scanner);
                        break;
                    case 6:
                        banco32.alterarConta(scanner,"bloquear");
                        break;
                    case 7:
                        banco32.alterarConta(scanner,"desbloquear");
                        break;
                    case 8:
                        banco32.cancelarConta(scanner);
                        break;
                    case 9:
                        System.out.println("<Finalizando programa>");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void cadastroConta(Scanner scanner, Banco32 banco32){
        String nome = Banco32.validandoNome(scanner);
        String cpf = Banco32.validandoCpf(scanner);
        int numeroConta = Banco32.validandoNumeroConta(scanner);
        Conta32.TipoConta32 tipoConta32 = Banco32.validandoTipoConta(scanner);
        Cliente32 cliente32 = new Cliente32(nome,cpf);
        Conta32 conta32;
        if (tipoConta32 == Conta32.TipoConta32.CORRENTE){
            conta32 = new ContaCorrente32(cliente32,numeroConta,0.00,tipoConta32, Conta32.StatusConta32.ATIVA);
            banco32.addConta(conta32);
        }else {
            conta32 = new ContaPoupanca32(cliente32,numeroConta,0.00,tipoConta32, Conta32.StatusConta32.ATIVA);
            banco32.addConta(conta32);
        }
    }
}
