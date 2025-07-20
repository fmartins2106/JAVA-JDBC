package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class Moto34 extends Veiculo34{
    public Moto34(String placa, int anoFabricacao, String cor, double valorMercado) {
        super(placa, anoFabricacao, cor, valorMercado);
    }

    @Override
    public double calcularIPVA() {
        double aliquota = getAliquota();
        return valorMercado * aliquota;
    }

    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("Tipo: Moto.");
    }
}
