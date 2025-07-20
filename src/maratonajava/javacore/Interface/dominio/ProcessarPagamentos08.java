package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class ProcessarPagamentos08 {

    public void realizarPagamentos(Pagamento08 metodoPagamento, double valor){
        if (metodoPagamento.verificarSaldo(valor)){
            metodoPagamento.processarPagamentos(valor);
        }else {
            System.out.println("Pagamento não autorizado, verifica saldo/limite.");
        }
    }

    public void consultarSaldo(Pagamento08 metodoPagamento){
        metodoPagamento.consultarSaldo();
    }
}
