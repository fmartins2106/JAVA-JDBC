package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio;

import java.util.Scanner;

public class Aluno04 {
    private String nome;
    private double nota1;
    private double nota2;
    private double media;
    private String situacao;

    public Aluno04(String nome, double nota1, double nota2){
        setNome(nome);
        setNota1(nota1);
        setNota2(nota2);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            throw new IllegalArgumentException("Campo nome não pode ser vazio. Digite o nome completo, tente novamente.");
        }
        this.nome = formatandoNome(nome);
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        validarNotas(nota1);
        this.nota1 = nota1;
        calculandoMedia();
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        validarNotas(nota2);
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

    public void setSituacao(String sitiacao) {
        this.situacao = situacao;
    }

    private static final double MAXNOTA =10;
    private static final double MINNOTA =0;

    private static void validarNotas(double nota){
        if (nota < MINNOTA || nota > MAXNOTA){
            throw new IllegalArgumentException("ERRO. Nota precisa ser maior que zero e menor que 10.");
        }
    }
    public void calculandoMedia(){
        this.media = (nota1+nota2)/2;
        situacaoAluno();
    }

    public void situacaoAluno(){
        if (media>=7){
            this.situacao = "APROVADO(A).";
        } else if (media>=5 && media <=6.9) {
            this.situacao = "EM RECUPERAÇÃO.";
        }else {
            this.situacao = "REPROVADO(A).";
        }
    }

    private static String formatandoNome(String nome){
        String[] palavras = nome.toLowerCase().split("\\s+");
        StringBuilder nomeFormatado = new StringBuilder();
        for (String palavra : palavras){
            nomeFormatado.append(palavra.substring(0,1).toUpperCase()).append(palavra.substring(1)).append(" ");
        }
        return nomeFormatado.toString().trim();
    }

    public static String verificandoNome(Scanner scanner){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (nome.isEmpty()){
                System.out.println("Campo nome não pode ser vazio. Tente novamente.");
            }else {
                if (!nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
                    System.out.println("ERRO. Campo nome precisa ser preenchido com nome completo. Tente novamente.");
                }else {
                    return formatandoNome(nome);
                }
            }
        }
    }
    public static double verificandoNota1(Scanner scanner){
        while (true){
            try {
                System.out.print("Primeira nota:");
                double nota1 = Double.parseDouble(scanner.nextLine());
                if (nota1<0 || nota1>10){
                    System.out.println("Nota deve ser maior que 0 e menor que 10.");
                }else {
                    return nota1;
                }
            }catch (NumberFormatException e){
                System.out.println("ERRO:"+e.getMessage());
            }
        }
    }
    public static double verificandoNota2(Scanner scanner){
        while (true){
            try {
                System.out.print("Segunda nota:");
                double nota2 = Double.parseDouble(scanner.nextLine());
                if (nota2<0 || nota2>10){
                    System.out.println("Nota deve ser maior que 0 e menor que 10.");
                }else {
                    return nota2;
                }
            }catch (NumberFormatException e){
                System.out.println("ERRO:"+e.getMessage());
            }

        }
    }

    public void exibindoResultadoAlunos(int index, int aluno04s){
        if (index==0){
            for (int n = 0; n < 60; n++) {
                System.out.print("=");
            }
            System.out.println();
            System.out.printf("%-4s %-25s %-8s %-12s\n","No","Nome","Média","Situação");
            for (int n = 0; n < 60; n++) {
                System.out.print("=");
            }
            System.out.println();
        }
        System.out.printf("%-4d %-25s %-8.2f %-12s\n",index,getNome(),getMedia(),getSituacao());
        if (index==aluno04s-1){
            for (int n = 0; n < 60; n++) {
                System.out.print("=");
            }
            System.out.println();
        }
    }

    public void exibindoNotasAluno(){
        System.out.println("As notas de "+getNome()+" foram: "+getNota1()+ " e "+getNota2());
    }
}
