package academy.devdojo.maratonajava.javacore.Interface.dominio;

public interface Pagamento36 {
    boolean verificarSaldo(double valor);
    void processarPagamentos(double valor);
    void consultarSaldo();
}
