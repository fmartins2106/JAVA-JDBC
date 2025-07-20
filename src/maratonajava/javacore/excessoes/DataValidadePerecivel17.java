package academy.devdojo.maratonajava.javacore.excessoes;

public class DataValidadePerecivel17 extends IllegalArgumentException {
    public DataValidadePerecivel17() {
        super("Data de validade inválida. Digite uma data no formato DD/MM/AAAA.");
    }
}
