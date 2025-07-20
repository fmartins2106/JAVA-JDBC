package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaPercentualPorDia implements CalculadoraMulta35{
    private double percentual;

    public MultaPercentualPorDia(double percentual) {
        this.percentual = percentual;
    }

    @Override
    public double calcular(Fatura35 fatura35) {
        return fatura35.getDiasAtraso() * ((percentual / 100) * fatura35.getValor());
    }
}
