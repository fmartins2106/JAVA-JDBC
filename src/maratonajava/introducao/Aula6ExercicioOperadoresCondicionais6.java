package academy.devdojo.maratonajava.introducao;

import java.awt.font.FontRenderContext;
import java.util.*;
import java.time.LocalDate;
import java.util.Random;

public class Aula6ExercicioOperadoresCondicionais6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();



        ArrayList<Float> listaPeso = new ArrayList<>();
        System.out.println("Vamos verificar o maior e o menor peso");
        for (int peso=0; peso<5; peso++){
            System.out.print("Digite o "+(peso+1)+" Peso:");
            float pesosAdd = scanner.nextFloat();
            listaPeso.add(pesosAdd);
        }
        float maiorPeso = Collections.max(listaPeso);
        float menorPeso = Collections.min(listaPeso);
        System.out.println("o maior peso foi:"+maiorPeso);
        System.out.println("O menor peso foi:"+menorPeso);


        System.out.println("Soma somente número par");
        int contPar =0;
        int somaPar = 0;
        for (int c=0; c<7; c++){
            System.out.print("Digite um número:");
            int numerosPares = scanner.nextInt();
            if (numerosPares %2==0){
                contPar++;
                somaPar+=numerosPares;
            }
        }
        System.out.println("O total de números pares"+contPar+" e a soma dos números pares:"+somaPar);


        System.out.println("Vamos listar numeros com de 1 a 50 considerando somente os números pares");
        for (int q=0; q<=50; q+=2){
            System.out.println(q);
        }

        System.out.println("Números ímpares de 1 a 500 que são múltiplos de 3 ");
        int somaImpar = 0;
        int contImpar = 0;
        for (int impar=1; impar<=500;impar+=2){
            if (impar%3==0){
                somaImpar+=impar;
                contImpar++;
            }
        }
        System.out.println("A soma de todos os "+contImpar+" valores solicitados "+somaImpar);


        System.out.println("Vamos fazer uma tabuada");
        System.out.print("Digite um número:");
        int tabu = scanner.nextInt();
        for (int i=0; i<=10; i++){
            System.out.printf("%d x %d = %d%n",tabu,i,tabu*i);
        }


        System.out.println("Média notas juizes");
        ArrayList<Float> listaNotasJuizes1 = new ArrayList<>();
        for (int r=0; r<6;r++){
            System.out.print("Digite a "+(r+1)+"º nota do juiz:");
            float notasdosJuizes = scanner.nextFloat();
            listaNotasJuizes1.add(notasdosJuizes);
        }
        float maiorNotaJuiz = Collections.max(listaNotasJuizes1);
        float menorNotaJuiz = Collections.min(listaNotasJuizes1);
        listaNotasJuizes1.remove(maiorNotaJuiz);
        listaNotasJuizes1.remove(menorNotaJuiz);
        float soma = 0;
        for (float notasdosJuizes : listaNotasJuizes1){
            soma+=notasdosJuizes;
        }
        float mediaNotasJuizes = soma/listaNotasJuizes1.size();
        System.out.println("A média das notas ficou em:"+String.format("%.2f",mediaNotasJuizes));


        System.out.println("Vamos verificar o menor número informado!");
        int menorNumeroInformado = Integer.MAX_VALUE;
        for (int mm =0; mm<5;mm++){
            System.out.print("Digite o "+(mm+1)+" º número:");
            int addNumero = scanner.nextInt();
            if (addNumero < menorNumeroInformado){
                menorNumeroInformado = addNumero;
            }
        }
        System.out.println("O menor número informado foi:"+menorNumeroInformado);


        System.out.println("Vamos verificar quantas pessoas maiores e menores de idade");
        ArrayList<Integer> listaPessoas = new ArrayList<>();
        int idadeMaior = 0;
        int idadeMenor = 0;
        System.out.print("Quantas pessoas você quer cadastrar?:");
        int pessoas1 = scanner.nextInt();
        for (int k=0; k<pessoas1; k++){
            System.out.print("Digite a "+(k+1)+" º data de nascimento:");
            int dataAdicionada = scanner.nextInt();
            listaPessoas.add(dataAdicionada);
            int dataAtual = LocalDate.now().getYear();
            int idadeAtual = dataAtual-dataAdicionada;
            if (idadeAtual>=18){
                idadeMaior++;
            }else {
                idadeMenor++;
            }
        }
        System.out.println("Foram cadastradas:"+idadeMaior+" pessoa(s) maior(es) de idade.");
        System.out.println("Foram cadastradas:"+idadeMenor+" pessoa(s) menor(es) de idade.");


        System.out.println("Vamos verifica o maior e o menor número da lista!");
        ArrayList<Integer> listaNumeros = new ArrayList<>();
        System.out.print("Quantos números você quer adicionar na lista?:");
        int numerosAdicionados = scanner.nextInt();
        for (int b=0; b<numerosAdicionados; b++){
            System.out.print("Digite o "+(b+1)+"º número da lista:");
            int numerosDaLista = scanner.nextInt();
            listaNumeros.add(numerosDaLista);
        }
        int maiorLista = Collections.max(listaNumeros);
        int menorLista1 = Collections.min(listaNumeros);
        System.out.println("O maior número da lista é:"+maiorLista);
        System.out.println("O menor número da lista é:"+menorLista1);



        System.out.println("Vamos sortar um número");
        ArrayList<Integer> nList = new ArrayList<>();
        for (int n=0; n<5; n++){
            System.out.print("Digite o "+(n+1)+"º número da lista:");
            int nl = scanner.nextInt();
            nList.add(nl);
        }
        int sorte = random.nextInt(nList.size());
        int sorteando = nList.get(sorte);
        System.out.println("O número sorteado foi:"+sorteando);

        System.out.println("Vamos sortear a sequencia de apresentação!");
        ArrayList<String> myList = new ArrayList<>();
        for (int m=0; m<5; m++){
            System.out.print("Digite o "+(m+1)+"º da lista:");
            String theNames = scanner.nextLine();
            Collections.addAll(myList,theNames);
        }
        Collections.shuffle(myList);
        System.out.println("A sequência de apresentação ficou:"+myList);

        ArrayList<String> aLista = new ArrayList<>();
        System.out.println("Vamos sortear um número!");
        for (int pessoa=0; pessoa<5; pessoa++){
            System.out.print("Digite o "+(pessoa+1)+"º nome:");
            String nomes = scanner.nextLine();
            aLista.add(nomes);
        }
        int sorteio = random.nextInt(aLista.size());
        String sorteado = aLista.get(sorteio);
        System.out.println("O grande sortudo foi:"+sorteado);


