package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class ProcessarPagamentos13 {

    public static void autorizarPagamentos(Pagamento13 metodoPagamento, double valor){
        if (metodoPagamento.verificarSaldo(valor)){
            metodoPagamento.processarPagamentos(valor);
        }else {
            System.out.println("Pagamento não autorizado, verifique saldo.");
        }
    }

    public void consultarSaldo(Pagamento13 metodoPagamento){
        metodoPagamento.consultarSaldo();
    }
}
