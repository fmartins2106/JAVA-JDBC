package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.Arrays;

public class Aluno03 extends Pessoa03{
    private int matricula;
    private double[] nota = new double[4];
    private double media;

    public Aluno03(String nome, int idade, String cpf, int matricula, double[] nota) {
        super(nome, idade, cpf);
        setMatricula(matricula);
        setNota(nota);
    }

    public static final String MENSAGEM_ERRO_MATRICULA = "Matricula não pode ser menor que 1.";
    public static final int MENOR_MATRICULA = 1;
    public static final String MENSAGEM_NOTA_DIFERENTE_4 = "É necessário informar 4 notas.";

    private void  validacaoMatricula(int matricula){
        if (matricula < MENOR_MATRICULA){
            throw new IllegalArgumentException(MENSAGEM_ERRO_MATRICULA);
        }
    }

    private void validacaoNotas(double[] notas){
        if (notas.length != 4){
            throw new IllegalArgumentException(MENSAGEM_NOTA_DIFERENTE_4);
        }
    }

    public void calculandoMedia(){
        this.media = Arrays.stream(nota).average().orElse(0);
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        validacaoMatricula(matricula);
        this.matricula = matricula;
    }

    public double[] getNota() {
        return nota;
    }

    public void setNota(double[] nota) {
        validacaoNotas(nota);
        this.nota = nota;
        calculandoMedia();
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }


    @Override
    public String toString(){
        return super.toString()+String.format(" |Matricula %s |Média: %.2f",matricula, media);
    }
}


