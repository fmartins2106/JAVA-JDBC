package academy.devdojo.maratonajava.introducao;

import java.time.LocalDate;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Locale;


public class Aula6ExercicioOperadoresCondicionais8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();



//        vamos verificar o maior número informado
        System.out.println("Vamos verificar o maior número listado!");
        int numeros = Integer.MIN_VALUE;
        for (int n=0;n<3;n++){
            System.out.print("Digite o "+(n+1)+"º número:");
            int numeroVerificado = scanner.nextInt();
            if (numeroVerificado>numeros){
                numeros = numeroVerificado;
            }
        }
        System.out.println("O maior número da lista é:"+numeros);

//        Total de número pares e a soma dos números pares
        System.out.println("Vamos contar e somar os números pares");
        int somaPar = 0;
        int contPar = 0;
        for (int l=0;l<6;l++){
            System.out.print("Digite o "+(l+1)+"º número:");
            int pares = scanner.nextInt();
            if (pares%2==0){
                somaPar+=pares;
                contPar++;
            }
        }
        System.out.println("O total de número pares é "+contPar+" e a soma dos nçumeros pares é:"+somaPar);

//        vamos contar números pares
        for (int par=0;par<=50;par+=2){
            System.out.println(par);
        }


//        Vamos contar e somar números impares de 0 a 30
        int somaImpar = 0;
        int contImpar = 0;
        for (int impar=1;impar<=30;impar+=2){
            System.out.println(impar);
            contImpar++;
            somaImpar+=impar;

        }
        System.out.println("Tem:"+contImpar+" e a soma deles é:"+somaImpar);





// vamos calcular a tabuada
        System.out.println("Vamos calcular a tabuada");
        System.out.print("Digite um número:");
        int tabuada = scanner.nextInt();
        for (int t=0;t<=10;t++){
            System.out.printf("%d x %d = %d%n",tabuada,t,tabuada*t);
        }



//        calcular 6 notas, elimiar maior e menor e fazer media
        System.out.println("Vamos fazer calculo da média das notas dos Juizes");
        ArrayList<Float> listaNotasJuizes = new ArrayList<>();
        for (int nj=0;nj<6;nj++){
            System.out.print("Digite a "+(nj+1)+"º nota:");
            float notasJuiz = scanner.nextFloat();
            listaNotasJuizes.add(notasJuiz);
        }
        float MaiorNota = Collections.max(listaNotasJuizes);
        float MenorNota = Collections.min(listaNotasJuizes);
        listaNotasJuizes.remove(MaiorNota);
        listaNotasJuizes.remove(MenorNota);
        float soma = 0;
        for (float notasJuiz : listaNotasJuizes){
            soma+=notasJuiz;
        }
        float media = soma/ listaNotasJuizes.size();
        System.out.println("A sua média final é:"+String.format("%.2f",media));

//        Vamos sortear um número:
        System.out.println("Vamos sortear um número!");
        ArrayList<Integer> nLista = new ArrayList<>();
        System.out.print("Quantos números terá o sorteio?:");
        int numerosSorteio = scanner.nextInt();
        for (int j=0;j<numerosSorteio;j++){
            System.out.print("Informe o "+(j+1)+"º número:");
            int numerosInformados = scanner.nextInt();
            nLista.add(numerosInformados);
        }
        int sortearNumeros = random.nextInt(nLista.size());
        int numeroDaSorte = nLista.get(sortearNumeros);
        System.out.println("O número sorteado foi:"+numeroDaSorte);

//        sortear a sequencia de apresentação
        ArrayList<String> sorteioApresentacao = new ArrayList<>();
        System.out.println("Vamos sortear a sequência de apresentação!");
        for (int p=0;p<6;p++){
            System.out.print("Digite o "+(p+1)+"º nome da lista:");
            String nomes = scanner.nextLine();
            sorteioApresentacao.add(nomes);
        }
        Collections.shuffle(sorteioApresentacao);
        System.out.println("A sequência de apresentação ficou:"+sorteioApresentacao);



//        vamos sortear um pessoa
        ArrayList<String> listaNomes = new ArrayList<>();
        System.out.println("Vamos sortear uma pessoa:");
        for (int s=0;s<6;s++){
            System.out.print("Digite o "+(s+1)+"º nome:");
            String nome = scanner.nextLine();
            listaNomes.add(nome);
        }
        int Sorteio = random.nextInt(listaNomes.size());
        String sorteioUmNome = listaNomes.get(Sorteio);
        System.out.println("O grande sortudo foi:"+sorteioUmNome);



//vamos verificar quem é de maior e de menor de idade
        System.out.println("Cadastrar pessoas e verificar quem é de maior e de menor de idade");
        System.out.print("Quantas datas você quer cadastrar?:");
        int pessoaMaiorDeIdade = 0;
        int pessoaMenorDeIdade = 0;
        int pessoas = scanner.nextInt();
        for (int i=0;i<pessoas;i++){
            System.out.print("Digite a "+(i+1)+"º data de nascimento:");
            int dataDeNascimento = scanner.nextInt();
            int anoAtual = LocalDate.now().getYear();
            int idade = anoAtual-dataDeNascimento;
            if (idade>=18){
                pessoaMaiorDeIdade++;
            }else {
                pessoaMenorDeIdade++;
            }
        }
        System.out.println("Foram cadastradas: "+pessoaMaiorDeIdade+" pessoa(s) maior(es) de idade.");
        System.out.println("Foram cadastradas: "+pessoaMenorDeIdade+" pessoa(s) menor(es) de idade");
    }
}
