package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaPercentualPorDia11 implements CalculadoraMulta11{
    private double percentual;

    public MultaPercentualPorDia11(double percentual) {
        this.percentual = percentual;
    }

    @Override
    public double calcular(Fatura11 fatura11) {
        return fatura11.getDiasAtraso() * ((percentual / 100) * fatura11.getValor());
    }
}
