package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class ProcessarPagamentos41 {

    public void realizarPagamentos(Pagamento41 metodoPagamento, double valor){
        metodoPagamento.processarPagamentos(valor);
    }

    public void consultarSaldo(Pagamento41 metodoPagamento){
        metodoPagamento.consultarSaldo();
    }
}
