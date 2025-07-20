package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CartaoDeCredito19;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Paypall19;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProcessarPagamentos19;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Transferencia19;

import java.util.Scanner;

public class SistemaDePagamento19 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ProcessarPagamentos19 processarPagamentos19 = new ProcessarPagamentos19();
        CartaoDeCredito19 cartaoDeCredito19 = new CartaoDeCredito19(4000);
        Paypall19 paypall19 = new Paypall19(3000);
        Transferencia19 transferencia19 = new Transferencia19(3000);
        while (true){
            System.out.println("[1] Pagamento com cartão de crédito.");
            System.out.println("[2] Pagamento com Paypall.");
            System.out.println("[3] Transferência bancária.");
            System.out.println("[4] Consultar saldo.");
            System.out.println("[5] Sair.");
            int opcao = capturarOpcao();
            if (opcao == 5){
                System.out.println(">>>Finalizando programa.");
                return;
            }
            if (opcao == 4){
                exibindoConsultaSaldo(processarPagamentos19,cartaoDeCredito19,paypall19,transferencia19);
                continue;
            }
            if (opcao < 1 || opcao > 5){
                System.out.println("Digite uma opção válida.");
                continue;
            }
            double valor = capturarValor();
            switch (opcao){
                case 1:
                    processarPagamentos19.realizarOperacao(cartaoDeCredito19,valor);
                    break;
                case 2:
                    processarPagamentos19.realizarOperacao(paypall19,valor);
                    break;
                case 3:
                    processarPagamentos19.realizarOperacao(transferencia19,valor);
                    break;
            }
        }
    }

    private static int capturarOpcao(){
        while (true){
            try {
                System.out.print("Digite uma das opções acima:");
                return Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    private static double capturarValor(){
        while (true){
            try {
                System.out.print("Valor:R$");
                return Double.parseDouble(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static void exibindoConsultaSaldo(ProcessarPagamentos19 processarPagamentos19, CartaoDeCredito19 cartaoDeCredito19, Paypall19 paypall19, Transferencia19 transferencia19){
        System.out.println("[1] Consulta limite cartão de crédito.");
        System.out.println("[2] Consulta saldo Paypall.");
        System.out.println("[3] Consulta transferência bancária.");
        System.out.println("[4] Sair.");
        int opcao = capturarOpcao();
        switch (opcao){
            case 1:
                processarPagamentos19.consultarSaldoDisponivel(cartaoDeCredito19);
                break;
            case 2:
                processarPagamentos19.consultarSaldoDisponivel(paypall19);
                break;
            case 3:
                processarPagamentos19.consultarSaldoDisponivel(transferencia19);
                break;
            case 4:
                return;
            default:
                System.out.println("Digite uma opção válida.");
        }
    }
}
