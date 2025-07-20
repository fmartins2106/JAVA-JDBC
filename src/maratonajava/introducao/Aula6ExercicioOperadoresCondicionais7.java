package academy.devdojo.maratonajava.introducao;

import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.time.LocalDate;


public class Aula6ExercicioOperadoresCondicionais7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random =new Random();




// vamos verificar quem é maior e menor de idade
        System.out.println("Vamos verificar quem é maior e menor de idade");
        int MaiorIdade = 0;
        int MenorIdade = 0;
        System.out.print("Quantas pessoas você quer cadastrar?:");
        int anoNascimento = scanner.nextInt();
        for (int m=0;m<anoNascimento;m++){
            System.out.print("Digite a "+(m+1)+"º data de nascimento:");
            int cadastroDataNasc = scanner.nextInt();
            int anoAtual = LocalDate.now().getYear();
            int idade = anoAtual-cadastroDataNasc;
            if (idade>=18){
                MaiorIdade++;
            }else {
                MenorIdade++;
            }
        }
        System.out.println("Foram cadastrados:"+MaiorIdade+" pessoa(s) maior(es) de idade.");
        System.out.println("Foram cadastrados:"+MenorIdade+" pessoa(s menores(es) de idade.");

//        vamos sortear um número
        ArrayList<Integer> listaB = new ArrayList<>();
        System.out.println("Vamos sortear um número");
        System.out.print("Digite quantos números terá a lista:");
        int listaDeNumeros = scanner.nextInt();
        for (int nn=0; nn<listaDeNumeros;nn++){
            System.out.print("Digite o "+(nn+1)+"º número:");
            int numerais = scanner.nextInt();
            listaB.add(numerais);
        }
        int sorteio = random.nextInt(listaB.size());
        int nSorteado = listaB.get(sorteio);
        System.out.println("O número sorteado foi:"+nSorteado);
//        vamos sortear uma pessoa
        System.out.println("Vamos sortear uma pessoa!");
        ArrayList<String> listaPessoas = new ArrayList<>();
        for (int np=0;np<5;np++){
            System.out.print("Digite o "+(np+1)+"º nome:");
            String nomes = scanner.nextLine();
            listaPessoas.add(nomes);
        }
        int sorteandoPessoas = random.nextInt(listaPessoas.size());
        String nomeSortudo = listaPessoas.get(sorteandoPessoas);
        System.out.println("O grande sortudo foi:"+nomeSortudo);

//        vamos sortear a sequencia de apresentação
        System.out.println("Vamos sortear a sequência de aprensentação");
        ArrayList<String> listaApresentacao = new ArrayList<>();
        for (int pess=0;pess<5;pess++){
            System.out.print("Digite a "+(pess+1)+"º pessoa da lista:");
            String pessoasAdicionadas = scanner.nextLine();
            listaApresentacao.add(pessoasAdicionadas);

        }
        Collections.shuffle(listaApresentacao);
        System.out.println("A sequência de apresentação ficou:"+listaApresentacao);

//        tabuada
        System.out.println("Vamos Calcular a Tabuada!");
        System.out.print("Digite um número:");
        int tabuada = scanner.nextInt();
        for (int t=0;t<=10;t++){
            System.out.printf("%d x %d = %d%n",tabuada,t,tabuada*t);
        }

        //        números impares de 1 a 30 que são multiplos de 3
        int contImpar = 0;
        int somaImpar = 0;
        for (int impar=1; impar<=30;impar+=2){
            System.out.println(impar);
            contImpar++;
            somaImpar+=impar;
        }
        System.out.println("Tem:"+contImpar+" números impares a soma deles é:"+somaImpar);


//     contar números pares
        System.out.println("Contar números pares de 0 a 50");
        for (int par=0;par<=50;par+=2){
            System.out.println(par);
        }


//        soma somente números pares
        ArrayList<Integer> hList = new ArrayList<>();
        System.out.println("Vamos somar os números pares!");
        for (int h=0;h<7;h++){
            System.out.print("Digite o "+(h+1)+"º número:");
            int numbers = scanner.nextInt();
            hList.add(numbers);
        }
        int somap = 0;
        int cont = 0;
        for (int numbers : hList){
            if (numbers%2==0){
                somap+=numbers;
                cont++;
            }
        }
        System.out.println("O total de número pares é:"+cont+" e a soma dos números pares é:"+somap);



