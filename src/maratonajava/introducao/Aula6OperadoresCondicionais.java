package academy.devdojo.maratonajava.introducao;

import java.util.Scanner;
import java.time.LocalDate;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class Aula6OperadoresCondicionais {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random =  new Random();

        //calculo IMC
        System.out.println("Vamos calcular o IMC");
        System.out.print("Digite o seu nome:");
        String hh = scanner.nextLine();
        System.out.print("Digite sua idade:");
        int age = scanner.nextInt();
        System.out.print("Digite o seu peso:");
        float weight = scanner.nextFloat();
        System.out.print("Digite sua altura:");
        float height = scanner.nextFloat();
        float imc = weight/(height*2);
        if (imc>=18.5f && imc<=25f){
            System.out.println(hh+", você tem "+age+" anos, e seu IMC é:"+String.format("%.2f",imc)+", e você está com peso ideal!");
        }else if (imc>=25.01f && imc<=30f){
            System.out.println(hh+", você tem "+age+" anos, e seu IMC é:"+String.format("%.2f",imc)+", você está sobrepeso");
        }else if (imc>=30.01f){
            System.out.println(hh+", você tem "+age+" anos, e seu IMC é:"+String.format("%.2f",imc)+", você tem obesidade morbida");
        }


        //  Selecionando o maior e o menor

        System.out.println("Vamos verificar o maior e o menor número:");
        System.out.print("Digite o primeiro número:");
        int nn11 = scanner.nextInt();
        System.out.print("Digite o segundo número:");
        int nn2 = scanner.nextInt();
        System.out.print("Digite o terceiro número:");
        int nn33 = scanner.nextInt();
        System.out.print("Digite o quarto número:");
        int nn44 = scanner.nextInt();
        ArrayList<Integer> maiorEmenor1 = new ArrayList<>();
        maiorEmenor1.add(nn11);
        maiorEmenor1.add(nn2);
        maiorEmenor1.add(nn33);
        maiorEmenor1.add(nn44);
        int maior = Collections.max(maiorEmenor1);
        int menor = Collections.min(maiorEmenor1);
        System.out.println("O maior foi "+maior+" e o menor foi" +menor);


        System.out.println("Digite 4 números e vamos ver o maior e o menor.");
        System.out.print("Digite o primeiro número:");
        int aa1 = scanner.nextInt();
        System.out.print("Digite o segundo número:");
        int aa2 = scanner.nextInt();
        System.out.print("Digite o terceiro número:");
        int aa3 = scanner.nextInt();
        System.out.print("Digite o quarto número:");
        int aa4 = scanner.nextInt();
        ArrayList<Integer> MaxendMin = new ArrayList<>();
        MaxendMin.add(aa1);
        MaxendMin.add(aa2);
        MaxendMin.add(aa3);
        MaxendMin.add(aa4);
        int maior1 = Collections.max(MaxendMin);
        int menor1 = Collections.min(MaxendMin);
        System.out.println("O maior número foi "+maior1+" e o menor número foi "+menor1);



        // sorteio sequencia
        System.out.println("Vamos sortear a sequencia\n");
        System.out.print("Digite o primeiro nome:");
        String nome10 = scanner.nextLine();
        System.out.print("Digite o segundo nome:");
        String nome11 = scanner.nextLine();
        System.out.print("Digite o terceiro nome:");
        String nome12 = scanner.nextLine();
        System.out.print("Digite o quarto nome:");
        String nome13 = scanner.nextLine();
        ArrayList<String> aNossaLista = new ArrayList<>();
        Collections.addAll(aNossaLista, nome10,nome11,nome12,nome13);
        Collections.shuffle(aNossaLista);
        System.out.println("A sequecia de apresentação ficou:"+aNossaLista);


        //Sorteio de uma pessoa
        System.out.println("Vamos sortear uma pessoa");
        System.out.print("Digite o primeiro nome:");
        String primeiroNome = scanner.nextLine();
        System.out.print("Digite o segundo nome:");
        String segundoNome = scanner.nextLine();
        System.out.print("Digite o terceiro nome:");
        String terceiroNome = scanner.nextLine();
        System.out.print("Digite o quarto nome:");
        String quartoNome = scanner.nextLine();
        ArrayList<String> nossaLista = new ArrayList<>();
        nossaLista.add(primeiroNome);
        nossaLista.add(segundoNome);
        nossaLista.add(terceiroNome);
        nossaLista.add(quartoNome);
        int sorteioNome = random.nextInt(nossaLista.size());
        String sorteadoa = nossaLista.get(sorteioNome);
        System.out.println("O grande sorteado foi:"+sorteadoa);


        //calculo tabuada
        System.out.println("Vamos calcular uma tabuada!");
        System.out.print("Digite um número:");
        int tabuada2 = scanner.nextInt();
        for (int i=0;i<=10;i+=1){
            System.out.printf("%d x %d = %d%n",tabuada2,i,tabuada2*i);
        }

        // exercicio alistamento militar
        System.out.println("Vamos verificar se você precisa se alistar!");
        System.out.print("Digite o seu nome:");
        String name = scanner.nextLine();
        System.out.print("Digite o seu ano de nascimento:");
        int anoNascimento = scanner.nextInt();
        int anoAtual = LocalDate.now().getYear();
        int idadeAtual = anoAtual - anoNascimento;
        if (idadeAtual <=17){
            int idadeMenor = 18- idadeAtual;
            System.out.println(name+", Você tem "+idadeAtual+" e faltam " +idadeMenor+" anos para você se alistar.");
        }else if (idadeAtual ==18){
            System.out.println(name+", você tem "+idadeAtual+" e você precisa comparecer a Junta de serviço militar");
        }else{
            int idadeMaior = idadeAtual - 18;
            System.out.println(name+", Você tme "+idadeAtual+" já se passaram "+idadeMaior+" anos para você se alistar.");
        }




        // calculo triângulo
        System.out.println("Vamos verificar se as 3 retas formam um triângulo");
        System.out.print("Digite o valor da primeira reta:");
        int retaUm = scanner.nextInt();
        System.out.print("Digite o valor da segunda reta:");
        int retaDois = scanner.nextInt();
        System.out.print("Digite o valor da terceira reta:");
        int retaTres = scanner.nextInt();
        if (retaUm+retaDois > retaTres && retaDois+retaTres> retaUm && retaUm+retaTres>retaDois){
            System.out.println("Essas três retas formam um triângulo!");{
            }if (retaUm ==retaDois && retaTres==retaUm){
                System.out.println("Esse triângulo é um EQUILATERO");
            }else if (retaUm != retaDois && retaTres != retaUm){
                System.out.println("Esse triângulo é um ESCALENO");
            }else{
                System.out.println("Esse triângulo é um ISÓCELES");
            }
        }else{
            System.out.println("Essas três retas não forma um triângulo!");
        }







        //média notas escola
        System.out.println("Vamos calcular a sua média");
        System.out.print("Digite a primeira nota:");
        float nt1 = scanner.nextInt();
        System.out.print("Digite a segunda nota:");
        float nt2 = scanner.nextInt();
        float media1 = (nt2+nt1)/2;
        if (media1>=7f){
            System.out.printf("Suas notas foram:%.2f e %.2f e sua média final:%.2f e você está APROVADO(A)!%n",nt1,nt2,media1);
        }else if (media1 >=5f && media1<=6.9f){
            System.out.printf("Suas notas foram:%.2f e %.2f e sua média final:%.2f e você está EM RECUPERAÇÃO!%n",nt1,nt2,media1);
        }else{
            System.out.printf("Suas notas foram:%.2f e %.2f e sua média final:%.2f e você está REPROVADO(A)!%n",nt1,nt2,media1);
        }



        //vamos ver a sua categoria
        System.out.println("Vamos verificar a sua categoria:");
        System.out.print("Digite seu nome:");
        String nomes = scanner.nextLine();
        System.out.print("Digite o ano de nascimento:");
        int anoNasc = scanner.nextInt();
        int YearNow = LocalDate.now().getYear();
        int idadePessoa = YearNow - anoNasc;
        if (idadePessoa <=9){
            System.out.println(nomes+", você tem " +idadePessoa+" e sua categoria é Mirim!");
        } else if (idadePessoa >=10 && idadePessoa <=14){
            System.out.println(nomes+", você tem "+idadePessoa+" e sua categoria é Infantil!");
        }else if (idadePessoa >=15 && idadePessoa <=19){
            System.out.println(nomes+", você tem "+idadePessoa+" e sua categoria é Junior!");
        } else if (idadePessoa ==20){
            System.out.println(nomes+", você tem "+idadePessoa+" e sua categoria é Senior!");
        }else{
            System.out.println(nomes+", você tem "+idadePessoa+" e sua categoria é Master");
        }


        // sortear a sequencia de apresentação
        System.out.println("Vamos sortear a sequência de apresentação!");
        System.out.print("Digite o primeiro nome:");
        String nm1 = scanner.nextLine();
        System.out.print("Digite o segundo nome:");
        String nm2 = scanner.nextLine();
        System.out.print("Digite o terceiro nome:");
        String nm3 = scanner.nextLine();
        System.out.print("Digite o quarto nome:");
        String nm4 = scanner.nextLine();
        ArrayList<String> amlista = new ArrayList<>();
        Collections.addAll(amlista, nm1,nm2,nm3,nm4);
        Collections.shuffle(amlista);
        System.out.println("A sequência de apresentação é igual:"+amlista);


        //Sortear um aluno
        System.out.println("Vamos sortear um aluno!");
        System.out.print("Digite o nume do primeiro aluno:");
        String all1 = scanner.nextLine();
        System.out.print("Dgite o nome do segundo aluno:");
        String all2 = scanner.nextLine();
        System.out.print("Digite o nome do terceiro aluno:");
        String all3 = scanner.nextLine();
        System.out.print("Digite o nome do quarto aluno:");
        String all4 = scanner.nextLine();
        ArrayList<String> minhaLista = new ArrayList<>();
        minhaLista.add(all1);
        minhaLista.add(all2);
        minhaLista.add(all3);
        minhaLista.add(all4);
        int meuSorteio = random.nextInt(minhaLista.size());
        String minhaSorte = minhaLista.get(meuSorteio);
        System.out.println("O grande sortudo foi:"+minhaSorte);





        System.out.println("Vamos verificar se 3 retas formam um triângulo");
        System.out.print("Digite o valor da primeira reta:");
        float reta1 = scanner.nextFloat();
        System.out.print("Digite o valor da segunda reta:");
        float reta2 = scanner.nextFloat();
        System.out.print("Digite o valor da terceira reta:");
        float reta3 = scanner.nextFloat();
        if (reta1+reta2>reta3 && reta2+reta3>reta1 && reta1+reta3>reta2) {
            System.out.println("Essas três retas forma um triângulo!");
            if (reta1 == reta2 && reta3 == reta1) {
                System.out.println("Esse triângulo é EQUILÁTERO!");
            } else if (reta1 != reta2 && reta3 != reta1) {
                System.out.println("Esse triângulo é ESCANELO");
            } else {
                System.out.println("Esse triêngulo é ISOCELES");
            }
        } else {
            System.out.println("Essas três retas não forma um triângulo!");
        }


        System.out.println("Vamos verificar o seu IMC!");
        System.out.print("Digite o seu nome:");
        String nome0 = scanner.nextLine();
        System.out.print("Digite o seu peso:");
        float peso0 = scanner.nextFloat();
        System.out.print("Digite a sua altura:");
        float altura0 = scanner.nextFloat();
        float imc0 = peso0/(altura0*2);
        if (imc0 >=18.5f && imc0 <=25.0f){
            System.out.println(nome0+", o seu IMC é igual "+String.format("%.2f",imc0)+" você está com peso ideal");
        }else if (imc0>=25.01f && imc0<=30.0f){
            System.out.println(nome0+", o seu IMC é igual "+String.format("%.2f", imc0)+" você está com sobrepeso");
        }else if (imc0>=30.01f && imc0<=40.0f){
            System.out.println(nome0+", o seu IMC é igual "+String.format("%.2f",imc0)+" você está obeso(a)");
        }else{
            System.out.println(nome0+", o seu IMC é igual "+String.format("%.2f",imc0)+" você está com obesidade morbida!");
        }



        System.out.println("Vamos fazer uma tabuada!");
        System.out.print("Digite um número:");
        int tabuada = scanner.nextInt();
        for (int i=0; i<=10;i+=1){
            System.out.printf("%d x %d = %d%n",tabuada,i,tabuada*i);
        }


        System.out.println("Vamos sortear um aluno!");
        System.out.print("Digite o nome do primeiro aluno:");
        String aln1 = scanner.nextLine();
        System.out.print("Digite o nome do segundo aluno:");
        String aln2 = scanner.nextLine();
        System.out.print("Digite o nome do terceiro aluno:");
        String aln3 = scanner.nextLine();
        System.out.print("Digite o nome do quarto aluno:");
        String aln4 = scanner.nextLine();
        ArrayList<String> alunos = new ArrayList<>();
        alunos.add(aln1);
        alunos.add(aln2);
        alunos.add(aln3);
        alunos.add(aln4);
        int soteio_alunos = random.nextInt(alunos.size());
        String sortudo = alunos.get(soteio_alunos);
        System.out.printf("O grande sortudo foi: %s%n",sortudo);




        System.out.println("Vamos ver sua categoria!");
        System.out.print("Digite o ano de nascimento:");
        int ano_nasc = scanner.nextInt();
        int ano_atual = LocalDate.now().getYear();
        int idade = ano_atual - ano_nasc;
        if (idade <=9){
            System.out.println("Você tem "+idade+" anos e você está na categoria mirim.");
        } else if (idade >=10 && idade<=14){
            System.out.println("Você tem "+idade+" anos e você está na categoria Infantil.");
        } else if (idade >=15 && idade <=19){
            System.out.println("Você tem "+idade+" anos e você está na categoria Junior.");
        } else if (idade ==20){
            System.out.println("Você tem "+idade+ " anos e você está na categoria Sênior");
        } else if (idade >=21){
            System.out.println("Você tem "+idade+" anos e você está na categoria Master");
        }


        System.out.println("Vamos calcular o seu IMC!");
        System.out.print("Digite o seu nome:");
        String nome = scanner.nextLine();
        System.out.print("Digite o seu peso:");
        float peso = scanner.nextFloat();
        System.out.print("Digite a sua altura:");
        float altura = scanner.nextFloat();
        float imc1 = peso/(altura*2);
        if (imc1 <= 18.5f){
            System.out.println(nome+", seu IMC é igual a " +String.format("%.2f", imc1)+ " e você está abaixo do peso!");
        } else if (imc1 >= 18.6f && imc1 <=25){
            System.out.println(nome+", seu IMC é igual a " +String.format("%.2f", imc1)+ " e você está com peso ideal");
        } else if(imc1 >=25.1f && imc1 <=30){
            System.out.println(nome+ ", seu IMC é igual " +String.format("%.2f", imc1)+ " e você está sobrepeso");
        } else {
            System.out.println(nome+", seu IMC é igual "+imc1+" e vocÊ está com obesidade morbida!");
        }

        //Encontrando o maior e o menor número da lista
        System.out.println("Vamos encontra o maior e o menor número da lista.");
        System.out.print("Digite o primeiro número:");
        int number1 = scanner.nextInt();
        System.out.print("Digite o segundo número:");
        int number2 = scanner.nextInt();
        System.out.print("Digite o terceiro número:");
        int number3 = scanner.nextInt();
        System.out.print("Digite o quarto número:");
        int number4 = scanner.nextInt();
        ArrayList<Integer> maiorEmenor = new ArrayList<>();
        maiorEmenor.add(number1);
        maiorEmenor.add(number2);
        maiorEmenor.add(number3);
        maiorEmenor.add(number4);
        int numeroMaior = Collections.max(maiorEmenor);
        int numeroMenor = Collections.min(maiorEmenor);
        System.out.println("O maior número da lista é: "+numeroMaior+ " e o menor número da lista é: "+numeroMenor);

        //condicional par ou impar
        System.out.print("Digite um número para saber se é par ou impar!:");
        int parouimpar = scanner.nextInt();
        if (parouimpar %2==0){
            System.out.println("Você digitou " +parouimpar+ " que é PAR");
        } else{
            System.out.println("Você digitou " +parouimpar+ " que é IMPAR");
        }


        //sorteio sequencia
        System.out.println("Vamos sortear a sequencia de apresentação");
        System.out.print("Digite o primeiro nome:");
        String nn1 = scanner.nextLine();
        System.out.print("Digite o segundo nome:");
        String nn22 = scanner.nextLine();
        System.out.print("Digite o terceiro nome:");
        String nn3 = scanner.nextLine();
        System.out.print("Digite o quarto nome:");
        String nn4 = scanner.nextLine();
        ArrayList<String> mlista = new ArrayList<>();
        Collections.addAll(mlista, nn1,nn22,nn3,nn4);
        Collections.shuffle(mlista);
        System.out.printf("A sequencia de apresentação ficou:%s%n",mlista);




        // sorteio de uma unica pessoa dentro de uma lista
        System.out.println("Vamos sortear uma pessoa!");
        System.out.print("Digite o nome da primeira pessoa:");
        String pessoa1 = scanner.nextLine();
        System.out.print("Digite o nome da segunda pessoa:");
        String pessoa2 = scanner.nextLine();
        System.out.print("Digite o nome da terceira pessoa:");
        String pessoa3 = scanner.nextLine();
        System.out.print("Digite o nome da quarta pessoa:");
        String pessoa4 = scanner.nextLine();
        ArrayList<String> alista = new ArrayList<>();
        alista.add(pessoa1);
        alista.add(pessoa2);
        alista.add(pessoa3);
        alista.add(pessoa4);
        int sorteando = random.nextInt(alista.size());
        String sorteado = alista.get(sorteando);
        System.out.printf("A pessoa sorteada foi:%s%n",sorteado);






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
        String sorte = lista.get(sorteio);
        System.out.printf("O grande sortudo foi: %s%n",sorte);





        // calcula media notas
        System.out.println("Vamos calcular sua média");
        System.out.print("Digite a primeira nota:");
        float nota1 = scanner.nextFloat();
        System.out.print("Digite a segunda nota:");
        float nota2 = scanner.nextFloat();
        System.out.print("Digite a terceira nota:");
        float nota3 = scanner.nextFloat();
        float median = (nota1+nota3+nota2)/3;
        if (median >=7){
            System.out.println("Sua média foi " +String.format("%.2f",median)+" e você foi aprovado!");
        } else if (median >= 5 && median <=6.9) {
            System.out.println("Sua média foi "+String.format("%.2f", median)+" e você está em recuperação");
        } else{
            System.out.println("Sua média foi "+String.format("%.2f",median)+" e você foi reprovado");
        }



        // Exercicio comparação maior numero
        System.out.print("Digite o primeiro número:");
        int numero1 = scanner.nextInt();
        System.out.print("Digite o segundo número:");
        int numero2 = scanner.nextInt();
        if (numero1 >numero2){
            System.out.println("O maior número é o:"+numero1);
        } else if (numero2 > numero1) {
            System.out.println("O maior número é o:"+numero2);
        } else {
            System.out.println("Deu empeta, não tivemos número maior");
        }

        // Exercicio calculo velocidade
        System.out.println("Vamos calcular a velocidade!");
        System.out.print("Digite a sua velocidade:");
        float velocidade = scanner.nextFloat();
        float faixa1 = velocidade+(velocidade*0.50f);
        float faixa2 = velocidade+(velocidade*0.80f);
        float faixa3 = velocidade+(velocidade*1.50f);
        if (velocidade<=79){
            System.out.println("Parabéns, você respeita os limites de velocidade, não tomará multa!");
        } else if (velocidade >=81 && velocidade <=90){
            System.out.println("Você estava acimado do limite de volocidade, tomará uma multa de R$:"+faixa1);
        } else if (velocidade >=91 && velocidade <=120){
            System.out.println("Você estava acima do limite de velocidade, tomará uma multa de R$:"+faixa2);
        }else {
            System.out.println("Você estava acima do limente de velocidade, tomará uma multa de R$"+String.format("%.2f",faixa3));
        }


        //média nota
        System.out.println("Vamos ver sua média e ver se você passou!");
        System.out.print("Digite a primeira nota:");
        float notas1 = scanner.nextFloat();
        System.out.print("Digite a segunda nota:");
        float notas2 = scanner.nextFloat();
        float media = (notas1+notas2)/2;
        if (media >=7){
            System.out.println("Sua média foi "+media+" e você foi aprovado!!!");
        } else if ( media>=5 && media <= 6.9){
            System.out.println("Sua média foi "+media+" e você esta em recuperação");
        } else {
            System.out.println("A sua média foi "+media+" e você foi reprovado!");
        }


        // comparação numero que tem o maior valor.
        System.out.println("Vamos ver agora qual é o maior valor!");
        System.out.print("Digite o primeiro número:");
        int n1 = scanner.nextInt();
        System.out.print("Digite o segundo número:");
        int n2 = scanner.nextInt();
        if (n1 > n2){
            System.out.println("O maior número é o:"+n1);
        } else if (n2 >n1){
            System.out.print("O maior número é o:"+n2);
        } else{
            System.out.print("EMPATE! o primeiro valor é "+n1+" e o segundo "+n2);
        }
    }
}
