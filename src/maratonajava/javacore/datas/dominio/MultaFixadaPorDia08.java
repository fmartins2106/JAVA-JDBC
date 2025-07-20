package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaFixadaPorDia08 implements CalculadoraMulta08{
    private double valorPorDia;

    public MultaFixadaPorDia08(double valorPorDia) {
        this.valorPorDia = valorPorDia;
    }

    @Override
    public double calcular(Fatura08 fatura08) {
        return valorPorDia * fatura08.getDiasAtraso();
    }
}
