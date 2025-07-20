package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class NumeroFaturaException26 extends IllegalArgumentException {
    public NumeroFaturaException26() {
        super("Campo número não pode ser vazio. Caracteres permitidos: \"/._-\"");
    }
}
