package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class ProcessarPagamentos40 {


    public void realizarPagamento(Pagamento40 metodoPagamento, double valor){
        metodoPagamento.processarPagamentos(valor);
    }

    public void consultaSaldo(Pagamento40 metodoPagamento){
        metodoPagamento.consultaSaldo();
    }
}
