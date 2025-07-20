package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class ValorFaturaException03 extends IllegalArgumentException {
    public static final double MENOR_PRECO = 0;
    public ValorFaturaException03() {
        super(String.format("Preço não pode ser menor que R$%.2f.",MENOR_PRECO));
    }
}
