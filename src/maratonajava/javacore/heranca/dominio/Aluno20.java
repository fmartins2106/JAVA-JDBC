package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.HashSet;
import java.util.Set;

public class Aluno20 extends Pessoa20{
    private int matricula;
    private double[] notas = new double[4];
    private double media;
    private SituacaoAluno20 situacaoAluno20;

    public Aluno20(String nome, String cpf, int idade, int matricula, double[] notas) {
        super(nome, cpf, idade);
        setMatricula(matricula);
        setNotas(notas);
    }

    public static final int MENOR_NUM_MATRICULA = 1;
    public static final double MENOR_NOTA = 0;
    public static final double MAIOR_NOTA = 10;

    private static final Set<Integer> matriculaCadastrada = new HashSet<>();

    public static void validacaoMatricula(int matricula){
        if (matricula < MENOR_NUM_MATRICULA){
            throw new IllegalArgumentException(MensagensValidacaoPessoa20.ERRO_MATRICULA.getDescricaoFormatada(MENOR_NUM_MATRICULA));
        }
        if (matriculaCadastrada.contains(matricula)){
            throw new IllegalArgumentException(MensagensValidacaoPessoa20.ERRO_MATRICULA_DUPLICADA.getDescricao());
        }
    }

    public static void validacaoNotas(double[] notas){
        for (double nota : notas){
            if (nota < MENOR_NOTA || nota > MAIOR_NOTA){
                throw new IllegalArgumentException(MensagensValidacaoPessoa20.ERRO_NOTAS.getDescricaoFormatada(MENOR_NOTA,MAIOR_NOTA));
            }
        }
    }

    private void calculandoMedia(){
        double soma = 0;
        for (double nota : notas){
            soma+=nota;
        }
        this.media = soma / notas.length;
    }

    private SituacaoAluno20 validandoSituacaoAluno20(){
        if (this.media >= 7){
            return SituacaoAluno20.APROVADO;
        } else if (this.media >=5) {
            return SituacaoAluno20.EM_RECUPERACAO;
        }else {
            return SituacaoAluno20.REPROVADO;
        }
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        validacaoMatricula(matricula);
        this.matricula = matricula;
        matriculaCadastrada.add(matricula);
    }

    public double[] getNotas() {
        return notas;
    }

    public void setNotas(double[] notas) {
        validacaoNotas(notas);
        this.notas = notas;
        calculandoMedia();
        situacaoAluno20 = validandoSituacaoAluno20();
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public SituacaoAluno20 getSituacaoAluno20() {
        return situacaoAluno20;
    }

    public void setSituacaoAluno20(SituacaoAluno20 situacaoAluno20) {
        this.situacaoAluno20 = situacaoAluno20;
    }

    public enum SituacaoAluno20{
        APROVADO("Aprovado(a)."),
        EM_RECUPERACAO("Em recuperação."),
        REPROVADO("Reprovado(a).");

        private final String descricao;

        SituacaoAluno20(String descricao){
            this.descricao = descricao;
        }

        public String getDescricao(){
            return descricao;
        }
    }

    @Override
    public String toString() {
        return super.toString()+String.format(" |Matrícula: %d |Média: %.2f |Situação: %s",matricula,media,situacaoAluno20.getDescricao());
    }
}
