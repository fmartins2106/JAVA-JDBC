package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class Moto30 extends Veiculo30{
    public Moto30(String placa, int anoFabricacao, String cor, double valorMercado) {
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
