package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class ProcessarPagamentos07 {

    public void realizarPagamentos(Pagamento07 metodoPagamento, double valor){
        if (metodoPagamento.verificarSaldo(valor)){
            metodoPagamento.processarPagamentos(valor);
        }else {
            System.out.println("Pagamento não autorizado. verificar limite/saldo");
        }
    }

    public void consultarSaldo(Pagamento07 metodoPagamento){
        metodoPagamento.consultarSaldo();
    }
}
