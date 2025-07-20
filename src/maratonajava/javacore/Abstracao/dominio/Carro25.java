package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class Carro25 extends Veiculo25{
    public Carro25(String placa, int anoFabricacao, String cor, double valorMercado) {
        super(placa, anoFabricacao, cor, valorMercado);
    }

    @Override
    public double calcularIPVA(){
        double aliquota = getAliquota();
        return valorMercado * aliquota;
    }

    @Override
    public void exibirResultados(){
        super.exibirResultados();
        System.out.println("Tipo: Carro.");
    }
}
