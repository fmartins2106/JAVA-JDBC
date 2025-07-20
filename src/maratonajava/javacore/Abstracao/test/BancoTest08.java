package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class BancoTest08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco08 banco08 = new Banco08();
        while (true){
            System.out.println("[1] Cadastro conta.");
            System.out.println("[2] Lista de contas.");
            System.out.println("[3] Deposito em conta.");
            System.out.println("[4] Saque.");
            System.out.println("[5] Bloquear conta.");
            System.out.println("[6] Cancelar conta.");
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
                    cadastroConta(scanner,banco08);
                    break;
                case 2:
                    banco08.listaContas();
                    break;
                case 3:
                    banco08.realizarDeposito(scanner);
                    break;
                case 4:
                    banco08.realisarSaque(scanner);
                    break;
                case 5:
                    banco08.alterarDados(scanner,"bloquear");
                    break;
                case 6:
                    banco08.alterarDados(scanner,"encerrar");
                    break;
                case 7:
                    banco08.desbloquearConta(scanner);
                    break;
                case 8:
                    System.out.println(">>>Finalizar conta.");
                    return;
                default:
                    System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void cadastroConta(Scanner scanner, Banco08 banco08){
        String nome = Banco08.validandoNome(scanner,banco08);
        String cpf = Banco08.validandoCpf(scanner,banco08);
        int numeroConta = Banco08.validandoNumeroConta(scanner,banco08);
        Cliente08.TipoContaBanco tipoContaBanco = Banco08.validandoTipoDeConta(scanner,banco08);
        Cliente08 cliente08 = new Cliente08(nome,cpf);
        Conta08 conta08;
        if (tipoContaBanco == Cliente08.TipoContaBanco.CORRENTE){
            conta08 = new ContaCorrente08(cliente08,numeroConta,0.0, tipoContaBanco, Cliente08.StatusContaBanco.ATIVA);
        }else {
            conta08 = new ContaPoupanca08(cliente08,numeroConta,0.0,tipoContaBanco, Cliente08.StatusContaBanco.ATIVA);
        }
        banco08.addContas(conta08);
        System.out.println("Conta cadastrada com sucesso.");
    }
}
