package academy.devdojo.maratonajava.javacore.heranca.dominio;

public class Produto12 {
    private int codigo;
    private String nome;
    private String categoria;
    private int quantidade;
    private double precoCompra;
    private double precoVenda;
    private String fornecedor;

    public Produto12(int codigo, String nome, String categoria, int quantidade, double precoCompra, double precoVenda, String fornecedor) {
        setCodigo(codigo);
        setNome(nome);
        setCategoria(categoria);
        setQuantidade(quantidade);
        setPrecoCompra(precoCompra);
        setPrecoVenda(precoVenda);
        setFornecedor(fornecedor);
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

    public static final int MENOR_CODIGO =1;
    public static final String MENSAGEM_MENOR_CODIGO = "Campo código não pode ser menor que 1.";
    public static final String MENSAGEM_NOME_INVALIDO = "Campo nome não ser vazio ou conter caracteres.";
    public static final String MENSAGEM_CATEGORIA_INVALIDA = "Campo categoria não pode ser vazio ou conter caracteres";
    public static final int QUANTIDADE_MINIMA = 0;
    public static final String MENSAGEM_QUANTIDADE_INVALIDA = "Campo quantidade não pode ser menor que zero.";
    public static final double MENOR_PRECO_COMPRA = 0;
    public static final String MENSAGEM_PRECO_COMPRA_INVALIDO = "Campo preço de compra não pode ser menor que zero.";
    public static final String MENSAGEM_PRECO_VENDA_INVALIDO = "Preço de venda não pode ser menor que preço de compra.";
    public static final String MENSAGEM_FORNECEDOR_INVALIDO = "Campo fornecedor não pode ser vazio ou conter caracteres.";

    public void validandoStrings(String palavra, String MENSAGEM){
        if (palavra == null || palavra.isEmpty() || !palavra.matches("^[\\p{L}\\p{N}]+( [\\p{L}\\p{N}]+)*$")){
            throw new IllegalArgumentException(MENSAGEM);
        }
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        if (codigo < MENOR_CODIGO){
            throw new IllegalArgumentException(MENSAGEM_MENOR_CODIGO);
        }
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        validandoStrings(nome, MENSAGEM_NOME_INVALIDO);
        this.nome = formatoNome(nome);
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        validandoStrings(categoria, MENSAGEM_CATEGORIA_INVALIDA);
        this.categoria = formatoNome(categoria);
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade < QUANTIDADE_MINIMA){
            throw new IllegalArgumentException(MENSAGEM_QUANTIDADE_INVALIDA);
        }
        this.quantidade = quantidade;
    }

    public double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(double precoCompra) {
        if (precoCompra < MENOR_PRECO_COMPRA){
            throw new IllegalArgumentException(MENSAGEM_PRECO_COMPRA_INVALIDO);
        }
        this.precoCompra = precoCompra;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        if (precoVenda < precoCompra){
            throw new IllegalArgumentException(MENSAGEM_PRECO_VENDA_INVALIDO);
        }
        this.precoVenda = precoVenda;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        validandoStrings(fornecedor, MENSAGEM_FORNECEDOR_INVALIDO);
        this.fornecedor = formatoNome(fornecedor);
    }

    @Override
    public String toString(){
        return String.format("Código: %d |Nome: %s |Categoria: %s |Quantidade: %d |Preço compra:R$ %.2f |Preço venda:R$ %.2f |Fornecedor: %s",
                codigo,nome,categoria,quantidade,precoCompra,precoVenda,fornecedor);
    }

}
