package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class ProcessarPagamentos44 {

    public void realizarPagamento(Pagamento44 metodoPagamento, double valor){
        metodoPagamento.processarPagamento(valor);
    }

    public void consultaSaldo(Pagamento44 metodoPagamento){
        metodoPagamento.consultaSaldo();
    }
}
