package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaPorDia19 implements CalculadoraMulta19{
    private double valorPorDia;

    public MultaPorDia19(double valorPorDia) {
        this.valorPorDia = valorPorDia;
    }

    @Override
    public double calcular(Fatura19 fatura19) {
        return fatura19.getDiasAtraso() * valorPorDia;
    }
}
