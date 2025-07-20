package academy.devdojo.maratonajava.introducao;

import java.util.SimpleTimeZone;

public class Aula5OperadoresLogicos {
    public static void main(String[] args) {
        // operadores logicos &&(end), ||(or) !(not)

        int idades = 11;
        boolean isAutorizadoComprarBebidas = idades >=18;
        if (isAutorizadoComprarBebidas){
            System.out.println("Autorizado a Compra pebida!");
        }else{
            System.out.println("Não Autorizado a comprar bebida");
        }




        int age =15;
        boolean isAutorizadoComprarBebida = age >=18;
        if (isAutorizadoComprarBebida){
            System.out.println("Autorizado a comprar bebida alcolica");
        }
        if (!isAutorizadoComprarBebida){
            System.out.println("Não Autorizadoa  comprar bebila alcolica.");
        }


        // exemplo ||(or)
        double valorTotalContCorrete = 200;
        double valorTotalContaPoupanca = 10000;
        float valorPlayStation = 5000f;
        boolean isPlayStationCincoCompravel = valorTotalContCorrete > valorPlayStation ||valorTotalContaPoupanca >valorPlayStation;
        System.out.println("isPlayStationCincoCompravel"+isPlayStationCincoCompravel);

        // exemplo &&(end)

        int idade = 35;
        float salario =5500f;
        boolean isDentroDaLeiMaiorQueTrinta = idade >= 30 && salario >=4612;
        boolean isDentroDaLeiMenorQueTrinta = idade <= 30 && salario >=3581;
        System.out.println("isDentroDaLeiMaiorQueTrinta"+isDentroDaLeiMaiorQueTrinta);
        System.out.println("isDentroDaLeiMenorQueTrinta"+isDentroDaLeiMenorQueTrinta);
    }
}
