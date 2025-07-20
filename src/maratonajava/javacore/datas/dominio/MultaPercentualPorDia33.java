
package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaPercentualPorDia33 implements CalculadoraMulta33{
    private double percentual;

    public MultaPercentualPorDia33(double percentual) {
        this.percentual = percentual;
    }

    @Override
    public double calcular(Fatura33 fatura33) {
        return fatura33.getDiasAtraso() * ((percentual / 100) * fatura33.getValor());
    }
}
