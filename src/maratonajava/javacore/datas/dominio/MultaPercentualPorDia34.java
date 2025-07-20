package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaPercentualPorDia34 implements CalculadoraMulta34{
    private double percentual;

    public MultaPercentualPorDia34(double percentual) {
        this.percentual = percentual;
    }

    @Override
    public double calcular(Fatura34 fatura34) {
        return fatura34.getDiasAtraso() * ((percentual / 100) * fatura34.getValorFatura());
    }
}
