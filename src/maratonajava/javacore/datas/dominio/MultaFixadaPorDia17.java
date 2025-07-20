package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaFixadaPorDia17 implements CalculadoraMulta17{
    private double valorPorDia;

    public MultaFixadaPorDia17(double valorPorDia) {
        this.valorPorDia = valorPorDia;
    }

    @Override
    public double calcular(Fatura17 fatura17) {
        return valorPorDia * fatura17.getDiasAtraso();
    }
}
