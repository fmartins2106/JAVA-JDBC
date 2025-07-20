package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaFixadaPorDia04 implements CalculadoraMulta04{
    private double valorPordia;

    @Override
    public double calcular(Fatura04 fatura04) {
        return valorPordia * fatura04.getDiasAtraso();
    }
}
