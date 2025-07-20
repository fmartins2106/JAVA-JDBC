
package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaPercentualPorDia31 implements CalculadoraMulta31{
    private double percentual;

    public MultaPercentualPorDia31(double percentual) {
        this.percentual = percentual;
    }

    @Override
    public double calcular(Fatura31 fatura31) {
        return fatura31.getDiasAtraso() * ((percentual / 100) * fatura31.getValor());
    }
}
