package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Aluno26 extends Pessoa26{
    private int matricula;
    private double[] notas = new double[4];
    private double media;
    private SituacaoAluno26 situacaoAluno26;

    public Aluno26(String nome, String cpf, int idade, int matricula, double[] notas) {
        super(nome, cpf, idade);
        setMatricula(matricula);
        setNotas(notas);
    }

    public static final int MENOR_MATRICULA = 1;

    public static Set<Integer> matriculaCadastrada = new HashSet<>();

    public static void validacaoMatricula(int matricula){
        if (matricula < MENOR_MATRICULA){
            throw new IllegalArgumentException(MensagensValidacaoAluno26.MATRICULA.getDescricaoFormatada(MENOR_MATRICULA));
        }
        if (matriculaCadastrada.contains(matricula)){
            throw new IllegalArgumentException(MensagensValidacaoAluno26.MATRICULA_DUPLICADA.getDescricao());
        }
    }

    public static final double MENOR_NOTA = 0;
    public static final double MAIOR_NOTA = 10;

    public static void validacaoNotas(double[] notas){
        for (double nota : notas) {
            if (nota < MENOR_NOTA || nota > MAIOR_NOTA){
                throw new IllegalArgumentException(MensagensValidacaoAluno26.NOTAS.getDescricaoFormatada(MENOR_NOTA,MAIOR_NOTA));
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

    private SituacaoAluno26 validandoSituacaoAluno26(){
        if (this.media >= 7){
            return SituacaoAluno26.APROVADO;
        } else if (this.media >= 5) {
            return SituacaoAluno26.EM_RECUPERACAO;
        }else {
            return SituacaoAluno26.REPROVADO;
        }
    }

    public enum SituacaoAluno26{
        APROVADO("Aprovado(a)."),
        EM_RECUPERACAO("Em recuperação."),
        REPROVADO("Reprovado(a).");

        private final String descricao;

        SituacaoAluno26(String descricao){
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
        matriculaCadastrada.add(matricula);
    }

    public double[] getNotas() {
        return notas;
    }

    public void setNotas(double[] notas) {
        validacaoNotas(notas);
        this.notas = notas;
        calcularMedia();
        situacaoAluno26 = validandoSituacaoAluno26();
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public SituacaoAluno26 getSituacaoAluno26() {
        return situacaoAluno26;
    }

    public void setSituacaoAluno26(SituacaoAluno26 situacaoAluno26) {
        this.situacaoAluno26 = situacaoAluno26;
    }

    public enum MensagensValidacaoAluno26{
        MATRICULA("Digite um número de matricula maior que %d."),
        MATRICULA_DUPLICADA("Matrícula duplicada."),
        NOTAS("Nota não pode ser menor que %.2f ou maior que %.2f.");

        public final String descricao;

        MensagensValidacaoAluno26(String descricao){
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

    @Override
    public String toString(){
        return super.toString()+String.format(" |Matrícula: %d |Média: %.2f |Situação: %s",matricula,media,situacaoAluno26);
    }
}

