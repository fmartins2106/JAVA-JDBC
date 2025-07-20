package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaFixadaPorDia05 implements CalculadoraMulta05{
    private double valorPor;

    public MultaFixadaPorDia05(double valorPor) {
        this.valorPor = valorPor;
    }

    @Override
    public double calcular(Fatura05 fatura05) {
        return valorPor * fatura05.getDiasAtraso();
    }
}
