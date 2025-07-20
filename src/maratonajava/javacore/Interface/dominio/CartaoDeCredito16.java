package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;

public class CartaoDeCredito16 implements Pagamento16{
    private double limiteDisponivel;
    private static DecimalFormat df = new DecimalFormat("0.00");

    public CartaoDeCredito16(double limiteDisponivel) {
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
            System.out.println("Pagamento no valor de R$"+df.format(valor)+" realizado com sucesso.");
        }else {
            System.out.println("Valor inválido.");
        }
    }

    @Override
    public void consultarSaldo(){
        System.out.println("Limite atualizado para compra ->R$"+df.format(limiteDisponivel));
    }
}
