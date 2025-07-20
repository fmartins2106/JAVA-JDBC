package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class NumeroFaturaException17 extends IllegalArgumentException{
    public NumeroFaturaException17() {
        super("Campo número fatura não pode ser vazio. Caracteres permitidos:\"/._-\"");
    }
}
