package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.Arrays;

public class Aluno02 extends Pessoa02{
    private int matricula;
    private double[] notas = new double[4];
    private double media;

    public Aluno02(String nome, int idade, String cpf, int matricula) {
        super(nome, idade, cpf);
        setMatricula(matricula);
    }

    public static final String MENSAGEM_MINIMO_MATRICULA = "matrícula não pode ser menor que 1";
    public static final int MENOR_MATRICULA = 1;
    public static final String MENSAGEM_NOTA_DIFERENTE_4 = "É necessário informar 4 notas.";

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        if (matricula < MENOR_MATRICULA){
            throw new IllegalArgumentException(MENSAGEM_MINIMO_MATRICULA);
        }
        this.matricula = matricula;
    }

    public double[] getNotas() {
        return notas;
    }

    public void setNotas(double[] notas) {
        if (notas.length != 4){
            throw new IllegalArgumentException(MENSAGEM_NOTA_DIFERENTE_4);
        }
        this.notas = notas;
        calcularMedia();
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public void calcularMedia(){
        this.media = Arrays.stream(notas).average().orElse(0);
    }

    @Override
    public String toString(){
        return super.toString()+String.format("Matricula: "+matricula+" |Média: "+media);
    }
}
