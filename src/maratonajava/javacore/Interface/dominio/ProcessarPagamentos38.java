package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class ProcessarPagamentos38 {

    public void realizarPagamento(Pagamento38 metodoPagamento, double valor){
        metodoPagamento.processarPagamento(valor);
    }

    public void consultarSaldo(Pagamento38 metodoPagamento){
        metodoPagamento.consultarSaldo();
    }
}
