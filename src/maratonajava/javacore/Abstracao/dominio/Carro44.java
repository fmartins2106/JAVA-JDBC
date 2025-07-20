package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class Carro44 extends Veiculo44{
    public Carro44(String placa, int anoFabricacao, String cor, double valorMercado) {
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
        System.out.println("Tipo: carro.");
    }
}
