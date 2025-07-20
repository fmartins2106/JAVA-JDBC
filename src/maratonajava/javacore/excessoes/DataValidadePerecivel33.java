package academy.devdojo.maratonajava.javacore.excessoes;

public class DataValidadePerecivel33 extends IllegalArgumentException {
    public DataValidadePerecivel33() {
        super("Data de validade inválida. Data precisa estar no formato DD/MM/AAAA");
    }
}
