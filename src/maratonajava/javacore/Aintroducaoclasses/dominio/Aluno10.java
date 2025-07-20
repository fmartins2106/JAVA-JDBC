package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio;

public class Aluno10 implements Cloneable{
    private String nome;
    private double nota1;
    private double nota2;
    private double media;
    private String situacao;

    public Aluno10(String nome, double nota1, double nota2){
        setNome(nome);
        setNota1(nota1);
        setNota2(nota2);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            throw new IllegalArgumentException("Digite nome completo sem caracteres.");
        }
        this.nome = formatoNome(nome);
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        validandoNotas(nota1);
        this.nota1 = nota1;
        calculandoMedia();
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        validandoNotas(nota2);
        this.nota2 = nota2;
        calculandoMedia();
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
    private static final double MAX_NOTA =10;
    private static final double MIN_NOTA=0;
    private void validandoNotas(double nota){
        if (nota < MIN_NOTA || nota > MAX_NOTA){
            throw new IllegalArgumentException("Nota não pode ser menor que zero e maior que dez.");
        }
    }

    private void calculandoMedia(){
        this.media = (nota1+nota2)/2;
        validandoSituacao();
    }

    private void validandoSituacao(){
        if (media >=7){
            this.situacao = "APROVADO(A)";
        } else if (media>=5 && media <=6.9) {
            this.situacao = "EM RECUPERAÇÃO";
        }else {
            this.situacao = "REPROVADO(A)";
        }
    }

    public static String formatoNome(String nome){
        String[] palavras = nome.toLowerCase().split("\\s+");
        StringBuilder formatandoNome = new StringBuilder();
        for (String palavra : palavras){
            formatandoNome.append(palavra.substring(0,1).toUpperCase())
                    .append(palavra.substring(1))
                    .append(" ");
        }
        return formatandoNome.toString().trim();
    }
    @Override
    public Aluno10 clone(){
        try {
            return (Aluno10) super.clone();
        }catch (CloneNotSupportedException e){
            throw new AssertionError("Erro na clonagem.");
        }
    }
}
