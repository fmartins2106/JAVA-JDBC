package academy.devdojo.maratonajava.javacore.Interface.dominio;

public interface Pagamento21 {
    boolean verificarSaldo(double valor);
    void processarPagamentos(double valor);
    void consultaSaldo();
}
