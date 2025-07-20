package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaFixadaPorDia11 implements CalculadoraMulta11{
    private double valorPorDia;

    public MultaFixadaPorDia11(double valorPorDia) {
        this.valorPorDia = valorPorDia;
    }

    @Override
    public double calcular(Fatura11 fatura11) {
         return fatura11.getDiasAtraso() * valorPorDia;
    }
}
