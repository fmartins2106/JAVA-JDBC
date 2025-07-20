package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaPercentualPorDia13 implements CalculadoraMulta13{
    private double  percentual;

    public  MultaPercentualPorDia13(double percentual) {
        this.percentual = percentual;
    }

    @Override
    public double calcular(Fatura13 fatura13) {
        return fatura13.getDiasAtraso() * ((percentual / 100) * fatura13.getValor());
    }
}
