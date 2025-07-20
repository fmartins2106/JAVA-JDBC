package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class Carro45 extends Veiculo45{
    public Carro45(String placa, int anoFabricacao, String cor, double valorMercado) {
        super(placa, anoFabricacao, cor, valorMercado);
    }

    @Override
    public double calcularIPVA() {
        double aliquota = getAliquota();
        return getValorMercado() * aliquota;
    }

    @Override
    public void exibirInfo() {
        super.exibirInfo();
        System.out.println("Tipo: Carro.");
    }
}
