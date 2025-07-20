package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaFixadaPorDia35 implements CalculadoraMulta35{
    private double valorPorDia;

    public MultaFixadaPorDia35(double valorPorDia) {
        this.valorPorDia = valorPorDia;
    }

    @Override
    public double calcular(Fatura35 fatura35) {
        return valorPorDia * fatura35.getDiasAtraso();
    }
}
