package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;

public class CartaoDeCredito12 implements Pagamento12{
    private double limiteDisponivel;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public CartaoDeCredito12(double limiteDisponivel) {
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
        }else {
            System.out.println("Digite um valor válido.");
        }
    }

    @Override
    public void saldoDisponivel(){
        System.out.println("Limite disponível ->R$"+df.format(limiteDisponivel));
    }
}
