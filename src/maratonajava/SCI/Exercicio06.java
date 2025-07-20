package academy.devdojo.maratonajava.SCI;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Exercicio06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        vendasBrecho(scanner);
    }

    private static DecimalFormat df = new DecimalFormat("0.00");
    public static void vendasBrecho(Scanner scanner){
        try {
            System.out.print("Digite o valor de compra:R$");
            double valorCompra = Double.parseDouble(scanner.nextLine().trim());
            if (valorCompra < 50){
                double precoVenda1 = (valorCompra * 0.45) +valorCompra;
                System.out.println("Preço de venda:R$"+df.format(precoVenda1));
            }else {
                double precoVenda02 = (valorCompra * 0.30) + valorCompra;
                System.out.println("Preço de venda:R$"+df.format(precoVenda02));
            }
        }catch (NumberFormatException e){
            System.out.println("Digite um valor válido");
        }
    }
}
