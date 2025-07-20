package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaFixadaPorDia29 implements CalculadoraMulta29{
    private double valorPorDia;

    public MultaFixadaPorDia29(double valorPorDia) {
        this.valorPorDia = valorPorDia;
    }

    @Override
    public double calcular(Fatura29 fatura29) {
        return fatura29.getDiasAtraso() * valorPorDia;
    }
}
