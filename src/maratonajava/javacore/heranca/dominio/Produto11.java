package academy.devdojo.maratonajava.javacore.heranca.dominio;

public class Produto11 {
    private int codigo;
    private String nome;
    private String categoria;
    private int quantidade;
    private double precoCompra;
    private double precoVenda;
    private String fornecedor;

    public Produto11(int codigo, String nome, String categoria, int quantidade, double precoCompra, double precoVenda, String fornecedor) {
        setCodigo(codigo);
        setNome(nome);
        setCategoria(categoria);
        setQuantidade(quantidade);
        setPrecoCompra(precoCompra);
        setPrecoVenda(precoVenda);
        setFornecedor(fornecedor);
    }

    public static final int MENOR_CODIGO = 1;
    public static final int MENOR_QUANTIDADE = 0;
    public static final double MENOR_PRECO_COMPRA = 0;
    public static final String TEXTO_DESCRICAO = "Campo não pode ficar vazio ou conter caracteres. Digite descrição completa";
    public static final String TEXTO_PARA_CODIGO ="Código não pode ser menor que "+MENOR_CODIGO+".";
    public static final String TEXTO_PARA_QUANTIDADE = "Quantidade não pode ser menor que "+MENOR_QUANTIDADE+".";
    public static final String TEXTO_PARA_VALOR_COMPRA = "Preço de compra não pode ser menor que "+MENOR_PRECO_COMPRA+".";
    public static final String TEXTO_PARA_VALOR_VENDA ="Preço de venda não pode ser menor que preço de compra.";

    public void validandoString(String palavra){
        if (palavra == null || palavra.isEmpty() || !palavra.matches("^[\\p{L}\\p{N}]+( [\\p{L}\\p{N}]+)*$")){
            throw new IllegalArgumentException(TEXTO_DESCRICAO);
        }
    }


    public int getCodigo() {
        return codigo;
    }


    public void setCodigo(int codigo) {
        if ( codigo < MENOR_CODIGO){
            throw new IllegalArgumentException(TEXTO_PARA_CODIGO);
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
        if (quantidade < MENOR_QUANTIDADE){
            throw new IllegalArgumentException(TEXTO_PARA_QUANTIDADE);
        }
        this.quantidade = quantidade;
    }

    public double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(double precoCompra) {
        if (precoCompra < MENOR_PRECO_COMPRA){
            throw new IllegalArgumentException(TEXTO_PARA_VALOR_COMPRA);
        }
        this.precoCompra = precoCompra;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        if (precoVenda < precoCompra){
            throw new IllegalArgumentException(TEXTO_PARA_VALOR_VENDA);
        }
        this.precoVenda = precoVenda;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        validandoString(fornecedor);
        this.fornecedor = formatoNome(fornecedor);
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
        return String.format("Código: %d |Nome: %s |Categoria: %s |Quantidade: %d |Preço de compra:R$ %.2f |Preço de venda:R$ %.2f |Fornecedor: %s",
                codigo,nome,categoria,quantidade,precoCompra,precoVenda,fornecedor);
    }

}
