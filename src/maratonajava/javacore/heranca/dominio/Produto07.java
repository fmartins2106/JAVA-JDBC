package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.Scanner;

public class Produto07 {
    private int codigo;
    private String nome;
    private String categoria;
    private int quantidade;
    private double precoCompra;
    private double precoVenda;
    private String fornecedor;

    public Produto07(int codigo, String nome, String categoria, int quantidade, double precoCompra, double precoVenda, String fornecedor) {
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

    private static final int COD_MINIMO =1;
    public void setCodigo(int codigo) {
        if (codigo < COD_MINIMO){
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

    private static final int QUANT_MINIMO =0;
    public void setQuantidade(int quantidade) {
        if (quantidade < QUANT_MINIMO){
            throw new IllegalArgumentException("Quantidade não pode ser menor que 0.");
        }
        this.quantidade = quantidade;
    }

    public double getPrecoCompra() {
        return precoCompra;
    }

    private static final double PRECO_MINIMO =0;
    public void setPrecoCompra(double precoCompra) {
        if (precoCompra < PRECO_MINIMO){
            throw new IllegalArgumentException("Preço mínimo não pode ser menor que zero.");
        }
        this.precoCompra = precoCompra;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        if (precoVenda < precoCompra){
            throw new IllegalArgumentException("Preço de venda não pode ser menor que preço compra.");
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

    private void validandoString(String palavra){
        if (palavra == null || palavra.isEmpty() || !palavra.matches("^[\\p{L}\\p{N}]+( [\\p{L}\\p{N}]+)+$")){
            throw new IllegalArgumentException("Campo "+palavra+ " não pode ser vazio ou conter caracteres. Digite descrição completa");
        }
    }

    public static String formatoNome(String nome){
        String[] palavras = nome.split("\\s+");
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
        return String.format("Código: %d |Nome: %s |Categoria: %s |Quantidade: %d |Preço compra:R$ %.2f |Preço Venda:R$ %.2f |Fornecedor: %s",
                codigo,nome,categoria,quantidade,precoCompra,precoVenda,fornecedor);
    }

}
