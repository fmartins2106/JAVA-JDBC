package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class ProcessarPagamentos01 {

    public void realizarPagamentos(Pagamento01 metodoPagamento, double valor){
        if (metodoPagamento.verificarSaldo(valor)){
            metodoPagamento.processarPagamento(valor);
        }else {
            System.out.println("Pagamento não autorizado. Verifique seu saldo limite.");
        }
    }

    public void consultarSaldo(Pagamento01 metodoPagamento){
        metodoPagamento.consultarSaldo();
    }
}
