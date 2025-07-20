package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class Carro40 extends Veiculo40{
    public Carro40(String placa, int anoFabricacao, String cor, double valorMercado) {
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
        System.out.println("Tipo: Carro.");
    }
}
