package academy.devdojo.maratonajava.javacore.heranca.dominio;

public class Aluno10 extends Pessoa10{
    private int matricula;
    private double[] notas = new double[4];
    private double media;

    public Aluno10(String nome, int idade, String cpf, int matricula, double[] notas) {
        super(nome, idade, cpf);
        setMatricula(matricula);
        setNotas(notas);
    }

    public static final String MENSAGEM_ERRO_MATRICULA = "Matricula não pode ser menor que 1;";
    public static final String MENSAGEM_ERRO_NOTA = "Nota não pode ser menor que zero ou maior que dez.";
    public static final double MAIOR_NOTA = 10;
    public static final double MENOR_NOTA = 0;
    public static final int MENOR_MATRICULA = 1;


    private void validacaoMatricula(int matricula){
        if (matricula < MENOR_MATRICULA){
            throw new IllegalArgumentException(MENSAGEM_ERRO_MATRICULA);
        }
    }

    private void validacaoNotas(double[] notas){
        for (double nota : notas){
            if (nota < MENOR_NOTA || nota > MAIOR_NOTA){
                throw new IllegalArgumentException(MENSAGEM_ERRO_NOTA);
            }
        }
    }

    private void calculandoMedia(){
        double soma =0;
        for (double nota : notas){
            soma+=nota;
        }
        this.media = soma / notas.length;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        validacaoMatricula(matricula);
        this.matricula = matricula;
    }

    public double[] getNotas() {
        return notas;
    }

    public void setNotas(double[] notas) {
        validacaoNotas(notas);
        this.notas = notas;
        calculandoMedia();
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    @Override
    public String toString() {
        return super.toString()+String.format(" |Matricula: %d |Média: %.2f",matricula,media);
    }
}
