package academy.devdojo.maratonajava.SCI;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Exercicio08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
            calculandoMediaTurma(scanner);
    }

    private static DecimalFormat df = new DecimalFormat("0.00");

    public static void calculandoMediaTurma(Scanner scanner){
        double[] notas = new double[20];
        int soma = 0;
        double mediaTurma = 0;
        for (int i = 0; i < notas.length; i++) {
            while (true){
                try {
                    System.out.print("Digite a nota do "+(i+1)+"ª aluno:");
                    double nota = Double.parseDouble(scanner.nextLine().trim());
                    if (nota < 0 || nota > 10){
                        System.out.println("Nota inválida.");
                        continue;
                    }
                    double somaNotas = 0;
                    for (double n1 : notas) {
                        somaNotas = n1+=1;
                        if (n1 > mediaTurma){
                            soma+=1;
                        }
                    }
                    mediaTurma = somaNotas / notas.length;
                    break;
                }catch (NumberFormatException e){
                    System.out.println("Digite uma nota válida.");
                }
            }
        }
        System.out.println("Média da turma:"+df.format(mediaTurma));
        System.out.println("Alunos acima da média:"+soma);
    }
}
