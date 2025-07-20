package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class ProcessarPagamentos37 {

    public void realizarPagamento(Pagamento37 metodoPagamento, double valor){
        metodoPagamento.processarPagamento(valor);
    }

    public void consultarSaldo(Pagamento37 metodoPagamento){
        metodoPagamento.consultarSaldo();
    }
}
