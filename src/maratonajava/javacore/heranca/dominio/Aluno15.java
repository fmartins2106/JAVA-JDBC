package academy.devdojo.maratonajava.javacore.heranca.dominio;

public class Aluno15 extends Pessoa15{
    private int matricula;
    private double[] notas = new double[4];
    private double media;
    private SituacaoNotas situacaoNotas;

    public Aluno15(String nome, String cpf, int idade, int matricula, double[] notas) {
        super(nome, cpf, idade);
        setMatricula(matricula);
        setNotas(notas);
        this.situacaoNotas = getSituacaoNotas();
    }

    public static final int MENOR_MATRICULA = 1;
    public static final double MENOR_NOTA = 0;
    public static final double MAIOR_NOTA = 10;

    private void validacaoMatricula(int matricula){
        if (matricula < MENOR_MATRICULA){
            throw new IllegalArgumentException(ErroPrevisto.ERRO_MATRICULA.getDescricao());
        }
    }

    private void validacaoNotas(double[] notas){
        for (double nota : notas){
            if (nota < MENOR_NOTA || nota > MAIOR_NOTA){
                throw new IllegalArgumentException(ErroPrevisto.ERRO_NOTAS.getDescricao());
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

    private SituacaoNotas validacaoSituacao(){
        if (this.media >= 7){
            return SituacaoNotas.APROVADO;
        }else if (this.media >=5){
            return SituacaoNotas.EM_RECUPERACAO;
        }else {
            return SituacaoNotas.REPROVADO;
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
        this.situacaoNotas = validacaoSituacao();
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public SituacaoNotas getSituacaoNotas() {
        return situacaoNotas;
    }

    public void setSituacaoNotas(SituacaoNotas situacaoNotas) {
        this.situacaoNotas = situacaoNotas;
    }

    public enum SituacaoNotas{
        APROVADO("Aprovado(a)."),
        EM_RECUPERACAO("Em recuperação."),
        REPROVADO("Reprovado(a).");

        private final String descricao;

        SituacaoNotas(String descricao){
            this.descricao = descricao;
        }

        public String getDescricao(){
            return descricao;
        }
    }

    @Override
    public String toString() {
        return super.toString()+String.format(" |Matrícula: %d |Média: %.2f |Situação: %s",matricula,media,situacaoNotas.getDescricao());
    }
}
