package academy.devdojo.maratonajava.javacore.Interface.dominio;

public interface Pagamento06 {
    void processarPagamentos(double valor);
    boolean verificarSaldo(double valor);
    void consultarSaldo();
}
