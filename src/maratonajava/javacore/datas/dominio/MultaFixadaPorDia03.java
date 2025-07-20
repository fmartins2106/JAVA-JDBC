package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaFixadaPorDia03 implements CalculadoraMulta03{
    private double valorPorDia;

    public MultaFixadaPorDia03(double valorPorDia) {
        this.valorPorDia = valorPorDia;
    }

    @Override
    public double calcular(Fatura03 fatura03) {
        return valorPorDia * fatura03.getDiasAtraso();
    }
}
