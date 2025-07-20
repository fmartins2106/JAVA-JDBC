package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.HashSet;
import java.util.Set;

public class Aluno18 extends Pessoa18{
    private int matricula;
    private double[] notas = new double[4];
    private double media;
    private SituacaoAluno18 situacaoAluno18;

    public Aluno18(String nome, String cpf, int idade, int matricula, double[] notas) {
        super(nome, cpf, idade);
        setMatricula(matricula);
        setNotas(notas);
    }

    public static final int MENOR_MATRICULA = 1;
    public static final double MENOR_NOTA = 0;
    public static final double MAIOR_NOTA = 10;

    private static final Set<Integer> matriculasCadastradas = new HashSet<>();


    private void validacaoMatricula(int matricula){
       if (matricula < MENOR_MATRICULA){
           throw new IllegalArgumentException(MensagensValidacaoPessoas18.ERRO_MATRICULA.getDescricao());
       }
       if (matriculasCadastradas.contains(matricula)){
           System.out.println(MensagensValidacaoPessoas18.ERRO_MATRICULA_DUPLICADA.getDescricao());
       }
    }

    private void validacaoNotas(double[] notas){
        for (double nota : notas){
            if (nota < MENOR_NOTA || nota > MAIOR_NOTA){
                throw new IllegalArgumentException(MensagensValidacaoPessoas18.ERRO_NOTAS.getDescricao());
            }
        }
    }

    private void calculoMedia(){
        double soma = 0;
        for (double nota : notas){
            soma+=nota;
        }
        this.media = soma / notas.length;
    }

    private SituacaoAluno18 validandoSituacao(){
        if (this.media >= 7){
            return SituacaoAluno18.APROVADO;
        } else if (this.media >=5 && this.media <= 6.9) {
            return SituacaoAluno18.EM_RECUPERACAO;
        }else {
            return SituacaoAluno18.REPROVADO;
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
        calculoMedia();
        situacaoAluno18 = validandoSituacao();
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public SituacaoAluno18 getSituacaoAluno18() {
        return situacaoAluno18;
    }

    public void setSituacaoAluno18(SituacaoAluno18 situacaoAluno18) {
        this.situacaoAluno18 = situacaoAluno18;
    }

    public enum SituacaoAluno18{
        APROVADO("Aprovado(a)."),
        EM_RECUPERACAO("Em recuperação."),
        REPROVADO("Reprovado(a).");

        private final String descricao;

        SituacaoAluno18(String descricao){
            this.descricao = descricao;
        }

        public String getDescricao(){
            return descricao;
        }
    }

    @Override
    public String toString() {
        return super.toString()+String.format(" |Matrícula: %d |Média: %.2f |Situação: %s ",matricula,media,situacaoAluno18.getDescricao());
    }
}
