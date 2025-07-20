package academy.devdojo.maratonajava.introducao;

public class Aula6EstruturasCondicionais4 {
    public static void main(String[] args) {
//        condicional switch (Exemplo imprimir o dia da semana.)
        byte dia = 10;
        // pode usar o swich com char, int, byte, short, enum, String
        switch (dia) {
            case 1:
                System.out.println("Domingo");
                break;
            case 2:
                System.out.println("Segunda");
                break;
            case 3:
                System.out.println("Terça");
                break;
            case 4:
                System.out.println("Quarta");
                break;
            case 5:
                System.out.println("Quinta");
                break;
            case 6:
                System.out.println("Sexta");
                break;
            case 7:
                System.out.println("Sábado");
                break;
            default:
                System.out.println("Opção inválida");

        }

    }
}
