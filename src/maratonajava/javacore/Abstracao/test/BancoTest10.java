package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class BancoTest10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco10 banco10 = new Banco10();
        while (true){
            System.out.println("[1] Cadastro conta.");
            System.out.println("[2] Lista de contas.");
            System.out.println("[3] Deposito.");
            System.out.println("[4] Transferência.");
            System.out.println("[5] Bloquear conta.");
            System.out.println("[6] Cancelar conta.");
            System.out.println("[7] Desbloquear conta.");
            System.out.println("[8] Sair.");
            int opcao = 0;
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite  uma opção válida.");
            }
            switch (opcao){
                case 1:
                    cadastroConta(scanner,banco10);
                    break;
                case 2:
                    banco10.listaContas();
                    break;
                case 3:
                    banco10.depositar(scanner,banco10);
                    break;
                case 4:
                    banco10.realizarTransferencia(scanner,banco10);
                    break;
                case 5:
                    banco10.alterarDados(scanner,"bloquear");
                    break;
                case 6:
                    banco10.alterarDados(scanner,"encerrar");
                    break;
                case 7:
                    banco10.desbloquearConta(scanner);
                    break;
                case 8:
                    System.out.println(">>>Finalizar programa...");
                    return;
                default:
                    System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void cadastroConta(Scanner scanner, Banco10 banco10){
        String nome = Banco10.validandoNome(scanner,banco10);
        String cpf = Banco10.validandoCpf(scanner,banco10);
        int numeroConta = Banco10.validandoNumeroConta(scanner,banco10);
        Cliente10 cliente10 = new Cliente10(nome,cpf);
        Cliente10.TipoConta10 tipoConta10 = Banco10.validandoTipoConta(scanner);
        Cliente10.StatusConta10 statusConta10 = Cliente10.StatusConta10.ATIVA;
        Conta10 conta10;
        if (tipoConta10 == Cliente10.TipoConta10.CORRENTE){
            conta10 =new ContaCorrente10(cliente10,numeroConta,0.0,tipoConta10,statusConta10);
        }else {
            conta10 = new ContaPoupanca10(cliente10,numeroConta, 0.0,tipoConta10,statusConta10);
        }
        banco10.addContas(conta10);
        System.out.println("Conta criada com sucesso.");
    }
}
