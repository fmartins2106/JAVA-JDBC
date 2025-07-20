package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class Caminhao20 extends Veiculo20{
    public Caminhao20(String placa, int anoFabricacao, String cor, double valorDeMercado) {
        super(placa, anoFabricacao, cor, valorDeMercado);
    }

    @Override
    public double calcularIPVA(){
        double aliquota = getAliquota();
        return getValorDeMercado() * aliquota;
    }

    @Override
    public void exibirDetalhes(){
        super.exibirDetalhes();
        System.out.println("Tipo: Caminhão");
    }
}
