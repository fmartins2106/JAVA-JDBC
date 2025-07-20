package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaPercentualPorDia22 implements CalculadoraMulta22{
    private double percentual;

    public MultaPercentualPorDia22(double percentual) {
        this.percentual = percentual;
    }

    @Override
    public double calcular(Fatura22 fatura22) {
        return fatura22.getDiasAtraso() * ((percentual / 100) * fatura22.getValor());
    }
}
