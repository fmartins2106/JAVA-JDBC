package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class ProcessarPagamentos35 {

    public void realizarPagamentos(Pagamento35 metodoPagamento, double valor){
        metodoPagamento.processarPagamentos(valor);
    }

    public void consultarSaldo(Pagamento35 metodoPagamento){
        metodoPagamento.consultarSaldo();
    }
}
