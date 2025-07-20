package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.HashSet;
import java.util.Set;

public class Aluno21 extends Pessoa21{
    private int matricula;
    private double[] notas = new double[4];
    private double media;
    private SituacaoAluno21 situacaAluno21;

    public Aluno21(String nome, String cpf, int idade, int matricula, double[] notas) {
        super(nome, cpf, idade);
        setMatricula(matricula);
        setNotas(notas);
    }

    public static final int MATRICULA_MINIMA = 1;
    public static final double MENOR_NOTA = 0;
    public static final double MAIOR_NOTA = 10;


    public static Set<Integer> matriculasCadastradas = new HashSet<>();
    public static void validacaoMatricula(int matricula){
        if (matricula < MATRICULA_MINIMA){
            throw new IllegalArgumentException(Pessoa21.MensagensValidacaoPessoa21.ERRO_MATRICULA.getDescricaoFormatada(MATRICULA_MINIMA));
        }
        if (matriculasCadastradas.contains(matricula)){
            throw new IllegalArgumentException(Pessoa21.MensagensValidacaoPessoa21.ERRO_MATRICULA_DUPLICADA.getDescricao());
        }
    }

    public static void validacaoNotas(double[] notas){
        for (double nota : notas){
            if (nota < MENOR_NOTA || nota > MAIOR_NOTA){
                throw new IllegalArgumentException(Pessoa21.MensagensValidacaoPessoa21.ERRO_NOTA.getDescricaoFormatada(MENOR_NOTA,MAIOR_NOTA));
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

    public SituacaoAluno21 validacaoSituacaoAluno(){
        if (this.media >= 7){
            return SituacaoAluno21.APROVADO;
        } else if (this.media >= 5) {
            return SituacaoAluno21.EM_RECUPERACAO;
        }else {
            return SituacaoAluno21.REPROVADO;
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
        this.situacaAluno21 = validacaoSituacaoAluno();
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public SituacaoAluno21 getSituacaAluno21() {
        return situacaAluno21;
    }

    public void setSituacaAluno21(SituacaoAluno21 situacaAluno21) {
        this.situacaAluno21 = situacaAluno21;
    }

    public enum SituacaoAluno21{
        APROVADO("Aprovado(a)."),
        EM_RECUPERACAO("Em recuperação."),
        REPROVADO("Reprovado(a).");

        private final String descricao;

        SituacaoAluno21(String descricao){
            this.descricao = descricao;
        }

        public String getDescricao(){
            return descricao;
        }
    }

    @Override
    public String toString(){
        return super.toString()+String.format("|Matrícula: %s |Média: %.2f |Situação: %s",matricula,media,situacaAluno21.getDescricao());
    }

}
