package academy.devdojo.maratonajava.javacore.Interface.dominio;

public interface Pagamento03 {
    void processarPagamento(double valor);
    boolean verificarSaldo(double valor);
    void consultarSaldo();
}
