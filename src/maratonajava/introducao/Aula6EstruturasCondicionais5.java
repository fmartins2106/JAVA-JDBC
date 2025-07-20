package academy.devdojo.maratonajava.introducao;

import java.util.Scanner;

public class Aula6EstruturasCondicionais5 {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
//        opções de um sistema
        System.out.println("1 - Dados bancários");
        System.out.println("2 - Dados pessoais");
        System.out.println("3 - Histórico de compras");
        System.out.println("4 - Contactar Suporte");
        System.out.print("Digite uma opções acima:");
        byte opcao = scanner.nextByte();
        switch (opcao){
            case 1:
                System.out.println("Dados bancários");
                break;
            case 2:
                System.out.println("Dados pessoais");
                break;
            case 3:
                System.out.println("Histórico de compras");
                break;
            case 4:
                System.out.println("Contactar suporte");
                break;
            default:
                System.out.println("Opção inválida");
        }

//        resolvendo de outra forma
        byte day = 5;
        switch (day){
            case 1:
            case 7:
                System.out.println("Final de semana");
                break;
            case 2:
            case 3:
            case 4:
            case 5:
                System.out.println("Dia de últil");
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }


//        dados o valores de 1 a 7, imprima se o dia é util ou final de semana, considerando 1 como domingo
        byte dia = 5;
        switch (dia){
            case 1:
                System.out.println("Domingo = final de semana");
                break;
            case 2:
                System.out.println("Segunda = dia de semana");
                break;
            case 3:
                System.out.println("Terça = dia de semana");
                break;
            case 4:
                System.out.println("Quarta = dia de semana");
                break;
            case 5:
                System.out.println("Quinta = dia da semana");
                break;
            case 6:
                System.out.println("Sexta = dia da semana");
                break;
            case 7:
                System.out.println("Sábado = dia da semana");
                break;
            default:
                System.out.println("Opção inválida");
        }

    }
}
