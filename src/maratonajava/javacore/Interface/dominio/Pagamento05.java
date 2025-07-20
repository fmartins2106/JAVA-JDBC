package academy.devdojo.maratonajava.javacore.Interface.dominio;

public interface Pagamento05 {
    void processarPagamentos(double valor);
    boolean verificarSaldo(double valor);
    void consultarSaldo();
}
