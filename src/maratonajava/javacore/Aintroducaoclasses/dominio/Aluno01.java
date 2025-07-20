package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio;

public class Aluno01 {
    private String nome;
    private double nota1;
    private double nota2;
    private double media;

    public Aluno01(String nome, double nota1, double nota2){
        setNome(nome);
        setNota1(nota1);
        setNota2(nota2);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            throw new IllegalArgumentException("Nome não pode ser nulo, vazio ou conter caracteres. Tente novamente.");
        }
        this.nome = formantandoNome(nome);
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        if (nota1<=-1 || nota1>=11){
            throw new IllegalArgumentException("Nota inválida, tente uma nota entre 0 e 10.");
        }
        this.nota1 = nota1;
        calcularMediaAluno();
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        if (nota2<=-1 || nota2>=11){
            throw new IllegalArgumentException("Nota inválida, tente ma nota entre 0 e 10.");
        }
        this.nota2 = nota2;
        calcularMediaAluno();
    }

    public double getMedia() {
        return media;
    }

    public void calcularMediaAluno(){
        if (media<=-1 || media>=11){
            throw new IllegalArgumentException("ERRO. Média não pode ser maior que 10 ou menor que 1. Tente novamente.");
        }
        this.media = (nota1+nota2)/2;
    }
    public void exibindoMediaAlunos(int index){
        if (index==0){
            for (int n=0;n<38;n++){
                System.out.print("=");
            }
            System.out.println();
            System.out.printf("%-4s %-25s %-8s\n","No","Nome","Média");
            for (int n=0;n<38;n++){
                System.out.print("=");
            }
            System.out.println();
        }
        System.out.printf("%-4d %-25s %-8.2f\n",index,getNome(),getMedia());
        for (int n=0;n<38;n++){
            System.out.print("=");
        }
        System.out.println();
    }
    public void exibindoNotasAluno(int index){
        System.out.println("As notas de "+getNome()+" foram: "+getNota1()+" e "+getNota2());
    }


    private static String formantandoNome(String nome){
        String[] palavras = nome.toLowerCase().split("\\s+");
        StringBuilder nomeFormatado = new StringBuilder();
        for (String palavra : palavras){
            nomeFormatado.append(palavra.substring(0,1).toUpperCase()).append(palavra.substring(1)).append(" ");
        }
        return nomeFormatado.toString().trim();
    }
}
