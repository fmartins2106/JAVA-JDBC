package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class Caminhao43 extends Veiculo43{
    public Caminhao43(String placa, int anoFabricacao, String cor, double valorMercado) {
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
        System.out.println("Tipo: Caminhão.");
    }
}
