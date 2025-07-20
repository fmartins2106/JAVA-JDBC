package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.HashSet;
import java.util.Set;

public class Aluno19 extends Pessoa19{
    private int matricula;
    private double[] notas = new double[4];
    private double media;
    private SituacaoAluno19 situacaoAluno19;

    public Aluno19(String nome, String cpf, int idade, int matricula, double[] notas) {
        super(nome, cpf, idade);
        setMatricula(matricula);
        setNotas(notas);
    }

    public static final int MENOR_MATRICULA = 1;
    public static final double MENOR_NOTA = 0;
    public static final double MAIOR_NOTA = 10;

    private static final Set<Integer> matriculaCadastrada = new HashSet<>();

    public static void validacaoMatricula(int matricula){
        if (matricula < MENOR_MATRICULA){
            throw new IllegalArgumentException(MensagemValidacaoPessoa19.ERRO_MATRICULA.getDescricao());
        }
        if (matriculaCadastrada.contains(matricula)){
            throw new IllegalArgumentException(MensagemValidacaoPessoa19.ERRO_MATRICULA_REPETIDA.getDescricao());
        }
    }

    public static void validacaoNotas(double[] notas){
        for (double nota : notas){
            if (nota < MENOR_NOTA || nota > MAIOR_NOTA){
                throw new IllegalArgumentException(MensagemValidacaoPessoa19.ERRO_NOTA.getDescricao());
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

    private SituacaoAluno19 validandoSituacaoAluno19(){
        if (this.media >= 7){
            return SituacaoAluno19.APROVADO;
        } else if (this.media >=5) {
            return SituacaoAluno19.EM_RECUPERACAO;
        }else {
            return SituacaoAluno19.REPROVADO;
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
        situacaoAluno19 =validandoSituacaoAluno19();
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public SituacaoAluno19 getSituacaoAluno19() {
        return situacaoAluno19;
    }

    public void setSituacaoAluno19(SituacaoAluno19 situacaoAluno19) {
        this.situacaoAluno19 = situacaoAluno19;
    }

    public enum SituacaoAluno19{
        APROVADO("Aprovado(a)."),
        EM_RECUPERACAO("Em recuperação."),
        REPROVADO("Reprovado(a).");

        private final String descricao;

        SituacaoAluno19(String descricao){
            this.descricao = descricao;
        }

        public String getDescricao(){
            return descricao;
        }
    }

    @Override
    public String toString(){
        return super.toString()+String.format(" |Matrícula: %d |Média: %.2f |Situação: %s",
                matricula,media,situacaoAluno19.getDescricao());
    }

}
