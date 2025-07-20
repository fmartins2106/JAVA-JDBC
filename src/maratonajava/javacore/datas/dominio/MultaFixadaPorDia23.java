package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaFixadaPorDia23 implements CalculadoraMulta23 {
    private double valorPorDia;

    public MultaFixadaPorDia23(double valorPorDia) {
        this.valorPorDia = valorPorDia;
    }

    @Override
    public double calcular(Fatura23 fatura23) {
        return valorPorDia * fatura23.getDiasAtraso();
    }
}
