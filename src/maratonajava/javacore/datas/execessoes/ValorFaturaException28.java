package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class ValorFaturaException28 extends IllegalArgumentException {
    public static final double MENOR_VALOR_FATURA = 0;
    public ValorFaturaException28() {
        super(String.format("Campo valor fatura não pode ser vazio ou conter caracteres.",MENOR_VALOR_FATURA));
    }
}
