package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Aluno28 extends Pessoa28{
    private int matricula;
    private double[] notas = new double[4];
    private double media;
    private SituacaoAluno28 situacaoAluno28;

    public Aluno28(String nome, String cpf, int idade, int matricula, double[] notas) {
        super(nome, cpf, idade);
        setMatricula(matricula);
        setNotas(notas);
    }

    private static final int MENOR_MATRICULA =0;

    public static Set<Integer> matriculasCadastradas = new HashSet<>();

    public static void validacaoMatricula(int matricula){
        if (matricula < MENOR_MATRICULA){
            throw new IllegalArgumentException(MensagensValidacaoAluno28.MATRICULA.getDescrica());
        }
        if (matriculasCadastradas.contains(matricula)){
            throw new IllegalArgumentException(MensagensValidacaoAluno28.MATRICULA_DUPLICADA.getDescricaoFomatada(MENOR_MATRICULA));
        }
    }

    private static final double MENOR_NOTA = 0;
    private static final double MAIOR_NOTA = 10;

    public static void validacaoNotas(double[] notas){
        for (double nota : notas) {
            if (nota < MENOR_NOTA || nota > MAIOR_NOTA){
                throw new IllegalArgumentException(MensagensValidacaoAluno28.NOTAS.getDescricaoFormatada(MENOR_NOTA,MAIOR_NOTA));
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

    public SituacaoAluno28 validandoSituacaoAluno(){
        if (this.media >= 7){
            return SituacaoAluno28.APROVADO;
        } else if (this.media >=5) {
            return SituacaoAluno28.EM_RECUPERACAO;
        }else {
            return SituacaoAluno28.REPROVADO;
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
        this.situacaoAluno28 = validandoSituacaoAluno();
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public SituacaoAluno28 getSituacaoAluno28() {
        return situacaoAluno28;
    }

    public enum SituacaoAluno28{
        APROVADO("Aprovado(a)."),
        EM_RECUPERACAO("Em recuperaçao."),
        REPROVADO("Reprovado(a).");

        private final String descricao;

        SituacaoAluno28(String descricao){
            this.descricao = descricao;
        }

        public String getDescricao(){
            return descricao;
        }
    }

    public enum MensagensValidacaoAluno28{
        MATRICULA("Matricula não pode ser menor que %d."),
        MATRICULA_DUPLICADA("Matrícula duplicada."),
        NOTAS("Nota não pode ser menor que %.2f ou maior que %.2f.");

        private final String descrica;

        MensagensValidacaoAluno28(String descrica){
            this.descrica = descrica;
        }

        public String getDescrica(){
            return descrica;
        }

        public String getDescricaoFomatada(int... valores){
            return String.format(descrica, Arrays.stream(valores).boxed().toArray());
        }

        public String getDescricaoFormatada(double... valores){
            return String.format(descrica,Arrays.stream(valores).boxed().toArray());
        }
    }

    @Override
    public String toString(){
        return super.toString()+String.format("|Matrícula: %d |Média: %.2f |Situação: %s",matricula,media,situacaoAluno28.getDescricao());
    }
}
