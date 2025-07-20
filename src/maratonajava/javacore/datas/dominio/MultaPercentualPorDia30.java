package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaPercentualPorDia30 implements CalculadoraMulta30{
    private double percentual;

    public MultaPercentualPorDia30(double percentual) {
        this.percentual = percentual;
    }

    @Override
    public double calcular(Fatura30 fatura30) {
        return fatura30.getDiasAtraso() * ((percentual / 100) * fatura30.getValor());
    }
}

