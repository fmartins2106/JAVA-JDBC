package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio;



public class Produto03 {
    private String nome;
    private double preco;
    private int quantidade;

    public Produto03(String nome, double preco, int quantidade){
        setNome(nome);
        setPreco(preco);
        setQuantidade(quantidade);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+(\\s[\\p{L}]+)*$")){
            throw new IllegalArgumentException("ERRO. Nome não pode ser nulo, vazio ou conter caracteres. Tente novamente.");
        }
        this.nome = formatandoNome(nome);
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco<=0){
            throw new IllegalArgumentException("Valor não pode ser menor que zero. Tente novamente.");
        }
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade<=0){
            throw new IllegalArgumentException("ERRO. Quantidade não pode ser menor que zero. Tente novamente.");
        }
        this.quantidade = quantidade;
    }

    public void motrandoResultadosProdutos(){
        System.out.println("Nome:"+getNome());
        System.out.println("Preço:R$"+getPreco());
        System.out.println("Quantidade:"+getQuantidade());
        System.out.println("__________________________________________________");
    }

    private static String formatandoNome(String nome){
        String[] palavras = nome.toLowerCase().split("\\s+");
        StringBuilder nomeFormatado = new StringBuilder();
        for (String palavra : palavras){
            nomeFormatado.append(palavra.substring(0,1).toUpperCase()).append(palavra.substring(1)).append(" ");
        }
        return nomeFormatado.toString().trim();
    }
}
