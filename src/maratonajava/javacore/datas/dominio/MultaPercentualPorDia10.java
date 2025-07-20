package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaPercentualPorDia10 implements CalculadoraMulta10{
    private double percentual;

    public MultaPercentualPorDia10(double percentual) {
        this.percentual = percentual;
    }

    @Override
    public double calcular(Fatura10 fatura10) {
        return fatura10.getDiasAtraso() * ((percentual / 100) * fatura10.getValor());
    }
}
