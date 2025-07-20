package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaPercentualPorDia04 implements CalculadoraMulta04{
    private double percentual;

    public MultaPercentualPorDia04(double percentual) {
        this.percentual = percentual;
    }

    @Override
    public double calcular(Fatura04 fatura04) {
        return fatura04.getValor() * (percentual / 100) * fatura04.getDiasAtraso();
    }
}
