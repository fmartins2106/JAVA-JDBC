package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaFixadaPorDia01 implements CalculadoraMulta01{
    private double valorPorDia;

    public MultaFixadaPorDia01(double valorPorDia) {
        this.valorPorDia = valorPorDia;
    }

    @Override
    public double calcularMulta(Fatura01 fatura01) {
        return valorPorDia * fatura01.getDiasAtraso();
    }


}