//        Escreva um algoritmo que leia N números e os mostre na tela em ordem crescente.
        System.out.println("Vamos montar uma lista e colocar em ordem crescente!");
        ArrayList<Integer> iLista = new ArrayList<>();
        System.out.print("Digite quantos número quer inserir na lista:");
        int valoresLista = scanner.nextInt();
        for (int z=0; z<valoresLista; z++){
            System.out.print("Digite o "+(z+1)+"º número da lista:");
            int numbers = scanner.nextInt();
            iLista.add(numbers);
        }
        Collections.sort(iLista);
        System.out.println("A lista em ordem crescente é:"+iLista);

//        Escreva um algoritmo que leia N números e mostre na tela o maior deles.
        System.out.println("Vamos fazer uma lista de números  e verificar qual o maior");
        System.out.print("Digite quantos números quer inserir na lista:");
        int numeros = scanner.nextInt();
        int maiorNumero1 = Integer.MIN_VALUE;
        for (int i=0; i<numeros; i++){
            System.out.print("Digite o "+(i+1)+"º número:");
            int numerosInseridos = scanner.nextInt();
            if (numerosInseridos> maiorNumero1){
                maiorNumero1=numerosInseridos;
            }
        }
        System.out.println("O maior número da lista:"+maiorNumero1);


