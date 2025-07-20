package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaFixadaPorDia14 implements CalculadoraMulta14{
    private double valorPorDia;

    public MultaFixadaPorDia14(double valorPorDia) {
        this.valorPorDia = valorPorDia;
    }

    @Override
    public double calcular(Fatura14 fatura14) {
        return fatura14.getDiasAtraso() * valorPorDia;
    }
}
