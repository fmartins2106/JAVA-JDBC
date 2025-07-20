package academy.devdojo.maratonajava.javacore.heranca.dominio;

public class Produto10 {
    private int codigo;
    private String nome;
    private String categoria;
    private int quantidade;
    private double precoCompra;
    private double precoVenda;
    private String fornecedor;

    public Produto10(int codigo, String nome, String categoria, int quantidade, double precoCompra, double precoVenda, String fornecedor) {
        setCodigo(codigo);
        setNome(nome);
        setCategoria(categoria);
        setQuantidade(quantidade);
        setPrecoCompra(precoCompra);
        setPrecoVenda(precoVenda);
        setFornecedor(fornecedor);
    }

    public int getCodigo() {
        return codigo;
    }

    public static final int CODIGO_MINIMO = 1;
    public void setCodigo(int codigo) {
        if (codigo < CODIGO_MINIMO){
            throw new IllegalArgumentException("Código não pode ser menor que "+CODIGO_MINIMO);
        }
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        validandoPalavras(nome);
        this.nome = formatoNome(nome);
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        validandoPalavras(categoria);
        this.categoria = formatoNome(categoria);
    }

    public int getQuantidade() {
        return quantidade;
    }

    public static final int QUANTIDADE_MINIMA =0;
    public void setQuantidade(int quantidade) {
        if (quantidade < QUANTIDADE_MINIMA){
            throw new IllegalArgumentException("Quantidade não pode ser menor que "+ QUANTIDADE_MINIMA);
        }
        this.quantidade = quantidade;
    }

    public double getPrecoCompra() {
        return precoCompra;
    }

    public static final double PRECO_MINIMO_COMPRA =0;
    public void setPrecoCompra(double precoCompra) {
        if (precoCompra < PRECO_MINIMO_COMPRA){
            throw new IllegalArgumentException("Preço de compra não pode ser menor que "+PRECO_MINIMO_COMPRA);
        }
        this.precoCompra = precoCompra;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        if (precoVenda < precoCompra){
            throw new IllegalArgumentException("Preço de compra não pode ser menor que preço de venda.");
        }
        this.precoVenda = precoVenda;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        validandoPalavras(fornecedor);
        this.fornecedor = formatoNome(fornecedor);
    }

    private void validandoPalavras(String palavra){
        if (palavra == null || palavra.isEmpty() || !palavra.matches("^[\\p{L}\\p{N}]+( [\\p{L}\\p{N}]+)+$")){
            throw new IllegalArgumentException("Campo não pode ser vazio ou conter caracteres, digite descrição completa.");
        }
    }

    public static String formatoNome(String nomes ){
        String[] palavras = nomes.toLowerCase().split("\\s+");
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
        return String.format("Código: %d |Nome: %s |Categoria: %s |Quantidade: %d |Preço compra:R$ %.2f |Preço venda:R$ %.2f |Fornecedor: %s",
                codigo,nome,categoria,quantidade,precoCompra,precoVenda,fornecedor);
    }
}


