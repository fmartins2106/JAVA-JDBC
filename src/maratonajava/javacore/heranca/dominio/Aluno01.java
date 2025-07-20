package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.Arrays;

public class Aluno01 extends Pessoa01{
    private int matricula;
    private double[] notas = new double[4];
    private double media;

    public Aluno01(String nome, int idade, String cpf, int matricula) {
        super(nome, idade, cpf);
        setMatricula(matricula);
    }

    public int getMatricula() {
        return matricula;
    }

    public static final int MINIMO_MATRICULA = 1;
    public static final String MENSAGEM_MATRICULA = "Matrícula não pode ser menor que 1.";
    public void setMatricula(int matricula) {
        if (matricula < MINIMO_MATRICULA){
            throw new IllegalArgumentException(MENSAGEM_MATRICULA);
        }
        this.matricula = matricula;
    }

    public double[] getNotas() {
        return notas;
    }

    public void setNotas(double[] notas) {
        if (notas.length !=4){
            throw new IllegalArgumentException("é necessário informar 4 notas.");
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

    private void calcularMedia(){
        this.media = Arrays.stream(notas).average().orElse(0);
    }

    @Override
    public String toString(){
        return super.toString()+" |Matricula:"+matricula+ "|Média:"+media;
    }
}
