package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaFixadaPorDia10 implements CalculadoraMulta10{
    private double valorPorDia;

    public MultaFixadaPorDia10(double valorPorDia) {
        this.valorPorDia = valorPorDia;
    }

    @Override
    public double calcular(Fatura10 fatura10) {
        return valorPorDia * fatura10.getDiasAtraso();
    }
}
