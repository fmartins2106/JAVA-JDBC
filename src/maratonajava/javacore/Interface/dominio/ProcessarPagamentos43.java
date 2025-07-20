package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class ProcessarPagamentos43 {

    public void realizarPagamento(Pagamento43 metodoPagamento, double valor){
        metodoPagamento.processarPagamentos(valor);
    }

    public void consultarSaldo(Pagamento43 metodoPagamento){
        metodoPagamento.consultarSaldo();
    }
}
