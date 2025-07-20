package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaFixadaPorDia07 implements CalculadoraMulta07{
    private double valorPorDia;

    public MultaFixadaPorDia07(double valorPorDia){
        this.valorPorDia  = valorPorDia;
    }

    @Override
    public double calcular(Fatura07 fatura07) {
        return valorPorDia * fatura07.getDiasAtraso();
    }
}
