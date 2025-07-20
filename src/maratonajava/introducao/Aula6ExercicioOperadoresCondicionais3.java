package academy.devdojo.maratonajava.introducao;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.time.LocalDate;
public class Aula6ExercicioOperadoresCondicionais3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        vamos verificar o menor número digitado
        System.out.println("Vamos verificar o menor número da lista");
        System.out.print("Digite quantos elementos você quer adicionar:");
        int seusNumeros = scanner.nextInt();
        if (seusNumeros==0){
            System.out.println("Valor inválidos, informe um número positivo!");
            return;
        }
        int nMenor = Integer.MAX_VALUE;
        for (int s=0;s<seusNumeros;s++){
            System.out.print("Digite o "+(s+1)+"º número da lista:");
            int sn = scanner.nextInt();
            if (sn<nMenor){
                nMenor=sn;
            }
        }
        System.out.println("O menor número da lista é:"+nMenor);


//        vamos verificar quantos da lista são de maior ou menor de idade
        System.out.println("Vamos verificar quem é de maior e menor de idade!");
        int maior2 =0;
        int menor2 =0;
        ArrayList<Integer> idadeLista = new ArrayList<>();
        int dataHoje = LocalDate.now().getYear();
        System.out.print("Digite quantas pessoas você quer adicionar na lista:");
        int pessoas = scanner.nextInt();
        for (int p=0;p<pessoas;p++){
            System.out.print("Digite o ano de nascimento da "+(p+1)+"º pessoa:");
            int anoDeNascimento = scanner.nextInt();
            int idade1 = dataHoje - anoDeNascimento;
            if (idade1 >=18){
                maior2++;
            }else{
                menor2++;
            }
        }
        System.out.println("Foram cadastrados: "+maior2+" maiores de idade");
        System.out.println("Foram cadastrados: "+menor2+" menores de idade");



//        Vamos verificar o maior e o menor da lista
        ArrayList<Integer> nossaLista = new ArrayList<>();
        System.out.print("Digite quantos números você quer adicionair na lista:");
        int valoresLista = scanner.nextInt();
        for (int nn1=0;nn1<valoresLista;nn1++){
            System.out.print("Digite o "+(nn1+1)+"º da lista:");
            int numbers = scanner.nextInt();
            nossaLista.add(numbers);
        }
        int maior1 = Collections.max(nossaLista);
        int menor1 = Collections.min(nossaLista);
        System.out.println("O maior número da lista é:"+maior1);
        System.out.println("O menor número da lista é:"+menor1);


//        Escreva um algoritmo que leia N números e os mostre na tela em ordem crescente.
        ArrayList<Integer> mylist = new ArrayList<>();
        System.out.print("Digite quantos número você quer iserir na lista:");
        int valor = scanner.nextInt();
        if (valor<=0){
            return;
        }
        for (int v=0;v<valor;v++){
            System.out.print("Digite o "+(v+1)+" da lista:");
            int myNumber = scanner.nextInt();
            mylist.add(myNumber);
        }
        Collections.sort(mylist);
        System.out.println("A lista em ordem crescente ficou:"+mylist);


//        comparação de números e e selecionaro o maior dentre eles.
        System.out.print("Digite quanto números você deseja comparar:");
        int numeros = scanner.nextInt();
        if (numeros<=0){
            System.out.println("Por favor, informe um número positivo.");
            return;
        }
        int maiorNumero = Integer.MIN_VALUE;
        for (int n=0;n<numeros;n++){
            System.out.print("Digite o "+(n+1)+"º número:");
            int valores = scanner.nextInt();
            if (valores>maiorNumero){
                maiorNumero = valores;
            }
        }
        System.out.println("O maior número digitado foi:"+maiorNumero);

//        Escreva um algoritmo para ler o número total de eleitores de um município,
//        o número de votos brancos, nulos e válidos
        System.out.println("Vamos calcular os votos de um município");
        System.out.print("Digite o número total de eleitores da cidade:");
        int totalEleitores = scanner.nextInt();
        System.out.print("Digite os número de votos válidos:");
        float votosValidos = scanner.nextInt();
        System.out.print("Digite os votos nulos:");
        float votosNulos = scanner.nextInt();
        System.out.print("Digite os votos em branco:");
        float votosBrancos = scanner.nextInt();
        float eleitoresQueNaoVotaram = totalEleitores-(votosBrancos+votosNulos+votosValidos);
        if (totalEleitores<(votosBrancos+votosNulos+votosValidos)){
            System.out.println("ERRO! votos brancos, nulos e válidos NÃO pode ser maior que total de eleitores da cidade.");
        }else {
            float somaVotosValidos = (votosValidos/totalEleitores)*100;
            System.out.println("O total de votos válidos é igual: "+String.format("%.2f",somaVotosValidos)+"%");
            float somavotosBrancos = (votosBrancos/totalEleitores)*100;
            System.out.println("O total de votos em branco é igual: "+String.format("%.2f",somavotosBrancos)+"%");
            float somavotosNulos = (votosNulos/totalEleitores)*100;
            System.out.println("O total de votos nulos é igual: "+String.format("%.2f",somavotosNulos)+"%");
            float somaNaoVotaram = (eleitoresQueNaoVotaram/totalEleitores)*100;
            System.out.println("O total de pessoas que não votaram é igual: "+String.format("%.2f",somaNaoVotaram)+"%");
        }


