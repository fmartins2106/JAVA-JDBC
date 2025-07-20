package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CartaoDeCredito24;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Paypall24;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProcessarPagamentos24;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Transferencia24;

import java.util.Scanner;

public class SistemaDePagamento24 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ProcessarPagamentos24 processarPagamentos24 = new ProcessarPagamentos24();
        CartaoDeCredito24 cartaoDeCredito24 = new CartaoDeCredito24(4000);
        Paypall24 paypall24 = new Paypall24(1000);
        Transferencia24 transferencia24 = new Transferencia24(2000);
        while (true){
            System.out.println("[1] Pagamento com cartão de crédito.");
            System.out.println("[2] Pagamento com Paypall.");
            System.out.println("[3] Pagamento com transferência bancária.");
            System.out.println("[4] Consulta saldo.");
            System.out.println("[5] Sair.");
            int opcao = capturarOpcao();
            if (opcao == 5){
                System.out.println(">>>>>Finalizando programa.");
                return;
            }
            if (opcao == 4){
                consultaSaldo(processarPagamentos24,cartaoDeCredito24,paypall24,transferencia24);
                continue;
            }
            if (opcao < 1 || opcao > 5){
                System.out.println("Digite uma opção válida.");
                continue;
            }
            double valor = capturarValor();
            switch (opcao){
                case 1:
                    processarPagamentos24.realizarPagamentos(cartaoDeCredito24,valor);
                    break;
                case 2:
                    processarPagamentos24.realizarPagamentos(paypall24,valor);
                    break;
                case 3:
                    processarPagamentos24.realizarPagamentos(transferencia24,valor);
                    break;
            }
        }
    }

    public static int capturarOpcao(){
        while (true){
            try {
                System.out.print("Digite uma das opções acima:");
                return Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static double capturarValor(){
        while (true){
            try {
                System.out.print("Valor:R$");
                return Double.parseDouble(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static void consultaSaldo(ProcessarPagamentos24 processarPagamentos24, CartaoDeCredito24 cartaoDeCredito24, Paypall24 paypall24, Transferencia24 transferencia24){
        System.out.println("[1] Consulta limite cartão de crédito.");
        System.out.println("[2] Consulta conta Paypall.");
        System.out.println("[3] Consulta saldo conta.");
        System.out.println("[4] Sair.");
        int opcao = capturarOpcao();
        switch (opcao){
            case 1:
                processarPagamentos24.consultarSaldo(cartaoDeCredito24);
                break;
            case 2:
                processarPagamentos24.consultarSaldo(paypall24);
                break;
            case 3:
                processarPagamentos24.consultarSaldo(transferencia24);
                break;
            case 4:
                return;
            default:
                System.out.println("Digite uma opção válida.");
        }
    }
}
