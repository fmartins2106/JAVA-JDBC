package academy.devdojo.maratonajava.javacore.Interface.dominio;

public interface Produtos05 {
    String getNome();
    double getPreco();
    int getQuantidade();
    int getEstoqueMinimo();
    void aumentarQuantidade();
    void verificarEstoqueMinimo();
}
