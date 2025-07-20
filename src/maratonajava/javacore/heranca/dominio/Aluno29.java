package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Aluno29 extends Pessoa29{
    private int matricula;
    private double[] notas = new double[4];
    private double media;
    private SituacaoAluno29 situacaoAluno29;

    public Aluno29(String nome, String cpf, int idade, int matricula, double[] notas) {
        super(nome, cpf, idade);
        setMatricula(matricula);
        setNotas(notas);
    }

    private static final int MENOR_NUMERO_MATRICULA = 1;
    public static Set<Integer> matriculasCadastradas = new HashSet<>();

    public static void validacaoMatricula(int matricula){
        if (matricula <  MENOR_NUMERO_MATRICULA){
            throw new IllegalArgumentException(MensagensValidacaoAluno29.MATRICULA.getDescricao());
        }
        if (matriculasCadastradas.contains(matricula)){
            throw new IllegalArgumentException(MensagensValidacaoAluno29.MATRICULA_DUPLICADA.getDescricaoFormatada(MENOR_NUMERO_MATRICULA));
        }
    }

    private static final double MENOR_NOTA = 0;
    private static final double MAIOR_NOTA = 10;

    public static void validancaoNotas(double[] notas){
        for (double nota : notas) {
            if (nota < MENOR_NOTA || nota > MAIOR_NOTA){
                throw new IllegalArgumentException(MensagensValidacaoAluno29.NOTAS.getDescricaoFormatada(MENOR_NOTA,MAIOR_NOTA));
            }
        }
    }

    public void calcularMedia(){
        double soma = 0;
        for (double nota : notas) {
            soma+=nota;
        }
        this.media = soma / notas.length;
    }

    public SituacaoAluno29 validandoSituacaoAluno(){
        if (this.media >= 7){
            return SituacaoAluno29.APROVADO;
        } else if (this.media >= 5) {
            return SituacaoAluno29.EM_RECUPERACAO;
        }else {
            return SituacaoAluno29.REPROVADO;
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
        validancaoNotas(notas);
        this.notas = notas;
        calcularMedia();
        situacaoAluno29 = validandoSituacaoAluno();
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public SituacaoAluno29 getSituacaoAluno29() {
        return situacaoAluno29;
    }

    public void setSituacaoAluno29(SituacaoAluno29 situacaoAluno29) {
        this.situacaoAluno29 = situacaoAluno29;
    }

    public enum MensagensValidacaoAluno29{
        MATRICULA("Digite um número de matricula maior que %d."),
        MATRICULA_DUPLICADA("Matricula duplicada."),
        NOTAS("Nota não pode ser menor que %.2f ou maior que %.2f.");

        private final String descricao;

        MensagensValidacaoAluno29(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }

        public String getDescricaoFormatada(double... valores){
            return String.format(descricao, Arrays.stream(valores).boxed().toArray());
        }

        public String getDescricaoFormatada(int... valores){
            return String.format(descricao,Arrays.stream(valores).boxed().toArray());
        }
    }

    public enum SituacaoAluno29{
        APROVADO("Aprovado(a)."),
        EM_RECUPERACAO("Em recuperação."),
        REPROVADO("Reprovado(a).");

        private final String descricao;

        SituacaoAluno29(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }
    }

    @Override
    public String toString() {
        return super.toString()+String.format(" |Matrícula: %d |Média: %.2f |Situação: %s",matricula,media,situacaoAluno29.getDescricao());
    }
}
















