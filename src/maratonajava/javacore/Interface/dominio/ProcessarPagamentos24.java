package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class ProcessarPagamentos24 {

    public void realizarPagamentos(Pagamento24 metodoPagamento, double valor){
        if (metodoPagamento.verificarSaldo(valor)){
            metodoPagamento.processarPagamentos(valor);
            return;
        }
        System.out.println("Valor inválido.");
    }

    public void consultarSaldo(Pagamento24 metodoPagamento){
        metodoPagamento.consultarSaldo();
    }
}
