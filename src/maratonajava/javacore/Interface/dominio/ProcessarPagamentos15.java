package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class ProcessarPagamentos15 {

    public void realizarPagamento(Pagamento15 metodoPagamento, double valor){
        if (metodoPagamento.verificarSaldo(valor)){
            metodoPagamento.processarPagamentos(valor);
        }else {
            System.out.println("Pagamento não realizado. Verificar valor.");
        }
    }

    public void consultarSaldo(Pagamento15 metodoPagamento){
        metodoPagamento.consultarSaldo();
    }
}
