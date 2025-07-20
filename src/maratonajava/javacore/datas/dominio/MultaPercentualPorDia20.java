package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaPercentualPorDia20 implements CalculadoraMulta20{
    private double percentual;

    public MultaPercentualPorDia20(double percentual) {
        this.percentual = percentual;
    }

    @Override
    public double calcular(Fatura20 fatura20) {
        return fatura20.getDiasAtraso() * ((percentual / 100) * fatura20.getValor());
    }
}
