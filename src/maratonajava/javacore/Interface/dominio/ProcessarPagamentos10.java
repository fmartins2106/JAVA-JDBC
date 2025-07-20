package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class ProcessarPagamentos10 {

    public void autorizarPagamentos(Pagamento10 metodoPagamento, double valor){
        if (metodoPagamento.verificarSaldo(valor)){
            metodoPagamento.processarPagamentos(valor);
        }else {
            System.out.println("Valor inválido. pagamento não autorizado.");
        }
    }
    public void consultarSaldo(Pagamento10 metodoPagamento){
        metodoPagamento.consultarSaldo();
    }
}
