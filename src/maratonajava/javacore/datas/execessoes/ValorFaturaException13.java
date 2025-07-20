package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class ValorFaturaException13 extends IllegalArgumentException {
    public static final double MENOR_VALOR_FATURA = 0;
    public ValorFaturaException13() {
        super(String.format("Fatura não pode ser menor que R$%.2f",MENOR_VALOR_FATURA));
    }
}
