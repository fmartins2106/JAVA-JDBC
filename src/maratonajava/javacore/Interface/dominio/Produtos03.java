package academy.devdojo.maratonajava.javacore.Interface.dominio;

public interface Produtos03 {
    String getNome();
    double getPreco();
    int getQuantidade();
    int getEstoqueMinimo();
    double calcularValorTotal();
    void aumentarQuantidade(int quantidade);
    void verificarEstoqueMinimo();

}
