package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class Carro15 extends Veiculo15{
    public Carro15(String placa, int anoFabricacao, String cor, double valorDeMercado) {
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
        System.out.println("Tipo: Carro.");
    }
}
