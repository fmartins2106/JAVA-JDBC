package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaFixadaPorDia18 implements CalculadoraMulta18{
    private double valorPorDia;

    public MultaFixadaPorDia18(double valorPorDia) {
        this.valorPorDia = valorPorDia;
    }

    @Override
    public double calcular(Fatura18 fatura18) {
        return valorPorDia * fatura18.getDiasAtraso();
    }
}
