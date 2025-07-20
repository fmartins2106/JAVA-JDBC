package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class ProcessarPagamentos22 {

    public void realizarPagamentos(Pagamento22 metodoPagamento, double valor){
        if (metodoPagamento.verificarSaldo(valor)){
            metodoPagamento.processarPagamentos(valor);
        }else {
            System.out.println("Valor inválido. Verifique.");
        }
    }

    public void consultarSaldo(Pagamento22 metodoPagamento){
        metodoPagamento.consultarSaldo();
    }
}
