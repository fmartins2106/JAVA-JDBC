package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaPercentualPorDia02 implements CalculadoraMulta02{
    private double percentual;

    public MultaPercentualPorDia02(double percentual) {
        this.percentual = percentual;
    }

    @Override
    public double calcular(Fatura02 fatura02) {
        return fatura02.getValor() * (percentual / 100) * fatura02.getDiasAtraso();
    }
}
