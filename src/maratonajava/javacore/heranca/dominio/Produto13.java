package academy.devdojo.maratonajava.javacore.heranca.dominio;

public class Produto13 {
    private int codigo;
    private String nome;
    private String categoria;
    private int quantidade;
    private double precoCompra;
    private double precoVenda;
    private String fornecedor;

    public Produto13(int codigo, String nome, String categoria, int quantidade, double precoCompra, double precoVenda, String fornecedor) {
        setCodigo(codigo);
        setNome(nome);
        setCategoria(categoria);
        setQuantidade(quantidade);
        setPrecoCompra(precoCompra);
        setPrecoVenda(precoVenda);
        setFornecedor(fornecedor);
    }

    public static final int CODIGO_MINIMO = 1;
    public static final String MENSAGEM_ERRO_CODIGO = "Código não pode ser menor que 1.";
    public static final String MENSAGEM_ERRO_NOME = "Campo nome não pode ser vazio ou conter caracteres. Digite nome completo";
    public static final String MENSAGEM_ERRO_CATEGORIA = "Campo categoria não pode ser vazio ou conter caracteres.";
    public static final int QUANTIDADE_MINIMA = 0;
    public static final String MENSAGEM_ERRO_QUANT_MINIMA = "Quantidade não pode ser menor que zero.";
    public static final double MINIMO_PRECO_COMPRA = 0;
    public static final String MENSAGEM_ERRO_PRECO_COMPRA = "Preço de compra não pode ser menor que zero.";
    public static final String MENSAGEM_ERRO_PRECO_VENDA = "Preço de venda não pode ser menor que preço de compra.";
    public static final String MENSAGEM_ERRO_FORNECEDOR = "Campo fornecedor não pode ser vazio ou conter caracteres.";

    public static String formatoNome(String nome){
        String[] palavras  = nome.toLowerCase().split("\\s+");
        StringBuilder nomeFormatado = new StringBuilder();
        for (String palavra : palavras){
            nomeFormatado.append(palavra.substring(0,1).toUpperCase())
                    .append(palavra.substring(1))
                    .append(" ");
        }
        return nomeFormatado.toString().trim();
    }

    private void validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}\\p{N}]+( [\\p{L}\\p{N}]+)+$")){
            throw new IllegalArgumentException(MENSAGEM_ERRO_NOME);
        }
    }

    private void validacaoCategoria(String categoria){
        if (categoria == null || categoria.isEmpty() || !categoria.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException(MENSAGEM_ERRO_CATEGORIA);
        }
    }

    private void validacaoFornecedor(String fornecedor){
        if (fornecedor == null || fornecedor.isEmpty() || !fornecedor.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException(MENSAGEM_ERRO_FORNECEDOR);
        }
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        if (codigo < CODIGO_MINIMO){
            throw new IllegalArgumentException(MENSAGEM_ERRO_CODIGO);
        }
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        validacaoNome(nome);
        this.nome = formatoNome(nome);
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        validacaoCategoria(categoria);
        this.categoria = formatoNome(categoria);
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade < QUANTIDADE_MINIMA){
            throw new IllegalArgumentException(MENSAGEM_ERRO_QUANT_MINIMA);
        }
        this.quantidade = quantidade;
    }

    public double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(double precoCompra) {
        if (precoCompra < MINIMO_PRECO_COMPRA){
            throw new IllegalArgumentException(MENSAGEM_ERRO_PRECO_COMPRA);
        }
        this.precoCompra = precoCompra;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        if (precoVenda < precoCompra){
            throw new IllegalArgumentException(MENSAGEM_ERRO_PRECO_VENDA);
        }
        this.precoVenda = precoVenda;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        validacaoFornecedor(fornecedor);
        this.fornecedor = formatoNome(fornecedor);
    }

    @Override
    public String toString() {
        return String.format("Código: %d |Nome: %s |Categoria: %s |Quantidade: %d |Preço compra:R$ %.2f |Preço venda:R$ %.2f |Fornecedor: %s",
                codigo,nome,categoria,quantidade,precoCompra, precoVenda,fornecedor);
    }
}
