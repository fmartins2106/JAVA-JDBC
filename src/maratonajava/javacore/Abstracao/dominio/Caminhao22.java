package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class Caminhao22 extends Veiculo22{
    public Caminhao22(String placa, int anoFabricacao, String cor, double valorDeMercado) {
        super(placa, anoFabricacao, cor, valorDeMercado);
    }

    @Override
    public double calcularIPVA(){
        double aliquota = getAliquota();
        return valorDeMercado * aliquota;
    }

    @Override
    public void exibirDetalhes(){
        super.exibirDetalhes();
        System.out.println("Tipo: Caminhão");
    }
}
