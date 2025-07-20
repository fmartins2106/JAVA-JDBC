package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaPercentualPorDia12 implements CalculadoraMulta12{
    private double percentual;

    public MultaPercentualPorDia12(double percentual) {
        this.percentual = percentual;
    }

    @Override
    public double calcular(Fatura12 fatura12) {
        return fatura12.getDiasAtraso() * ((percentual / 100) * fatura12.getValor());
    }
}
