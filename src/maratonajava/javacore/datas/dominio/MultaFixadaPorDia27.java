package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaFixadaPorDia27 implements CalculadoraMulta27{
    private double valorPorDia;

    public MultaFixadaPorDia27(double valorPorDia) {
        this.valorPorDia = valorPorDia;
    }

    @Override
    public double calcular(Fatura27 fatura27) {
        return valorPorDia * fatura27.getDiasAtraso();
    }
}
