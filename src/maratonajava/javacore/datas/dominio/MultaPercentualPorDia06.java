package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaPercentualPorDia06 implements CalculadoraMulta06{
    private double percentual;

    public MultaPercentualPorDia06(double percentual) {
        this.percentual = percentual;
    }

    @Override
    public double calcular(Fatura06 fatura06) {
        return fatura06.getValor() * (percentual / 100) * fatura06.getDiasAtraso();
    }
}
