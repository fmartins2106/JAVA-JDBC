package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaPercentualPorDia07 implements CalculadoraMulta07{
    private double percentual;

    public MultaPercentualPorDia07(double percentual) {
        this.percentual = percentual;
    }

    @Override
    public double calcular(Fatura07 fatura07) {
        return fatura07.getValor() * (percentual / 100) * fatura07.getDiasAtraso();
    }
}
