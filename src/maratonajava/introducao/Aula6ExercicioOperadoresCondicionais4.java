package academy.devdojo.maratonajava.introducao;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Random;
import java.time.LocalTime;


public class Aula6ExercicioOperadoresCondicionais4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
//        vamos verificar qual o maior e o menor de idade
        System.out.println("Vamos verificar na lista quem é maior e quem é de menor de idade");
        int pessoaMaior = 0;
        int pessoaMenor = 0;
        System.out.print("Quantas pessoas você quer adicionar na lista:");
        int pessoas = scanner.nextInt();
        for (int pessoa=0; pessoa<pessoas;pessoa++){
            System.out.print("Digite o ano de nascimento da "+(pessoa+1)+"º pessoa:");
            int anoNascimento = scanner.nextInt();
            int anoAtual = LocalDate.now().getYear();
            int idadePessoa = anoAtual-anoNascimento;
            if (idadePessoa>=18){
                pessoaMaior++;
            }else {
                pessoaMenor++;
            }
        }
        System.out.println("Foram cadastrados: "+pessoaMaior+" maior de idade");
        System.out.println("Foram cadastrados: "+pessoaMenor+" menor de idade");



//       Escreva um algoritmo que leia N números e os mostre na tela em ordem crescente.
        ArrayList<Integer> gLista = new ArrayList<>();
        System.out.println("Vamos ler números e mostrar em ordem crescente");
        System.out.print("Digite quanto elementos quer adicionar na lista:");
        int elementosLista = scanner.nextInt();
        if (elementosLista==0){
            System.out.println("Valor inválido, tente novamente!");
            return;
        }for (int numero=0;numero<elementosLista;numero++){
            System.out.print("Digite o "+(numero+1)+"º número da lista:");
            int numerosAdicionados = scanner.nextInt();
            gLista.add(numerosAdicionados);
        }
        Collections.sort(gLista);
        System.out.println("A lista em ordem crescente ficou:"+gLista);

//        Escreva um algoritmo que leia N números e mostre na tela o maior deles.
        System.out.println("Vamos verificar o maior dentro de uma lista");
        System.out.print("Digite quantos números quer adicionar:");
        int valores = scanner.nextInt();
        if (valores==0){
            System.out.println("Valor inválidos, tente novamente!");
            return;
        }
        int maiorValor1 = Integer.MIN_VALUE;
        for (int num=0; num<valores; num++){
            System.out.print("Digite o "+(num+1)+"º número:");
            int valoresNaLista = scanner.nextInt();
            if (valoresNaLista>maiorValor1){
                maiorValor1=valoresNaLista;
            }
        }
        System.out.println("O maior valor da lista é:"+maiorValor1);

//        calculo eleitores
        System.out.println("Vamos calcular o número de votos de uma cidade");
        System.out.print("Digite o total de votos da cidade:");
        float votosTotais = scanner.nextInt();
        System.out.print("Digite o número de votos válidos:");
        float votosValidos = scanner.nextInt();
        System.out.print("Digite o número de votos nulos:");
        float votosNulos = scanner.nextInt();
        System.out.print("Digite o número de votos em branco:");
        float votosBrancos = scanner.nextInt();
        float naoVotaram = votosTotais-(votosBrancos+votosNulos+votosValidos);
        if (votosTotais<(votosBrancos+votosNulos+votosValidos)){
        } else {
            float totalVotosValidos = (votosValidos/votosTotais)*100;
            System.out.println("O total de votos válidos é de "+String.format("%.2f",totalVotosValidos)+"%");
            float totalVotosNulos = (votosNulos/votosTotais)*100;
            System.out.println("O total de votos nulos é de "+String.format("%.2f",totalVotosNulos)+"%");
            float totalVotosBrancos = (votosBrancos/votosTotais)*100;
            System.out.println("O total de votos brancos é de "+String.format("%.2f",totalVotosBrancos)+"%");
            float totalNaoVotantes = (naoVotaram/votosTotais)*100;
            System.out.println("O total de eleitores não votantes é de "+String.format("%.2f",totalNaoVotantes)+"%");
        }


