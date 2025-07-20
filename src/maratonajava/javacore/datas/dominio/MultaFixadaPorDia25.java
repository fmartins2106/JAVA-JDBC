package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaFixadaPorDia25 implements CalculadoraMulta25{
    private double valorPorDia;

    public MultaFixadaPorDia25(double valorPorDia) {
        this.valorPorDia = valorPorDia;
    }

    @Override
    public double calcular(Fatura25 fatura25) {
        return valorPorDia * fatura25.getDiasAtraso();
    }
}