//        Vamos calcular o número de eleitores
        System.out.println("Vamos calcular os votos da cidade!");
        System.out.print("Digite o número total de eleitores da cidade:");
        float totalEleitores = scanner.nextInt();
        System.out.print("Digite o total de votos válidos:");
        float totalVotosValidos = scanner.nextInt();
        System.out.print("Digite o total de votos nulos:");
        float totalVotosNulos = scanner.nextInt();
        System.out.print("Digite o total de votos em branco:");
        float totalVotosEmBranco = scanner.nextInt();
        if (totalEleitores<(totalVotosEmBranco+totalVotosNulos+totalVotosValidos)){
            System.out.println("Soma dos votos válidos, nulos e brancos, não pode ser maior que Total de eleitores");
            return;
        }else {
            float votosValidos = (totalVotosValidos/totalEleitores)*100;
            System.out.println("Total de votos vãlidos:"+String.format("%.2f",votosValidos)+"%");
            float votosNulos = (totalVotosNulos/totalEleitores)*100;
            System.out.println("Total de votos válidos:"+String.format("%.2f",votosNulos)+"%");
            float votosBrancos = (totalVotosEmBranco/totalEleitores)*100;
            System.out.println("Total de votos válidos:"+String.format("%.2f",votosBrancos)+"%");
            float naoVotantes = ((totalEleitores-(totalVotosEmBranco+totalVotosNulos+totalVotosValidos))/totalEleitores)*100;
            System.out.println("Total de pessoas não votantes:"+String.format("%.2f",naoVotantes)+"%");
        }

//        Escreva um algoritmo que armazene o valor 10 em uma variável A e o valor 20 em uma variável B.
//        A seguir (utilizando apenas atribuições entre variáveis) troque os seus conteúdos
        System.out.println("Vamos trocar as vairáveis!");
        byte A =10;
        byte B = 20;
        System.out.println("A variável A:"+A);
        System.out.println("A variável B:"+B);
        byte troca = A;
        A = B;
        B = troca;
        System.out.println("Após a Troca !");
        System.out.println("A variável A:"+A);
        System.out.println("A variável B:"+B);




//        calcular o IMC
        System.out.println("Vamos calcular o IMC!");
        System.out.print("Digite o seu nome:");
        String nome = scanner.nextLine();
        System.out.print("Digite o seu peso:");
        float peso = scanner.nextFloat();
        System.out.print("Digite a sua altura:");
        float altura = scanner.nextFloat();
        float imc = peso/(altura*2);
        if (imc<18.f){
            System.out.println(nome+": Seu IMC é:"+String.format("%.2f",imc)+" e você está com bulemia!");
        } else if (imc>=18.5 && imc<=25.00f) {
            System.out.println(nome+": Seu IMC é:"+String.format("%.2f",imc)+" e você está com peso ideal!");
        } else if (imc>=25.01f && imc <=30.00f) {
            System.out.println(nome+": Seu IMC é:"+String.format("%.2f",imc)+" e você está com sobre peso!");
        } else if (imc>=30.01f && imc<=35.00f) {
            System.out.println(nome+": Seu IMC é:"+String.format("%.2f",imc)+" e você está obeso");
        }else {
            System.out.println(nome+": Seu IMC é:"+String.format("%.2f",imc)+" e você está com obesidade morbida");
        }


