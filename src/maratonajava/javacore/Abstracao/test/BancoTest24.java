package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class BancoTest24 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco24 banco24 = new Banco24();
        while (true){
            try {
                System.out.println("[1] Cadastro Conta.");
                System.out.println("[2] Lista de contas cadastradas.");
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
                        cadastroConta(scanner,banco24);
                        break;
                    case 2:
                        banco24.listaContasCadastradas();
                        break;
                    case 3:
                        banco24.validandoDeposito(scanner);
                        break;
                    case 4:
                        banco24.validandoSaque(scanner);
                        break;
                    case 5:
                        banco24.validandoAlterarConta(scanner,"bloquear");
                        break;
                    case 6:
                        banco24.validandoAlterarConta(scanner,"desbloquear");
                        break;
                    case 7:
                        banco24.validandoAlterarConta(scanner,"cancelar");
                        break;
                    case 8:
                        System.out.println(">>>Finalizando conta...");
                        return;
                    default:
                        System.out.println("Digite um valor válido para depósito.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static void cadastroConta(Scanner scanner, Banco24 banco24){
        String nome = Banco24.validandoNome(scanner);
        String cpf = Banco24.validandoCpf(scanner);
        int numeroConta = Banco24.validandoNumeroConta(scanner);
        Cliente24.TipoConta24 tipoConta24 = Banco24.validandoTipoConta(scanner);
        Cliente24 cliente24 = new Cliente24(nome,cpf);
        Conta24 conta24;
        if (tipoConta24 == Cliente24.TipoConta24.CORRENTE){
            conta24 = new ContaCorrente24(cliente24,numeroConta,0.0,tipoConta24, Cliente24.StatusConta24.ATIVA);
            banco24.addConta(conta24);
        }else {
            conta24 = new ContaPoupanca24(cliente24,numeroConta,0.0,tipoConta24, Cliente24.StatusConta24.ATIVA);
            banco24.addConta(conta24);
        }
        System.out.println("Conta cadastrada com sucesso.");
    }
}
