package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class ValorFaturaException35 extends IllegalArgumentException {
    public static final double MENOR_VALOR_FATURA = 0;
    public ValorFaturaException35() {
        super(String.format("Campo valor fatura não pode ser menor que R$%.2f",MENOR_VALOR_FATURA));
    }
}
