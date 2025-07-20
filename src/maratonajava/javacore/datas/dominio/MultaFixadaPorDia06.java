package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaFixadaPorDia06 implements CalculadoraMulta06{
    private double valorPorDia;

    public MultaFixadaPorDia06(double valorPorDia) {
        this.valorPorDia = valorPorDia;
    }

    @Override
    public double calcular(Fatura06 fatura06) {
        return valorPorDia * fatura06.getDiasAtraso();
    }
}
