package academy.devdojo.maratonajava.javacore.heranca.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.AlunoMatriculaDuplicada33;
import academy.devdojo.maratonajava.javacore.excessoes.AlunoMatriculaInvalida33;
import academy.devdojo.maratonajava.javacore.excessoes.AlunoNotasInvalidas33;

import java.util.HashSet;
import java.util.Set;

public class Aluno33 extends Pessoa33{
    private int matricula;
    private double[] notas = new double[4];
    private double media;
    private SituacaoAluno33 situacaoAluno33;

    public Aluno33(String nome, String cpf, int idade, int matricula, double[] notas) {
        super(nome, cpf, idade);
        setMatricula(matricula);
        setNotas(notas);
    }

    public static void validacaoMatricula(int matricula){
        if (matricula < AlunoMatriculaInvalida33.MENOR_NUMERO_MATRICULA){
            throw new AlunoNotasInvalidas33();
        }
    }

    public static Set<Integer> matriculasCadastras = new HashSet<>();

    public static void validacaoMatriculaDuoplicada(int matricula){
        if (matriculasCadastras.contains(matricula)){
            throw new AlunoMatriculaDuplicada33();
        }
    }

    public static void validacaoNotas(double[] notas){
        for (double nota : notas) {
            if (nota < AlunoNotasInvalidas33.MENOR_NOTA || nota > AlunoNotasInvalidas33.MAIOR_NOTA){
                throw new AlunoNotasInvalidas33();
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

    public SituacaoAluno33 validandoSituacaoAluno33(){
        if (this.media >= 7){
            return SituacaoAluno33.APROVADO;
        } else if (this.media >=5) {
            return SituacaoAluno33.EM_RECUPERACAO;
        }else {
            return SituacaoAluno33.REPROVADO;
        }
    }

    public enum SituacaoAluno33{
        APROVADO("Aprovado(a)."),
        EM_RECUPERACAO("Em recuperação."),
        REPROVADO("Reprovado(a).");

        private final String descricao;

        SituacaoAluno33(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        validacaoMatricula(matricula);
        this.matricula = matricula;
        matriculasCadastras.add(matricula);
    }

    public double[] getNotas() {
        return notas;
    }

    public void setNotas(double[] notas) {
        validacaoNotas(notas);
        this.notas = notas;
        calcularMedia();
        situacaoAluno33 = validandoSituacaoAluno33();
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public SituacaoAluno33 getSituacaoAluno33() {
        return situacaoAluno33;
    }

    public void setSituacaoAluno33(SituacaoAluno33 situacaoAluno33) {
        this.situacaoAluno33 = situacaoAluno33;
    }

    @Override
    public String toString(){
        return super.toString()+String.format(" |Matrícula: %d |Média: %.2f |Situação: %s",
                matricula,media,situacaoAluno33.getDescricao());
    }
}
