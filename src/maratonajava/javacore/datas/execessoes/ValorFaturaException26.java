package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class ValorFaturaException26 extends IllegalArgumentException {
    public static final double MENOR_VALOR_FATURA = 0;
    public ValorFaturaException26() {
        super(String.format("Valor da fatura não pode ser menor que R$%.2f.",MENOR_VALOR_FATURA));
    }
}
