package academy.devdojo.maratonajava.introducao;


import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.time.LocalDate;

public class Aula6OperadoresCondicionais2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        // vamos calcular o imposto sobre o salário
        System.out.println("Vamos calcular o imposto sobre o seu salário!");
        System.out.print("Informe o seu salário:");
        float salario = scanner.nextFloat();
        if (salario<=499.99f){
            float impostoFaixa1 = salario*0.05f;
            System.out.println("O imposto sobre o seu salário é:R$ "+String.format("%.2f",impostoFaixa1));
        }else if (salario>=500 && salario<=1000){
            float impostosFaixa2 = salario*0.10f;
            System.out.println("O imposto sobre o seu salário é:R$ "+String.format("%.2f",impostosFaixa2));
        }else if (salario>=1001 && salario<=1499.99f){
            float impostoFaixa3 = salario*0.15f;
            System.out.println("O imposto sobre o seu salário é:R$ "+String.format("%.2f",impostoFaixa3));
        }else if (salario>=1500 && salario<=1999.99f){
            float impostoFaixa4 = salario*.20f;
            System.out.println("O imposto sobre o seu salário é:R$ "+String.format("%.2f",impostoFaixa4));
        }else {
            float impostoFaixa5 = salario*.25f;
            System.out.println("O imposto sobre o seu salário é:R$ "+String.format("%.2f",impostoFaixa5));
        }



        //Vamos calcular os votos da cidade
        System.out.println("Vamos calcular os votos da cidade!");
        System.out.print("Digite o total de eleitores da cidade:");
        int eleitores = scanner.nextInt();
        System.out.print("Digite o total de votos válidos:");
        int votosValidos = scanner.nextInt();
        System.out.print("Digite o total de votos nulos:");
        int votosNulos = scanner.nextInt();
        System.out.print("Digite o total de votos brancos:");
        int votosBrancos = scanner.nextInt();
        float percentualvotosValidos = (votosValidos/(float)eleitores)*100;
        float percentualvotosBrancos = (votosBrancos/(float)eleitores)*100;
        float percentualvotosNulos = (votosNulos/(float)eleitores)*100;
        float percentualNaoVotaram = ((eleitores-(votosNulos+votosBrancos+votosValidos))/(float)eleitores)*100;
        if (eleitores< votosBrancos+votosValidos+votosNulos){
            System.out.println("Votos totais não pode ser maior que a soma dos votos válidos, nulos e branco");
        }else{
            System.out.println("Os votos válidos é igual: "+String.format("%.2f",percentualvotosValidos)+"%");
            System.out.println("Os votos nulos é igual: "+String.format("%.2f",percentualvotosNulos)+"%");
            System.out.println("Os votos em branco é igual: "+String.format("%.2f",percentualvotosBrancos)+"%");
            System.out.println("Pessoas que não votaram, representam: "+String.format("%.2f",percentualNaoVotaram)+"%");
        }




        System.out.println("Vamos calcular a tabuada!");
        System.out.print("Digite um número inteiro:");
        int tabuadas = scanner.nextInt();
        for (int l=0; l<=10;l++){
            System.out.printf("%d x %d = %d%n",tabuadas,l,tabuadas*l);
        }

        //lista par ou impar
        System.out.println("Vamos verificar se os números são pares ou impares!");
        System.out.print("Digite o primeiro número:");
        int primeiro = scanner.nextInt();
        System.out.print("Digite o segundo número:");
        int segundo  = scanner.nextInt();
        System.out.print("Digite o terceiro número:");
        int terceiro = scanner.nextInt();
        System.out.print("Digite o quarto número:");
        int quarto = scanner.nextInt();
        ArrayList<Integer> listinha = new ArrayList<>();
        Collections.addAll(listinha, primeiro,segundo,terceiro,quarto);
        for (int numero:listinha) {
            if (numero % 2 == 0) {
                System.out.println(numero + "- Esse números é par:");
            } else {
                System.out.println(numero + "- Esse número é impar");
            }
        }


        //Sequencia de apresentação
        System.out.println("Vamos sortear a sequencia de apresentação!");
        System.out.print("Digite o primeiro nome:");
        String nomes1 = scanner.nextLine();
        System.out.print("Digite o segundo nome:");
        String nomes2 = scanner.nextLine();
        System.out.print("Digite o terceiro nome:");
        String nomes3 = scanner.nextLine();
        System.out.print("Digite o quarto nome:");
        String nomes4 = scanner.nextLine();
        ArrayList<String> cc = new ArrayList<>();
        cc.add(nomes1);
        cc.add(nomes2);
        cc.add(nomes3);
        cc.add(nomes4);
        Collections.shuffle(cc);
        System.out.println("A sequência de apresentação ficou:"+cc);


        // maior e menor na lista
        System.out.println("Vamos verificar o maior e o menor da lista");
        System.out.print("Digite o primeiro número:");
        int b1 = scanner.nextInt();
        System.out.print("Digite o segundo número:");
        int b2 = scanner.nextInt();
        System.out.print("Digite o terceiro:");
        int b3 = scanner.nextInt();
        System.out.print("Digite o quarto:");
        int b4 = scanner.nextInt();
        ArrayList<Integer> bb = new ArrayList<>();
        Collections.addAll(bb,b1,b2,b3,b4);
        int maiorMax = Collections.max(bb);
        int menorMin = Collections.min(bb);
        System.out.println("O maior da lista é "+maiorMax+ " e o menor da lista "+menorMin);

        // Sorteio de um número
        System.out.println("VAMOS SORTEAR UM NÚMERO!");
        System.out.print("Digit o primeiro número:");
        int mm1 = scanner.nextInt();
        System.out.print("Digite o segundo número:");
        int mm2 = scanner.nextInt();
        System.out.print("Digite o terceiro número:");
        int mm3 = scanner.nextInt();
        System.out.print("Digite o quarto número:");
        int mm4 = scanner.nextInt();
        ArrayList<Integer> nossaLista1 = new ArrayList<>();
        Collections.addAll(nossaLista1,mm1,mm2,mm3,mm4);
        int sorteNossa1 = random.nextInt(nossaLista1.size());
        int nossaSorte1 = nossaLista1.get(sorteNossa1);
        System.out.println("O número sorteado foi:"+nossaSorte1);


        // Vamos sequencia de apresentação!
        System.out.println("Vamos sequencia de apresentação!");
        System.out.print("Digite o primeiro nome:");
        String nm1 = scanner.nextLine();
        System.out.print("Digite o segundo nome:");
        String nm2 = scanner.nextLine();
        System.out.print("Digite o terceiro nome:");
        String nm3 = scanner.nextLine();
        System.out.print("Digite o quarto nome:");
        String nm4 = scanner.nextLine();
        ArrayList<String> listas = new ArrayList<>();
       // listas.add(nm1);
        //listas.add(nm2);
        //listas.add(nm3);
        //listas.add(nm4);
        Collections.addAll(listas, nm1,nm2,nm3,nm4);
        Collections.shuffle(listas);
        System.out.println("A sequencia de apresentação ficou:"+listas);




        // VAMOS VERIFICAR A SUA CATEGORIA
        System.out.println("Vamos verificar a sua categoria");
        System.out.print("Digite seu nome:");
        String nome10 = scanner.nextLine();
        System.out.print("Digite seu ano de nascimento:");
        int nascimento = scanner.nextInt();
        int ano_atual = LocalDate.now().getYear();
        int idadeHoje = ano_atual-nascimento;
        if (idadeHoje <=9){
            System.out.println(nome10+", sua idade é "+idadeHoje+" e sua categoria é MIRIM");
        }else if (idadeHoje>=10 && idadeHoje<=14){
            System.out.println(nome10+", sua idade é "+idadeHoje+" e sua categoria é INFANTIL");
        }else if (idadeHoje>=15 && idadeHoje<=19){
            System.out.println(nome10+", sua idade é "+idadeHoje+" e sua categoria é JUNIOR");
        }else if (idadeHoje ==20){
            System.out.println(nome10+", sua idade é "+idadeHoje+" e sua categoria é SENIOR");
        }else{
            System.out.println(nome10+", sua idade é "+idadeHoje+" e sua categoria é MASTER");
        }

        //exercicio alistamento militar:
        System.out.println("Alistamento militar!");
        System.out.print("Digite o ano de nascimento:");
        int anoInformado = scanner.nextInt();
        int year = LocalDate.now().getYear();
        int ano = year - anoInformado;
        if (ano<=17){
            int falta = 18-ano;
            System.out.println("Você tem "+ano+", faltam "+falta+ " anos para você se alistar.");
        }else if (ano==18){
            System.out.println("Você tem "+ano+", e precisa comparecer a junta de seviço militar este ano.");
        }else{
            int passou = ano-18;
            System.out.println("Você tem "+ano+", passou "+passou+" anos para você se alistar.");
        }



        //media notas escola
        System.out.println("Vamos calcular média");
        System.out.print("Digite a primeira nota:");
        float note1 = scanner.nextFloat();
        System.out.print("Digite a segunda nota:");
        float note2 = scanner.nextFloat();
        float mediaNota = (note1+note2)/2;
        if (mediaNota>=7f){
            System.out.println("Suas notas foram "+String.format("%.2f",note1)+ " e " +String.format("%.2f",note2)+" e sua média ficou em: "+String.format("%.2f",mediaNota)+" Você está APROVADO(A)");
        } else if (mediaNota >=5f && mediaNota <=6.9f){
            System.out.println("Suas notas foram "+String.format("%.2f",note1)+" e "+String.format("%.2f",note2)+" e sua média ficou em: "+String.format("%.2f",mediaNota)+" Você está em RECUPERAÇÃO");
        } else{
            System.out.println("Suas notas foram "+String.format("%.2f",note1)+" e "+String.format("%.2f",note2)+" e sua média ficou em: "+String.format("%.2f",mediaNota)+" Você está REPROVADO(A)");
        }


        //Verificar 3 retas
        System.out.println("Vamos verificar se as 3 retas formam um triângulo!");
        System.out.print("Digite o valor da primeira reta:");
        int retas1 = scanner.nextInt();
        System.out.print("Digite o valor da segunda reta:");
        int retas2  = scanner.nextInt();
        System.out.print("Digite o valor da terceira reta:");
        int retas3 = scanner.nextInt();
        if (retas1+retas2>retas3 && retas2+retas3>retas1 && retas1+retas3>retas2){
            System.out.println("Essas três retas fomam um triângulo");
            if (retas1 == retas2 && retas2 == retas3 && retas3 == retas1) {
                System.out.println("Esse triângulo é um EQUILÁTERO");
            } else if (retas1 != retas2 && retas3 != retas1) {
                System.out.println("Esse triângulo é um ESCALENO");
            } else {
                System.out.println("Esse triângulo é um ISÓCELES");
            }
        }else{
            System.out.println("Essas três retas não formam um triângulo");
        }

        // tabuada
        System.out.println("Vamos calcular a tabuada!");
        System.out.print("Digite o primeiro número:");
        int tabuadas1 = scanner.nextInt();
        for (int a=0 ; a<=10 ;a++){
            System.out.printf("%d x %d = %d%n",tabuadas1,a,tabuadas1*a);
        }

        // exercicio sorteio de uma pessoa
        System.out.println("Vamos sortear 1 pessoa!");
        System.out.print("Digite o primeiro nome:");
        String pearson1 = scanner.nextLine();
        System.out.print("Digite o segundo nome:");
        String pearson2 = scanner.nextLine();
        System.out.print("Digite o terceiro nome:");
        String pearson3 = scanner.nextLine();
        System.out.print("Digite o quarto nome:");
        String pearson4 = scanner.nextLine();
        ArrayList<String> yourlist = new ArrayList<>();
        yourlist.add(pearson1);
        yourlist.add(pearson2);
        yourlist.add(pearson3);
        yourlist.add(pearson4);
        int sort = random.nextInt(yourlist.size());
        String mysort = yourlist.get(sort);
        System.out.println("O grande sortudo de hoje foi: "+mysort);


        //Vamos sortear a sequencia de apresentação
        System.out.println("Vamos sortear a sequencia de apresentação!");
        System.out.print("Digite o primeiro nome:");
        String pe1 = scanner.nextLine();
        System.out.print("Digite o segundo nome:");
        String pe2 = scanner.nextLine();
        System.out.print("Digite o terceiro nome:");
        String pe3 = scanner.nextLine();
        System.out.print("Digite o quarto nome:");
        String pe4 = scanner.nextLine();
        ArrayList<String> mylist = new ArrayList<>();
        Collections.addAll(mylist, pe1,pe2,pe3,pe4);
        Collections.shuffle(mylist);
        System.out.println("A sequência de apresentação ficou: "+mylist);

        // verificar o maior e o menor
        System.out.println("Vamos verificar o maior e o menor!");
        System.out.print("Digite o primeiro número:");
        int p1 = scanner.nextInt();
        System.out.print("Digite o segundo número:");
        int p2 = scanner.nextInt();
        System.out.print("Digite o terceiro número:");
        int p3 = scanner.nextInt();
        System.out.print("Digite o quarto número:");
        int p4 = scanner.nextInt();
        ArrayList<Integer> num = new ArrayList<>();
        num.add(p1);
        num.add(p2);
        num.add(p3);
        num.add(p4);
        int maior_num = Collections.max(num);
        int menor_num = Collections.min(num);
        System.out.println("O maior número é: " +maior_num+ " e o menor número: "+menor_num);


        //Vamos verificar o maior e o menor
        System.out.println("Vamos verificar o maior e o menor");
        System.out.print("Digite o primeiro número:");
        int nn1  = scanner.nextInt();
        System.out.print("Digite segundo número:");
        int nn2 = scanner.nextInt();
        System.out.print("Digite o terceiro número:");
        int nn3 = scanner.nextInt();
        System.out.print("Digite o quarto número:");
        int nn4 = scanner.nextInt();
        ArrayList<Integer> menorEmaior = new ArrayList<>();
        menorEmaior.add(nn1);
        menorEmaior.add(nn2);
        menorEmaior.add(nn3);
        menorEmaior.add(nn4);
        int maior2 = Collections.max(menorEmaior);
        int menor2 = Collections.min(menorEmaior);
        System.out.println("O maior da lista é "+maior2+" e o menor da lista:"+menor2);



        // encontrando o par e o impar na lista
        System.out.println("Vamos verificar os números pares e impares na lista:");
        System.out.print("Digite um número:");
        int numero1 = scanner.nextInt();
        System.out.print("Digite o segundo número:");
        int numero2 = scanner.nextInt();
        System.out.print("Digite o terceiro número:");
        int numero3 = scanner.nextInt();
        System.out.print("Digite o quarto número:");
        int numero4 = scanner.nextInt();
        ArrayList<Integer> sorteio1 = new ArrayList<>();
        sorteio1.add(numero1);
        sorteio1.add(numero2);
        sorteio1.add(numero3);
        sorteio1.add(numero4);
        int meuSorteio = random.nextInt(sorteio1.size());
        int sorte = sorteio1.get(meuSorteio);
        System.out.println("O número sorteado foi:"+sorte);

        //Calculo maior e menor
        System.out.println("Vamos verificar o maior e o menor da lista");
        System.out.print("Digite um número:");
        int na1 = scanner.nextInt();
        System.out.print("Digite o segundo número:");
        int na2 = scanner.nextInt();
        System.out.print("Digite o terceiro número:");
        int na3 = scanner.nextInt();
        System.out.print("Digite o quarto número:");
        int na4 = scanner.nextInt();
        ArrayList<Integer> nossaLista = new ArrayList<>();
        nossaLista.add(na1);
        nossaLista.add(na2);
        nossaLista.add(na3);
        nossaLista.add(na4);
        int maior = Collections.max(nossaLista);
        int menor  = Collections.min(nossaLista);
        System.out.println("O maior da lista é " +maior+ " e o menor da lista é "+menor);

        //Exercicio tabuada

        System.out.println("Vamos calcular a tabuada!");
        System.out.print("Digite um número:");
        int tabuada = scanner.nextInt();
        for(int i=0;i<=10;i+=1){
            System.out.printf("%d x %d = %d%n",tabuada,i,tabuada*i);
        }


        //Exercicio triangulo
        System.out.println("Vamos verificar se é possivel fazer um triângulo !");
        System.out.print("Digite o tamanho da primeira reta:");
        int reta1 = scanner.nextInt();
        System.out.print("Digite o tamanho da segunda reta:");
        int reta2 = scanner.nextInt();
        System.out.print("Digite o tamanho da terceira reta:");
        int reta3 = scanner.nextInt();
        if (reta1+reta2>reta3 && reta2+reta3>reta1 && reta1+reta3>reta2){
            System.out.println("Com as três retas, é possivel fazer um triângulo!");
            if (reta1==reta2 && reta3==reta1){
                System.out.println("Esse triângulo possui todos os lados iguais, é um triângulo EQUILÁTERO");
            }else if (reta1 != reta2 && reta2 !=reta3 && reta1!=reta3){
                System.out.println("Esse triângulo possui todos os lados diferentes, é um triângulo ESCALENO");
            }else{
                System.out.println("Esse triângulo possui 2 lados iguais e um diferente, é um triângulo ISOCELES");
            }
        }else{
            System.out.println("Essas três retas não forma um triângulo!");
        }


        //exercicio imc

        System.out.println("Vamos calcular seu IMC!");
        System.out.print("Digite o seu nome:");
        String nome = scanner.nextLine();
        System.out.print("Digite sua idade:");
        int idade = scanner.nextInt();
        System.out.print("Digite o seu peso:");
        float peso = scanner.nextFloat();
        System.out.print("Digite sua altura:");
        float altura = scanner.nextFloat();
        float imc = peso/(altura*2);
        if (imc>=18.50f && imc<=25.00f){
            System.out.println(nome+ ", seu IMC é igual "+String.format("%.2f",imc)+" Você está com peso adequado" );
        }else if (imc>=25.01f && imc <=30.00f){
            System.out.println(nome+", seu IMC é igual " +String.format("%.2f",imc)+ " Você está sobrepeso");
        }else{
            System.out.println(nome+", seu IMC é igual "+String.format("%.2f",imc)+" Você está com obesidade morbida!");
        }






        //exercicio media nota
        System.out.println("Vamos calcular a média das duas notas!");
        System.out.print("Digite a primeira nota:");
        float nota1 = scanner.nextFloat();
        System.out.print("Digite a segunda nota:");
        float nota2 = scanner.nextFloat();
        float media = (nota2+nota1)/2;
        if (media>=7.0f){
            System.out.println("Suas notas foram "+String.format("%.2f",nota1)+ " e " +String.format("%.2f",nota2)+" e sua média foi "+String.format("%.2f",media)+ " Você foi Aprovado(a)");
        }else if (media>=5.0f && media<=6.9f){
            System.out.println("Suas notas foram "+String.format("%.2f",nota1)+" e "+String.format("%.2f",nota2)+" e sua média foi "+String.format("%.2f",media)+ " você estã em recuperação!");
        }else{
            System.out.println("Suas notas foram "+String.format("%.2f",nota1)+ " e " +String.format("%.2f",nota2)+" e sua média foi "+String.format("%.2f",media)+ " você está reprovado!");
        }



        //Verificando o maior e o menor
        System.out.println("Vamos agora verificar o maior e o menor da lista");
        System.out.print("Digite o primeiro número:");
        int number1 = scanner.nextInt();
        System.out.print("Digite o segundo número:");
        int number2 = scanner.nextInt();
        System.out.print("Digite o terceiro número:");
        int number3 = scanner.nextInt();
        System.out.print("Digite o quarto número:");
        int number4 = scanner.nextInt();
        ArrayList<Integer> nlista = new ArrayList<>();
        nlista.add(number1);
        nlista.add(number2);
        nlista.add(number3);
        nlista.add(number4);
        int maior1 = Collections.max(nlista);
        int menor1 = Collections.min(nlista);
        System.out.println("O maior número da lista é "+maior1+" e o menor é "+menor1);


        // Exercicio sorteia sequencia

        System.out.println("Vamos sortear a sequencia de apresentação!");
        System.out.print("Digite o primeiro nome:");
        String n1 = scanner.nextLine();
        System.out.print("Digite o segundo nome:");
        String n2 = scanner.nextLine();
        System.out.print("Digite o terceiro nome:");
        String n3 = scanner.nextLine();
        System.out.print("Digite o quarto nome:");
        String n4 = scanner.nextLine();
        ArrayList<String> alista = new ArrayList<>();
        Collections.addAll(alista, n1,n2,n3,n4);
        Collections.shuffle(alista);
        System.out.println("A sequencia de apresentação ficou:"+alista);


        //Exercicio sorteia 1
        System.out.println("Vamos sortear um aluno !");
        System.out.print("Digite o primeiro nome:");
        String nome1 = scanner.nextLine();
        System.out.print("Digite o segundo nome:");
        String nome2 = scanner.nextLine();
        System.out.print("Digite o terceiro nome:");
        String nome3 = scanner.nextLine();
        System.out.print("Digite o quarto nome:");
        String nome4 = scanner.nextLine();
        ArrayList<String> lista = new ArrayList<>();
        lista.add(nome1);
        lista.add(nome2);
        lista.add(nome3);
        lista.add(nome4);
        int sorteio = random.nextInt(lista.size());
        String sorteado = lista.get(sorteio);
        System.out.println("O grande sortudo desta noite foi:"+sorteado);

        scanner.close();
    }
}