//        calculo notas juizes(excluir a maior e a menor nota e fazer média)
        System.out.println("Vamos verificar as notas dos juizes!");
        ArrayList<Float> listaNotasJuizes = new ArrayList<>();
        for (int j=0; j<6; j++){
            System.out.print("Digite a nota do "+(j+1)+"º juiz:");
            float notasJuizes = scanner.nextFloat();
            listaNotasJuizes.add(notasJuizes);
        }
        float maiorNota = Collections.max(listaNotasJuizes);
        float menorNota = Collections.min(listaNotasJuizes);
        listaNotasJuizes.remove(maiorNota);
        listaNotasJuizes.remove(menorNota);
        float soma1 = 0;
        for (float notasJuizes : listaNotasJuizes){
            soma1+=notasJuizes;
        }
        float media = soma1/ listaNotasJuizes.size();
        System.out.println("A média final ficou em:"+media);


//        Assuma que o trabalhador do exercício anterior deve pagar um imposto sobre o valor do seu salário
        System.out.println("Vamos Calcular o imposto sobre o seu salário!");
        System.out.print("Digite o valor do seu salário:R$");
        float salario = scanner.nextFloat();
        if (salario<=499.99f){
            float faixa1 = salario*.05f;
            System.out.println("O seu salário é:R$"+String.format("%.2f",salario)+" e o imposto devido é R$"+String.format("%.2f",faixa1));
        } else if (salario>=500.00f && salario<=999.99f) {
            float faixa2 = salario*0.10f;
            System.out.println("O seu salário é:R$"+String.format("%.2f",salario)+" e o imposto devido é:R$"+String.format("%.2f",faixa2));
        } else if (salario>=1000.00f && salario<=1499.99f) {
            float faixa3 = salario*.15f;
            System.out.println("O seu salário é:R$"+String.format("%.2f",salario)+" e o imposto devido é:R$"+String.format("%.2f",faixa3));
        } else if (salario>=1500.00f && salario<=1999.99f) {
            float faixa4 = salario*0.20f;
            System.out.println("O seu salário é:R$"+String.format("%.2f",salario)+" e o imposto devido é:R$"+String.format("%.2f",faixa4));
        }else {
            float faixa5 = salario*0.25f;
            System.out.println("O seu salário é:R$"+String.format("%.2f",salario)+" e o imposto devido é:R$"+String.format("%.2f",faixa5));
        }


//        ler salário funcionário
        System.out.println("Vamos calcular seu salário!");
        System.out.print("Digite quantas horas você trabalhou no mês:");
        float horas = scanner.nextFloat();
        System.out.print("Digite o valor da hora trabalhada:");
        float valor = scanner.nextFloat();
        if (horas<=220){
            float salarioSemHorasExtras = valor*horas;
            System.out.println("Este mês o seu salário foi de R$"+String.format("%.2f",salarioSemHorasExtras));
        }else {
            float salarioComHorasExtras = valor*220+((horas-220)*(valor+(valor*0.5f)));
            System.out.println("Esse mês o seu salário foi de R$"+String.format("%.2f",salarioComHorasExtras));
        }


//        conversão cambial entre Reais e Dólares
        System.out.println("Vamos fazer a conversão de Reais para Dolar");
        System.out.print("Digite o valor em reais a ser convertido:R$");
        float reais = scanner.nextFloat();
        System.out.print("Digite o valor da taxa de câmbio:R$");
        float taxaCambio = scanner.nextFloat();
        float conversao = reais/taxaCambio;
        System.out.printf("O valor de R$%.2f convertidos em dolar a taxa de câmbio de R$%.2f é igual:U$$:%.2f%n",reais,taxaCambio,conversao);


//        Escreva um algoritmo que leia três números e mostre o maior deles.
        System.out.println("Vamos ler três número e ver o maior deles!");
        int maiorNumero = Integer.MIN_VALUE;
        for (int n=0;n<3;n++){
            System.out.print("Digite o "+(n+1)+"º número da lista:");
            int numeros1 = scanner.nextInt();
            if (numeros1>maiorNumero){
                maiorNumero=numeros1;
            }
        }
        System.out.println("O maior número digitado foi:"+maiorNumero);

    }
}
