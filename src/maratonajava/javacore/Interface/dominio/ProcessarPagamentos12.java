package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class ProcessarPagamentos12 {

    public static void autorizarPagamentos(Pagamento12 metodoPagamento, double valor){
        if (metodoPagamento.verificarSaldo(valor)){
            metodoPagamento.processarPagamentos(valor);
        }else {
            System.out.println("Pagamento não autorizado. Valor inválido.");
        }
    }

    public void exibirConsultaSaldo(Pagamento12 metodoPagamento){
        metodoPagamento.saldoDisponivel();
    }
}
