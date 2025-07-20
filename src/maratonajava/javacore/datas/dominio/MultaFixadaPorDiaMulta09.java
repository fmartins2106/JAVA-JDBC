package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaFixadaPorDiaMulta09 implements CalculadoraMulta09 {
    private double valorPorDia;

    public MultaFixadaPorDiaMulta09(double valorPorDia) {
        this.valorPorDia = valorPorDia;
    }

    @Override
    public double calcular(Fatura09 fatura09) {
        return valorPorDia * fatura09.getDiasAtraso();
    }
}
