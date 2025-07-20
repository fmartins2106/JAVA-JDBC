package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class Carro29 extends Veiculo29{
    public Carro29(String placa, int anoFabricacao, String cor, double valorMercado) {
        super(placa, anoFabricacao, cor, valorMercado);
    }

    @Override
    public double calcularIPVA(){
        double aliquota = getAliquota();
        return valorMercado * aliquota;
    }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Tipo: carro.");
    }
}
