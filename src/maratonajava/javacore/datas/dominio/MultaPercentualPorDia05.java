package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaPercentualPorDia05 implements CalculadoraMulta05{
    private double percentual;

    public MultaPercentualPorDia05(double percentual) {
        this.percentual = percentual;
    }

    @Override
    public double calcular(Fatura05 fatura05) {
        return fatura05.getValor() * (percentual / 100) * fatura05.getDiasAtraso();
    }
}
