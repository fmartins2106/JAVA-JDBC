package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Aluno27 extends Pessoa27{
    private int numeroMatricula;
    private double[] notas = new double[4];
    private double media;
    private SituacaoAluno27 situacaoAluno27;

    public Aluno27(String nome, String cpf, int idade, int numeroMatricula, double[] notas) {
        super(nome, cpf, idade);
        setNumeroMatricula(numeroMatricula);
        setNotas(notas);
    }

    private static final int MENOR_NUMERO_MATRICULA = 1;
    private static final double MENOR_NOTA = 0;
    private static final double MAIOR_NOTA = 10;

    public static Set<Integer> matriculasCadastradas = new HashSet<>();

    public static void validacaoMatricula(int numeroMatricula){
        if (numeroMatricula < MENOR_NUMERO_MATRICULA){
            throw new IllegalArgumentException(MensagensValidacaoAluno27.MATRICULA.getDescricaoFomatada(MENOR_NUMERO_MATRICULA));
        }
        if (matriculasCadastradas.contains(numeroMatricula)){
            throw new IllegalArgumentException(MensagensValidacaoAluno27.MATRICULA_DUPLICADA.getDescricao());
        }
    }

    public static void validacaoNotas(double[] notas){
        for (double nota : notas) {
            if (nota < MENOR_NOTA || nota > MAIOR_NOTA){
                throw new IllegalArgumentException(MensagensValidacaoAluno27.NOTAS.getDescricaoFormatada(MENOR_NOTA,MAIOR_NOTA));
            }
        }
    }

    private void calculandoMedia(){
        double soma = 0;
        for (double nota : notas) {
            soma+=nota;
        }
        this.media = soma / notas.length;
    }

    public SituacaoAluno27 validandoSituacaoAluno27(){
        if (this.media >= 7){
            return SituacaoAluno27.APROVADO;
        } else if (this.media >= 5) {
            return SituacaoAluno27.EM_RECUPERACAO;
        }else {
            return SituacaoAluno27.REPROVADO;
        }
    }

    public int getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(int numeroMatricula) {
        validacaoMatricula(numeroMatricula);
        this.numeroMatricula = numeroMatricula;
        matriculasCadastradas.add(numeroMatricula);
    }

    public double[] getNotas() {
        return notas;
    }

    public void setNotas(double[] notas) {
        validacaoNotas(notas);
        this.notas = notas;
        calculandoMedia();
        situacaoAluno27 = validandoSituacaoAluno27();
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public SituacaoAluno27 getSituacaoAluno27() {
        return situacaoAluno27;
    }

    public void setSituacaoAluno27(SituacaoAluno27 situacaoAluno27) {
        this.situacaoAluno27 = situacaoAluno27;
    }

    public enum SituacaoAluno27{
        APROVADO("Aprovado(a)."),
        EM_RECUPERACAO("Em recuperação."),
        REPROVADO("Reprovado(a).");

        private final String descricao;

        SituacaoAluno27(String descricao){
            this.descricao = descricao;
        }

        public String getDescricao(){
            return descricao;
        }
    }

    public enum MensagensValidacaoAluno27{
        MATRICULA("Matrículo não pode ser menor que %d."),
        MATRICULA_DUPLICADA("Matricula duplicada."),
        NOTAS("Nota não pode ser menor que %.2f ou maior que %.2f.");

        private final String descricao;

        MensagensValidacaoAluno27(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }

        public String getDescricaoFormatada(double... valores){
            return String.format(descricao, Arrays.stream(valores).boxed().toArray());
        }

        public String getDescricaoFomatada(int... valores){
            return String.format(descricao,Arrays.stream(valores).boxed().toArray());
        }
    }

    @Override
    public String toString() {
        return super.toString()+String.format(" |Matrículo: %d |Média: %.2f |Situação: %s",numeroMatricula,media,situacaoAluno27.getDescricao());
    }
}
