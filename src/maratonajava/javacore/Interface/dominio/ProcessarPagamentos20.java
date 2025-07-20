package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class ProcessarPagamentos20 {

    public void realizarPagamentos(Pagamento20 metodoPagamento, double valor){
        if (metodoPagamento.verificarSaldo(valor)){
            metodoPagamento.processarPagamentos(valor);
        }else {
            System.out.println("Valor inválido.");
        }
    }

    public void consultarSaldo(Pagamento20 metodoPagamento){
        metodoPagamento.consultarSaldo();
    }
}
