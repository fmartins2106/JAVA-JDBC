package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;

public class CartaoDeCredito15 implements Pagamento15{
    private double limiteDisponivel;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public CartaoDeCredito15(double limiteDisponivel) {
        this.limiteDisponivel = limiteDisponivel;
    }

    @Override
    public boolean verificarSaldo(double valor){
        return valor <= limiteDisponivel;
    }

    @Override
    public void processarPagamentos(double valor){
        if (verificarSaldo(valor)){
            limiteDisponivel -= valor;
            System.out.println("Pagamento de R$"+df.format(valor)+" autorizado.");
        }else {
            System.out.println("Valor inválido.");
        }
    }

    @Override
    public void consultarSaldo(){
        System.out.println("Limite atualizado ->R$"+df.format(limiteDisponivel));
    }
}
