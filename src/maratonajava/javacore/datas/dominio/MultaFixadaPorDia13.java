package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaFixadaPorDia13 implements CalculadoraMulta12{
    private double valorPorDia;

    public MultaFixadaPorDia13(double valorPorDia) {
        this.valorPorDia = valorPorDia;
    }

    @Override
    public double calcular(Fatura12 fatura12) {
        return valorPorDia * fatura12.getDiasAtraso();
    }
}
