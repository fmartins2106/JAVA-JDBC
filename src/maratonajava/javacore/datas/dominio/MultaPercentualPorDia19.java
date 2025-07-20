package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaPercentualPorDia19 implements CalculadoraMulta19{
    private double percentual;

    public MultaPercentualPorDia19(double percentual) {
        this.percentual = percentual;
    }

    @Override
    public double calcular(Fatura19 fatura19) {
        return fatura19.getDiasAtraso() * ((percentual / 100) * fatura19.getValor());
    }
}
