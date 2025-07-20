package academy.devdojo.maratonajava.javacore.heranca.dominio;

public class Aluno13 extends Pessoa13{
    private int matricula;
    private double[] notas = new double[4];
    private double media;
    private SituacaoAcademia13 situacaoAcademia13;

    public Aluno13(String nome, String cpf, int idade, int matricula, double[] notas) {
        super(nome, cpf, idade);
        setMatricula(matricula);
        setNotas(notas);
        this.situacaoAcademia13 = validacaoSituacao13();
    }

    public static final int MENOR_NUMERO_MATRICULA = 1;
    public static final double MENOR_NOTA = 0;
    public static final double MAIOR_NOTA =10;

    private void validacaoMatricula(int matricula){
        if (matricula < MENOR_NUMERO_MATRICULA){
            throw new IllegalArgumentException(MensagensDeErros.ERRO_MATRICULA.getDescricao());
        }
    }

    private void validacaoNotas(double[] notas){
        for (double nota : notas){
            if (nota < MENOR_NOTA || nota > MAIOR_NOTA){
                throw new IllegalArgumentException(MensagensDeErros.ERRO_NOTAS.getDescricao());
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

    private SituacaoAcademia13 validacaoSituacao13(){
        if (this.media >= 7){
            return SituacaoAcademia13.APROVADO;
        } else if (this.media >=5 && this.media <= 6.9) {
            return SituacaoAcademia13.EM_RECUPERACAO;
        }else {
            return SituacaoAcademia13.REPROVADO;
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
        this.situacaoAcademia13 = validacaoSituacao13();
    }

    @Override
    public String toString() {
        return super.toString()+String.format(" |Matrícula: %d |Média: %.2f",matricula,media);
    }

    public enum SituacaoAcademia13{
        APROVADO("Aprovado(a)."),
        REPROVADO("Reprovado(a)."),
        EM_RECUPERACAO("Em Recuperação.");

        public final String decricao;

        SituacaoAcademia13(String decricao){
            this.decricao = decricao;
        }

        public String getDecricao(){
            return decricao;
        }

    }

}
