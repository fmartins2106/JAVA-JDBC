package academy.devdojo.maratonajava.javacore.Interface.dominio;

public interface Pagamento39 {
    boolean verificarSaldo(double valor);
    void processarPagamento(double valor);
    void consultarSaldo();
}
