package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class ValorFaturaException15 extends IllegalArgumentException {
    public static final double MENOR_VALOR_FATURA = 0;
    public ValorFaturaException15() {
        super(String.format(String.format("Valor da fatura não pode ser menor que R$%.f",MENOR_VALOR_FATURA)));
    }
}
