package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CartaoDeCredito12;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Paypall12;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProcessarPagamentos12;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Transferencia12;

import java.util.Scanner;

public class SistemaDePagamento12 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ProcessarPagamentos12 processarPagamentos12 = new ProcessarPagamentos12();
        CartaoDeCredito12 cartaoDeCredito12 = new CartaoDeCredito12(5000);
        Paypall12 paypall12 = new Paypall12(3000);
        Transferencia12 transferencia12 = new Transferencia12(3000);
        while (true){
            System.out.println("[1] Pagamento com cartão de crédito.");
            System.out.println("[2] Pagamento com Paypall.");
            System.out.println("[3] Pagamento com transferência.");
            System.out.println("[4] Consultar saldo.");
            System.out.println("[5] Sair.");
            System.out.print("Digite uma das opções acima:");
            int opcao = capturandoOpcao();
            if (opcao == 5){
                System.out.println(">>>Finalizando programa.");
                return;
            }
            if (opcao == 4){
                exibindoSaldoAtualizado(processarPagamentos12,cartaoDeCredito12,paypall12,transferencia12);
                continue;
            }
            if (opcao < 1 || opcao > 5){
                System.out.println("Digite uma opção válida.");
                continue;
            }
            double valor = capturandoValor();
            switch (opcao){
                case 1:
                    ProcessarPagamentos12.autorizarPagamentos(cartaoDeCredito12,valor);
                    break;
                case 2:
                    ProcessarPagamentos12.autorizarPagamentos(paypall12,valor);
                    break;
                case 3:
                    ProcessarPagamentos12.autorizarPagamentos(transferencia12,valor);
                    break;
            }
        }
    }

    private static int capturandoOpcao(){
        while (true){
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    private static double capturandoValor(){
        while (true){
            try {
                System.out.print("Digite um valor válido:R$");
                return Double.parseDouble(scanner.nextLine().replace(",","."));
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    private static void exibindoSaldoAtualizado(ProcessarPagamentos12 processarPagamentos12, CartaoDeCredito12 cartaoDeCredito12, Paypall12 paypall12, Transferencia12 transferencia12){
        System.out.println("[1] Limite cartão de crédito.");
        System.out.println("[2] Saldo conta Paypall.");
        System.out.println("[3] Saldo conta.");
        System.out.println("[4] Sair.");
        int opcao = capturandoOpcao();
        switch (opcao){
            case 1:
                processarPagamentos12.exibirConsultaSaldo(cartaoDeCredito12);
                break;
            case 2:
                processarPagamentos12.exibirConsultaSaldo(paypall12);
                break;
            case 3:
                processarPagamentos12.exibirConsultaSaldo(transferencia12);
                break;
            case 4:
                return;
            default:
                System.out.println("Digite uma opção válida.");
        }
    }
}
