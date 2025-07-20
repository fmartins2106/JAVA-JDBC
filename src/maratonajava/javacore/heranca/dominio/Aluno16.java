package academy.devdojo.maratonajava.javacore.heranca.dominio;

public class Aluno16 extends Pessoa16{
    private int matricula;
    private double[] notas = new double[4];
    private double media;
    private SituacaoAluno16 situacaoAluno16;

    public Aluno16(String nome, String cpf, int idade, int matricula, double[] notas) {
        super(nome, cpf, idade);
        setMatricula(matricula);
        setNotas(notas);
        this.situacaoAluno16 = getSituacaoAluno16();
    }

    public static final double NOTA_MINIMA = 0;
    public static final double NOTA_MAXIMA = 10;
    public static final int MENOR_NUMERO_MATRICULA = 1;

    private void validacaoMatricula(int matricula){
        if (matricula < MENOR_NUMERO_MATRICULA){
            throw new IllegalArgumentException(MensagensValidacaoPessoas16.ERRO_MATRICULA.getDescricao());
        }
    }

    private void validacaoNotas(double[] notas){
        for (double nota : notas){
            if (nota < NOTA_MINIMA || nota > NOTA_MAXIMA){
                throw new IllegalArgumentException(MensagensValidacaoPessoas16.ERRO_NOTAS.getDescricao());
            }
        }
    }

    private void calculandoNota(){
        double soma =0;
        for (double nota : notas){
            soma+=nota;
        }
        this.media = soma / notas.length;
    }

    private SituacaoAluno16 validandoSituacao(){
        if (this.media >= 7){
            return SituacaoAluno16.APROVADO;
        }else if (this.media >= 5){
            return SituacaoAluno16.EM_RECUPERACAO;
        }else {
            return SituacaoAluno16.REPROVADO;
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
        calculandoNota();
        this.situacaoAluno16 = validandoSituacao();

    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public SituacaoAluno16 getSituacaoAluno16() {
        return situacaoAluno16;
    }

    public void setSituacaoAluno16(SituacaoAluno16 situacaoAluno16) {
        this.situacaoAluno16 = situacaoAluno16;
    }

    public enum ValidacaoErrosAluno16{
        ERRO_NOME("Campo nome não pode ser vazio ou conter caracateres."),
        ERRO_CPF("CPF inválido."),
        ERRO_IDADE("Idade não pode ser menor que 6.");

        private final String descricao;

        ValidacaoErrosAluno16(String descricao){
            this.descricao = descricao;
        }

        public String getDescricao(){
            return descricao;
        }
    }

    public enum SituacaoAluno16{
        APROVADO("Aprovado(a)."),
        EM_RECUPERACAO("Em recuperação."),
        REPROVADO("Reprovado(a).");

        private final String descricao;

        SituacaoAluno16(String descricao){
            this.descricao = descricao;
        }

        public String getDescricao(){
            return descricao;
        }
    }

    @Override
    public String toString(){
        return super.toString()+String.format(" |Matrícula: %d |Média: %.2f |Situação: %s",matricula,media,situacaoAluno16.getDescricao());
    }

}
