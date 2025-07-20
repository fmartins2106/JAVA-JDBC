package academy.devdojo.maratonajava.javacore.heranca.dominio;

public class Produto17 {
    private int codigo;
    private String nome;
    private String categoria;
    private int quantidade;
    private double precoCompra;
    private double precoVenda;
    private String fornecedor;

    public Produto17(int codigo, String nome, String categoria, int quantidade, double precoCompra, double precoVenda, String fornecedor) {
        setCodigo(codigo);
        setNome(nome);
        setCategoria(categoria);
        setQuantidade(quantidade);
        setPrecoCompra(precoCompra);
        setPrecoVenda(precoVenda);
        setFornecedor(fornecedor);
    }

    public static final int CODIGO_MINIMO = 1;
    public static final int QUANTIDADE_MINIMA = 0;
    public static final double PRECO_COMPRA = 0;

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

    private void validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}\\p{N}]+( [\\p{L}\\p{N}]+)+$")){
            throw new IllegalArgumentException(MensagemValidacaoProduto17.ERRO_NOME.getDescricao());
        }
    }

    private void validacaoCodigo(int codigo){
        if (codigo < CODIGO_MINIMO){
            throw new IllegalArgumentException(MensagemValidacaoProduto17.ERRO_CODIGO.getDescricao());
        }
    }

    private void validacaoCategoria(String categoria){
        if (categoria == null || categoria.isEmpty() || !categoria.matches("^[\\p{L}]+( [\\p{L}]}+)*$")){
            throw new IllegalArgumentException(MensagemValidacaoProduto17.ERR0_CATEGORIA.getDescricao());
        }
    }

    private void validacaoQuantidade(int quantidade){
        if (quantidade < QUANTIDADE_MINIMA){
            throw new IllegalArgumentException(MensagemValidacaoProduto17.ERRO_QUANTIDADE.getDescricao());
        }
    }

    private void validacaoPrecoCompra(double precoCompra){
        if (precoCompra < PRECO_COMPRA){
            throw new IllegalArgumentException(MensagemValidacaoProduto17.ERRO_PRECO_COMPRA.getDescricao());
        }
    }

    private void validacaoPrecoVenda(double precoVenda, double precoCompra){
        if (precoVenda < precoCompra){
            throw new IllegalArgumentException(MensagemValidacaoProduto17.ERRO_PRECO_VENDA.getDescricao());
        }
    }

    private void validacaoFornecedor(String fornecedor){
        if (fornecedor == null || fornecedor.isEmpty() || !fornecedor.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException(MensagemValidacaoProduto17.ERRO_FORNECEDOR.getDescricao());
        }
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        validacaoCodigo(codigo);
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
        validacaoQuantidade(quantidade);
        this.quantidade = quantidade;
    }

    public double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(double precoCompra) {
        validacaoPrecoCompra(precoCompra);
        this.precoCompra = precoCompra;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        validacaoPrecoVenda(precoVenda, precoCompra);
        this.precoVenda = precoVenda;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        validacaoFornecedor(fornecedor);
        this.fornecedor = formatoNome(fornecedor);
    }

    public enum MensagemValidacaoProduto17{
        ERRO_NOME("Campo nome não pode ser vazio ou conter caracteres."),
        ERRO_CODIGO("Codigo não pode ser menor que 1."),
        ERRO_ESTOQUE_MINIMO("Estoque mínimo não pode ser menor que 50."),
        ERRO_QUANTIDADE("Quantidade não pode ser menor que zero."),
        ERR0_CATEGORIA("Campo categoria não pode ser vazio ou conter caracteres."),
        ERRO_PRECO_COMPRA("Preço compra não pode ser menor que zero."),
        ERRO_PRECO_VENDA("Preço de venda não poed ser menor que preço de compra."),
        ERRO_FORNECEDOR("Campo fornecedor não pode zer vazio ou conter caracteres.");

        private final String descricao;

        MensagemValidacaoProduto17(String descricao){
            this.descricao = descricao;
        }

        public String getDescricao(){
            return descricao;
        }
    }

    @Override
    public String toString(){
        return String.format("Código: %d |Nome: %s |Categoria: %s |Quantidade: %d |Preço compra:R$ %.2f |Preço venda:R$ %.2f |Fornecedor: %s",
                codigo,nome,categoria,quantidade,precoCompra,precoVenda,fornecedor);
    }


}
