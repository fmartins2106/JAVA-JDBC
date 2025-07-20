package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class ProcessarPagamentos42 {

    public void realizarPagamento(Pagamento42 metodoPagamento, double valor){
        metodoPagamento.processarPagamentos(valor);
    }

    public void consultarSaldo(Pagamento42 metodoPagamento){
        metodoPagamento.consultarSaldo();
    }

}
