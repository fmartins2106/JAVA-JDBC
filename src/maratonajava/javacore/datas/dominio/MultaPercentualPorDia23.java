package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaPercentualPorDia23 implements CalculadoraMulta23 {
    private double percentual;

    public MultaPercentualPorDia23(double percentual) {
        this.percentual = percentual;
    }

    @Override
    public double calcular(Fatura23 fatura23) {
        return fatura23.getDiasAtraso() * ((percentual / 100) * fatura23.getValor());
    }
}
