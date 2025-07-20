package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaFixadaPorDia34 implements CalculadoraMulta34{
    private double valorPorDia;

    public MultaFixadaPorDia34(double valorPorDia) {
        this.valorPorDia = valorPorDia;
    }

    @Override
    public double calcular(Fatura34 fatura34) {
        return valorPorDia * fatura34.getDiasAtraso();
    }
}
