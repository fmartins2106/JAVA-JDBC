package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaPercentualPorDia01 implements CalculadoraMulta01{
    private double percentual;

    public MultaPercentualPorDia01(double percentual) {
        this.percentual = percentual;
    }

    @Override
    public double calcularMulta(Fatura01 fatura01) {
        return fatura01.getValor() * (percentual/100) * fatura01.getDiasAtraso();
    }
}
