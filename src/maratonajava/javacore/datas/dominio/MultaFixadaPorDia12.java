package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaFixadaPorDia12 implements CalculadoraMulta12 {
    private double valorPorDia;

    public MultaFixadaPorDia12(double valorPorDia) {
        this.valorPorDia = valorPorDia;
    }

    @Override
    public double calcular(Fatura12 fatura12) {
        return fatura12.getDiasAtraso() * valorPorDia;
    }
}
