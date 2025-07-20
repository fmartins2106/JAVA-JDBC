package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio;

import java.util.Scanner;

public class Aluno03 {
    private String nome;
    private double nota1;
    private double nota2;
    private double media;
    private String situacao;

    public Aluno03(String nome, double nota1, double nota2){
        setNome(nome);
        setNota1(nota1);
        setNota2(nota2);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome== null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            throw new IllegalArgumentException("ERRO. Campo nome não pode ser vazio ou incompleto. Digite o nome completo.");
        }
        this.nome = formatoNome(nome);
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        validarNotas(nota1);
        this.nota1 = nota1;
        calcularMedia();
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        validarNotas(nota2);
        this.nota2 = nota2;
        calcularMedia();
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
        if (situacao == null || situacao.isEmpty()){
            throw new IllegalArgumentException("ERRO. Verifique notas e média.");
        }
    }

    public static String validandoNomeAluno(Scanner scanner){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (nome.isEmpty()){
                System.out.println("Campo nome não pode ficar vazio.");
            }else {
                if (!nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
                    System.out.println("ERRO.Campo pode ter caracteres ou somente o primeiro nome. Digite o nome completo.");
                }else {
                    return nome;
                }
            }
        }
    }
    public static double validandoNota1(Scanner scanner){
        while (true){
            try {
                System.out.print("Digite a primeira nota:");
                double nota1 = Double.parseDouble(scanner.nextLine());
                if (nota1<0 || nota1>10){
                    System.out.println("ERRO, nota deve ser entre 0 e 10. Tente novamente.");
                }else {
                    return nota1;
                }
            }catch (NumberFormatException erro){
                System.out.println("Erro:"+erro.getMessage());
            }
        }
    }
    public static double validandoNota2(Scanner scanner){
        while (true){
            try {
                System.out.print("Digite a segunda nota:");
                double nota2 = Double.parseDouble(scanner.nextLine());
                if (nota2<0 || nota2>10){
                    System.out.println("ERRO, nota deve ser entre 0 e 10. Tente novamente.");
                } else {
                    return nota2;
                }
            }catch (NumberFormatException erro){
                System.out.println("Erro:"+erro.getMessage());
            }
        }
    }

    public void resultadoAlunos03(int index, int aluno03s){
        if (index==0){
            for (int n = 0; n < 55; n++) {
                System.out.print("=");
            }
            System.out.println();
            System.out.printf("%-4s %-25s %-8s %-10s\n","No","Nome","Média","Situação");
            for (int n = 0; n < 55; n++) {
                System.out.print("=");
            }
            System.out.println();
        }
        System.out.printf("%-4d %-25s %-8.2f %-10s\n",index,getNome(),getMedia(),getSituacao());
        if (index == aluno03s-1){
            for (int n = 0; n < 55; n++) {
                System.out.print("=");
            }
            System.out.println();
        }
    }
    public void verNotasAluno(int matricula){
        System.out.println("As notas de "+getNome()+" foram: "+getNota1()+" e "+getNota2());
        for (int i = 0; i < 80; i++) {
            System.out.print("=");
        }
        System.out.println();
    }

    private void situacaoAluno(){
        if (getMedia() >=7){
            this.situacao = "APROVADO(A).";
        } else if (getMedia()>=5 && getMedia()<=6.9) {
            this.situacao = "EM RECUPERAÇÃO.";
        }else {
            this.situacao = "REPROVADO(A).";
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

    public void calcularMedia(){
        this.media = (nota1+nota2)/2;
        situacaoAluno();
    }

    private static final double MAX_NOTA=10;
    private static final double MIN_NOTA=0;

    private static void validarNotas(double nota){
        if (nota < MIN_NOTA || nota > MAX_NOTA){
            throw new IllegalArgumentException("A nota deve ser entre 0 e 10.");
        }
    }

}
