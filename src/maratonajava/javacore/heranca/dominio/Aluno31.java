package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Aluno31 extends Pessoa31{
    private int matricula;
    private double[] notas = new double[4];
    private double media;
    private SituacaoAluno31 situacaoAluno31;

    public Aluno31(String nome, String cpf, int idade, int matricula, double[] notas) {
        super(nome, cpf, idade);
        setMatricula(matricula);
        setNotas(notas);
    }

    private static final int MENOR_MATRICULA = 1;

    public static void validacaoMatricula(int matricula){
        if (matricula < MENOR_MATRICULA){
            throw new IllegalArgumentException(MensagensValidacaoAluno31.MATRICULA.getDescricaoFormatada(MENOR_MATRICULA));
        }
    }

    public static Set<Integer> matriculasCadastradas = new HashSet<>();

    public static void validacaoMatriculaDuplicada(int matricula){
        if (matriculasCadastradas.contains(matricula)){
            throw new IllegalArgumentException(MensagensValidacaoAluno31.MATRICULA_DUPLICADA.getDescricao());
        }
    }

    private static final double MENOR_NOTA = 0;
    private static final double MAIOR_NOTA = 10;

    public static void validacaoNotas(double[] notas){
        for (double nota : notas) {
            if (nota < MENOR_NOTA || nota > MAIOR_NOTA){
                throw new IllegalArgumentException(MensagensValidacaoAluno31.NOTAS.getDescricaoFormatada(MENOR_NOTA,MAIOR_NOTA));
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

    public SituacaoAluno31 validandoSituacaoAluno31(){
        if (this.media >= 7){
            return SituacaoAluno31.APROVADO;
        } else if (this.media >= 5) {
            return SituacaoAluno31.EM_RECUPERACAO;
        }else {
            return SituacaoAluno31.REPROVADO;
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
        this.situacaoAluno31 = validandoSituacaoAluno31();
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public SituacaoAluno31 getSituacaoAluno31() {
        return situacaoAluno31;
    }

    public void setSituacaoAluno31(SituacaoAluno31 situacaoAluno31) {
        this.situacaoAluno31 = situacaoAluno31;
    }

    public enum SituacaoAluno31{
        APROVADO("Aprovado(a)."),
        EM_RECUPERACAO("Em recuperação."),
        REPROVADO("Reprovado(a).");

        private final String descricao;

        SituacaoAluno31(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }
    }

    public enum MensagensValidacaoAluno31{
        MATRICULA("Matricula não pode ser menor que %d."),
        MATRICULA_DUPLICADA("Matricula duplicada."),
        NOTAS("Nota não pode ser menor que %.2f ou maior que %.2f.");

        private final String descricao;

        MensagensValidacaoAluno31(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }

        public String getDescricaoFormatada(int... valores){
            return String.format(descricao, Arrays.stream(valores).boxed().toArray());
        }

        public String getDescricaoFormatada(double... valores){
            return String.format(descricao,Arrays.stream(valores).boxed().toArray());
        }
    }

    @Override
    public String toString() {
        return super.toString()+String.format(" |Matrícula: %d |Média: %.2f |Situação: %s",matricula,media,situacaoAluno31.getDescricao());
    }
}
