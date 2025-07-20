package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaFixadaPorDia02 implements CalculadoraMulta02{
    private double valorPorDia;

    public MultaFixadaPorDia02(double valorPorDia) {
        this.valorPorDia = valorPorDia;
    }

    @Override
    public double calcular(Fatura02 fatura02) {
        return valorPorDia * fatura02.getDiasAtraso();
    }
}
