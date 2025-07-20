package academy.devdojo.maratonajava.introducao;


import java.util.Scanner;
public class Aula5OperadorTernario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        calculo imposto sobre salário
        System.out.println("Vamos calcular o imposto sobre o seus salário!");
        System.out.print("Digite o seu salário anual:€");
        double salarioAnual = scanner.nextDouble();
        if (salarioAnual<=34.712){
            double impostoFaixa1 = (salarioAnual*0.70);
            System.out.println("€"+String.format("%.2f",salarioAnual)+": o imposto sobre seu salário é de 70% = €"+String.format("%.2f",impostoFaixa1));
        } else if (salarioAnual>=34.743 && salarioAnual<=68.588) {
            double impostoFaixa2 = (salarioAnual*.3750);
            System.out.println("€"+String.format("%.2f",salarioAnual)+": o imposto sobre seu salário é de 37,50% =  €"+String.format("%.2f",impostoFaixa2));
        } else {
            double impostoFaixa3 = (salarioAnual*0.4950);
            System.out.println("€"+String.format("%.2f",salarioAnual)+": o imposto sobre seu salário é de 49,50% = €"+String.format("%.2f",impostoFaixa3));
        }


        //exemplo de operador ternário
        // dpar se salario for >5000
        double salario = 4500;

        // condição ? verdadeiro : falso
        String resultado = salario > 5000 ? "Eu vou doar dinheiro" : "Eu não vou doar dinheiro!";
        System.out.println(resultado);
        }
    }

