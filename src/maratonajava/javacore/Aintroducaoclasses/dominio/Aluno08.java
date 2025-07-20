package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio;

import java.util.Scanner;

public class Aluno08 {
    private String nome;
    private double nota1;
    private double nota2;
    private double media;
    private String situacao;

    public Aluno08(String nome, double nota1, double nota2){
        setNome(nome);
        setNota1(nota1);
        setNota2(nota2);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome==null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            throw new IllegalArgumentException("Campo nome não pode ser vazio ou conter caracteres.");
        }
        this.nome = formatoNome(nome);
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        validandandoNotas(nota1);
        this.nota1 = nota1;
        calculandoMedia();
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        validandandoNotas(nota2);
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

    private void validandoSituacao(){
        if (media>=7){
            this.situacao = "APROVADO(A)";
        } else if (media>=5 && media<=6.9) {
            this.situacao = "EM RECUPERAÇÃO";
        }else {
            this.situacao = "REPROVADO(A)";
        }
    }

    private void calculandoMedia(){
        this.media = (nota1+nota2)/2;
        validandoSituacao();
    }

    private static final double MAX_NOTA =10;
    private static final double MIN_NOTA=0;
    private void validandandoNotas(double nota){
        if (nota < MIN_NOTA || nota > MAX_NOTA){
            throw new IndexOutOfBoundsException("Nota precisa estar entre 0 e 10.");
        }
    }

    private static String formatoNome(String nome){
        String[] palavras = nome.toLowerCase().split("\\s+");
        StringBuilder nomeFormatado = new StringBuilder();
        for (String palavra : palavras){
            nomeFormatado.append(palavra.substring(0,1).toUpperCase())
                    .append(palavra.substring(1)).
                    append(" ");
        }
        return nomeFormatado.toString().trim();
    }
    public static String validandoNome(Scanner scanner){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
                System.out.println("Campo nome não pode ser vazio ou conter caracteres. Digite seu nome completo.");
            }else {
                return formatoNome(nome);
            }
        }
    }
    public static double validandoNota1(Scanner scanner){
        while (true){
            try {
                System.out.print("Digite a primeira nota:");
                double nota1 = Double.parseDouble(scanner.nextLine());
                if (nota1<0 || nota1>10){
                    System.out.println("Digite uma nota válida entre 0 e 10.");
                }else {
                    return nota1;
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }
    public static double validandoNota2(Scanner scanner){
        while (true){
            try {
                System.out.print("Digite a segunda nota:");
                double nota2 = Double.parseDouble(scanner.nextLine());
                if (nota2 < 0 || nota2 > 10){
                    System.out.println("Digite uma nota válida entre 0 e 10.");
                }else {
                    return nota2;
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma nota válida.");
            }
        }
    }
    public void exbindoRelatorioAlunos(int index, int aluno08s){
        if (index ==0){
            for (int i = 0; i < 60; i++) {
                System.out.print("=");
            }
            System.out.println();
            System.out.printf("%-4s %-25s %-8s %-15s\n","No","Nome","Média","Situação");
            for (int i = 0; i < 60; i++) {
                System.out.print("=");
            }
            System.out.println();
        }
        System.out.printf("%-4d %-25s %-8.2f %-15s\n",index,getNome(),getMedia(),getSituacao());
        if (index==aluno08s-1){
            for (int i = 0; i < 60; i++) {
                System.out.print("=");
            }
            System.out.println();
        }
    }
    public void exibindoNotasAluno(int index){
        for (int i = 0; i < 80; i++) {
            System.out.print("");
        }
        System.out.println();
        System.out.println("As notas de "+getNome()+" foram:"+getNota1()+" e "+getNota2());
        for (int i = 0; i < 80; i++) {
            System.out.print("=");
        }
        System.out.println();
    }

}
