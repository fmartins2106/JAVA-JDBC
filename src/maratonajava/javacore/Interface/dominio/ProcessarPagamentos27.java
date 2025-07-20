package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class ProcessarPagamentos27 {

    public void realizarPagamento(Pagamento27 metodoPagamento, double valor){
        metodoPagamento.processarPagamentos(valor);
    }

    public void consultarSaldo(Pagamento27 metodoPagamento){
        metodoPagamento.consultarSaldo();
    }

}
