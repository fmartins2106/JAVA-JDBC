package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class BancoTest23 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco23 banco23 = new Banco23();
        while (true){
            try {
                System.out.println("[1] Cadstro conta.");
                System.out.println("[2] Lista de contas cadastradas.");
                System.out.println("[3] Deposito.");
                System.out.println("[4] Sacar.");
                System.out.println("[5] Bloquear conta.");
                System.out.println("[6] Cancelar conta.");
                System.out.println("[7] Desbloquear conta.");
                System.out.println("[8] Sair.");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        cadastroConta(scanner,banco23);
                        break;
                    case 2:
                        banco23.listarContas();
                        break;
                    case 3:
                        banco23.validandoDeposito(scanner);
                        break;
                    case 4:
                        banco23.validandoSaque(scanner);
                        break;
                    case 5:
                        banco23.alterarConta(scanner,"bloquear");
                        break;
                    case 6:
                        banco23.alterarConta(scanner,"cancelar");
                        break;
                    case 7:
                        banco23.desbloquearConta(scanner);
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

    public static void cadastroConta(Scanner scanner, Banco23 banco23){
        String nome = Banco23.validandoNome(scanner);
        String cpf = Banco23.validandoCpf(scanner);
        int numeroConta = Banco23.validandoNumeroConta(scanner);
        Cliente23.TipoConta23 tipoConta23 = Banco23.validandoTipoConta(scanner);
        Cliente23 cliente23 = new Cliente23(nome,cpf);
        Conta23 conta23;
        if (tipoConta23 == Cliente23.TipoConta23.CORRENTE){
            conta23 = new ContaCorrente23(cliente23,numeroConta,0.0,tipoConta23, Cliente23.StatusConta23.ATIVA);
            banco23.addConta(conta23);
        }else {
            conta23 = new ContaPoupanca23(cliente23,numeroConta,0.0,tipoConta23, Cliente23.StatusConta23.ATIVA);
        }
        System.out.println("Conta cadastrada com sucesso.");
    }
}
