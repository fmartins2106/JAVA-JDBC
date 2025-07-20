package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Imc01 {
    private String nome;
    private double peso;
    private double altura;
    private double imc;

    public Imc01(String nome, double peso, double altura){
        setNome(nome);
        setPeso(peso);
        setAltura(altura);
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            throw new IllegalArgumentException("ERRO. Campo nome não pode ser vazio. Digite o seu nome completo.");
        }
        this.nome = nome;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        if (peso<0 || peso>200){
            throw new IllegalArgumentException("ERRO. Digite um peso válido.");
        }
        this.peso = peso;
        calculandoIMC();
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        if (altura<0 || altura>2.50){
            throw new IllegalArgumentException("ERRO. Digite uma altura válida.");
        }
        this.altura = altura;
        calculandoIMC();
    }

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }

    public void calculandoIMC(){
        this.imc = peso/(altura*2);
    }

    private static String formatandoNome(String nome){
        String[] palavras = nome.toLowerCase().split("\\s+");
        StringBuilder nomeFormatado = new StringBuilder();
        for (String palavra : palavras){
            nomeFormatado.append(palavra.substring(0,1).toUpperCase()).append(palavra.substring(1)).append(" ");
        }
        return nomeFormatado.toString().trim();
    }

    public static String validandoNome(Scanner scanner){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (nome.isEmpty()){
                System.out.println("Nome não pode ser vazio, tente novamente.");
            }else {
                if (!nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
                    System.out.println("ERRO. Digite seu nome completo sem adição de caracteres.");
                }else {
                    return formatandoNome(nome);
                }
            }
        }
    }
    public static double validandoPeso(Scanner scanner){
        while (true){
            try {
                System.out.print("Peso:");
                double peso = Double.parseDouble(scanner.nextLine());
                if (peso< 0 || peso >200){
                    System.out.println("Erro. Digite um peso válido. Tente novamente.");
                }else {
                    return peso;
                }
            }catch (NumberFormatException e){
                System.out.println("ERRO:"+e.getMessage());
            }
        }
    }
    public static double validandoAltura(Scanner scanner){
        while (true){
            try {
                System.out.print("Altura:");
                double altura = Double.parseDouble(scanner.nextLine());
                if (altura<0 || altura>2.50){
                    System.out.println("ERRO. Digite uma altura válida. Tente novamente.");
                }else {
                    return altura;
                }
            }catch (NumberFormatException e){
                System.out.println("ERR:"+e.getMessage());
            }
        }
    }

    public void exibindoResultados(int index, int imc01s){
        if (index ==0){
            for (int n = 0; n < 65; n++) {
                System.out.print("=");
            }
            System.out.println();
            System.out.printf("%-4s %-25s %-8s %-8s %-12s\n","No","Nome","Peso","Altura","IMC");
        }
        System.out.printf("%-4d %-25s %-2.2fKg. %-2.2fm. %-12.2f\n",index,getNome(),getPeso(),getAltura(),getImc());
        if (index==imc01s-1){
            for (int n = 0; n < 65; n++) {
                System.out.print("=");
            }
            System.out.println();
        }
    }

    public void avaliacaoIMC(){
        if (imc<=20){
            System.out.println(getNome()+", seu IMC é: "+String.format("%.2f",getImc())+" | Está abaixo do normal, procure um médico.");
        }else if (imc>=21 && imc<=25){
            System.out.println(getNome()+", seu IMC é: "+String.format("%.2f",getImc())+" | Você está no peso ideal. Parabéns!!!");
        }else {
            System.out.println(getNome()+", seu IMC  é: "+String.format("%.2f",getImc())+" | Seu IMC está muito alto. Procure um médico.");
        }
    }
}
