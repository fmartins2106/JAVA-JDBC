package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class ProcessarPagamentos11 {

    public static void autorizarPagamentos(Pagamento11 metodoPagamento, double valor){
        if (metodoPagamento.verificarSaldo(valor)){
            metodoPagamento.processarPagamentos(valor);
        }else {
            System.out.println("Pagamento não autorizado. Verifique saldo/imite.");
        }
    }

    public void consultarSaldo(Pagamento11 metodoPagamento){
        metodoPagamento.consultarSaldo();
    }
}
