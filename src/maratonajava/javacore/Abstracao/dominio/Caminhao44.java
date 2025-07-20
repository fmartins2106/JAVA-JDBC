package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class Caminhao44 extends Veiculo44{
    public Caminhao44(String placa, int anoFabricacao, String cor, double valorMercado) {
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
        System.out.println("Tipo: Caminhão.");
    }
}
