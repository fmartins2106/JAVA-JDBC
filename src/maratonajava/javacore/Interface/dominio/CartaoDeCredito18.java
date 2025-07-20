package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;

public class CartaoDeCredito18 implements Pagamento18{
    private double limiteCartao;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public CartaoDeCredito18(double limiteCartao) {
        this.limiteCartao = limiteCartao;
    }

    @Override
    public boolean verificarSaldo(double valor){
        return valor <= limiteCartao;
    }

    @Override
    public void processarPagamentos(double valor){
        if (verificarSaldo(valor)){
            limiteCartao -= valor;
            System.out.println("Pagamento no valor de R$ "+df.format(valor)+" realizado com sucesso.");
        }else {
            System.out.println("Valor inválido. Verifique limite disponível.");
        }
    }

    @Override
    public void consultarSaldo(){
        System.out.println("Limite disponível para pagamento  -> R$"+df.format(limiteCartao));
    }
}

