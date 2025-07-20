package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class ProcessarPagamentos03 {

    public void realizarPagamento(Pagamento03 metodoPagamento, double valor){
        if (metodoPagamento.verificarSaldo(valor)){
            metodoPagamento.processarPagamento(valor);
        }else {
            System.out.println("Pagamento não autorizado, verifique seu saldo/limite.");
        }
    }

    public void consultarSaldo(Pagamento03 metodoPagamento) {
        metodoPagamento.consultarSaldo();
    }
}
