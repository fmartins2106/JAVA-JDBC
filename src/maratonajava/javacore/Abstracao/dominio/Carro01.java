package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.List;

public class Carro01 extends Veiculo01{
    public Carro01(String placa, int anoFabricacao, String cor, double valorDeMercado) {
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
