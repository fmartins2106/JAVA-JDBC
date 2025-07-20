package academy.devdojo.maratonajava.javacore.Interface.dominio;

public interface Pagamento40 {
    boolean verificarSaldo(double valor);
    void processarPagamentos(double valor);
    void consultaSaldo();
}
