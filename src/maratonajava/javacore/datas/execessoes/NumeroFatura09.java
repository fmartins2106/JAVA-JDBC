package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class NumeroFatura09 extends IllegalArgumentException {
    public NumeroFatura09() {
        super("Número de fatura inválido. caracteres permitidos: /_.-");
    }
}
