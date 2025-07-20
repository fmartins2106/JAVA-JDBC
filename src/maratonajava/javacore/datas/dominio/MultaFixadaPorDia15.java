package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaFixadaPorDia15 implements CalculadoraMulta15{
    private double valorPorDia;

    public MultaFixadaPorDia15(double valorPorDia) {
        this.valorPorDia = valorPorDia;
    }

    @Override
    public double calcular(Fatura15 fatura15) {
        return fatura15.getDiasAtraso() * valorPorDia;
    }
}
