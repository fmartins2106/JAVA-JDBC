package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class ProcessarPagamentos33 {

    public void realizarPagamento(Pagamento33 metodoPagamento, double valor){
        metodoPagamento.processarPagamentos(valor);
    }

    public void consultarSaldo(Pagamento33 metodoPagamento){
        metodoPagamento.consultarSaldo();
    }
}
