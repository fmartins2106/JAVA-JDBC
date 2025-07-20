package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.HashSet;
import java.util.Set;

public class Aluno24 extends Pessoa24{
    private int matricula;
    private double[] notas = new double[4];
    private double media;
    private SituacaoAluno24 situacaoAluno24;

    public Aluno24(String nome, String cpf, int idade, int matricula, double[] notas) {
        super(nome, cpf, idade);
        setMatricula(matricula);
        setNotas(notas);
    }

    public static final int MENOR_NUMERO_MATRICULA = 1;
    public static final double MENOR_NOTA = 0;
    public static final double MAIOR_NOTA = 10;

    private static Set<Integer> matriculacadastrada = new HashSet<>();

    public static void validacaoMatricula(int matricula){
        if (matricula < MENOR_NUMERO_MATRICULA){
            throw new IllegalArgumentException(MensagensValidacaoPessoa24.ERRO_MATRICULA.getDescricaoFormadata(MENOR_NUMERO_MATRICULA));
        }
        if (matriculacadastrada.contains(matricula)){
            throw new IllegalArgumentException(MensagensValidacaoPessoa24.MATRICULA_DUPLICADA.getDescricao());
        }
    }

    public static void validacaoNotas(double[] notas){
        for (double nota : notas){
            if (nota < MENOR_NOTA || nota > MAIOR_NOTA){
                throw new IllegalArgumentException(MensagensValidacaoPessoa24.ERRO_NOTA.getDescricaoFormatada(MENOR_NOTA,MAIOR_NOTA));
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

    public enum SituacaoAluno24{
        APROVADO("Aprovado(a)."),
        EM_RECUPERACAO("Em recuperação."),
        REPROVADO("Reprovado(a).");

        private final String descricao;

        SituacaoAluno24(String descricao){
            this.descricao = descricao;
        }

        public String getDescricao(){
            return descricao;
        }
    }

    public SituacaoAluno24 validandoSituacaoAluno(){
        if (this.media >= 7){
            return SituacaoAluno24.APROVADO;
        } else if (this.media >=5) {
            return SituacaoAluno24.EM_RECUPERACAO;
        }else {
            return SituacaoAluno24.REPROVADO;
        }
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        validacaoMatricula(matricula);
        this.matricula = matricula;
        matriculacadastrada.add(matricula);
    }

    public double[] getNotas() {
        return notas;
    }

    public void setNotas(double[] notas) {
        validacaoNotas(notas);
        this.notas = notas;
        calculandoMedia();
        situacaoAluno24 = validandoSituacaoAluno();
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public SituacaoAluno24 getSituacaoAluno24() {
        return situacaoAluno24;
    }

    public void setSituacaoAluno24(SituacaoAluno24 situacaoAluno24) {
        this.situacaoAluno24 = situacaoAluno24;
    }

    @Override
    public String toString(){
        return super.toString()+String.format(" Matrícula: %d |Média: %.2f |Situação: %s",matricula,media,situacaoAluno24.getDescricao());
    }
}
