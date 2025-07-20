package academy.devdojo.maratonajava.introducao;

import java.util.Scanner;

public class Aula4ExercicioDiversos2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Vamos calcular uma tabuada!");
        System.out.print("Digite um número inteiro:");
        int tabuada = scanner.nextInt();
        System.out.println("____________");
        for (int i=0; i<=10; i++){
            System.out.printf("%d x %d= %d%n", tabuada,i,tabuada*i);
        }
        System.out.println("____________");



        // metros em cm e mm
        System.out.print("Digite um número:");
        float num = scanner.nextFloat();
        float cm = num*100;
        float mm = num*1000;
        System.out.printf("%.2f metros é igual %.2fcm e %.2fmm%n", num, cm, mm);

        //calculo média notas.
        System.out.print("Digite sua primeira nota:");
        float n1 = scanner.nextInt();
        System.out.print("Digite a segunda nota:");
        float n2 = scanner.nextInt();
        float media = (n1+n2)/2;
        System.out.printf("Suas notas foram: %.2f e %.2f. A média das notas foi: %.2f%n", n1,n2, media);

        // calculo sucessor e antecessor
        System.out.print("Digite um número qualquer:");
        int num1 = scanner.nextInt();
        int ant = num1-1;
        int suc = num1+1;
        System.out.printf("Você digitou %d. O antecessor de %d é %d e o sucessor é %d%n", num1,num1,ant,suc);

        // calculo dobro, triplo e raiz quadrada
        System.out.print("Digite um número inteiro:");
        int numero = scanner.nextInt();
        int dobro = numero*2;
        int triplo = numero*3;
        double raiz = Math.sqrt(numero);
        System.out.printf("Você digitou %d, o dobro é:%d, o triplo é:%d e a raiz quadrada:%.2f%n",numero,dobro,triplo,raiz);

        //Exercicio tabuada!
        System.out.println("Vamos calcular a tabuada!");
        System.out.print("Digite um número inteiro:");
        int n = scanner.nextInt();
        int t0 = n*0;
        int t1 = n*1;
        int t2 = n*2;
        int t3 = n*3;
        int t4 = n*4;
        int t5 = n*5;
        int t6 = n*6;
        int t7 = n*7;
        int t8 = n*8;
        int t9 = n*9;
        int t10 = n*10;
        System.out.printf("%d x 0 = %d%n",n, t0);
        System.out.printf("%d x 1 = %d%n",n, t1);
        System.out.printf("%d x 2 = %d%n",n, t2);
        System.out.printf("%d x 3 = %d%n",n, t3);
        System.out.printf("%d x 4 = %d%n",n, t4);
        System.out.printf("%d x 5 = %d%n",n, t5);
        System.out.printf("%d x 5 = %d%n",n, t6);
        System.out.printf("%d x 7 = %d%n",n, t7);
        System.out.printf("%d x 8 = %d%n",n, t8);
        System.out.printf("%d x 9 = %d%n",n, t9);
        System.out.printf("%d x 10 = %d%n",n,t10);





        //exercicio desconto produto
        System.out.print("Informe o valor do produto:R$");
        float valor = scanner.nextFloat();
        System.out.print("Digite quantos % de desconto:");
        float desconto = scanner.nextFloat();
        float valor_final = valor-(valor*(desconto/100));
        System.out.printf("Com desconto é de %.2f%%. O produto tem valor final de R$%.2f%n",desconto,valor_final);

        //Calculo área de um terreno
        System.out.print("Digite a largura do terreno:");
        float largura = scanner.nextFloat();
        System.out.print("Digite o comprimento do terreno:");
        float comprimento = scanner.nextFloat();
        float area = largura*comprimento;
        System.out.printf("A área de um terreno %.2f x %.2f = %.2fm²%n", largura,comprimento,area);

        //Calculo taxa de câmbio
        System.out.println("Vamos fazer a conversão de R$ para U$$");
        System.out.print("Digite o valor em reais a ser convertido:R$");
        float reais = scanner.nextFloat();
        System.out.print("Digite a taxa de câmbio:R$");
        float taxa = scanner.nextFloat();
        float conversao = reais/taxa;
        System.out.printf("O valor de R$%.2f a taxa de R$%.2f é igual U$$%.2f %n", reais,taxa,conversao);



        // Exercicio Aumento no salario
        System.out.print("Digite o seu salário:");
        float salario = scanner.nextFloat();
        System.out.print("Digite o aumento em %:");
        float aumento = scanner.nextFloat();
        float valor_f = salario+(salario*(aumento/100));
        System.out.printf("O seu salário de R$%.2f com aumento de %.2f%% é igual: R$%.2f %n", salario,aumento,valor_f);
        scanner.close();

    }
}
