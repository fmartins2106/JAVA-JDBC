package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class ProcessarPagamentos21 {

    public void realizarPagamento(Pagamento21 metodoPagamento, double valor){
        if (metodoPagamento.verificarSaldo(valor)){
            metodoPagamento.processarPagamentos(valor);
        }else {
            System.out.println("Operação negada. valor inválido.");
        }
    }

    public void consultarSaldo(Pagamento21 metodoPagamento){
        metodoPagamento.consultaSaldo();
    }
}
