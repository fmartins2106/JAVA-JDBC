package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.HashSet;
import java.util.Set;

public class Aluno23 extends Pessoa23{
    private int matricula;
    private double[] notas = new double[4];
    private double media;
    private SituacaoAluno23 situacaoAluno23;

    public Aluno23(String nome, String cpf, int idade, int matricula, double[] notas) {
        super(nome, cpf, idade);
        setMatricula(matricula);
        setNotas(notas);
    }

    public static final int MENOR_MATRICULA = 1;
    public static final double MENOR_NOTA = 0;
    public static final double MAIOR_NOTA = 10;


    public static Set<Integer> matriculasCadastras = new HashSet<>();

    public static void validacaoMatricula(int matricula){
        if (matricula < MENOR_MATRICULA){
            throw new IllegalArgumentException(MensagensValidacaoPessoa23.ERRO_MATRICULA.getDescricaoFormatada(MENOR_MATRICULA));
        }
        if (matriculasCadastras.contains(matricula)){
            throw new IllegalArgumentException(MensagensValidacaoPessoa23.ERRO_MATRICULA_DUPLICADA.getDescricaoFormatada());
        }
    }

    public static void validacaoNotas(double[] notas){
        for (double nota : notas){
            if (nota < MENOR_NOTA || nota > MAIOR_NOTA){
                throw new IllegalArgumentException(MensagensValidacaoPessoa23.ERRO_NOTA.getDescricaoFormatada(MENOR_NOTA,MAIOR_NOTA));
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

    public enum SituacaoAluno23{
        APROVADO("Aprovado(a)."),
        EM_RECUPERACAO("Em recuperação."),
        REPROVADO("Reprovado(a).");

        private final String descricao;

        SituacaoAluno23(String descricao){
            this.descricao = descricao;
        }

        public String getDescricao(){
            return descricao;
        }
    }

    public SituacaoAluno23 validandoSituacaoAluno23(){
        if (this.media >= 7){
            return SituacaoAluno23.APROVADO;
        }else if (this.media >= 5){
            return SituacaoAluno23.EM_RECUPERACAO;
        }else {
            return SituacaoAluno23.REPROVADO;
        }
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        validacaoMatricula(matricula);
        this.matricula = matricula;
        matriculasCadastras.add(matricula);
    }

    public double[] getNotas() {
        return notas;
    }

    public void setNotas(double[] notas) {
        validacaoNotas(notas);
        this.notas = notas;
        calculandoMedia();
        situacaoAluno23 = validandoSituacaoAluno23();
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public SituacaoAluno23 getSituacaoAluno23() {
        return situacaoAluno23;
    }

    public void setSituacaoAluno23(SituacaoAluno23 situacaoAluno23) {
        this.situacaoAluno23 = situacaoAluno23;
    }

    @Override
    public String toString() {
        return super.toString()+String.format(" Matrícula: %d |Média: %.2f |Situação: %s",matricula,media,situacaoAluno23.getDescricao());
    }
}
