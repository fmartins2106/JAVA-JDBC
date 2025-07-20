package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CartaoDeCredito18;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Paypall18;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProcessarPagamentos18;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Transferencia18;

import java.util.Scanner;

public class SistemaDePagamento18 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ProcessarPagamentos18 processarPagamentos18 = new ProcessarPagamentos18();
        CartaoDeCredito18 cartaoDeCredito18 = new CartaoDeCredito18(3000);
        Paypall18 paypall18 = new Paypall18(1000);
        Transferencia18 transferencia18 = new Transferencia18(3000);
        while (true){
            System.out.println("[1] Pagamento com cartão de crédito.");
            System.out.println("[2] Pagamento com Paypall.");
            System.out.println("[3] Pagamento com transferência bancária.");
            System.out.println("[4] Saldo/Limite disponível.");
            System.out.println("[5] Sair.");
            int opcao = capturarOpcao();
            if (opcao == 5){
                System.out.println(">>Finalizando programa>>");
                return;
            }
            if (opcao == 4){
                exibirResultadosSaldo(processarPagamentos18,cartaoDeCredito18,paypall18,transferencia18);
                continue;
            }
            if (opcao < 1 || opcao > 5){
                System.out.println("Digite uma opção válida.");
                continue;
            }
            double valor = capturarValor();
            switch (opcao){
                case 1:
                    processarPagamentos18.realizarPagamentos(cartaoDeCredito18,valor);
                    break;
                case 2:
                    processarPagamentos18.realizarPagamentos(paypall18,valor);
                    break;
                case 3:
                    processarPagamentos18.realizarPagamentos(transferencia18,valor);
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
                System.out.print("Digite um valor válido:");
                return Double.parseDouble(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static void exibirResultadosSaldo(ProcessarPagamentos18 processarPagamentos18, CartaoDeCredito18 cartaoDeCredito18, Paypall18 paypall18, Transferencia18 transferencia18){
        System.out.println("[1] Limite cartão de crédito.");
        System.out.println("[2] Saldo Paypall.");
        System.out.println("[3] Saldo conta.");
        System.out.println("[4] Sair.");
        System.out.print("Digite uma das opções acima:");
        int opcao = capturarOpcao();
        switch (opcao){
            case 1:
                processarPagamentos18.consultarSaldo(cartaoDeCredito18);
                break;
            case 2:
                processarPagamentos18.consultarSaldo(paypall18);
                break;
            case 3:
                processarPagamentos18.consultarSaldo(transferencia18);
                break;
            case 4:
                return;
            default:
                System.out.println("Digite uma opção válida.");
        }
    }
}
