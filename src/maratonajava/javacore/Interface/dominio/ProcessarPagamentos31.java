package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class ProcessarPagamentos31 {

    public void realizarPagamento(Pagamento31 metodoPagamento, double valor){
        metodoPagamento.processarPagamentos(valor);
    }

    public void consultarPagamento(Pagamento31 metodoPagamento){
        metodoPagamento.consultarSaldo();
    }
}
