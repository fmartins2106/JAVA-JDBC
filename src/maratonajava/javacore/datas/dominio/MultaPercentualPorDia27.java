package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaPercentualPorDia27 implements CalculadoraMulta27{
    private double percentual;

    public MultaPercentualPorDia27(double percentual) {
        this.percentual = percentual;
    }

    @Override
    public double calcular(Fatura27 fatura27) {
        return fatura27.getDiasAtraso() * ((percentual / 100) * fatura27.getValor());
    }
}
