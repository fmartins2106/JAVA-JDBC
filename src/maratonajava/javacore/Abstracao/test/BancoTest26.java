package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class BancoTest26 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco26 banco26 = new Banco26();
        while (true){
            System.out.println("[1] Cadastrar conta.");
            System.out.println("[2] Lista de contas.");
            System.out.println("[3] Pesquisa por número de conta.");
            System.out.println("[3] Depósito.");
            System.out.println("[4] Saque.");
            System.out.println("[5] Bloquear conta.");
            System.out.println("[6] Desbloquear conta.");
            System.out.println("[7] Cancelar conta.");
            try {
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        cadastroConta(scanner,banco26);
                        break;
                    case 2:
                        banco26.listaContas();
                        break;
                    case 3:
                        banco26.validandoDeposito(scanner);
                        break;
                    case 4:
                        banco26.validandoSaque(scanner);
                        break;
                    case 5:
                        banco26.bloquearConta(scanner);
                        break;
                    case 6:
                        banco26.desbloquearConta(scanner);
                        break;
                    case 7:
                        banco26.cancelarConta(scanner);
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

    public static void cadastroConta(Scanner scanner, Banco26 banco26){
        String nome = Banco26.validandoNome(scanner);
        String cpf = Banco26.validandoCpf(scanner);
        int numeroConta = Banco26.validandoNumeroConta(scanner);
        Conta26.TipoConta26 tipoConta26 = Banco26.validandoTipoConta26(scanner);
        Cliente26 cliente26 = new Cliente26(nome,cpf);
        Conta26 conta26;
        if (tipoConta26 == Conta26.TipoConta26.CORRENTE){
            conta26 = new ContaCorrente26(cliente26,numeroConta,0.0,tipoConta26, Conta26.StatusConta26.ATIVA);
            banco26.addConta(conta26);
        }else {
            conta26 = new ContaPoupanca26(cliente26,numeroConta,0.0,tipoConta26, Conta26.StatusConta26.ATIVA);
            banco26.addConta(conta26);
        }
        System.out.println("Conta criada com sucesso.");
    }
}
