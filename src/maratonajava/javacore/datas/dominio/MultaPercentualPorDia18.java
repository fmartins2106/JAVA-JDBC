package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaPercentualPorDia18 implements CalculadoraMulta18{
    private double percentual;

    public MultaPercentualPorDia18(double percentual) {
        this.percentual = percentual;
    }

    @Override
    public double calcular(Fatura18 fatura18) {
        return fatura18.getDiasAtraso() * ((percentual / 100) * fatura18.getValor());
    }
}
