package academy.devdojo.maratonajava.javacore.heranca.dominio;

public class Aluno14 extends Pessoa14{
    private int matricula;
    private double[] notas = new double[4];
    private double media;
    private SituacaoAluno situacaoAluno;

    public Aluno14(String nome, String cpf, int idade, int matricula, double[] notas) {
        super(nome, cpf, idade);
        setMatricula(matricula);
        setNotas(notas);
        this.situacaoAluno = validacaoSituacao();
    }
    public static final int NUMERO_MINIMO_MATRICULA = 1;
    public static final double NOTA_MINIMA= 0;
    public static final double NOTA_MAXIMA = 10;

    public void validacaoMatricula(int matricula){
        if (matricula < NUMERO_MINIMO_MATRICULA){
            throw new IllegalArgumentException(MensagensValidacoes.NUMERO_MINIMO_MATRICULA.getDescricao());
        }
    }

    public void validacaoNotas(double[] notas){
        for (double nota : notas){
            if (nota < NOTA_MINIMA || nota > NOTA_MAXIMA){
                throw new IllegalArgumentException(MensagensValidacoes.ERRO_NOTAS.getDescricao());
            }
        }
    }

    private void calculandoMedia(){
        double soma =0;
        for (double nota : notas){
            soma+=nota;
        }
        this.media = soma / notas.length;
    }

    private SituacaoAluno validacaoSituacao(){
        if (media >= 7){
            return SituacaoAluno.APROVADO;
        } else if (media >= 5 && media <= 6.9) {
            return SituacaoAluno.EM_RECUPERACAO;
        }else {
            return SituacaoAluno.REPROVADO;
        }
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        validacaoMatricula(matricula);
        this.matricula = matricula;
    }

    public double[] getNotas() {
        return notas;
    }

    public void setNotas(double[] notas) {
        validacaoNotas(notas);
        this.notas = notas;
        calculandoMedia();
        this.situacaoAluno = validacaoSituacao();
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public enum SituacaoAluno{
        APROVADO("Aprovado(a)."),
        EM_RECUPERACAO("Em recuperação."),
        REPROVADO("Reprovado.");

        private final String descricao;

        SituacaoAluno(String descricao){
            this.descricao = descricao;
        }

        public String getDescricao(){
            return descricao;
        }
    }

    @Override
    public String toString() {
        return super.toString()+String.format(" |Matrícula: %d |Média: %.2f |Situação: %s",matricula,media,situacaoAluno.getDescricao());
    }
}
