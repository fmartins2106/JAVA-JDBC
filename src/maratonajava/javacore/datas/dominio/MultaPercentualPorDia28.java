package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaPercentualPorDia28 implements CalculadoraMulta28{
    private double percentual;

    public MultaPercentualPorDia28(double percentual) {
        this.percentual = percentual;
    }

    @Override
    public double calcular(Fatura28 fatura28) {
        return fatura28.getDiasAtraso() * ((percentual / 100) * fatura28.getValor());
    }
}
