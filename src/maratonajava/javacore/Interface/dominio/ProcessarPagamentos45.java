package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class ProcessarPagamentos45 {

    public void realizarPagamento(Pagamento45 metodoPagamento, double valor){
        metodoPagamento.processarPagamentos(valor);
    }

    public void consultaSaldo(Pagamento45 metodoPagamento){
        metodoPagamento.consultaSaldo();
    }
}
