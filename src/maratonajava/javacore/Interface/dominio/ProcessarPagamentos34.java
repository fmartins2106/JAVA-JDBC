package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class ProcessarPagamentos34 {

    public void realizarPagamentos(Pagamento34 metodoPagamento, double valor){
        metodoPagamento.processarPagamentos(valor);
    }

    public void consultarSaldo(Pagamento34 metodoPagamento){
        metodoPagamento.consultarSaldo();
    }
}
