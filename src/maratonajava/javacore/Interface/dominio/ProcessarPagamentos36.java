package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class ProcessarPagamentos36 {

    public void realizarPagamento(Pagamento36 metodoPagamento, double valor){
        metodoPagamento.processarPagamentos(valor);
    }

    public void consultarSaldo(Pagamento36 metodoPagamento){
        metodoPagamento.consultarSaldo();
    }
}
