package academy.devdojo.maratonajava.SCI;

import java.text.DecimalFormat;
import java.util.Deque;
import java.util.Scanner;

public class Exercicio09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        validacaoVotos(scanner);
    }

    public static final DecimalFormat df = new DecimalFormat("0.00");

    public static void validacaoVotos(Scanner scanner){
        while (true){
            try {
                System.out.print("Digite o total de eleitores:");
                double totalDeEleitores = Double.parseDouble(scanner.nextLine().trim());
                System.out.print("Digite os votos válidos:");
                double votosValidos = Double.parseDouble(scanner.nextLine().trim());
                System.out.print("Digite os votos nulos:");
                double votoNulos = Double.parseDouble(scanner.nextLine().trim());
                System.out.print("Digite os votos em branco:");
                double votoBranco = Double.parseDouble(scanner.nextLine().trim());
                if ((votoBranco+votoNulos+votosValidos) > totalDeEleitores){
                    System.out.println("A soma de votos validos, branco e nulos não pode ser maior que total de eleitores.");
                }else {
                    double percentualVotosValidos = (votosValidos / totalDeEleitores) * 100;
                    System.out.println("Votos válidos:"+df.format(percentualVotosValidos)+"%");
                    double percentualVotosNulos = (votoNulos / totalDeEleitores) * 100;
                    System.out.println("Votos válidos:"+df.format(percentualVotosNulos)+"%");
                    double percentualVotosBranco = (votoBranco / totalDeEleitores) * 100;
                    System.out.println("Votos válidos:"+df.format(percentualVotosBranco)+"%");
                    double naoVotantes = ((totalDeEleitores - (votoBranco+votoNulos+votosValidos)) / totalDeEleitores) * 100;
                    System.out.println("Votos válidos:"+df.format(naoVotantes)+"%");
                    break;
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }
}
