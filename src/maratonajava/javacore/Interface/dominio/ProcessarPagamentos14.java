package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class ProcessarPagamentos14 {

    public static void realizarPagamento(Pagamento14 metodoPagamento, double valor){
        if (metodoPagamento.verificarSaldo(valor)){
            metodoPagamento.processarPagamentos(valor);
        }else {
            System.out.println("Operação negada. Valor inválido.");
        }
    }

    public void consultarSaldo(Pagamento14 metodoPagamento){
        metodoPagamento.saldoDisponivel();
    }
}
