package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class ProcessarPagamentos04 {

    public void realizarPagamentos(Pagamento04 metodoPagamento, double valor){
        if (metodoPagamento.verificarSaldo(valor)){
            metodoPagamento.processarPagamentos(valor);
        }else {
            System.out.println("Pagamento não autorizado. Verifique saldo.");
        }
    }

    public void consultarSaldo(Pagamento04 metodoPagamento){
        metodoPagamento.consultarSaldo();
    }
}
