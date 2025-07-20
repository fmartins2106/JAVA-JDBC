package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class ProcessarPagamentos28 {
    public void realizarPagamentos(Pagamento28 metodoPagamento, double valor){
        metodoPagamento.processarPagamentos(valor);
    }

    public void consultarPagamento(Pagamento28 metodoPagamento){
        metodoPagamento.consultarSaldo();
    }

}
