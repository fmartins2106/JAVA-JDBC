package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaPercentualPorDia03 implements CalculadoraMulta03{
    private double percentual;

    public MultaPercentualPorDia03(double percentual) {
        this.percentual = percentual;
    }

    @Override
    public double calcular(Fatura03 fatura03) {
        return fatura03.getValor() * (percentual / 100) * fatura03.getDiasAtraso();
    }
}
