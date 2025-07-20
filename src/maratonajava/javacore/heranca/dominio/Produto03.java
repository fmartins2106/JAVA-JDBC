package academy.devdojo.maratonajava.javacore.heranca.dominio;

public class Produto03 {
    private int codigo;
    private String nome;
    private String categoria;
    private int quantidade;
    private double precoCompra;
    private double precoVenda;
    private String fornecedor;

    public Produto03(int codigo, String nome, String categoria, int quantidade, double precoCompra, double precoVenda, String fornecedor) {
        this.codigo = codigo;
        this.nome = nome;
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.precoCompra = precoCompra;
        this.precoVenda = precoVenda;
        this.fornecedor = fornecedor;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        if (codigo < 1){
            throw new IllegalArgumentException("Código não pode ser menor que 1.");
        }
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        validandoString(nome);
        this.nome = formatoNome(nome);
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        validandoString(categoria);
        this.categoria = formatoNome(categoria);
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade < 0){
            throw new IllegalArgumentException("Quantidade não pode ser menor que zero.");
        }
        this.quantidade = quantidade;
    }

    public double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(double precoCompra) {
        if (precoCompra < 0){
            throw new IllegalArgumentException("Preço de compra não pode ser menor que zero.");
        }
        this.precoCompra = precoCompra;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        validandoPrecoVenda(precoCompra);
        this.precoVenda = precoVenda;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        validandoString(fornecedor);
        this.fornecedor = formatoNome(fornecedor);
    }

    private void validandoPrecoVenda(double precoCompra){
        if (precoVenda < precoCompra){
            throw new IllegalArgumentException("Preço de venda não pode ser menor que preço de compra.");
        }
    }

    private void validandoString(String palavra){
        if (palavra.isEmpty() || !palavra.matches("^[\\p{L}\\p{N}]+( [\\p{L}\\p{N}]+)*$")){
            throw new IllegalArgumentException("Campo "+palavra+" não pode ser vazio ou conter caracteres. Digite descrição completa.");
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
    public String toString(){
        return String.format("Código: %d |Nome: %s |Categoria: %s |Quantidade: %d |Preço compra:R$%.2f |Preço venda: R$%.2f |Fornecedor: %s",
                codigo,nome,categoria,quantidade,precoCompra,precoVenda,fornecedor);
    }

}