//     Vamos verificar o maior e o menor peso
        System.out.println("Vamos verificar o maior e o menor peso.");
        ArrayList<Float> listaPeso = new ArrayList<>();
        for (int p=0; p<=6; p++){
            System.out.print("Digite o "+(p+1)+"º peso:");
            float pesos = scanner.nextFloat();
            listaPeso.add(pesos);
        }
        float maiorPeso = Collections.max(listaPeso);
        float menorPeso = Collections.min(listaPeso);
        System.out.println("O maior peso foi:"+maiorPeso);
        System.out.println("O menor peso foi:"+menorPeso);




//        Escreva um algoritmo que leia N números e os mostre na tela em ordem crescente
        System.out.println("Vamos montar uma lista e mostrar em orde crescente");
        ArrayList<Integer> myList = new ArrayList<>();
        System.out.print("Quantos números quer adicionar na lista?:");
        int adicionar = scanner.nextInt();
        for (int i=0; i<adicionar;i++){
            System.out.print("Digite o "+(i+1)+"º número:");
            int numerosDaLista = scanner.nextInt();
            myList.add(numerosDaLista);
        }
        Collections.sort(myList);
        System.out.println("A lista em ordem crescente é:"+myList);



//          Escreva um algoritmo que leia N números e mostre na tela o maior deles.
        System.out.println("Vamos verificar o maior número informado");
        int MaiorNumeroInformado = Integer.MIN_VALUE;
        System.out.print("Digite quantos números você quer adicionar na lista:");
        int numerosLista = scanner.nextInt();
        for (int h=0; h<numerosLista; h++){
            System.out.print("Digite o "+(h+1)+"º da lista:");
            int valoresInformados = scanner.nextInt();
            if (valoresInformados>MaiorNumeroInformado){
                MaiorNumeroInformado=valoresInformados;
            }
        }
        System.out.println("O maior número é:"+MaiorNumeroInformado);

//        Calculo eleitores
        System.out.println("Vamos calcular os votos");
        System.out.print("Quantidade de eleitores:");
        float eleitores = scanner.nextInt();
        System.out.print("Votos válidos:");
        float votosValidos = scanner.nextInt();
        System.out.print("Votos Nulos:");
        float votosNulos = scanner.nextInt();
        System.out.print("Votos Brancos:");
        float votosBrancos = scanner.nextInt();
        if (eleitores<(votosBrancos+votosNulos+votosValidos)){
            System.out.println("Votos totais, não pode ser menor que soma de votos válidos, nulos e brancos.");
        }else {
            float contagemVotosValidos = (votosValidos/eleitores)*100;
            System.out.println("Votos válidos:"+String.format("%.2f",contagemVotosValidos)+"%");
            float contagemVotosNulos = (votosNulos/eleitores)*100;
            System.out.println("Votos Nulos:"+String.format("%.2f",contagemVotosNulos)+"%");
            float contagemVotosBrancos = (votosBrancos/eleitores)*100;
            System.out.println("Votos Brancos:"+String.format("%.2f",contagemVotosBrancos)+"%");
            float contagemNaoVotaram = ((eleitores-(votosBrancos+votosNulos+votosValidos))/eleitores)*100;
            System.out.println("Não votaram:"+String.format("%.2f",contagemNaoVotaram)+"%");
        }




//        armazene o valor 10 em uma variável A e o valor 20 em uma variável B e depois trocar
        System.out.println("Vamos fazer troca de variáveis");
        byte A = 10;
        byte B = 20;
        System.out.println("Valores antes da troca:");
        System.out.println("Variável A:"+A);
        System.out.println("Variável B:"+B);
        byte troca = A;
        A = B;
        B = troca;
        System.out.println("Valores após a troca:");
        System.out.println("Variável A:"+A);
        System.out.println("Variável B:"+B);


//        calculo IMC
        System.out.println("Vamos calcular o seu IMC");
        System.out.print("Digite o seu nome:");
        String nome = scanner.next();
        System.out.print("Digite o seu peso:");
        float peso = scanner.nextFloat();
        System.out.print("Digite a sua altura:");
        float altura = scanner.nextFloat();
        float imc = peso/(altura*2);
        if (imc<=18.5f){
            System.out.println(nome+", seu IMC é:"+String.format("%.2f",imc)+" e você está com bulemia.");
        } else if (imc>=18.5f && imc<=25.00f) {
            System.out.println(nome+", seu IMC é:"+String.format("%.2f",imc)+" e você está no peso ideal.");
        } else if (imc>=25.01f && imc<=30.00f) {
            System.out.println(nome+", seu IMC é:"+String.format("%.2f",imc)+" e você está com sobre peso.");
        } else if (imc>=30.01 && imc<=35.00f) {
            System.out.println(nome+", seu IMC é:"+String.format("%.2f",imc)+" e você está obeso");
        }else {
            System.out.println(nome+", seu IMC é:"+String.format("%.2f",imc)+" e você está com obesidade morbida");
        }


