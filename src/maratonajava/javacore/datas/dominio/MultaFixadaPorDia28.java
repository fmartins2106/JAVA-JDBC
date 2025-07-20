package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaFixadaPorDia28 implements CalculadoraMulta28{
    private double valorPorDia;

    public MultaFixadaPorDia28(double valorPorDia) {
        this.valorPorDia = valorPorDia;
    }

    @Override
    public double calcular(Fatura28 fatura28) {
        return valorPorDia * fatura28.getDiasAtraso();
    }
}
