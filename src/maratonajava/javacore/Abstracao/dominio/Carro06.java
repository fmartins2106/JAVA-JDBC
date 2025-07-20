package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class Carro06 extends Veiculo06{
    public Carro06(String placa, int ano, String cor, double valorDeMercado) {
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
        System.out.println("Tipo: Carro");
    }
}
