package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class ProcessarPagamentos25 {

    public void realizarPagamentos(Pagamento25 metodoPagamento, double valor){
        if (metodoPagamento.verificarSaldo(valor)){
            metodoPagamento.processarPagamentos(valor);
            return;
        }
        System.out.println("Pagamento não autorizado, verifique valor.");
    }

    public void consultarSaldo(Pagamento25 metodoPagamento){
        metodoPagamento.consultarSaldo();
    }
}
