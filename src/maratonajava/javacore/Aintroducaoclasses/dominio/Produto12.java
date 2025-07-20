package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio;

public class Produto12 implements Cloneable{
    private String nome;
    private double valor;
    private String categoria;

    public Produto12(String nome, double valor, String categoria){
        setNome(nome);
        setValor(valor);
        setCategoria(categoria);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            throw new IllegalArgumentException("Digite nome completo. Campo nome não pode ser vazio ou conter caracteres.");
        }
        this.nome = formatoNome(nome);
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        if (valor  < 0 || valor > 10000){
            throw new IllegalArgumentException("Digite um valor maior que zero e menor que R$10.000");
        }
        this.valor = valor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        if (categoria == null || categoria.isEmpty() || !categoria.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException("Campo categoria não pode estar vazio ou conter caracteres.");
        }
        this.categoria = formatoNome(categoria);
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
    public Produto12 clone(){
        try {
            return (Produto12) super.clone();
        }catch (CloneNotSupportedException e){
            throw new AssertionError("Erro na clonagem.");
        }
    }

}
