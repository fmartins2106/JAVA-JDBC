package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class ValorFaturaException05 extends IllegalArgumentException {
    public static final double MENOR_VALOR_FATURA = 0;
    public ValorFaturaException05() {
        super("Valor fatura não pode ser menor que zero.");
    }
}