//        troca de variaveis
        int a = 10;
        int b = 20;
        System.out.println("Variáveis antes da troca:");
        System.out.println("Variável A:"+a);
        System.out.println("Variável B:"+b);
        System.out.println("Variável depois da troca:");
        int temp = a;
        a=b;
        b = temp;
        System.out.println("O valor de A é igual:"+a);
        System.out.println("O valor de B é igual:"+b);




//        calculo IMC
        System.out.println("Vamos calcular o seu IMC!");
        System.out.print("Digite o seu peso:");
        float peso = scanner.nextFloat();
        System.out.print("Digite a sua altura:");
        float altura = scanner.nextFloat();
        float imc = peso/(altura*2);
        System.out.println("O seu IMC é igual:"+String.format("%.2f",imc));


//        calculo imposto de renda
        System.out.println("Vamos calcular o imposto de renda de acordo com a faixa salarial");
         System.out.print("Digite o valor do seu salário:R$");
         float salario = scanner.nextFloat();
         if (salario<=499.99f){
             float faixa1 = (salario*.05f);
             System.out.println("O imposto sobre o seu salário este mês é de R$"+faixa1);
         } else if (salario>=500.00f && salario<=999.99f) {
             float faixa2 = (salario*.10f);
             System.out.println("O imposto sobre o seu salário este mês é de R$"+faixa2);             
         } else if (salario>=1000.00f && salario<=1499.99f) {
             float faixa3 = (salario*.15f);
             System.out.println("O imposto sobre o seu salário este mês é de R$"+faixa3);
         } else if (salario>=1500.00f && salario<=1999.99f) {
             float faixa4 = (salario*.20f);
             System.out.println("O imposto sobre o seu salário este mÊs é de R$"+faixa4);
         }else {
             float faixa5 = (salario*.25f);
             System.out.println("O imposto sobre o seu salário este mês é de R$"+faixa5);
         }

//        Escreva um programa que leia o salário hora do funcionário e o número de horas trabalhadas no mês e
//        calcule o valor a ser pago. Até 220 horas trabalhadas basta simplesmente multiplicar o valor do
//        salário hora pelo número de horas. A quantidade de horas que exceder 220 deverá ser paga com 50% a
//        mais do seu valor.
        System.out.println("Vamos calcular o seu salário!");
        System.out.print("Digite o valor da hora R$:");
        float valorHora = scanner.nextFloat();
        System.out.print("Digite a quantidade de horas trabalhadas este mês:");
        float horasTrabalhadas = scanner.nextFloat();
        if (horasTrabalhadas<=220){
            float salario220 = horasTrabalhadas*valorHora;
            System.out.println("Esse mês você trabalhou"+horasTrabalhadas+" horas e seu salário é R$"+String.format("%.2f",salario220));
        }else {
            float salarioMais220 = ((valorHora*220)+((horasTrabalhadas-220)*(valorHora+(valorHora*.5f))));
            System.out.println("Esse mÊs você trabalhou "+horasTrabalhadas+" horas e seu salário é R$"+String.format("%.2f",salarioMais220));
        }

//        Crie um programa que permita fazer a conversão cambial entre Reais e Dólares.axa de câmbio US$1,0 = R$2,40
        System.out.println("Vamos fazer conversão cambial de R$ para U$$");
        System.out.print("Digite o valor em :R$");
        float reais = scanner.nextFloat();
        System.out.print("Digite o valor da taxa de câmbio:R$");
        float taxa = scanner.nextFloat();
        float conversao = reais/taxa;
        System.out.printf("R$%.2f convertidos a taxa de câmbio de U$$1,00 = R$%.2f é igual:U$$%.2f%n",reais,taxa,conversao);



//        FAÇA UM ALGORITIMO QUE LEIA TRÊS NÚMEROS E MOSTRE O MAIOR DELES.
        System.out.println("Vamos ler 3 números e ver o maior deles!");
        ArrayList<Byte> lista = new ArrayList<>();
        for (int n=1;n<=3;n++){
            System.out.print("Digite o "+n+"º número:");
            byte numero = scanner.nextByte();
            lista.add(numero);
        }
        int maior = Collections.max(lista);
        System.out.println("O maior número da lista é:"+maior);
    }
}
