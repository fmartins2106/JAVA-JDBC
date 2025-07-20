package academy.devdojo.maratonajava.javacore.excessoes;

public class DataValidadePerecivel12 extends IllegalArgumentException {
    public DataValidadePerecivel12() {
        super("Data de validade inválida. Informe uma data no formato dd/mm/aaaa");
    }
}
