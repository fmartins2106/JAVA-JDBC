package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class BancoTest22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco22 banco22 = new Banco22();
        while (true){
            System.out.println("[1] Cadastro conta.");
            System.out.println("[2] Lista conta.");
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
                        cadastroConta(scanner,banco22);
                        break;
                    case 2:
                        banco22.listaContas();
                        break;
                    case 3:
                        banco22.validandoDeposito(scanner);
                        break;
                    case 4:
                        banco22.validandoSaque(scanner);
                        break;
                    case 5:
                        banco22.validandoBloqueioConta(scanner);
                        break;
                    case 6:
                        banco22.validandoDesbloqueioConta(scanner);
                        break;
                    case 7:
                        banco22.validandoCancelamentoConta(scanner);
                        break;
                    case 8:
                        System.out.println(">>>Finalizando sistema...");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void cadastroConta(Scanner scanner, Banco22 banco22){
        String nome = Banco22.validandoNome(scanner);
        String cpf = Banco22.validandoCpf(scanner);
        int numeroConta = Banco22.validandoNumeroConta(scanner);
        Cliente22.TipoConta22 tipoConta22 = banco22.validandoTipoConta(scanner);
        Cliente22 cliente22 = new Cliente22(nome,cpf);
        Conta22 conta22;
        if (tipoConta22 == Cliente22.TipoConta22.CORRENTE){
            conta22 = new ContaCorrente22(cliente22,numeroConta,0.0,tipoConta22, Cliente22.StatusConta22.ATIVA);
            banco22.addConta(conta22);
        }else {
            conta22 = new ContaPoupanca22(cliente22,numeroConta,0.0,tipoConta22, Cliente22.StatusConta22.ATIVA);
        }
        System.out.println("Conta cadastrada com sucesso.");
    }

}
