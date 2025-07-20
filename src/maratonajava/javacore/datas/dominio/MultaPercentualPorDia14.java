package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaPercentualPorDia14 implements CalculadoraMulta14{
    private double percentual;

    public MultaPercentualPorDia14(double percentual) {
        this.percentual = percentual;
    }

    @Override
    public double calcular(Fatura14 fatura14) {
        return fatura14.getDiasAtraso() * ((percentual / 100) * fatura14.getValor());
    }
}