//        troca de variáveis
        System.out.println("Vamos trocar as variáveis");
        int a1 = 10;
        int b = 20;
        System.out.println("Variável A:"+a1);
        System.out.println("Variável B:"+b);
        System.out.println("Após a Troca!");
        int trocaVariavel = a1;
        a1 = b;
        b=trocaVariavel;

        System.out.println("Variável A:"+a1);
        System.out.println("Variável B:"+b);



//        calculo IMC
        System.out.println("Vamos calcular o IMC");
        System.out.print("Digite seu nome:");
        String nomeImc = scanner.nextLine();
        System.out.print("Digite o seu peso:");
        float pesoImc = scanner.nextFloat();
        System.out.print("Digite a sua altura:");
        float alturaImc = scanner.nextFloat();
        float imc = pesoImc/(alturaImc*2);
        if (imc<=18.4f){
            System.out.println("Seu IMC é:"+String.format("%.2f",imc)+" Procure um médico, você está com Bulemia");
        } else if (imc>=18.5f && imc<=25.00f) {
            System.out.println("Seu IMC é:"+String.format("%.2f",imc)+" Você com peso ideal!");
        } else if (imc>=25.01f && imc<=30.00f) {
            System.out.println("Seu IMC é:"+String.format("%.2f",imc)+" Você está sobre peso!");
        } else if (imc>=30.01 && imc<=35.00f) {
            System.out.println("Seu IMC é:"+String.format("%.2f",imc)+" você está obeso!");
        } else if (imc>=35) {
            System.out.println("Seu IMC é:"+String.format("%.2f",imc)+" você está com obesidade morbida!");
        }


//Em uma competição 6 (seis) juízes informam notas reais variando de 0 a 10. Para calcular
// a nota do atleta deve-se excluir a maior e a menor nota dos juízes e fazer uma média simples das demais notas.
// Faça um programa que lê as seis notas dos juízes e informa a nota final do atleta.
        ArrayList<Float> listaNotasJuizes =  new ArrayList<>();
        System.out.println("Vamos verificar as notas dos juizes");
        for (int j=0;j<6;j++){
            System.out.print("Digite a nota do "+(j+1)+"º juiz:");
            float notasJuizes = scanner.nextFloat();
            listaNotasJuizes.add(notasJuizes);
        }
        float maiorNotaJuiz = Collections.max(listaNotasJuizes);
        float menorNotaJuiz = Collections.min(listaNotasJuizes);
        listaNotasJuizes.remove(maiorNotaJuiz);
        listaNotasJuizes.remove(menorNotaJuiz);
        float soma = 0;
        for (float notasJuizes : listaNotasJuizes){
            soma+=notasJuizes;
        }
        float media = soma/ listaNotasJuizes.size();
        System.out.println("A a soma das notas dos juizes é igual:"+media);


//     calculo imposto sobre salário
        System.out.println("Vamos calcular o imposto sobre o seu salário");
        System.out.print("Digite o seu salário:R$");
        float salario = scanner.nextFloat();
        if (salario<=499.99f){
            float faixa1 = salario*0.05f;
            System.out.println("Seu salario é R$"+String.format("%.2f",salario)+" e o imposto é R$"+String.format("%.2f",faixa1));
        } else if (salario>=500.00f && salario<=999.99f) {
            float faixa2 = salario*0.10f;
            System.out.println("Seu salário é R$"+String.format("%.2f",salario)+" e o imposto é R$"+String.format("%.2f",faixa2));            
        } else if (salario>=1000.00 && salario<=1499.99f) {
            float faixa3 = salario*0.15f;
            System.out.println("Seu salário é R$"+String.format("%.2f",salario)+" e o imposto é de R$"+String.format("%.2f",faixa3));            
        } else if (salario>=1500.00f && salario<=1999.99) {
            float faixa4 = salario*0.20f;
            System.out.println("Seu salário é R$"+String.format("%.2f",salario)+" e o imposto é de R$"+String.format("%.2f",faixa4));
        }else {
            float faixa5 = salario*0.25f;
            System.out.println("Seu salário é R$"+String.format("%.2f",salario)+" e o imposto é de R$"+String.format("%.2f",faixa5));
        }


