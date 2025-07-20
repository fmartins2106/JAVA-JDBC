package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class Carro10 extends Veiculo10{
    public Carro10(String placa, int anoFabricacao, String cor, double valorDeMercado) {
        super(placa, anoFabricacao, cor, valorDeMercado);
    }

    @Override
    public double calcularIPVA(){
        double aliquota = getAliquotaIPVA();
        return getValorDeMercado() * aliquota;
    }

    @Override
    public void exibirDetalhes(){
        super.exibirDetalhes();
        System.out.println("Tipo: Carro");
    }
}
