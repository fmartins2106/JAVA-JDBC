package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class ProcessarPagamentos19 {

    public void realizarOperacao(Pagamento19 metodoPagamento, double valor){
        if (metodoPagamento.verificarSaldo(valor)){
            metodoPagamento.processarPagamentos(valor);
        }else {
            System.out.println("Pagamento inválido. Verifique valor.");
        }
    }

    public void consultarSaldoDisponivel(Pagamento19 metodoPagamento){
        metodoPagamento.consultarSaldo();
    }
}
