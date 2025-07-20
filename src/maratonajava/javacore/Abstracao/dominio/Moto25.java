package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class Moto25 extends Veiculo25{
    public Moto25(String placa, int anoFabricacao, String cor, double valorMercado) {
        super(placa, anoFabricacao, cor, valorMercado);
    }

    @Override
    public double calcularIPVA(){
        double aliquota =  getAliquota();
        return valorMercado * aliquota;
    }

    @Override
    public void exibirResultados(){
        super.exibirResultados();
        System.out.println("Tipo: Moto.");
    }
}
