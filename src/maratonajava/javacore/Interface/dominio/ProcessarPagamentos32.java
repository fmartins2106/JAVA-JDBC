package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class ProcessarPagamentos32 {

    public void realizarPagamento(Pagamento32 metodoPagamento, double valor){
        metodoPagamento.processarPagamentos(valor);
    }

    public void consultarSaldo(Pagamento32 metodopagamento){
        metodopagamento.consultarSaldo();
    }
}
