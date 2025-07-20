package academy.devdojo.maratonajava.javacore.Interface.dominio;

public interface Pagamento37 {
    boolean verificarSaldo(double valor);
    void processarPagamento(double valor);
    void consultarSaldo();
}
