package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class ProcessarPagamentos26 {

    public void realizarPagamento(Pagamento26 metodoPagamento, double valor){
        metodoPagamento.processarPagamentos(valor);

    }

    public void consultarSaldo(Pagamento26 metodoPagamento){
        metodoPagamento.consultarSaldo();
    }
}
