package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class ValorFaturaException18 extends IllegalArgumentException {
    public static final double MENOR_VALOR_FATURA = 0;
    public ValorFaturaException18() {
        super(String.format("Valor não pode ser menor que R$%.2f",MENOR_VALOR_FATURA));
    }
}
