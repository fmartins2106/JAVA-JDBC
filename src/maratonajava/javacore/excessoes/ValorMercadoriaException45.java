package academy.devdojo.maratonajava.javacore.excessoes;

public class ValorMercadoriaException45 extends IllegalArgumentException {
    public static final double MENOR_VALOR_FATURA = 0;
    public ValorMercadoriaException45() {
        super(String.format("Valor da mercadoria não pode ser menor que R$%.2f",MENOR_VALOR_FATURA));
    }
}
