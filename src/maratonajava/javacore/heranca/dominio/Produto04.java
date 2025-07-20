package academy.devdojo.maratonajava.javacore.heranca.dominio;

public class Produto04 {
    private int codigo;
    private String nome;
    private String categoria;
    private double precoCompra;
    private double precoVenda;
    private int quantidade;
    private String fornecedor;

    public Produto04(int codigo, String nome, String categoria, double precoCompra, double precoVenda, int quantidade, String fornecedor) {
        this.codigo = codigo;
        this.nome = nome;
        this.categoria = categoria;
        this.precoCompra = precoCompra;
        this.precoVenda = precoVenda;
        this.quantidade = quantidade;
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
        validandoFormatoEntradaPalavra(nome);
        this.nome = formatoNome(nome);
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        validandoFormatoEntradaPalavra(categoria);
        this.categoria = formatoNome(categoria);
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
        if (precoVenda < precoCompra){
            throw new IllegalArgumentException("Preço de venda não pode ser menor que zero.");
        }
        this.precoVenda = precoVenda;
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

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        validandoFormatoEntradaPalavra(fornecedor);
        this.fornecedor = formatoNome(fornecedor);
    }

    public void validandoFormatoEntradaPalavra(String palavra){
        if (palavra == null || palavra.isEmpty() || !palavra.matches("^[\\p{P}\\p{N}]+( [\\p{P}\\p{N}]+)+$")){
            throw new IllegalArgumentException("Campo "+palavra+" não pode ser vazio, conter caracteres. Digite descrição completa.");
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
        return String.format("Código: %d |Nome: %s |Categoria: %s |Preço compra:R$ %.2f |Preço venda:R$ %.2f |Quantidade: %d |Fornecedor: %s",
                codigo,nome,categoria,precoCompra,precoVenda,quantidade,fornecedor);
    }

}
