package academy.devdojo.maratonajava.SCI;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Exercicio05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        calcularAreaTerreno(scanner);

    }

    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static void calcularAreaTerreno(Scanner scanner){
        try {
            String tipoTerreno="";
            do {
                System.out.print("O terreno é retangular ou  trapezoidal?:");
                tipoTerreno = scanner.nextLine().trim();
            }while (!tipoTerreno.equalsIgnoreCase("retangular") && !tipoTerreno.equalsIgnoreCase("trapezoidal"));
            if (tipoTerreno.equalsIgnoreCase("retangular")){
                System.out.print("Digite a base:");
                double base = Double.parseDouble(scanner.nextLine().trim());
                System.out.print("Digite a altura:");
                double altura = Double.parseDouble(scanner.nextLine().trim());
                double calculo = base * altura;
                System.out.println("A área do terreno é:"+df.format(calculo)+"m2");
            }else {
                System.out.print("Digite a base maior:");
                double baseMaior = Double.parseDouble(scanner.nextLine().trim());
                System.out.print("Digite a base menor:");
                double baseMenor = Double.parseDouble(scanner.nextLine().trim());
                System.out.print("Digite a altura:");
                double altura = Double.parseDouble(scanner.nextLine().trim());
                double calculo2 = ((baseMaior+baseMenor) * altura) /2;
                System.out.println("A área do terreno é:"+df.format(calculo2)+"m2");
            }
        }catch (NumberFormatException e){
            System.out.println("Digite um número válido.");
        }
    }
}
