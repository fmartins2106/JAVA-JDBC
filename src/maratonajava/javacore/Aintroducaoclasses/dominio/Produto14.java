package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio;

public class Produto14 {
    private int codigo;
    private String nome;
    private String categoria;
    private double valor;
    private int quantidade;
    private int estoqueMinimo;

    public Produto14(int codigo, String nome, String categoria, double valor, int quantidade, int estoqueMinimo){
        setCodigo(codigo);
        setNome(nome);
        setCategoria(categoria);
        setValor(valor);
        setQuantidade(quantidade);
        setEstoqueMinimo(estoqueMinimo);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        if (codigo <= 0){
            throw new IllegalArgumentException("Código não pode ser menor que zero.");
        }
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            throw new IllegalArgumentException("Digite nome completo sem caracateres.");
        }
        this.nome = formatoNome(nome);
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        if (categoria == null || categoria.isEmpty() || !categoria.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException("Campo categoria não pode ser vazio ou conter caracteres.");
        }
        this.categoria = formatoNome(categoria);
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        if (valor < 0 || valor > 10000){
            throw new IllegalArgumentException("Valor não pode ser menor que zero ou maior que R$10.000,00");
        }
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade < 0 ){
            throw new IllegalArgumentException("Quantidade não pode ser menor que zero.");
        }
        this.quantidade = quantidade;
    }

    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(int estoqueMinimo) {
        if (estoqueMinimo < 50){
            throw new IllegalArgumentException("Estoque mínimo não pode ser menor que 50.");
        }
        this.estoqueMinimo = estoqueMinimo;
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
    public boolean estoqueBaixo(){
        return quantidade < estoqueMinimo;
    }

    @Override
    public String toString(){
        return String.format("Código: %d |Nome: %s |Categoria: %s |Valor: %.2f |Quantidade: %d |Estoque mínimo: %d",getCodigo(),getNome(),getCategoria(),getValor(),getQuantidade(),getEstoqueMinimo());
    }
}
