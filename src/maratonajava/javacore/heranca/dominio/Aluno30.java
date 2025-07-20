package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Aluno30 extends Pessoa30 {
    private int matricula;
    private double[] notas = new double[4];
    private double media;
    private SituacaoAluno30 situacaoAluno30;

    public Aluno30(String nome, String cpf, int idade, int matricula, double[] notas) {
        super(nome, cpf, idade);
        setMatricula(matricula);
        setNotas(notas);
    }

    public static Set<Integer> matriculasCadastradas = new HashSet<>();

    public static void validacaoMatriculaDuplicada(int matricula){
        if (matriculasCadastradas.contains(matricula)){
            throw new IllegalArgumentException(MensagensValidacaoAluno30.MATRICULA_DUPLICADA.getDescricao());
        }
    }

    private static final int MENOR_MATRICULA = 1;

    public static void validacaoMatricula(int matricula){
        if (matricula < MENOR_MATRICULA){
            throw new IllegalArgumentException(MensagensValidacaoAluno30.MATRICULA.getDescricaoFormatada(MENOR_MATRICULA));
        }
    }

    private static final double MENOR_NOTA = 0;
    private static final double MAIOR_NOTA = 10;

    public static void validacaoNotas(double[] notas){
        for (double nota : notas) {
            if (nota < MENOR_NOTA || nota > MAIOR_NOTA){
                throw new IllegalArgumentException(MensagensValidacaoAluno30.NOTAS.getDescricaoFormatada(MENOR_NOTA,MAIOR_NOTA));
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

    public SituacaoAluno30 validandoSituacaoAluno30(){
        if (this.media >= 7){
            return SituacaoAluno30.APROVADO;
        } else if (media >=5) {
            return SituacaoAluno30.EM_RECUPERACAO;
        }else {
            return SituacaoAluno30.REPROVADO;
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
        this.situacaoAluno30 = validandoSituacaoAluno30();
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public SituacaoAluno30 getSituacaoAluno30() {
        return situacaoAluno30;
    }

    public enum SituacaoAluno30{
        APROVADO("Aprovado(a)."),
        EM_RECUPERACAO("Em recuperação."),
        REPROVADO("Reprovado(a).");

        private final String descricao;

        SituacaoAluno30(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }
    }

    public enum MensagensValidacaoAluno30{
        MATRICULA("Matricula não pode ser menor que %d."),
        MATRICULA_DUPLICADA("Matricula duplicada. Verifique."),
        NOTAS("Nota não pode ser menor que %.2f ou maior que %.2f.");

        private final String descricao;

        MensagensValidacaoAluno30(String descricao) {
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
    public String toString(){
        return super.toString()+String.format(" |Matrícula: %d |Média: %.2f |Situação: %s",matricula,media,situacaoAluno30.getDescricao());
    }
}
