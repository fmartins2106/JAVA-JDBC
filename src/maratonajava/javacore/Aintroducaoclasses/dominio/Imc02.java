package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio;


import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test.ImcTest02;

import java.util.Scanner;

public class Imc02 {
    private String nome;
    private double peso;
    private  double altura;
    private double imc;

    public Imc02(String nome, double peso, double altura){
        setNome(nome);
        setPeso(peso);
        setAltura(altura);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            throw new IllegalArgumentException("ERRO. Nome não pode ser vazio ou ter nome incompleto.");
        }
        this.nome = formatoNome(nome);
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        if (peso<0 || peso>200){
            throw new IllegalArgumentException("ERRO. Peso não pode ser menor que zero e maior que 200. Tente novamente.");
        }
        this.peso = peso;
        calculandoImc();
    }

    public double getAltura() {
        return altura;
    }


    public void setAltura(double altura) {
        if (altura<0 || altura >2.50){
            throw new IllegalArgumentException("ERRO. Altura não pode ser menor que 0 e maior que 2.50. Tente novamente.");
        }
        this.altura = altura;
        calculandoImc();
    }

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }

    private void calculandoImc(){
        this.imc = peso/(altura*altura);
    }

    private static String formatoNome(String nome){
        String[] palavras = nome.toLowerCase().split("\\s+");
        StringBuilder formatandoNome = new StringBuilder();
        for (String palavra : palavras){
            formatandoNome.append(palavra.substring(0,1).toUpperCase()).append(palavra.substring(1)).append(" ");
        }
        return formatandoNome.toString().trim();
    }

    public static String validandoNome(Scanner scanner){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (nome.isEmpty()){
                System.out.println("ERRO. Campo nome não pode ser vazio. Tente novamente.");
            }else {
                if (!nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
                    System.out.println("ERRO. Digite seu nome completo. Tente novamente.");
                }else {
                    return formatoNome(nome);
                }
            }
        }
    }
    public static double validandoPeso(Scanner scanner){
        while (true){
            try {
                System.out.print("Digite o peso:");
                double peso = Double.parseDouble(scanner.nextLine());
                if (peso<0 || peso > 200){
                    System.out.println("Peso não pode ser menor que 0 e maior que 200. Tente novamente.");
                }else {
                    return peso;
                }
            }catch (NumberFormatException erro){
                System.out.println("ERRO. Digite um número válido, tente novamente.");
            }
        }
    }
    public static double validandoAltura(Scanner scanner){
        while (true){
            try {
                System.out.print("Digite sua altura:");
                double altura = Double.parseDouble(scanner.nextLine());
                if (altura<0 || altura>2.50){
                    System.out.println("Altura não pode ser menor que zero ou maior que 2.50m");
                }else {
                    return altura;
                }
            }catch (NumberFormatException erro){
                System.out.println("Digite um valor válido. Tente novamente.");
            }
        }
    }

    public void relatorioPessoasCadastradas(int index, int imc02s){
        if (index==0){
            for (int n = 0; n < 65; n++) {
                System.out.print("=");
            }
            System.out.println();
            System.out.printf("%-4s %-25s %-8s %-8s %-8s\n","No","Nome","Peso","Altura","IMC");
        }
        System.out.printf("%-4d %-25s %-8.2f %-8.2f %-8.2f\n",index,getNome(),getPeso(),getAltura(),getImc());
        if (index== imc02s-1){
            for (int n = 0; n < 65; n++) {
                System.out.print("=");
            }
            System.out.println();
        }
    }
    public void exibindoAvaliacaoImc(){
        for (int i = 0; i < 80; i++) {
            System.out.print("=");
        }
        System.out.println();
        if (imc <= 20){
            System.out.println(getNome()+", seu IMC foi: "+getImc()+" | Está abaixo do recomendado. Você precisa procurar uma nutricionista para melhorar sua dieta.");
        }else if (imc >= 21 && imc<=25){
            System.out.println(getNome()+", seu IMC foi: "+getImc()+" | Você está com peso Ideal, parabéns!!!");
        }else if (imc >=26 && imc<=30){
            System.out.println(getNome()+", seu IMC foi: "+getImc()+" | Seu IMC está um pouco acima do recomendado. Procure um médico.");
        }else {
            System.out.println(getNome()+", seu IMC foi:"+getImc()+" | Você está com obesidade morbida. Procure um médico urgente!!!");
        }
    }
}
