package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaFixadaPorDia24 implements CalculadoraMulta24{
    private double valorPorDia;

    public MultaFixadaPorDia24(double valorPorDia) {
        this.valorPorDia = valorPorDia;
    }

    @Override
    public double calcular(Fatura24 fatura24) {
        return valorPorDia * fatura24.getDiasAtraso();
    }
}
