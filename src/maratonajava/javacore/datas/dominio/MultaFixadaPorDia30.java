package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaFixadaPorDia30 implements CalculadoraMulta30{
    private double valorPorDia;

    public MultaFixadaPorDia30(double valorPorDia) {
        this.valorPorDia = valorPorDia;
    }

    @Override
    public double calcular(Fatura30 fatura30) {
        return fatura30.getDiasAtraso() * valorPorDia;
    }
}
