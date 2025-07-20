package academy.devdojo.maratonajava.javacore.heranca.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.AlunoMatriculaDuplicada34;
import academy.devdojo.maratonajava.javacore.excessoes.AlunoMatriculaInvalida34;
import academy.devdojo.maratonajava.javacore.excessoes.AlunoNotasInvalidas34;

import java.util.HashSet;
import java.util.Set;

public class Aluno34 extends Pessoa34{
    private int matricula;
    private double[] notas = new double[4];
    private double media;
    private SituacaoAluno34 situacaoAluno34;

    public Aluno34(String nome, String cpf, int idade, int matricula, double[] notas) {
        super(nome, cpf, idade);
        setMatricula(matricula);
        setNotas(notas);
    }

    public static void validacaoMatricula(int matricula){
        if (matricula < AlunoMatriculaInvalida34.MENOR_MATRICULA){
            throw new AlunoMatriculaInvalida34();
        }
    }

    public static Set<Integer> matriculasCadastradas = new HashSet<>();

    public static void validacaoMatriculaDuplicada(int matricula){
        if (matriculasCadastradas.contains(matricula)){
            throw new AlunoMatriculaDuplicada34();
        }
    }

    public static void validacaoNotas(double[] notas){
        for (double nota : notas) {
            if (nota < AlunoNotasInvalidas34.MENOR_NOTA || nota > AlunoNotasInvalidas34.MAIOR_NOTA){
                throw new AlunoNotasInvalidas34();
            }
        }
    }

    public void calcularMedia(){
        double soma = 0;
        for (double nota : notas) {
            soma += nota;
        }
        this.media = soma / notas.length;
    }

    public SituacaoAluno34 validandoSituacaoAluno34(){
        if (this.media >= 7){
            return SituacaoAluno34.APROVADO;
        } else if (this.media >=5) {
            return SituacaoAluno34.EM_RECUPERACAO;
        }else {
            return SituacaoAluno34.REPROVADO;
        }
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        validacaoMatricula(matricula);
        this.matricula = matricula;
        matriculasCadastradas.add(matricula);
    }

    public double[] getNotas() {
        return notas;
    }

    public void setNotas(double[] notas) {
        validacaoNotas(notas);
        this.notas = notas;
        calcularMedia();
        this.situacaoAluno34 = validandoSituacaoAluno34();
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public SituacaoAluno34 getSituacaoAluno34() {
        return situacaoAluno34;
    }

    public void setSituacaoAluno34(SituacaoAluno34 situacaoAluno34) {
        this.situacaoAluno34 = situacaoAluno34;
    }

    public enum SituacaoAluno34{
        APROVADO("Aprovado(a)."),
        EM_RECUPERACAO("Em recuperação."),
        REPROVADO("Reprovado(a).");

        private final String descricao;

        SituacaoAluno34(String descricao){
            this.descricao = descricao;
        }

        public String getDescricao(){
            return descricao;
        }
    }

    @Override
    public String toString() {
        return super.toString()+String.format(" |Matrícula: %d |Média: %.2f |Situação: %s",matricula,media,
                situacaoAluno34.getDescricao());
    }
}
