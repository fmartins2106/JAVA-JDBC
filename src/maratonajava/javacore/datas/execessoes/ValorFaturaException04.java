package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class ValorFaturaException04 extends IllegalArgumentException {
    public static final double MENOR_VALOR_FATURA = 0;
    public ValorFaturaException04() {
        super(String.format("Valor da fatura não pode ser menor ou igual a R$%.2f",MENOR_VALOR_FATURA));
    }
}
