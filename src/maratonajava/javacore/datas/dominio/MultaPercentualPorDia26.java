package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaPercentualPorDia26 implements CalculadoraMulta26{
    private double percentual;

    public MultaPercentualPorDia26(double percentual) {
        this.percentual = percentual;
    }

    @Override
    public double calcular(Fatura26 fatura26) {
        return fatura26.getDiasAtraso() * ((percentual / 100) * fatura26.getValor());
    }
}
