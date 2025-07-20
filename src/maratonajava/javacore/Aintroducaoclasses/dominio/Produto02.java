package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio;

import java.util.Arrays;

public class Produto02 {
    private String nome;
    private double preco;
    private int quantidade;

    public Produto02(String nome,double preco, int quantidade){
        setNome(nome);
        setPreco(preco);
        setQuantidade(quantidade);
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        if (nome== null || nome.isEmpty() || !nome.matches("^[\\p{L}]+(\\s[\\p{L}]+)+$")){
            throw new IllegalArgumentException("Digite seu nome completo, tente novamenteo.");
        }else {
            this.nome = formatandoNome(nome);
        }
    }
    public double getPreco(){
        return preco;
    }

    public void setPreco(double preco) {
        if (preco<=0){
            throw new IllegalArgumentException("Digite um valor maior que zero.");
        }else
            this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade<=-1){
            throw new IllegalArgumentException("Digite um valor maior que zero.");
        }else {
            this.quantidade = quantidade;
        }
    }

    public void mostrandoResultados(){
        System.out.println("Nome:"+getNome());
        System.out.println("Preço:"+getPreco());
        System.out.println("Quantidade:"+getQuantidade());
        System.out.println("__________________________________________");
    }

    private static String formatandoNome(String nome){
        String[] palavras = nome.toLowerCase().split("\\s+");
        StringBuilder nomeFormatado = new StringBuilder();
        for (String palavra : palavras){
            nomeFormatado.append(palavra.substring(0,1).toUpperCase()).append(palavra.substring(1)).append(" ");
        }
        return nomeFormatado.toString().trim();
    }
}
