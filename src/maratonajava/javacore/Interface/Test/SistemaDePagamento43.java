package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CartaoDeCredito43;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Paypall43;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProcessarPagamentos43;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Transferencia43;

import javax.swing.text.Style;
import java.util.Scanner;

public class SistemaDePagamento43 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ProcessarPagamentos43 processarPagamento43 = new ProcessarPagamentos43();
    private static final CartaoDeCredito43 cartaoDeCredito43 = new CartaoDeCredito43(3000);
    private static final Paypall43 paypall43 = new Paypall43(2000);
    private static final Transferencia43 transferencia43 = new Transferencia43(2000);

    public static void main(String[] args) {
        while (true){
            exibirMenu();
            int opcao = capturarOpcao();
            if (opcao == 4){
                exbirSaldo();
                continue;
            }
            if (opcao == 5){
                System.out.println(">>>Finalizando sistema.");
                return;
            }
            if (opcao < 0 || opcao > 5){
                System.out.println("Erro. Digite uma opção válida.");
            }
            double valor = capturarValor();
            codigoOpcoes(opcao,valor);
        }

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

    private static void exibirMenu(){
        System.out.println("[1] Pagamento com cartão de crédito.");
        System.out.println("[2] Pagamento com Paypall.");
        System.out.println("[3] Trasnferência bancária.");
        System.out.println("[4] Consulta saldo.");
        System.out.println("[5] Sair.");
    }

    private static void codigoOpcoes(int opcao, double valor){
        switch (opcao){
            case 1:
                processarPagamento43.realizarPagamento(cartaoDeCredito43,valor);
                break;
            case 2:
                processarPagamento43.realizarPagamento(paypall43,valor);
                break;
            case 3:
                processarPagamento43.realizarPagamento(transferencia43,valor);
        }
    }

    private static void exbirSaldo(){
        System.out.println("[1] Consulta limite cartão.");
        System.out.println("[2] Consulta saldo Paypall.");
        System.out.println("[3] Consulta saldo conta.");
        System.out.println("[4] Sair.");
        int opcao = capturarOpcao();
        switch (opcao){
            case 1:
                processarPagamento43.consultarSaldo(cartaoDeCredito43);
                break;
            case 2:
                processarPagamento43.consultarSaldo(paypall43);
                break;
            case 3:
                processarPagamento43.consultarSaldo(transferencia43);
                break;
            case 4:
                return;
            default:
                System.out.println("Erro. Digite uma opção válida.");
        }
    }

}
