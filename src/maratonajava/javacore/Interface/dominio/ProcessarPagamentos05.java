package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class ProcessarPagamentos05 {

    public void realizarPagamentos(Pagamento05 metodoPagamento, double valor){
        if (metodoPagamento.verificarSaldo(valor)){
            metodoPagamento.processarPagamentos(valor);
        }else {
            System.out.println("Pagamento não autorizado. Verifique seu saldo/limite.");
        }
    }

    public void consultarSaldo(Pagamento05 metodoPagamento){
        metodoPagamento.consultarSaldo();
    }
}
