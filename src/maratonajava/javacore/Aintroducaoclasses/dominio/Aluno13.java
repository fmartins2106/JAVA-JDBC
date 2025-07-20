package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio;

public class Aluno13 implements Cloneable{
    private String nome;
    private double nota1;
    private double nota2;
    private double media;
    private String situacao;

    public Aluno13(String nome, double nota1, double nota2){
        setNome(nome);
        setNota1(nota1);
        setNota2(nota2);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty() || !nome.matches("[\\p{L}]+( [\\p{L}]+)+$")){
            throw new IllegalArgumentException("Digite seu nome completo sem adição de caracteres.");
        }
        this.nome = formatoNome(nome);
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        validandoNota(nota1);
        this.nota1 = nota1;
        calculoMedia();
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        validandoNota(nota2);
        this.nota2 = nota2;
        calculoMedia();
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

    private static final double MAX_NOTA = 10;
    private static final double MIN_NOTA = 0;
    private void validandoNota(double nota){
        if (nota < MIN_NOTA || nota > MAX_NOTA){
            throw new IllegalArgumentException("Para nota ser válida precisa estar entre 0 e 10.");
        }
    }

    private void calculoMedia(){
        this.media = (nota1+nota2)/2;
        validandoSituacaoAluno();
    }

    private void validandoSituacaoAluno(){
        if (media >=7){
            this.situacao = "Aprovado(a).";
        }else if (media >=5 && media <=6.9){
            this.situacao = "Em recuperação";
        }else {
            this.situacao = "Reprovado(a)";
        }
    }

    public static String formatoNome(String nome){
        String[] palavras = nome.toLowerCase().split("\\s+");
        StringBuilder nomeFormatado = new StringBuilder();
        for (String palavra : palavras){
            nomeFormatado.append(palavra.substring(0,1).toUpperCase())
                    .append(palavra.substring(1))
                    .append(" ");
        }
        return nomeFormatado.toString().trim();
    }

    @Override
    public Aluno13 clone(){
        try {
            return (Aluno13) super.clone();
        }catch (CloneNotSupportedException e){
            throw new AssertionError("Clonagem não realizada.");
        }
    }
}
