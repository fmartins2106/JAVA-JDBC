package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaFixadaPorDia22 implements CalculadoraMulta22{
    private double valorPorDia;

    public MultaFixadaPorDia22(double valorPorDia) {
        this.valorPorDia = valorPorDia;
    }

    @Override
    public double calcular(Fatura22 fatura22) {
        return fatura22.getDiasAtraso() * valorPorDia;
    }
}
