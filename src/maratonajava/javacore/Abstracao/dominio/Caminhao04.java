package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class Caminhao04 extends Veiculo04{
    public Caminhao04(String placa, int anoFabricacao, String cor, double valorMercado) {
        super(placa, anoFabricacao, cor, valorMercado);
    }

    @Override
    public double calcularIPVA(){
        double aliquota = getAliquotaIPVA();
        return getValorMercado() * aliquota;
    }

    @Override
    public void exibirDetalhes(){
        super.exibirDetalhes();
        System.out.println("Tipo: Caminhão");
    }
}
