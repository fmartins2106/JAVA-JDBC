package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaFixadaPorDia26 implements CalculadoraMulta26{
    private double valorPorDia;

    public MultaFixadaPorDia26(double valorPorDia) {
        this.valorPorDia = valorPorDia;
    }

    @Override
    public double calcular(Fatura26 fatura26) {
        return valorPorDia * fatura26.getDiasAtraso();
    }
}
