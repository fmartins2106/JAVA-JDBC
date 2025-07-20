package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class Caminhao05 extends Veiculo05{
    public Caminhao05(String placa, int ano, String cor, double valorDeMercado) {
        super(placa, ano, cor, valorDeMercado);
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
