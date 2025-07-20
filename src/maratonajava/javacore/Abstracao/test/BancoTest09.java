package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class BancoTest09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco09 banco09 = new Banco09();
        while (true){
            System.out.println("[1] Cadastro de conta.");
            System.out.println("[2] Lista de conta.");
            System.out.println("[3] Deposito.");
            System.out.println("[4] Saque.");
            System.out.println("[5] Bloquear conta.");
            System.out.println("[6] Cancelar conta.");
            System.out.println("[7] Desbloquear conta. ");
            System.out.println("[8] Sair.");
            int opcao =0;
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
            switch (opcao){
                case 1:
                    cadastroConta(scanner,banco09);
                    break;
                case 2:
                    banco09.listaContas();
                    break;
                case 3:
                    banco09.realizarDeposito(scanner);
                    break;
                case 4:
                    banco09.realizarSaque(scanner);
                    break;
                case 5:
                    banco09.alterarDados(scanner,"bloquear");
                    break;
                case 6:
                    banco09.alterarDados(scanner,"encerrar");
                    break;
                case 7:
                    banco09.desbloquearConta(scanner);
                    break;
                case 8:
                    System.out.println(">>Finalizando programa...");
                    return;
                default:
                    System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void cadastroConta(Scanner scanner, Banco09 banco09){
        String nome = Banco09.validandoNome(scanner,banco09);
        String cpf = Banco09.validandoCpf(scanner,banco09);
        int numeroConta = Banco09.validandoNumeroConta(scanner,banco09);
        Cliente09.TipoContas tipoContas = Banco09.validandoTipoDeConta(scanner,banco09);
        Cliente09 cliente09 = new Cliente09(nome,cpf);
        Conta09 conta09;
        if (tipoContas == Cliente09.TipoContas.CORRENTE){
            conta09 = new ContaCorrente09(cliente09,numeroConta,0.0, tipoContas, Cliente09.StatusContas.ATIVA);
        }else {
            conta09 = new ContaPoupanca09(cliente09,numeroConta,0.0,tipoContas, Cliente09.StatusContas.ATIVA);
        }
        banco09.addContas(conta09);
        System.out.println("Cadastro realizado com sucesso.");
    }
}
