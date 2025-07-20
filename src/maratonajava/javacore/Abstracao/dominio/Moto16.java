package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class Moto16 extends Veiculo16{
    public Moto16(String placa, int anoFabricacao, String cor, double valorDeMercado) {
        super(placa, anoFabricacao, cor, valorDeMercado);
    }

    @Override
    public double calcularIPVA(){
        double aliquita =  getAliquotaIPVA();
        return getValorDeMercado() * aliquita;
    }

    @Override
    public void exibirDetalhes(){
        super.exibirDetalhes();
        System.out.println("Tipo: Moto");
    }
}
