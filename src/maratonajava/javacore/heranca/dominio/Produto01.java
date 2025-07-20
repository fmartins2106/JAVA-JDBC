package academy.devdojo.maratonajava.javacore.heranca.dominio;

public class Produto01 {
    private int codigo;
    private String nome;
    private String categoria;
    private int quantidade;
    private double precoCompra;
    private double precoVenda;
    private String fornecedor;

    public Produto01(int codigo, String nome, String categoria, int quantidade, double precoCompra, double precoVenda, String fornecedor) {
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
            throw new IllegalArgumentException("Código precisa ser maior que zero.");
        }
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}\\p{N}]+( [\\p{L}]\\p{N}+)+$")){
            throw new IllegalArgumentException("Campo nome não pode ficar vazio ou conter caracteres.");
        }
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        validandoFornecedorCategoria(categoria);
        this.categoria = categoria;
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
        validandoPreco();
        this.precoVenda = precoVenda;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        validandoFornecedorCategoria(fornecedor);
        this.fornecedor = formatoNome(fornecedor);
    }

    public boolean validandoPrecoVendaCompra(){
        return precoCompra > precoVenda;
    }

    private void validandoPreco(){
        if (precoCompra > precoVenda){
            throw new IllegalArgumentException("Preço de compra não pode ser maior que preço de venda.");
        }
    }

    private void validandoFornecedorCategoria(String palavra){
        if ( palavra == null || palavra.isEmpty() || !palavra.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException("Campo não pode ficar vazio ou conter caracteres.");
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
        return String.format("Código: %d |Nome: %s |Categoria: %s |Quantidade: %d |Preço compra: %.2f |Preço venda: %.2f |Fornecedor: %s",getCodigo(),getNome(),getCategoria(),getQuantidade(), getPrecoCompra(),getPrecoVenda(),getFornecedor());
    }
}
