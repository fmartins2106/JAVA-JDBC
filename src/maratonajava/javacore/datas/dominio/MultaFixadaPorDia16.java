package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaFixadaPorDia16 implements CalculadoraMulta16{
    private double valorPorDia;

    public MultaFixadaPorDia16(double valorPorDia) {
        this.valorPorDia = valorPorDia;
    }

    @Override
    public double calcular(Fatura16 fatura16) {
        return valorPorDia * fatura16.getDiasAtraso();
    }
}
