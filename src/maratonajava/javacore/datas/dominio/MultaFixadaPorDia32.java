
package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaFixadaPorDia32 implements CalculadoraMulta32{
    private double valorPorDia;

    public MultaFixadaPorDia32(double valorPorDia) {
        this.valorPorDia = valorPorDia;
    }

    @Override
    public double calcular(Fatura32 fatura32) {
        return fatura32.getDiasAtraso() * valorPorDia;
    }
}

