package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class NumeroFaturaException07 extends IllegalArgumentException {
    public NumeroFaturaException07() {
        super("Campo número não pode ficar vazio. caracteres permitidos: /_-.");
    }
}
