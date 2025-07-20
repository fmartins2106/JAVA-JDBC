package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio;

import java.util.Scanner;

public class Aluno07 {
    private String nome;
    private double nota1;
    private double nota2;
    private double media;
    private String situacao;

    public Aluno07(String nome,double nota1, double nota2){
        setNome(nome);
        setNota1(nota1);
        setNota2(nota2);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome==null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            throw new IllegalArgumentException("ERRO. Nome não pode ser nulo, vazio, conter caracteres o nome incompleto.");
        }
        this.nome = formatoNome(nome);
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        validandoNotas(nota2);
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

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    private static String formatoNome(String nome){
        String[] palavras = nome.toLowerCase().split("\\s+");
        StringBuilder nomeFormatado = new StringBuilder();
        for (String palavra : palavras){
            nomeFormatado.append(palavra.substring(0,1).toUpperCase()).append(palavra.substring(1)).append(" ");
        }
        return nomeFormatado.toString().trim();
    }

    private static final double MAXNOTA = 10;
    private static final double MINNOTA = 0;

    private static void validandoNotas(double nota){
        if (nota < MINNOTA || nota > MAXNOTA){
            throw new IllegalArgumentException("ERRO. Nota não pode ser menor que zero e maior que dez. Tente novamente.");
        }
    }
    private void calculandoMedia(){
        this.media = (nota1+nota2)/2;
        situacaoAluno();

    }

    private void situacaoAluno(){
        if (media>=7){
            this.situacao = "Aprovado(a).";
        } else if (media>=5 && media<=6.9) {
            this.situacao = "Em recuperação.";
        }else {
            this.situacao = "Reprovado(a).";
        }
    }
    public static String verificandoNome(Scanner scanner){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
                System.out.println("Nome não pode ser vazio, conter caracteres ou somente o primeiro nome. Tente novamente.");
            }else {
                return formatoNome(nome);
            }
        }
    }
    public static double verificandoNota1(Scanner scanner){
        while (true){
            try {
                System.out.print("Digite a primeira nota:");
                double nota1 = Double.parseDouble(scanner.nextLine());
                if (nota1 <0 || nota1 >10){
                    System.out.println("Digite uma nota entre 0 e 10 para validar.");
                }else {
                    return nota1;
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido. Tente novamente.");
            }
        }
    }
    public static double verificandoNota2(Scanner scanner){
        while (true){
            try {
                System.out.print("Digite a segunda nota:");
                double nota2 = Double.parseDouble(scanner.nextLine());
                if (nota2<0 || nota2>10){
                    System.out.println("Digite uma nota entre 0 e 10 para validar.");
                }else {
                    return nota2;
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido. Tente novamente.");
            }
        }
    }

    public void resultadoTabelaMedia(int index, int aluno07s){
        if (index==0){
            for (int i = 0; i < 60; i++) {
                System.out.print("=");
            }
            System.out.println();
            System.out.printf("%-4s %-25s %-8s %-15s\n","No","Nome","Média","");
            for (int i = 0; i < 60; i++) {
                System.out.print("=");
            }
            System.out.println();
        }
        System.out.printf("%-4d %-25s %-8.2f %-15s\n",index,getNome(),getMedia(),getSituacao());
        if (index==aluno07s-1){
            for (int i = 0; i < 60; i++) {
                System.out.print("=");
            }
            System.out.println();
        }
    }

    public void mostrarNotasAluno(int index){
        for (int i = 0; i < 80; i++) {
            System.out.print("=");
        }
        System.out.println();
        System.out.println("As notas de "+getNome()+" foram:" +getNota1()+" e "+getNota2());
        for (int i = 0; i < 80; i++) {
            System.out.print("=");
        }
        System.out.println();
    }

}
