package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class ProcessarPagamentos09 {

    public void realizarPagamentos(Pagamento09 metodoPagamento, double valor){
        if (metodoPagamento.verificarSaldo(valor)){
            metodoPagamento.processarPagamentos(valor);
        }else {
            System.out.println("Pagamento não autorizado. Verificar saldo.");
        }
    }

    public void consultarSaldo(Pagamento09 metodoPagamento){
        metodoPagamento.consultarSaldo();
    }
}
