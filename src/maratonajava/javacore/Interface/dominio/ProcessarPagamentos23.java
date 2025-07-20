package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class ProcessarPagamentos23 {

    public void realizarPagamentos(Pagamento23 metodoPagamento, double valor){
        if (metodoPagamento.verificarSaldo(valor)){
            metodoPagamento.processarPagamentos(valor);
        }else {
            System.out.println("Pagamento não autorizado. Verifique valor.");
        }
    }

    public void consultarSaldo(Pagamento23 metodoPagamento){
        metodoPagamento.consultarSaldo();
    }
}
