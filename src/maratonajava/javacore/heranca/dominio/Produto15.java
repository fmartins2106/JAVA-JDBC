package academy.devdojo.maratonajava.javacore.heranca.dominio;

public class Produto15 {
    private int codigo;
    private String nome;
    private String categoria;
    private int quantidade;
    private double precoCompra;
    private double precoVenda;
    private String formecedor;

    public Produto15(int codigo, String nome, String categoria, int quantidade, double precoCompra, double precoVenda, String formecedor) {
        setCodigo(codigo);
        setNome(nome);
        setCategoria(categoria);
        setQuantidade(quantidade);
        setPrecoCompra(precoCompra);
        setPrecoVenda(precoVenda);
        setFormecedor(formecedor);
    }

    public static final String MENSAGEM_ERRO_CODIGO = "Código não pode ser menor que 1.";
    public static final String MENSAGEM_ERRO_NOME = "Campo nome não pode ser vazio ou conter caracteres.";
    public static final String MENSAGEM_ERRO_CATEGORIA = "Campo categoria não pode ser vazio ou conter caracteres.";
    public static final String MENSAGEM_ERRO_QUANTIDADE = "Quantidade não pode ser menor que 0.";
    public static final String MENSAGEM_ERRO_PRECO_COMPRA = "Preço de compra não pode ser menor que 0.";
    public static final String MENSAGEM_ERRO_PRECO_VENDA = "Preço de venda não pode ser menor que preço de compra.";
    public static final String MENSAGEM_ERRO_FORNECEDOR = "Campo fornecedor não pode ser vazio ou conter caracteres.";
    public static final int QUANTIDADE_MINIMA = 0;
    public static final double PRECO_COMPRA_MINIMO = 0;
    public static final int CODIGO_MINIMO = 1;

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
            throw new IllegalArgumentException(MENSAGEM_ERRO_NOME);
        }
    }

    private void  validacaoCodigo(int codigo){
        if (codigo < CODIGO_MINIMO){
            throw new IllegalArgumentException(MENSAGEM_ERRO_CODIGO);
        }
    }

    private void validacaoCategoria(String categoria){
        if (categoria == null || categoria.isEmpty() || !categoria.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException(MENSAGEM_ERRO_CATEGORIA);
        }
    }

    private void validacaoQuantidade(int quantidade){
        if (quantidade < QUANTIDADE_MINIMA){
            throw new IllegalArgumentException(MENSAGEM_ERRO_QUANTIDADE);
        }
    }

    private void validacaoPrecoCompra(double precoCompra){
        if (precoCompra < PRECO_COMPRA_MINIMO){
            throw new IllegalArgumentException(MENSAGEM_ERRO_PRECO_COMPRA);
        }
    }

    private void validacaoPrecoVenda(double precoVenda, double precoCompra){
        if (precoVenda < precoCompra){
            throw new IllegalArgumentException(MENSAGEM_ERRO_PRECO_VENDA);
        }
    }

    private void validacaoFornecedor(String formecedor){
        if (formecedor == null || formecedor.isEmpty() || !formecedor.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException(MENSAGEM_ERRO_FORNECEDOR);
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
        validacaoPrecoVenda(precoVenda,precoCompra);
        this.precoVenda = precoVenda;
    }

    public String getFormecedor() {
        return formecedor;
    }

    public void setFormecedor(String formecedor) {
        validacaoFornecedor(formecedor);
        this.formecedor = formecedor;
    }

    @Override
    public String toString() {
        return "Produto15{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", categoria='" + categoria + '\'' +
                ", quantidade=" + quantidade +
                ", precoCompra=" + precoCompra +
                ", precoVenda=" + precoVenda +
                ", formecedor='" + formecedor + '\'' +
                '}';
    }

}