//        calculo notas juizes
        System.out.println("Vamos calcular as notas dos juizes!");
        ArrayList<Float> listaNotasJuizes = new ArrayList<>();
        for (int j=0; j<6; j++){
            System.out.print("Digite a "+(j+1)+"º nota dos juizes:");
            float notas = scanner.nextFloat();
            listaNotasJuizes.add(notas);
        }
        float notaMaior = Collections.max(listaNotasJuizes);
        float notaMenor = Collections.min(listaNotasJuizes);
        listaNotasJuizes.remove(notaMaior);
        listaNotasJuizes.remove(notaMenor);
        float soma = 0;
        for (float notas : listaNotasJuizes){
            soma+=notas;
        }
        float media = soma/ listaNotasJuizes.size();
        System.out.println("A sua nota final é:"+String.format("%.2f",media));




//        imposto sobre o salário de acordo com a faixa salárial

        System.out.println("Vamos calcular o imposto sobre o seu salário");
        System.out.print("Digite o seu salário:R$");
        float salario = scanner.nextFloat();
        if (salario<=499.99){
            float faixa1 = salario*0.05f;
            System.out.println("O imposto sobre o seu salário é:R$"+String.format("%.2f",faixa1));
        } else if (salario>=500.00f && salario<=999.99f) {
            float faixa2 = salario*0.10f;
            System.out.println("O imposto sobre o seu salário é:R$"+String.format("%.2f",faixa2));
        } else if (salario>=1000.00f && salario<=1499.99f) {
            float faixa3 = salario*0.15f;
            System.out.println("O imposto sobre o seu salário é:R$"+String.format("%.2f",faixa3));
        } else if (salario>=1500.00f && salario<=1999.99f) {
            float faixa4 = salario*.20f;
            System.out.println("O imposto sobre o seu salário é:R$"+String.format("%.2f",faixa4));
        }else {
            float faixa5 = salario*.25f;
            System.out.println("O imposto sobre o seu salário é:R$"+String.format("%.2f",faixa5));
        }

//        calculo trabalho mês
        System.out.println("Vamos calcular o seu salário!");
        System.out.print("Digite quantas horas você trabalhou no mês:");
        float horasTrabalhadasMes = scanner.nextFloat();
        System.out.print("Digite o valor da hora trabalhada R$:");
        float valorHoraTrabalhada = scanner.nextFloat();
        if (horasTrabalhadasMes<=220){
            float valorAte220 = horasTrabalhadasMes*valorHoraTrabalhada;
            System.out.println("Este mês seu salário é:R$"+String.format("%.2f",valorAte220));
        }else {
            float valorMais220 = (valorHoraTrabalhada*220)+((horasTrabalhadasMes-220)*(valorHoraTrabalhada+(valorHoraTrabalhada*0.5f)));
            System.out.println("Este mês seu salário é: R$"+String.format("%.2f",valorMais220));
        }


//       conversão de reais para dollar
        System.out.println("Vamos fazer conversão cambial");
        System.out.print("Digite qual o valor em reais você quer converter:R$");
        float reais = scanner.nextFloat();
        System.out.print("Digite qual valor da taxa de câmbio:R$");
        float taxa = scanner.nextFloat();
        float conversao = reais/taxa;
        System.out.println("O valor de R$"+String.format("%.2f",reais)+" convetidos a taxa de câmbial de R$"+String.format("%.2f",taxa)+" é igual a:R$"+String.format("%.2f",conversao));



//        Escreva um algoritmo que leia três números e mostre o maior deles.
        System.out.println("Vamos verificar três números e informar o maior deles");
        int maiorNumero = Integer.MIN_VALUE;
        for (int n=0;n<3;n++){
            System.out.print("Digite o "+(n+1)+"º número:");
            int numero = scanner.nextInt();
            if (numero>maiorNumero){
                maiorNumero=numero;
            }
        }
        System.out.println("O maior número da lista foi:"+maiorNumero);
    }
}
