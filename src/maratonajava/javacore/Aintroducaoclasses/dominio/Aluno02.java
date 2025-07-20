package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio;



import java.util.Scanner;

public class Aluno02 {
    private String nome;
    private double nota1;
    private double nota2;
    private double media;

    public Aluno02(String nome, double nota1, double nota2){
        setNome(nome);
        setNota1(nota1);
        setNota2(nota2);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            throw new IllegalArgumentException("ERRO. Campo nome não pode ser vazio. Digite o seu nome completo. Tente novamente.");
        }
        this.nome = formatandoNome(nome);
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        if (nota1<=-1 || nota1>=11){
            throw new IllegalArgumentException("Para validar a nota. Digite uma nota entre 0 e 10. Tente novamente.");
        }
        this.nota1 = nota1;
        media();
    }

    public double getNota2() {
        return nota2;

    }

    public void setNota2(double nota2) {
        if (nota2<=-1 || nota2>=11){
            throw new IllegalArgumentException("Para validar a nota. Digite uma nota entre 0 e 10. Tente novamente.");
        }
        this.nota2 = nota2;
        media();
    }

    public static double validandoNota1(Scanner scanner){
        double nota1=0;
        while (true){
            try {
                System.out.print("Digite a primeira nota:");
                nota1 = Double.parseDouble(scanner.nextLine());
                if (nota1<=-1 || nota1>=11){
                    System.out.println("Para validar a nota. Digite uma nota entre 0 e 10.");
                }else {
                    return nota1;
                }
            }catch (NumberFormatException erro){
                System.out.println("ERRO. Digite uma nota válida. Tente novamente.");
            }
        }
    }
    public static double validandoNota2(Scanner scanner){
        double nota2=0;
        while (true){
            try {
                System.out.print("Digite a segunda nota:");
                nota2 = Double.parseDouble(scanner.nextLine());
                if (nota2<=-1 || nota2>=11){
                    System.out.println("Para validar a nota. Digite uma nota entre 0 e 10.");
                }else{
                    return nota2;
                }
            }catch (NumberFormatException erro){
                System.out.println("ERRO. Digite uma nota válida. Tente novamente.");
            }
        }
    }

    public double getMedia() {
        return media;
    }

    public void media(){
        if (media<=-1 || media>=11){
            throw new IllegalArgumentException("Para validar a média. O resultado precisa estar entre 0 e 10. Verifique as notas.");
        }
        this.media = (nota1+nota2)/2;
    }


    public void exibirTabelaAlunos(int index, int Aluno02){
        if (index==0){
            for (int n=0;n<42;n++){
                System.out.print("=");
            }
            System.out.println();
            System.out.printf("%-4s %-25s %-8s\n","No","Nome","Média");
            for (int n=0;n<42;n++){
                System.out.print("=");
            }
            System.out.println();
        }
        System.out.printf("%-4d %-25s %-8.2f\n",index,getNome(),getMedia());
        if (index== Aluno02-1){
            for (int n=0;n<42;n++){
                System.out.print("=");
            }
            System.out.println();
        }
    }

    public void verificandoNotasAlunos(){
        System.out.println("As notas de "+getNome()+" foram: "+getNota1()+" e "+getNota2());
    }

    private static String formatandoNome(String nome){
        String[] letras = nome.toLowerCase().split("\\s+");
        StringBuilder nomeFormatado = new StringBuilder();
        for (String letra : letras){
            nomeFormatado.append(letra.substring(0,1).toUpperCase()).append(letra.substring(1)).append(" ");
        }
        return nomeFormatado.toString().trim();
    }
}
