package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class ProcessarPagamentos30 {
    public void realizarPagamento(Pagamento30 metodoPagamento, double valor){
        metodoPagamento.processarPagamentos(valor);
    }

    public void consultarSaldo(Pagamento30 metodoPagamento){
        metodoPagamento.consultarSaldo();
    }
}
