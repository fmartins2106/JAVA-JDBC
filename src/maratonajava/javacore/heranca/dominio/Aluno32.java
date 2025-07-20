package academy.devdojo.maratonajava.javacore.heranca.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.AlunoMatriculaDuplicada32;
import academy.devdojo.maratonajava.javacore.excessoes.AlunoMatriculaInvalida32;
import academy.devdojo.maratonajava.javacore.excessoes.AlunoNotasInvalidas32;

import java.util.HashSet;
import java.util.Set;

public class Aluno32 extends Pessoa32{
    private int matricula;
    private double[] notas = new double[4];
    private double media;
    private SituacaoAluno32 situacaoAluno32;

    public Aluno32(String nome, String cpf, int idade, int matricula, double[] notas) {
        super(nome, cpf, idade);
        setMatricula(matricula);
        setNotas(notas);
    }

    public static void validacaoMatricula(int matricula){
        if (matricula < AlunoMatriculaInvalida32.MENOR_MATRICULA){
            throw new AlunoMatriculaInvalida32();
        }
    }

    public static Set<Integer> matriculasCadastradas = new HashSet<>();

    public static void validacaoMatriculaDuplicada(int matricula){
        if (matriculasCadastradas.contains(matricula)){
            throw new AlunoMatriculaDuplicada32();
        }
    }

    public static void validacaoNotas(double[] notas){
        for (double nota : notas) {
            if (nota < AlunoNotasInvalidas32.MENOR_NOTA || nota > AlunoNotasInvalidas32.MAIOR_NOTA){
                throw new AlunoNotasInvalidas32();
            }
        }
    }

    public void calcularMedia(){
        double soma = 0;
        for (double nota : notas) {
            soma+= nota;
        }
        this.media = soma / notas.length;
    }

    public SituacaoAluno32 validandoSituacaoAluno32(){
        if (this.media >= 7){
            return SituacaoAluno32.APROVADO;
        } else if (media >=5) {
            return SituacaoAluno32.EM_RECUPERACAO;
        }else {
            return SituacaoAluno32.REPROVADO;
        }
    }

    public enum SituacaoAluno32{
        APROVADO("Aprovado(a)."),
        EM_RECUPERACAO("Em recuperação."),
        REPROVADO("Reprovado(a).");

        private final String descricao;

        SituacaoAluno32(String descricao){
            this.descricao = descricao;
        }

        public String getDescricao(){
            return descricao;
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
        situacaoAluno32 = validandoSituacaoAluno32();
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public SituacaoAluno32 getSituacaoAluno32() {
        return situacaoAluno32;
    }

    public void setSituacaoAluno32(SituacaoAluno32 situacaoAluno32) {
        this.situacaoAluno32 = situacaoAluno32;
    }

    @Override
    public String toString() {
        return super.toString()+String.format(" |Matrícula: %d |Média: %.2f |Situação: %s",matricula,media,situacaoAluno32.getDescricao());
    }
}
