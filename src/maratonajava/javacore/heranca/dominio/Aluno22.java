package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.HashSet;
import java.util.Set;

public class Aluno22 extends Pessoa22{
    private int matricula;
    private double[] notas = new double[4];
    private double media;
    private SituacaoAluno22 situacaoAluno22;

    public Aluno22(String nome, String cpf, int idade, int matricula, double[] notas) {
        super(nome, cpf, idade);
        setMatricula(matricula);
        setNotas(notas);
    }

    public static final int MATRICULA_MINIMA = 1;
    public static final double NOTA_MINIMA = 0;
    public static final double NOTA_MAXIMA = 10;

    public static Set<Integer> matriculasCadastradas = new HashSet<>();

    public static void validacaoMatricula(int matricula){
        if (matricula < MATRICULA_MINIMA){
            throw new IllegalArgumentException(MensagensValidacaoPessoa22.ERRO_MATRICULA.getDescricaoFormatada(MATRICULA_MINIMA));
        }
        if (matriculasCadastradas.contains(matricula)){
            throw new IllegalArgumentException(MensagensValidacaoPessoa22.MATRICULA_DUPLICADA.getDescricao());
        }
    }

    public static void validacaoNotas(double[] notas){
        for (double nota : notas){
            if (nota < NOTA_MINIMA || nota > NOTA_MAXIMA){
                throw new IllegalArgumentException(MensagensValidacaoPessoa22.ERRO_NOTAS.getDescricaoFormatada(NOTA_MINIMA,NOTA_MAXIMA));
            }
        }
    }

    public void calculandoMedia(){
        double soma = 0;
        for (double nota : notas){
            soma+=nota;
        }
        this.media = soma / notas.length;
    }

    private SituacaoAluno22 validandoSituacao(){
        if (this.media >= 7){
            return SituacaoAluno22.APROVADO;
        } else if (this.media >= 5) {
            return SituacaoAluno22.EM_RECUPERACAO;
        }else {
            return SituacaoAluno22.REPROVADO;
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
        calculandoMedia();
        situacaoAluno22 = validandoSituacao();
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public SituacaoAluno22 getSituacaoAluno22() {
        return situacaoAluno22;
    }

    public void setSituacaoAluno22(SituacaoAluno22 situacaoAluno22) {
        this.situacaoAluno22 = situacaoAluno22;
    }

    public enum SituacaoAluno22{
        APROVADO("Aprovado(a)."),
        EM_RECUPERACAO("Em recuperação."),
        REPROVADO("Reprovado(a).");

        private final String descricao;

        SituacaoAluno22(String descricao){
            this.descricao = descricao;
        }

        public String getDescricao(){
            return descricao;
        }
    }

    @Override
    public String toString() {
        return super.toString()+String.format(" |Matrícula: %d |Média: %.2f |Situação: %s",matricula,media,situacaoAluno22.getDescricao());
    }
}
