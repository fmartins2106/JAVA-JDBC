package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaPercentualPorDia25 implements CalculadoraMulta25{
    private double percentual;

    public MultaPercentualPorDia25(double percentual) {
        this.percentual = percentual;
    }

    @Override
    public double calcular(Fatura25 fatura25) {
        return fatura25.getDiasAtraso() * ((percentual / 100) * fatura25.getValorFatura());
    }
}
