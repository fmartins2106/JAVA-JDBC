package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class BancoTest07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco07 banco07 = new Banco07();
        while (true){
            System.out.println("[1] Cadastro dados conta.");
            System.out.println("[2] Listar contas.");
            System.out.println("[3] Depositar.");
            System.out.println("[4] Sacar.");
            System.out.println("[5] Bloquear conta.");
            System.out.println("[6] Encerrar conta.");
            System.out.println("[7] Desbloquear conta.");
            System.out.println("[8] Sair.");
            int opcao = 0;
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
            switch (opcao){
                case 1:
                    cadastroConta(scanner,banco07);
                    break;
                case 2:
                    banco07.listarContasCadastradas();
                    break;
                case 3:
                    banco07.realizarDeposito(scanner);
                    break;
                case 4:
                    banco07.realizarSaque(scanner);
                    break;
                case 5:
                    banco07.alterarDados(scanner,"bloquear");
                    break;
                case 6:
                    banco07.alterarDados(scanner,"encerrar");
                    break;
                case 7:
                    banco07.desbloquear(scanner);
                    break;
                case 8:
                    System.out.println(">>Finalizando programa.");
                    return;
                default:
                    System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void cadastroConta(Scanner scanner, Banco07 banco07){
        String nome = Banco07.validandoNome(scanner,banco07);
        String cpf = Banco07.validandoCpf(scanner,banco07);
        int numeroConta = Banco07.validandoNumeroConta(scanner,banco07);
        Cliente07.TipoContas tipoContas = Banco07.validandoTipoConta(scanner,banco07);
        Cliente07 cliente07 = new Cliente07(nome,cpf);
        Conta07 conta07;
        if (tipoContas == Cliente07.TipoContas.CORRENTE){
            conta07 = new ContaCorrente07(cliente07,numeroConta,0.00,tipoContas, Cliente07.StatusContas.ATIVA);
        }else {
            conta07 = new ContaPoupanca07(cliente07,numeroConta,0.00, tipoContas, Cliente07.StatusContas.ATIVA);
        }
        banco07.addContas(conta07);
        System.out.println("Conta cadastrada com sucesso.");
    }
}
