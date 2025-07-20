
package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaPercentualPorDia32 implements CalculadoraMulta32{
    private double percentual;

    public MultaPercentualPorDia32(double percentual) {
        this.percentual = percentual;
    }

    @Override
    public double calcular(Fatura32 fatura32) {
        return fatura32.getDiasAtraso() * ((percentual / 100) * fatura32.getValor());
    }
}

