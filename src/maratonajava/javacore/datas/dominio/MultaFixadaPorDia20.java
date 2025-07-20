package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaFixadaPorDia20 implements CalculadoraMulta20{
    private double valorPorDia;

    public MultaFixadaPorDia20(double valorPorDia) {
        this.valorPorDia = valorPorDia;
    }

    @Override
    public double calcular(Fatura20 fatura20) {
        return fatura20.getDiasAtraso() * valorPorDia;
    }
}
