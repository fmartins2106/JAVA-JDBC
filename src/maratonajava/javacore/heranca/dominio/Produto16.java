package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.Scanner;

public class Produto16 {
    private int codigo;
    private String nome;
    private String categoria;
    private int quantidade;
    private double precoCompra;
    private double precoVenda;
    private String fornecedor;

    public Produto16(int codigo, String nome, String categoria, int quantidade, double precoCompra, double precoVenda, String fornecedor) {
        setCodigo(codigo);
        setNome(nome);
        setCategoria(categoria);
        setQuantidade(quantidade);
        setPrecoCompra(precoCompra);
        setPrecoVenda(precoVenda);
        setFornecedor(fornecedor);
    }

    public static final int MENOR_CODIGO =1;
    public static final int MENOR_QUANTIDADE =0;
    public static final double MENOR_PRECO_COMPRA =0;

    public static String formatoNome(String nome){
        String[] palavras = nome.toLowerCase().split("\\s+");
        StringBuilder nomeFormatado = new StringBuilder();
        for (String palavra :  palavras){
            nomeFormatado.append(palavra.substring(0,1).toUpperCase())
                    .append(palavra.substring(1))
                    .append(" ");
        }
        return nomeFormatado.toString().trim();
    }

    private void validacaoCogido(int codigo){
        if (codigo < MENOR_CODIGO){
            throw new IllegalArgumentException(MensagemValidacao.ERRO_CODIGO.getDescricao());
        }
    }

    private void validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}\\p{N}]+( [\\p{L}\\p{N}]+)+$")){
            throw new IllegalArgumentException(MensagemValidacao.ERRO_NOME.getDescricao());
        }
    }

    private void validacaoCategoria(String categoria){
        if (categoria == null || categoria.isEmpty() || !categoria.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException(MensagemValidacao.ERRO_CATEGORIA.getDescricao());
        }
    }

    private void validacaoQuantidade(int quantidade){
        if (quantidade < MENOR_QUANTIDADE){
            throw new IllegalArgumentException(MensagemValidacao.ERRO_QUANTIDADE.getDescricao());
        }
    }

    private void validacaoPrecoCompra(double precoCompra){
        if (precoCompra < MENOR_PRECO_COMPRA){
            throw new IllegalArgumentException(MensagemValidacao.ERRO_PRECO_COMPRA.getDescricao());
        }
    }

    private void validacaoPrecoVenda( double precoVenda,double precoCompra){
        if (precoVenda < precoCompra){
            throw new IllegalArgumentException(MensagemValidacao.ERRO_PRECO_VENDA.getDescricao());
        }
    }

    private void validacaoFornecedor(String fornecedor){
        if (fornecedor == null || fornecedor.isEmpty() || !fornecedor.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException(MensagemValidacao.ERRO_FORNECEDOR.getDescricao());
        }
    }


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        validacaoCogido(codigo);
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

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        validacaoFornecedor(fornecedor);
        this.fornecedor = fornecedor;
    }

    @Override
    public String toString(){
        return String.format("Código: %d |Nome: %s |Categoria: %s |Quantidade: %d |Preço compra:R$ %.2f |Preço venda:R$ %.2f |Fornecedor: %s ",
                codigo,nome,categoria,quantidade,precoCompra,precoVenda,fornecedor);
    }


    public enum MensagemValidacao{
        ERRO_CODIGO("Código não pode ser menor que 1."),
        ERRO_NOME("Campo nome não pode ser vazio ou conter caracteres."),
        ERRO_CATEGORIA("Campo categoria não pode ser vazio ou conter caracteres."),
        ERRO_QUANTIDADE("Quantidade não pode ser menor que 0."),
        ERRO_PRECO_COMPRA("Preço de compra não pode ser menor que 0."),
        ERRO_PRECO_VENDA("Preço de venda não pode ser menor que preço de compra."),
        ERRO_FORNECEDOR("Campo fornecedor não pode ser vazio ou conter caracteres."),
        ERRO_ESTOQUE_MINIMO("Estoque mínimo não pode ser menor que 50.");

        private String descricao;

        MensagemValidacao(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }
    }
}

