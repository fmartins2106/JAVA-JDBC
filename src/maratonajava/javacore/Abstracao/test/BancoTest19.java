package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class BancoTest19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco19 banco19 = new Banco19();
        while (true){
            try {
                System.out.println("[1] Cadastro conta.");
                System.out.println("[2] Lista conta.");
                System.out.println("[3] Depósito.");
                System.out.println("[4] Saque.");
                System.out.println("[5] Bloquear conta.");
                System.out.println("[6] Desbloquear conta.");
                System.out.println("[7] Cancelar conta.");
                System.out.println("[8] Sair.");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        cadastroConta(scanner,banco19);
                        break;
                    case 2:
                        banco19.listaContas();
                        break;
                    case 3:
                        banco19.validandoDeposito(scanner);
                        break;
                    case 4:
                        banco19.validandoSaque(scanner);
                        break;
                    case 5:
                        banco19.alterarStatusConta(scanner,"bloquear");
                        break;
                    case 6:
                        banco19.desbloquearConta(scanner);
                        break;
                    case 7:
                        banco19.alterarStatusConta(scanner,"encerrar");
                        break;
                    case 8:
                        System.out.println(">>>>Finalizando programa....");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void cadastroConta(Scanner scanner, Banco19 banco19){
        String nome = Banco19.validandoNome(scanner);
        String cpf = Banco19.validandoCpf(scanner);
        int numeroConta = Banco19.validandoNumeroConta(scanner);
        Cliente19.TipoConta19 tipoConta19 = Banco19.validandoTipoConta(scanner);
        Cliente19 cliente19 = new Cliente19(nome,cpf);
        Conta19 conta19;
        if (tipoConta19 == Cliente19.TipoConta19.CORRENTE){
            conta19 = new ContaCorrente19(cliente19,numeroConta,0.0, tipoConta19, Cliente19.StatusConta19.ATIVA);
            banco19.addConta(conta19);
        }else {
            conta19 = new ContaPoupanca19(cliente19,numeroConta,0.0,tipoConta19, Cliente19.StatusConta19.ATIVA);
            banco19.addConta(conta19);
        }
        System.out.println("Conta cadastrada com sucesso.");
    }
}
