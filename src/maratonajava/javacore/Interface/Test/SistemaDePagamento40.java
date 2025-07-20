package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CartaoDeCredito40;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Paypall40;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProcessarPagamentos40;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Transferencia40;

import java.util.Scanner;

public class SistemaDePagamento40 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final CartaoDeCredito40 cartaoDeCredito = new CartaoDeCredito40(4000);
    private static final Paypall40 paypall = new Paypall40(300);
    private static final Transferencia40 transferencia = new Transferencia40(3000);


    public static void main(String[] args) {
        ProcessarPagamentos40 processarPagamentos40 = new ProcessarPagamentos40();
        while (true){
            System.out.println("[1] Pagamento com cartão de crédito.");
            System.out.println("[2] Pagamento com Paypall.");
            System.out.println("[3] Pagamento com transferência bancária.");
            System.out.println("[4] Consulta saldo.");
            System.out.println("[5] Sair.");
            System.out.print("Digite uma das opções acima:");
            int opcao = Integer.parseInt(scanner.nextLine().trim());
            if (opcao == 5){
                System.out.println(">>>Finalizando sistema.");
                return;
            }
            if (opcao == 4){
                consultaSaldo(processarPagamentos40);
                continue;
            }
            if (opcao < 0 || opcao > 5){
                System.out.println("Erro. Digite uma opção válida.");
                continue;
            }
            double valor = capturarValor();
            switch (opcao){
                case 1:
                    processarPagamentos40.realizarPagamento(cartaoDeCredito,valor);
                    break;
                case 2:
                    processarPagamentos40.realizarPagamento(paypall,valor);
                    break;
                case 3:
                    processarPagamentos40.realizarPagamento(transferencia,valor);
            }
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

    private static void consultaSaldo(ProcessarPagamentos40 processarPagamentos40){
        System.out.println("[1] Limite cartão de crédito.");
        System.out.println("[2] Saldo Paypall.");
        System.out.println("[3] Saldo conta.");
        System.out.println("[4] Sair.");
        int opcao = capturarOpcao();
        switch (opcao){
            case 1:
                processarPagamentos40.consultaSaldo(cartaoDeCredito);
                break;
            case 2:
                processarPagamentos40.consultaSaldo(paypall);
                break;
            case 3:
                processarPagamentos40.consultaSaldo(transferencia);
                break;
            case 4:
                return;
            default:
                System.out.println(">>Erro<<Digite uma opção válida.");
        }
    }
}
