package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class ProcessarPagamentos39 {

    public void realizarPagamento(Pagamento39 metodoPagamento, double valor){
        metodoPagamento.processarPagamento(valor);
    }

    public void consultarSaldo(Pagamento39 metodoPagamento){
        metodoPagamento.consultarSaldo();
    }
}
