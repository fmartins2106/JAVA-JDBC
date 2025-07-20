package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class ProcessarPagamentos17 {

    public void realizarPagamento(Pagamento17 metodoPagamento, double valor){
        if (metodoPagamento.verificarSaldo(valor)){
            metodoPagamento.processarPagamentos(valor);
        }else {
            System.out.println("Pagamento não autorizado. Verifique valor.");
        }
    }

    public void consultarSaldo(Pagamento17 metodoPagamento){
        metodoPagamento.consultarSaldo();
    }
}
