package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaPercentualPorDia24 implements CalculadoraMulta24{
    private double percentual;

    public MultaPercentualPorDia24(double percentual) {
        this.percentual = percentual;
    }

    @Override
    public double calcular(Fatura24 fatura24) {
        return fatura24.getDiasAtraso() * ((percentual / 100) * fatura24.getValorFatura());
    }
}
