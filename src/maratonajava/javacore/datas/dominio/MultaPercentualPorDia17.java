package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaPercentualPorDia17 implements CalculadoraMulta17{
    private double percentual;

    public MultaPercentualPorDia17(double percentual) {
        this.percentual = percentual;
    }

    @Override
    public double calcular(Fatura17 fatura17) {
        return fatura17.getDiasAtraso() * ((percentual / 100) * fatura17.getValor());
    }
}
