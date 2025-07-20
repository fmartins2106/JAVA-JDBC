package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaPercentualPorDia29 implements CalculadoraMulta29{
    private double percentual;

    public MultaPercentualPorDia29(double percentual) {
        this.percentual = percentual;
    }

    @Override
    public double calcular(Fatura29 fatura29) {
        return fatura29.getDiasAtraso() * ((percentual / 100) * fatura29.getValor());
    }
}
