package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class BancoTest13 {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        Banco13 banco13 = new Banco13();

        while (true){
            try {
                System.out.println("[1] Cadastro conta.");
                System.out.println("[2] Lista de contas cadastradas.");
                System.out.println("[3] Deposito.");
                System.out.println("[4] Saque.");
                System.out.println("[5] Bloquear conta.");
                System.out.println("[6] Cancelar conta.");
                System.out.println("[7] Desbloquear conta.");
                System.out.println("[8] Sair.");
                System.out.print("Digite uma das oopções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        cadastroConta(scanner,banco13);
                        break;
                    case 2:
                        banco13.listaConta();
                        break;
                    case 3:
                        banco13.deposito(scanner);
                        break;
                    case 4:
                        banco13.saque(scanner);
                        break;
                    case 5:
                        banco13.alterarStatusConta(scanner,"bloquear");
                        break;
                    case 6:
                        banco13.alterarStatusConta(scanner,"encerrar");
                        break;
                    case 7:
                        banco13.desbloquearConta(scanner);
                        break;
                    case 8:
                        System.out.println(">>>Finalizando programa...");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static void cadastroConta(Scanner scanner, Banco13 banco13){
        String nome = Banco13.validandoNome(scanner,banco13);
        String cpf = Banco13.validandoCpf(scanner,banco13);
        int numeroConta = Banco13.validandoNumeroConta(scanner,banco13);
        Cliente13.TipoConta13 tipoConta13 = Banco13.validacaoTipoConta(scanner);
        Cliente13 cliente13 = new Cliente13(nome,cpf);
        Conta13 conta13;
        if (tipoConta13 == Cliente13.TipoConta13.CORRENTE){
            conta13 = new ContaCorrente13(cliente13,numeroConta,0.0,tipoConta13, Cliente13.StatusConta13.ATIVA);
            banco13.addConta(conta13);
        }else {
            conta13 = new ContaPoupanca13(cliente13,numeroConta,0.0,tipoConta13, Cliente13.StatusConta13.ATIVA);
            banco13.addConta(conta13);
        }
        System.out.println("Conta cadastrada com sucesso.");
    }

}
