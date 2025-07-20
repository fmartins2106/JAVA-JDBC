package academy.devdojo.maratonajava.javacore.heranca.dominio;

public class Aluno11 extends Pessoa11{
    private int matricula;
    private double[] notas = new double[4];
    private double media;
    private String situacao;

    public Aluno11(String nome, int idade, String cpf, int matricula, double[] notas) {
        super(nome, idade, cpf);
        setMatricula(matricula);
        setNotas(notas);
    }

    public static final String MENSAGEM_ERRO_MATRICULA = "Matricula não pode ser menor que 1.";
    public static final int MENOR_NUMERO_MATRICULA = 1;
    public static final String MENSAGEM_ERRO_NOTA = "Nota não pode ser menor que zero ou maior que dez.";
    public static final double MENOR_NOTA = 0;
    public static final double MAIOR_NOTA = 10;

    private void validacaoMatricula(int matricula){
        if (matricula < MENOR_NUMERO_MATRICULA){
            throw new IllegalArgumentException(MENSAGEM_ERRO_MATRICULA);
        }
    }

    private void validacaoNotas(double[] notas){
        for (double nota : notas){
            if (nota < MENOR_NOTA || nota > MAIOR_NOTA){
                throw new IllegalArgumentException(MENSAGEM_ERRO_NOTA);
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

    private void validacaoSituacao(){
        if (this.media >= 7){
            this.situacao = "APROVADO(A).";
        } else if (this.media >= 5 && this.media <= 6.9) {
            this.situacao =  "EM RECUPERAÇÃO.";
        }else{
            this.situacao = "REPROVADO(A).";
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
        validacaoSituacao();
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    @Override
    public String toString() {
        return super.toString()+String.format(" |Matricula: %d |Média: %.2f |Situação: %s",matricula,media,situacao);
    }
}
