package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class Moto43 extends Veiculo43{
    public Moto43(String placa, int anoFabricacao, String cor, double valorMercado) {
        super(placa, anoFabricacao, cor, valorMercado);
    }

    @Override
    public double calcularIPVA() {
        double aliquota = getAliquota();
        return valorMercado * aliquota;
    }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Tipo: Moto.");
    }
}
