package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class Carro32 extends Veiculo32{
    public Carro32(String placa, int anoFabricacao, String cor, double valorMercado) {
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
        System.out.println("Tipo: Carro.");
    }
}
