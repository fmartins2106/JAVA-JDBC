package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio;

import java.util.Scanner;

public class Aluno06 {
    private String nome;
    private double nota1;
    private  double nota2;
    private double media;
    private String situacao;

    public Aluno06(String nome, double nota1, double nota2){
        setNome(nome);
        setNota1(nota1);
        setNota2(nota2);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            throw new IllegalArgumentException("ERRO. Campo não pode ficar vazio ou ter somente o primeiro nome. Tente novamente.");
        }
        this.nome = formatoNome(nome);
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        validandoNotas(nota1);
        this.nota1 = nota1;
        calculandoMedia();
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        validandoNotas(nota2);
        this.nota2 = nota2;
        calculandoMedia();
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    private void validandoSituacao(){
        if (this.media>=7){
            this.situacao = "APROVADO(A)";
        } else if (this.media >=5 && this.media<=6.9) {
            this.situacao = "EM RECUPERAÇÃO";
        }else {
            this.situacao = "REPROVADO(A)";
        }
    }

    private void calculandoMedia(){
        this.media = (nota1+nota2)/2;
        validandoSituacao();
    }

    private static final double MAX_NOTA = 10;
    private static final double MIN_NOTOA = 0;

    private static void validandoNotas(double nota){
        if (nota < MIN_NOTOA || nota > MAX_NOTA){
            throw new IllegalArgumentException("Nota deve ser maior ou igual a 0 e menor igual a 10. Tente novamente.");
        }
    }

    private static String formatoNome(String nome){
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
                System.out.println("Campo nome não pode ficar vazio. Tente novamente.");
            }else {
                if (!nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
                    System.out.println("Digite o nome completo sem caracteres. Tente novamente.");
                }else {
                    return formatoNome(nome);
                }
            }
        }
    }
    public static double validandoNota1(Scanner scanner){
        while (true){
            try {
                System.out.print("Digita a primeira nota:");
                double nota1 = Double.parseDouble(scanner.nextLine());
                if (nota1<0 || nota1>10){
                    System.out.println("Nota precisa ter valor entre 0 e 10. Tente novamente.");
                }else {
                    return nota1;
                }
            }catch (NumberFormatException erro){
                System.out.println("Erro. Digite um valor válido.");
            }
        }
    }
    public static double validandoNota2(Scanner scanner){
        while (true){
            try {
                System.out.print("Digite a segunda nota:");
                double nota2 = Double.parseDouble(scanner.nextLine());
                if (nota2<0 || nota2>10){
                    System.out.println("Nota precisa ter valor entre 0 e 10. Tente novamente.");
                }else {
                    return nota2;
                }
            }catch (NumberFormatException erro){
                System.out.println("Erro. Digite um valor válido.");
            }
        }
    }
    public void exibindoResultados(int index, int aluno06s){
        if (index==0){
            for (int n = 0; n < 65; n++) {
                System.out.print("=");
            }
            System.out.println();
            System.out.printf("%-4s %-25s %-8s %-10s\n","No","Nome","Média","Situação");
            for (int n = 0; n < 65; n++) {
                System.out.print("=");
            }
            System.out.println();
        }
        System.out.printf("%-4d %-25s %-8.2f %-10s\n",index,getNome(),getMedia(),getSituacao());
        if (index==aluno06s-1){
            for (int n = 0; n < 65; n++) {
                System.out.print("=");
            }
            System.out.println();
        }
    }

    public void monstrandoNotasAluno(){
        for (int n = 0; n < 80; n++) {
            System.out.print("=");
        }
        System.out.println();
        System.out.println("As notas de "+getNome()+" Foram: "+getNota1()+" e "+getNota2());
        for (int n = 0; n < 80; n++) {
            System.out.print("=");
        }
        System.out.println();
    }
}
