package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaPercentualPorDia16 implements CalculadoraMulta16{
    private double percentual;

    public MultaPercentualPorDia16(double percentual) {
        this.percentual = percentual;
    }

    @Override
    public double calcular(Fatura16 fatura16) {
        return fatura16.getDiasAtraso() * ((percentual / 100) * fatura16.getValor());
    }
}
