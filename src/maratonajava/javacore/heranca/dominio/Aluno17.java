package academy.devdojo.maratonajava.javacore.heranca.dominio;

public class Aluno17 extends Pessoa17{
    private int matricula;
    private double[] notas = new double[4];
    private double media;
    private SituacaoAluno17 situacaoAluno17;

    public Aluno17(String nome, String cpf, int idade, int matricula, double[] notas) {
        super(nome, cpf, idade);
        setMatricula(matricula);
        setNotas(notas);
    }

    public static final int MENOR_NUMERO_MATRICULA = 1;
    public static final double MENOR_NOTA = 0;
    public static final double MAIOR_NOTA = 10;

    private void validacaoMatricula(int matricula){
        if (matricula < MENOR_NUMERO_MATRICULA){
            System.out.println(MensagensErroPessoa17.ERRO_MATRICULA.getDescricao());
        }
    }

    private void validacaoNotas(double[] notas){
        for (double nota : notas){
            if (nota < MENOR_NOTA || nota > MAIOR_NOTA){
                System.out.println(MensagensErroPessoa17.ERRO_NOTAS.getDescricao());
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

    private SituacaoAluno17 validandoSituacao(){
        if (this.media >= 7){
            return SituacaoAluno17.APROVADO;
        } else if (this.media >= 5) {
            return SituacaoAluno17.EM_RECUPERACAO;
        }else {
            return SituacaoAluno17.REPROVADO;
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
        this.situacaoAluno17 = validandoSituacao();
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public SituacaoAluno17 getSituacaoAluno17() {
        return situacaoAluno17;
    }

    public void setSituacaoAluno17(SituacaoAluno17 situacaoAluno17) {
        this.situacaoAluno17 = situacaoAluno17;
    }

    public enum SituacaoAluno17{
        APROVADO("Aprovado(a)."),
        EM_RECUPERACAO("Em recuperação."),
        REPROVADO("Reprovado(a).");

        private final String descricao;

        SituacaoAluno17(String descricao){
            this.descricao = descricao;
        }

        public String getDescricao(){
            return descricao;
        }
    }

    @Override
    public String toString() {
        return super.toString()+String.format(" |Matrícula: %d |Média: %.2f |Situação: %s",matricula,media,situacaoAluno17.getDescricao());
    }
}
