package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class ProcessarPagamentos02 {

    public void realizarPagamento(Pagamento02 metodoPagamento, double valor){
        if (metodoPagamento.verificarSaldo(valor)){
            metodoPagamento.processarPagamento(valor);
        }else {
            System.out.println("Pagamento não autorizado. Verifique seu saldo/limite.");
        }
    }

    public void consultarSaldo(Pagamento02 metodoPagamento){
        metodoPagamento.consultarSaldo();
    }
}
