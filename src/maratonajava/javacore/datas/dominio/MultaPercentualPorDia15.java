package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaPercentualPorDia15 implements CalculadoraMulta15{
    private double percentual;

    public MultaPercentualPorDia15(double percentual) {
        this.percentual = percentual;
    }

    @Override
    public double calcular(Fatura15 fatura15) {
        return fatura15.getDiasAtraso() * ((percentual / 100) * fatura15.getValor());
    }
}
