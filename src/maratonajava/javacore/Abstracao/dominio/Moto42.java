package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class Moto42 extends Veiculo42{
    public Moto42(String placa, int anoFabricacao, String cor, double valorMercado) {
        super(placa, anoFabricacao, cor, valorMercado);
    }

    @Override
    public double calcularIPVA() {
        double aliquota = getAliquota();
        return valorMercado * aliquota;
    }

    @Override
    public void exibirInfo() {
        super.exibirInfo();
        System.out.println("Tipo: Moto.");
    }
}
