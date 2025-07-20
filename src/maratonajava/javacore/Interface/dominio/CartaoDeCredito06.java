package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;

public class CartaoDeCredito06 implements Pagamento06{
    private double limiteDisponivel;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public CartaoDeCredito06(double limiteDisponivel) {
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
            System.out.println("Pagamento de R$"+df.format(valor)+" realizado com sucesso.");
            System.out.println("Novo limite disponível para saque:R$"+df.format(limiteDisponivel));
        }else {
            System.out.println("Valor inválido, verifique.");
        }
    }

    @Override
    public void consultarSaldo(){
        System.out.println("Limite disponível para pagamento -> R$"+df.format(limiteDisponivel));
    }
}
