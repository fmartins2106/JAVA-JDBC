package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class Carro34 extends Veiculo34{
    public Carro34(String placa, int anoFabricacao, String cor, double valorMercado) {
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
        System.out.println("Tipo: Carro.");
    }
}
