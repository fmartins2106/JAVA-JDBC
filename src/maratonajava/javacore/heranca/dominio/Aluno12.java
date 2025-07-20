package academy.devdojo.maratonajava.javacore.heranca.dominio;

public class Aluno12 extends Pessoa12{
    private int matricula;
    private double[] notas = new double[4];
    private double media;
    private SituacaoAcademia situacaoAcademia;

    public Aluno12(String nome, String cpf, int idade, int matricula, double[] notas) {
        super(nome, cpf, idade);
        setMatricula(matricula);
        setNotas(notas);
        calculandoMedia();
        this.situacaoAcademia = validacaoSituacao();
    }

    public static final int MENOR_MATRICULA = 1;
    public static final double NOTA_MINIMA = 0;
    public static final double NOTA_MAXIMA = 10;


    private void validacaoMatricula(int matricula){
        if (matricula < MENOR_MATRICULA){
            throw new IllegalArgumentException(validationMessage.ERRO_MATRICULA.getDescricao());
        }
    }

    private void validacaoNotas(double[] notas){
        for (double nota : notas){
            if (nota < NOTA_MINIMA || nota > NOTA_MAXIMA){
                throw new IllegalArgumentException(validationMessage.ERRO_NOTAS.getDescricao());
            }
        }
    }

    private void calculandoMedia(){
        double soma=0;
        for (double nota : notas){
            soma+=nota;
        }

        this.media = soma / notas.length;
    }

    private SituacaoAcademia validacaoSituacao(){
        if (this.media >= 7){
            return SituacaoAcademia.APROVADO;
        } else if (this.media >= 5 && this.media <=6.9) {
            return SituacaoAcademia.EM_RECUPERACAO;
        }else {
            return SituacaoAcademia.REPROVADO;
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
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
        this.situacaoAcademia = validacaoSituacao();
    }

    @Override
    public String toString() {
        return super.toString()+String.format(" |Matrícula: %d |Média: %.2f |Situação: %s",matricula,media,situacaoAcademia.getDescricao());
    }

    public enum SituacaoAcademia{
        APROVADO("Aprovado(a)."),
        EM_RECUPERACAO("Em recuperação."),
        REPROVADO("Reprovado(a).");

        private String descricao;

        SituacaoAcademia(String descricao){
            this.descricao = descricao;
        }

        public String getDescricao(){
            return descricao;
        }
    }
}
