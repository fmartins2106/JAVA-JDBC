package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.util.Scanner;

public class ProcessarPagamentos16 {

    public void exibirResultados(Pagamento16 metodoPagamento, double valor){
        if (metodoPagamento.verificarSaldo(valor)){
            metodoPagamento.processarPagamentos(valor);
        }else {
            System.out.println("Pagamento não autorizado. Verifique valor.");
        }
    }

    public void consultarSaldo(Pagamento16 metodoPagamento){
        metodoPagamento.consultarSaldo();
    }
}
