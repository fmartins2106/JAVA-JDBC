package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaPercentualPorDia09 implements CalculadoraMulta09 {
    private double percentual;

    public MultaPercentualPorDia09(double percentual) {
        this.percentual = percentual;
    }

    @Override
    public double calcular(Fatura09 fatura09) {
        return fatura09.getValor() * (percentual / 100) * fatura09.getDiasAtraso();
    }
}
