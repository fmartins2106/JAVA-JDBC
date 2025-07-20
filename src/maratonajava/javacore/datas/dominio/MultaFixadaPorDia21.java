package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaFixadaPorDia21 implements CalculadoraMulta21{
    private double valorPorDia;

    public MultaFixadaPorDia21(double valorPorDia) {
        this.valorPorDia = valorPorDia;
    }

    @Override
    public double calcular(Fatura21 fatura21) {
        return valorPorDia * fatura21.getDiasAtraso();
    }
}
