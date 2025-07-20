package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class BancoTest16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco16 banco16 = new Banco16();
        while (true){
            System.out.println("[1] Cadastro de conta.");
            System.out.println("[2] Lista de contas.");
            System.out.println("[3] Deposito.");
            System.out.println("[4] Saque.");
            System.out.println("[5] Bloquear conta.");
            System.out.println("[6] Desbloquear conta.");
            System.out.println("[7] Cancelar conta.");
            System.out.println("[8] Sair.");
            try {
                System.out.print("Digite uma opção válida.");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        cadastroConta(scanner,banco16);
                        break;
                    case 2:
                        banco16.listarContas();
                        break;
                    case 3:
                        banco16.depositar(scanner);
                        break;
                    case 4:
                        banco16.sacar(scanner);
                        break;
                    case 5:
                        banco16.alterarStatusConta(scanner,"bloquear");
                        break;
                    case 6:
                        banco16.desbloquearConta(scanner);
                        break;
                    case 7:
                        banco16.alterarStatusConta(scanner,"encerrar");
                        break;
                    case 8:
                        System.out.println(">>>Finalizando programa.");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Opção inválida, tente novamente.");
            }
        }
    }

    public static void cadastroConta(Scanner scanner, Banco16 banco16){
        String nome = Banco16.validandoNome(scanner);
        String cpf = Banco16.validandoCpf(scanner);
        int numeroConta = Banco16.validandoNumeroConta(scanner);
        Cliente16.TipoContaCliente16 tipoContaCliente16 = Banco16.validandoTipoConta(scanner);
        Cliente16 cliente16 = new Cliente16(nome,cpf);
        Conta16 conta16;
        if (tipoContaCliente16 == Cliente16.TipoContaCliente16.CORRENTE){
            conta16 = new ContaCorrente16(cliente16,numeroConta,0.0,tipoContaCliente16, Cliente16.StatusContaCliente16.ATIVO);
            banco16.addConta(conta16);
            System.out.println("Conta corrente cadastrada com sucesso.");
        }else {
            conta16 = new ContaPoupanca16(cliente16,numeroConta,0.0,tipoContaCliente16, Cliente16.StatusContaCliente16.ATIVO);
            banco16.addConta(conta16);
            System.out.println("Conta poupança cadastrada com sucesso.");
        }
    }
}
