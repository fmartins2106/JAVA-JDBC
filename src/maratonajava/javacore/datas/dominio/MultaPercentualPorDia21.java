package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaPercentualPorDia21 implements CalculadoraMulta21{
    private double percentual;

    public MultaPercentualPorDia21(double percentual) {
        this.percentual = percentual;
    }

    @Override
    public double calcular(Fatura21 fatura21) {
        return fatura21.getDiasAtraso() * ((percentual / 100) * fatura21.getValor());
    }
}
