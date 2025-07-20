package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CartaoDeCredito44;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Paypall44;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProcessarPagamentos44;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Transferencia44;

import java.util.Scanner;

public class SistemaDePagamento44 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final CartaoDeCredito44 cartaoDeCredito44 = new CartaoDeCredito44(4000);
    private static final Paypall44 paypall44 = new Paypall44(2000);
    private static final Transferencia44 transferencia44 = new Transferencia44(3000);
    private static final ProcessarPagamentos44 processarPagamentos44 = new ProcessarPagamentos44();

    public static void main(String[] args) {
        while (true){
            exibirMenu();
            int opcao = capturarOpcao();
            if (opcao == 5){
                System.out.println(">>Finalizando sistema.");
                return;
            }
            if (opcao == 4){
                exibirSaldo();
                continue;
            }
            if (opcao < 0 || opcao > 5){
                System.out.println("Erro. Digite uma opção válida.");
                continue;
            }
            double valor = capturarValor();
            switch (opcao){
                case 1:
                    processarPagamentos44.realizarPagamento(cartaoDeCredito44,valor);
                    break;
                case 2:
                    processarPagamentos44.realizarPagamento(paypall44,valor);
                    break;
                case 3:
                    processarPagamentos44.realizarPagamento(transferencia44,valor);
                    break;
            }
        }
    }

    private static void exibirMenu(){
        System.out.println("[1] Pagamento com cartão de crédito.");
        System.out.println("[2] Pagamento com Paypall.");
        System.out.println("[3] Pagamento com transferência bancária.");
        System.out.println("[4] Consulta saldo.");
        System.out.println("[5] Sair.");
    }

    private static int capturarOpcao(){
        while (true){
            try {
                System.out.print("Digite uma das opções acima:");
                return Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite uma opção válida.");
            }
        }
    }

    private static double capturarValor(){
        while (true){
            try {
                System.out.print("Valor:R$");
                return Double.parseDouble(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido.");
            }
        }
    }

    private static void exibirSaldo(){
        System.out.println("[1] Limite cartão de crédito.");
        System.out.println("[2] Saldo Paypall.");
        System.out.println("[3] Saldo conta corrente.");
        System.out.println("[4] Sair.");
        int opcao = capturarOpcao();
        switch (opcao){
            case 1:
                processarPagamentos44.consultaSaldo(cartaoDeCredito44);
                break;
            case 2:
                processarPagamentos44.consultaSaldo(paypall44);
                break;
            case 3:
                processarPagamentos44.consultaSaldo(transferencia44);
                break;
            case 4:
                return;
            default:
                System.out.println("Erro, digite uma opção válida.");
        }
    }
}
