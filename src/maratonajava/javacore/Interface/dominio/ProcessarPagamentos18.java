package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class ProcessarPagamentos18 {

    public void realizarPagamentos(Pagamento18 metodoPagamento, double valor){
        if (metodoPagamento.verificarSaldo(valor)){
            metodoPagamento.processarPagamentos(valor);
        }else {
            System.out.println("Operação negada. Verifique limite/saldo disponível.");
        }
    }

    public void consultarSaldo(Pagamento18 metodoPagamento){
        metodoPagamento.consultarSaldo();
    }
}