//      Calculo horas de trabalho
        System.out.println("Vamos calcular a hora trabalhada");
        System.out.print("Digite quantas horas foram trabalhadas no mês:");
        float horasTrabalhadas = scanner.nextFloat();
        System.out.print("Digite qual o valor da hora trabalhada:R$");
        float valorHora = scanner.nextFloat();
        if (horasTrabalhadas<=220){
            float salarioMesAte220 = valorHora*horasTrabalhadas;
            System.out.println("O valor do seu salário este mês é igual:R$"+salarioMesAte220);
        } else {
            float salarioMesMais220 = ((220*valorHora)+((horasTrabalhadas-220)*(valorHora+(valorHora*0.5f))));
            System.out.println("O valor do seu salário este mês é igual:R$"+salarioMesMais220);
        }


//        Conversão câmbio reais em dolar
        System.out.println("Vamos converter R$ em U$$");
        System.out.print("Digeite o valor em reais a ser convertido:R$");
        float reais = scanner.nextFloat();
        System.out.print("Digite o valor da taxa de câmbio:R$");
        float taxa = scanner.nextFloat();
        float conversao = reais/taxa;
        System.out.println("O valor de R$"+String.format("%.2f",reais)+" convertido a taxa de câmbio de R$"+String.format("%.2f",taxa)+" é igual a:U$$"+String.format("%.2f",conversao));


//      Escreva um algoritmo que leia três números e mostre o maior deles.
        ArrayList<Integer> listaTresNumeros = new ArrayList<>();
        System.out.println("Vamos criar um programa que leia trÊs números e mostre o maior");
        for (int tres=0; tres<3;tres++){
            System.out.print("Digite o "+(tres+1)+"º da lista:");
            int tresNumeros = scanner.nextInt();
            listaTresNumeros.add(tresNumeros);
        }
        int maiorTres = Collections.max(listaTresNumeros);
        System.out.println("O maior número da lista foi:"+maiorTres);

//        exercicio tabuada
        System.out.println("Vamos calcular a tabuada");
        System.out.print("Digite um número inteiro:");
        int tabuada = scanner.nextInt();
        if (tabuada<0){
            System.out.println("Valor inválidos, tente novamente!");
            return;
        }
        for (int t=0; t<=10; t++){
            System.out.printf("%d x %d = %d%n",tabuada,t,tabuada*t);
        }



//        vamos agora sortear apenas uma pessoa
        ArrayList<String> pLista = new ArrayList<>();
        System.out.println("Vamos sortear apenas um aluno!");
        System.out.print("Digite quantos alunos farão parter do sorteio?:");
        int alunos = scanner.nextInt();
        scanner.nextLine();
        for (int a=0;a<alunos;a++){
            System.out.print("Digite o nome do "+(a+1)+"º aluno:");
            String nomeAluno = scanner.nextLine();
            pLista.add(nomeAluno);

        }
        int sorteio = random.nextInt(pLista.size());
        String sorteado = pLista.get(sorteio);
        System.out.println("O grande sortudo desta noite foi:"+sorteado);





        //  vamos fazer um sorteio de apresentação
        ArrayList<String> nLista = new ArrayList<>();
        System.out.println("Vamos fazer um sorteio e ver a sequencia de apresentação!");
        System.out.print("Digite quantos nomes você quer adicionar na lista:");
        int elementos = scanner.nextInt();
        scanner.nextLine();
        for (int e=0;e<elementos;e++){
            System.out.print("Digite o "+(e+1)+"º nome da lista:");
            String nomes = scanner.nextLine();
            nLista.add(nomes);
            Collections.shuffle(nLista);
        }
        System.out.println("A sequência de apresentação ficou:"+nLista);
        scanner.close();
    }

}
