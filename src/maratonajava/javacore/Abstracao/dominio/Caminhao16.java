package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class Caminhao16 extends Veiculo16{
    public Caminhao16(String placa, int anoFabricacao, String cor, double valorDeMercado) {
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
        System.out.println("Tipo: Caminhão");
    }
}
