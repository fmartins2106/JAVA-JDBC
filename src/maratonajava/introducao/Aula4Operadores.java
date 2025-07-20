package academy.devdojo.maratonajava.introducao;

public class Aula4Operadores {
    public static void main(String[] args) {
        // Os Operadores aritimeticos + - / *
        int numero01 = 10;
        double numero02 = 20;
        //int resultado = numero01+numero02;
        double resultado2 = numero01/numero02;
        System.out.println(numero01+numero02+" valor "+numero01+numero02);
        //System.out.println(resultado);
        System.out.println(resultado2);

        boolean isDezMaiorQueVinte = 10 > 20;
        boolean isDezMenorQueVinte = 10 < 20;
        boolean isDezIgualVinte = 10==20;
        boolean isDezIgualDez = 10==10;
        boolean isDezDiferenteDez = 10 !=10;
        System.out.println(" IsDezMaiorQueVinte "+isDezMaiorQueVinte);
        System.out.println(" isDezMenorQueVinte "+isDezMenorQueVinte);
        System.out.println(" isDezIgualVinte "+isDezIgualVinte);
        System.out.println(" isDezIgualVinte "+isDezIgualDez);
        System.out.println(" isDezDiferenteDez " +isDezDiferenteDez );

    }
}

