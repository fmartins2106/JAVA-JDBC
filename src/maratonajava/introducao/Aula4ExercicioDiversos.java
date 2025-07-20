package academy.devdojo.maratonajava.introducao;

import java.util.Scanner;


public class Aula4ExercicioDiversos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // aumento no salário
        System.out.print("Digite o seu salário:");
        float salario = scanner.nextFloat();
        System.out.print("Digite % de aumento no seu salário:");
        float aumento = scanner.nextFloat();
        System.out.println("Vamos agora verificar o aumento no salário!");
        float salario_final = salario+(salario*(aumento/100));
        System.out.printf("O seu salário de R$%.2f com aumento de %.2f%%, ficou em R$%.2f%n", salario, aumento,salario_final);


        // valor com desconto
        System.out.println("Seja vem vindo a nossa loja!");
        System.out.print("Digite o valor do produto:");
        float produto = scanner.nextFloat();
        System.out.print("Digite % de desconto:");
        float desconto = scanner.nextFloat();
        float valor_final = produto-(produto*((desconto/100)));
        System.out.printf("O valor final do produto com desconto de %.2f%% é: R$%.2f%n",desconto,valor_final);

        // calculo área
        System.out.print("Digite a largura:");
        float largura = scanner.nextFloat();
        System.out.print("Digite o comprimento:");
        float comprimento = scanner.nextFloat();
        float area = largura*comprimento;
        System.out.printf("A área total de um terreno %.2f x %.2f = %.2fm²%n",largura,comprimento,area);


        // calculando a taxa de cambio
        System.out.print("Digite o valor a ser convertido:R$");
        float reais = scanner.nextFloat();
        System.out.print("Digite a taxa de cambio:");
        float taxa = scanner.nextFloat();
        float conversao = reais/taxa;
        System.out.printf("Seus R$%.2f convertido na taxa de câmbio de R$%.2f é igual a U$$%.2f%n",reais,taxa,conversao);


        // Calculo da tabuada
        System.out.print("Digite um número inteiro:");
        int n = scanner.nextInt();
        int t1 = n*0;
        int t2 = n*1;
        int t3 = n*2;
        int t4 = n*3;
        int t5 = n*4;
        int t6 = n*5;
        int t7 = n*6;
        int t8 = n*7;
        int t9 = n*8;
        int t10 = n*9;
        int t11 = n*10;
        System.out.printf("%d x 0 = %d%n", n,t1);
        System.out.printf("%d x 1 = %d%n",n,t2);
        System.out.printf("%d x 2 = %d%n",n,t3);
        System.out.printf("%d x 3 = %d%n",n,t4);
        System.out.printf("%d x 4 = %d%n",n,t5);
        System.out.printf("%d x 5 = %d%n",n,t6);
        System.out.printf("%d x 6 = %d%n",n,t7);
        System.out.printf("%d x 7 = %d%n",n,t8);
        System.out.printf("%d x 8 = %d%n",n,t9);
        System.out.printf("%d x 9 = %d%n",n,t10);
        System.out.printf("%d x 10 = %d%n",n,t11);



        // exercicio cm, mm em metros
        System.out.print("Digite um valor em metros:");
        float metros = scanner.nextFloat();
        float cm1 = metros*100;
        float mm1 = metros*1000;
        System.out.printf("%.2f metros é igual %.2fcm  e %.2fmm%n", metros, cm1, mm1);



        // vamos fazer calculo de média!
        System.out.print("Digite a primeira nota:");
        float n3 = scanner.nextInt();
        System.out.print("Digite a segunda nota:");
        float n4 = scanner.nextInt();
        float media1 = (n3+n4)/2;
        System.out.printf("Suas notas foram:%.2f/ %.2f . A média das notas foi: %.2f%n",n3,n4,media1);


        // Exercicio antecessor e sucessos*/
        System.out.print("Digite um número:");
        int nn1 = scanner.nextInt();
        int suc1 = nn1+1;
        int ant1 = nn1-1;
        System.out.printf("O Antecessor de %d é: %d e o sucessor de %d é: %d%n", nn1, ant1,nn1,suc1);

        //Exercicio dobro, triplo e raiz quadrada!
        System.out.print("Digite um número qualquer:");
        int nn2 = scanner.nextInt();
        int dobro = nn2*2;
        int triplo = nn2*3;
        float raizq = (float) Math.sqrt(nn2);
        System.out.printf("Você digitou %d, o dobro é:%d, o triplo: %d e a raiz quadrada: %.2f%n", nn2,dobro,triplo,raizq);






        scanner.close();




    }
}