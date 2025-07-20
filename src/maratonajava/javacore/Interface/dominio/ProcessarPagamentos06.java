package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class ProcessarPagamentos06 {

    public void realizarPagamentos(Pagamento06 metodoPagamento, double valor){
        if (metodoPagamento.verificarSaldo(valor)){
            metodoPagamento.processarPagamentos(valor);
        }else {
            System.out.println("Pagamento não autorizado. Verificar saldo/limite.");
        }
    }

    public void consultarSaldo(Pagamento06 metodoPagamento){
        metodoPagamento.consultarSaldo();
    }
}
