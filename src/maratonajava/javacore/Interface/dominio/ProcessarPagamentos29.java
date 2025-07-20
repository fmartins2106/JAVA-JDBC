package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class ProcessarPagamentos29 {

    public void realizarPagamento(Pagamento29 metodoPagamento, double valor){
        metodoPagamento.processarPagamentos(valor);
    }

    public void consultarSaldo(Pagamento29 metodoPagamento){
        metodoPagamento.consultaSaldo();
    }
}
