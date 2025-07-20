package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class Carro03 extends Veiculo03{
    public Carro03(String placa, int anoFabricacao, String cor, double valorMercado) {
        super(placa, anoFabricacao, cor, valorMercado);
    }

    @Override
    public double calcularIPVA(){
        double aliquota = getAliquotaIPVA();
        return getValorMercado() * aliquota;
    }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Tipo: Carro");
    }
}
