package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio;



import java.util.Scanner;

public class Aluno05 {
    private String nome;
    private double nota1;
    private double nota2;
    private double media;
    private String situacao;

    public Aluno05(String nome,double nota1, double nota2 ){
        setNome(nome);
        setNota1(nota1);
        setNota2(nota2);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( \\p{L}+)+$")){
            throw new IllegalArgumentException("Campo nome não pode ser vazio, Digite nome completo. Tente novamente.");
        }
        this.nome = formatandoNome(nome);
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        validandoNotas(nota1);
        this.nota1 = nota1;
        validandoMedia();
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        validandoNotas(nota2);
        this.nota2 = nota2;
        validandoMedia();
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

    private static final double NOTA_MAX = 10;
    private static final double NOTA_MIN = 0;
    private static void validandoNotas(double nota){
        if (nota < NOTA_MIN || nota > NOTA_MAX){
            throw new IllegalArgumentException("Nota precisa estar entre 0 e 10. Tente novamente.");
        }
    }
    private void validandoMedia(){
        this.media = (nota1+nota2)/2;
        validandoSituacao();
    }
    private static String formatandoNome(String nome){
        String[] palavras = nome.toLowerCase().split("\\s+");
        StringBuilder nomeFormatado = new StringBuilder();
        for (String palavra : palavras){
            nomeFormatado.append(palavra.substring(0,1).toUpperCase()).append(palavra.substring(1)).append(" ");
        }
        return nomeFormatado.toString().trim();
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

    public static String validandoNome(Scanner scanner){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (nome.isEmpty()){
                System.out.println("Campo nome não pode ficar vazio.");
            }else {
                if (!nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
                    System.out.println("Digite o nome completo. Tente novamente.");
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
                if (nota1<0 || nota1 >10){
                    System.out.println("Nota precisar ser entre 0 e 10. Tente novamente.");
                }else {
                    return nota1;
                }
            }catch (NumberFormatException e){
                System.out.println("ERRO:"+e.getMessage());
            }
        }
    }
    public static double validandoNota2(Scanner scanner){
        while (true){
            try {
                System.out.print("Digite a segunda nota:");
                double nota2 = Double.parseDouble(scanner.nextLine());
                if (nota2<0 || nota2>10){
                    System.out.println("Nota precisa ser entre 0 e 10. Tente novamente.");
                }else {
                    return nota2;
                }
            }catch (NumberFormatException e){
                System.out.println("ERRO:"+e.getMessage());
            }
        }
    }
    public void exibindoTabelaResultados(int index, int aluno05s){
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
        if (index == aluno05s-1){
            for (int n = 0; n < 65; n++) {
                System.out.print("=");
            }
            System.out.println();
        }
    }
    public void exibindoNotas(int index){
        for (int n = 0; n < 80; n++) {
            System.out.print("=");
        }
        System.out.println();
        System.out.println("As notas de "+getNome()+" | nota1:"+String.format("%.2f",getNota1())+" e nota2:"+String.format("%.2f",getNota2()));
        for (int n = 0; n < 80; n++) {
            System.out.print("=");
        }
        System.out.println();
    }




}
