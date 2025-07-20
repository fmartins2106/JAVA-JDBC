package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class BancoTest17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco17 banco17 = new Banco17();
        while (true){
            System.out.println("[1] Cadastro conta.");
            System.out.println("[2] Lista de conta.");
            System.out.println("[3] Deposito.");
            System.out.println("[4] Saque.");
            System.out.println("[5] Bloquear.");
            System.out.println("[6] Cancelar.");
            System.out.println("[7] Desbloquear.");
            System.out.println("[8] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        cadastroConta(scanner,banco17);
                        break;
                    case 2:
                        banco17.listarContas();
                        break;
                    case 3:
                        banco17.validandoDeposito(scanner);
                        break;
                    case 4:
                        banco17.validacaoSaque(scanner);
                        break;
                    case 5:
                        banco17.validandoBloqueioEcancelamento(scanner,"bloquear");
                        break;
                    case 6:
                        banco17.validandoBloqueioEcancelamento(scanner, "Encerrar");
                        break;
                    case 7:
                        banco17.validandoDesbloqueiConta(scanner);
                        break;
                    case 8:
                        System.out.println(">>>>Finalizando programa.");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um número de opção válido.");
            }
        }
    }

    public static void cadastroConta(Scanner scanner, Banco17 banco17){
        String nome = Banco17.validandoNome(scanner);
        String cpf = Banco17.validandoCpf(scanner);
        int numeroConta = Banco17.validandoNumeroConta(scanner);
        Cliente17.TipoConta17 tipoConta17 = Banco17.validandoTipoConta(scanner);
        Cliente17 cliente17 = new Cliente17(nome,cpf);
        Conta17 conta17;
        if (tipoConta17 == Cliente17.TipoConta17.CORRENTE){
            conta17 = new ContaCorrente17(cliente17,numeroConta,0.0,tipoConta17, Cliente17.StatusConta17.ATIVA);
            banco17.addConta(conta17);
            System.out.println("Conta corrente criada com sucesso.");
        }else {
            conta17 = new ContaPoupanca17(cliente17,numeroConta,0.0,tipoConta17, Cliente17.StatusConta17.ATIVA);
            banco17.addConta(conta17);
            System.out.println("Conta poupança criada com sucesso.");
        }
    }

}
