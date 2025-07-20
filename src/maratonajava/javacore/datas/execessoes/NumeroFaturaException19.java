package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class NumeroFaturaException19 extends IllegalArgumentException{
    public NumeroFaturaException19() {
        super("Campo nome não pode ser vazio. Caracteres permitidos:\"/._-\"");
    }
}
