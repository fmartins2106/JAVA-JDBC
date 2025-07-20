package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Aluno25 extends Pessoa25{
    private int matricula;
    private double[] notas = new double[4];
    private double media;
    private SituacaoAluno25 situacaoAluno25;

    public Aluno25(String nome, String cpf, int idade, int matricula, double[] notas) {
        super(nome, cpf, idade);
        setMatricula(matricula);
        setNotas(notas);
    }

    public static final int MENOR_MATRICULA = 1;

    public static Set<Integer> matriculasCadastradas = new HashSet<>();

    public static void validacaoMatricula(int matricula){
        if (matricula < MENOR_MATRICULA){
            throw new IllegalArgumentException(MensagensValidacaoAluno25.ERRO_MATRICULA.getDescricaoFormatada(MENOR_MATRICULA));
        }
        if (matriculasCadastradas.contains(matricula)){
            throw new IllegalArgumentException(MensagensValidacaoAluno25.MATRICULA_DUPLICADA.getDescricao());
        }
    }

    public static final double MENOR_NOTA = 0;
    public static final double MAIOR_NOTA = 10;

    public static void validacaoNotas(double[] notas){
        for (double nota : notas) {
            if (nota < MENOR_NOTA || nota > MAIOR_NOTA){
                throw new IllegalArgumentException(MensagensValidacaoAluno25.ERRO_NOTAS.getDescricaoFormatada(MENOR_NOTA,MAIOR_NOTA));
            }
        }
    }

    public void calculandoMedia(){
        double soma = 0;
        for (double nota : notas) {
            soma+=nota;
        }
        this.media = soma / notas.length;
    }

    public SituacaoAluno25 validandoSituacaoAluno(){
        if (this.media >= 7){
            return SituacaoAluno25.APROVADO;
        } else if (this.media >=5) {
            return SituacaoAluno25.EM_RECUPERACAO;
        }else {
            return SituacaoAluno25.REPROVADO;
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
        this.situacaoAluno25 = validandoSituacaoAluno();
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public SituacaoAluno25 getSituacaoAluno25() {
        return situacaoAluno25;
    }

    public void setSituacaoAluno25(SituacaoAluno25 situacaoAluno25) {
        this.situacaoAluno25 = situacaoAluno25;
    }

    public enum MensagensValidacaoAluno25{
        ERRO_MATRICULA("Matrícula não pode ser menor que %d."),
        MATRICULA_DUPLICADA("Matrícula duplicada. Verifique."),
        ERRO_NOTAS("Nota não pode ser menor que %.2f ou maior que %.2f.");

        private final String descricao;

        MensagensValidacaoAluno25(String descricao){
            this.descricao = descricao;
        }

        public String getDescricao(){
            return descricao;
        }

        public String getDescricaoFormatada(double... valores){
            return String.format(descricao, Arrays.stream(valores).boxed().toArray());
        }

        public String getDescricaoFormatada(int... valores){
            return String.format(descricao,Arrays.stream(valores).boxed().toArray());
        }
    }

    public enum SituacaoAluno25{
        APROVADO("Aprovado(a)."),
        EM_RECUPERACAO("Em recuperação."),
        REPROVADO("Reprovado(a).");

        private final String descricao;

        SituacaoAluno25(String descricao){
            this.descricao = descricao;
        }

        public String getDescricao(){
            return descricao;
        }
    }

    @Override
    public String toString() {
        return super.toString()+String.format("|Matrícula: %d |Média: %.2f |Situação: %s",matricula,media,situacaoAluno25.getDescricao());
    }
}
