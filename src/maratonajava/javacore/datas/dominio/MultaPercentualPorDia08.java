package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaPercentualPorDia08 implements CalculadoraMulta08{
    private double percentual;

    public MultaPercentualPorDia08(double percentual) {
        this.percentual = percentual;
    }

    @Override
    public double calcular(Fatura08 fatura08) {
        return fatura08.getValor() * (percentual / 100) * fatura08.getDiasAtraso();
    }
}
