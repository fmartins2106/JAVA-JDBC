package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class BancoTest42 {
    private static final Scanner scanner = new Scanner(System.in);
    private static Banco42 banco42 = new Banco42();

    public static void main(String[] args) {
        while (true){
            try {
                exibirMenu();
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao){
                    case 1:
                        cadastroConta();
                        break;
                    case 2:
                        banco42.listarContasCadastradas();
                        break;
                    case 3:
                        banco42.sacar();
                        break;
                    case 4:
                        banco42.depositar();
                        break;
                    case 5:
                        banco42.alterarConta("bloquear");
                        break;
                    case 6:
                        banco42.alterarConta("desbloquear");
                        break;
                    case 7:
                        banco42.alterarConta("cancelar");
                        break;
                    case 8:
                        System.out.println(">>>Finalizando sistema.");
                        return;
                    default:
                        System.out.println("Erro. Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite uma opção válida.");
            }
        }
    }

    private static void exibirMenu(){
        System.out.println("[1] Cadastro conta.");
        System.out.println("[2] Lista de contas cadastradas.");
        System.out.println("[3] Sacar.");
        System.out.println("[4] Depositar.");
        System.out.println("[5] Bloquear.");
        System.out.println("[6] Desbloquear.");
        System.out.println("[7] Cancelar.");
        System.out.println("[8] Sair.");
    }

    private static void cadastroConta(){
        String nome = Banco42.validandoNome();
        String cpf = Banco42.validandoCpf();
        int numeroConta = Banco42.validandoConta();
        Conta42.TipoConta42 tipoConta42 = Banco42.validandoTipoConta();
        Cliente42 cliente42 = new Cliente42(nome,cpf);
        Conta42 conta42;
        if (tipoConta42 == Conta42.TipoConta42.CORRENTE){
            conta42 = new ContaCorrente42(cliente42,numeroConta,0.0,tipoConta42, Conta42.StatusConta42.ATIVA);
        }else {
            conta42 = new ContaPoupanca42(cliente42,numeroConta,0.00,tipoConta42,Conta42.StatusConta42.ATIVA);

        }
        banco42.addContaSistema(conta42);

    }

}
