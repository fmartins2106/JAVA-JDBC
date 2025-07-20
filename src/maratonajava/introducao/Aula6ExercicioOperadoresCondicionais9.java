package academy.devdojo.maratonajava.introducao;

import java.util.Scanner;

public class Aula6ExercicioOperadoresCondicionais9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        vamos verificar um produto, valores e outros dados
        double barato = Double.POSITIVE_INFINITY;
        double total = 0;
        int mais = 0;
        String maisBarato = "";
        while (true){
            System.out.print("Digite o nome do produto:");
            String nomeProduto = scanner.nextLine();
            System.out.print("Digite o valor do produto:");
            double valorProduto = scanner.nextDouble();
            if (valorProduto!=0){
                total+=valorProduto;
            }
            if (valorProduto>=1000.00f){
                mais++;
            }
            if (valorProduto<barato){
                barato = valorProduto;
                maisBarato = nomeProduto;
            }
            scanner.nextLine();
            System.out.print("Quer continuar ?[S/N]:");
            String novo = scanner.nextLine().trim().toLowerCase();
            while (!novo.equals("s") && !novo.equals("n")){
                System.out.print("Resposta inválida. Quer continuar?[S/N]:");
                novo = scanner.nextLine();
            }
            if (novo.equals("n")){
                System.out.printf("O total de compras foi:R$%.2f%n", total);
                System.out.printf("Temos %d produtos custando mais de R$1000.00%n", mais);
                System.out.printf("O produto mais barato foi:%s com valor de R$%.2f%n",nomeProduto,barato);
                break;
            }
        }






        int maiorValor = Integer.MIN_VALUE, menorValor = Integer.MAX_VALUE, somaValor = 0, quantValor = 0;
        String resposta = "s";
        while (resposta.equalsIgnoreCase("s")){
            System.out.print("Digite um valor:");
            int valorDigitado = scanner.nextInt();
            somaValor+=valorDigitado;
            quantValor++;
            if (valorDigitado>maiorValor){
                maiorValor = valorDigitado;
            }if (valorDigitado< menorValor){
                menorValor = valorDigitado;
            }
            System.out.print("Quer continuar?[s/n]:");
            resposta = scanner.next();
        }
        if (quantValor>0){
            float mediaValor = somaValor/quantValor;
            System.out.println("A quantidade é:"+quantValor+" e a média:"+mediaValor);
            System.out.println("O maior:"+maiorValor+" e o menor:"+menorValor);
        }else {
            System.out.println("Não foi informado nenhum valor!");
        }


        int contValor = 0;
        int somaValor1 = 0;
        while (true){
            System.out.print("Digite um número(999 para parar):");
            int valorInformado = scanner.nextInt();
            if (valorInformado !=999){
                contValor++;
                somaValor1+=valorInformado;
            }else {
                break;
            }
        }
        System.out.println("Ao todo você digitou:"+contValor);
        System.out.println("A soma dos números digitados:"+somaValor1);

        int maior = Integer.MIN_VALUE, menor = Integer.MAX_VALUE, quant = 0, soma = 0;
        String resp = "s";
        while (resp.equalsIgnoreCase("s")){
            System.out.print("Digite um número:");
            int valor = scanner.nextInt();
            soma+=valor;
            quant++;
            if (valor > maior){
                maior = valor;
            }if (valor < menor){
                menor = valor;
            }
            System.out.print("Quer continuar?[S/N]:");
            resp = scanner.next();
        }
        if (quant>0){
            float media = soma/quant;
            System.out.println("A quantidade é:"+quant+" e a média "+media);
            System.out.println("O maior:"+maior+" o menor:"+menor);
        }else {
            System.out.println("Não foram digitado valores.");
        }

        int somaNumero = 0;
        int contNumero = 0;
        while (true){
            System.out.print("Digite um número(999 para parar):");
            int numeros = scanner.nextInt();
            if (numeros !=999){
                somaNumero+=numeros;
                contNumero++;
            }else {
                break;
            }
        }
        System.out.println("Ao todo, você digitou "+contNumero+" números.");
        System.out.println("A soma dos número digitados:"+somaNumero);

        int d = 0, s = 0;
        while (d !=999 ){
            System.out.print("Digite um número:");
            d = scanner.nextInt();
            s+=d;
        }
        System.out.println("A soma vale:"+s);


        int cont = 0;
        while (cont<3){
            System.out.print("Digite um número:");
            int n = scanner.nextInt();
            cont++;
        }
        System.out.println("você digitou:"+cont);


        int maior1 = Integer.MIN_VALUE, menor1 = Integer.MAX_VALUE, quant1 = 0, soma1 = 0;
        String resp1 = "s";
        while (resp1.equalsIgnoreCase("s")){
            System.out.print("Digite um número:");
            int numero = scanner.nextInt();
            soma1+=numero;
            quant1++;
            if (numero > maior1){
                maior1 = numero;
            }if (numero< menor1){
                menor1 = numero;
            }
            System.out.print("Quer continuar?[S/N]:");
            resp1 = scanner.next();
        }
        if (quant1>0){
            float media = soma/quant1;
            System.out.println("Você digitou "+quant1+" números e a média foi:"+media);
            System.out.println("O maior número foi:"+maior1+" e o menor número foi:"+menor1);
        }else {
            System.out.println("Não foram digitados números!");
        }
        scanner.close();
    }
}
