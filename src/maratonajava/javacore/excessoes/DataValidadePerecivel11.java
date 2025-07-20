package academy.devdojo.maratonajava.javacore.excessoes;

public class DataValidadePerecivel11 extends IllegalArgumentException {
    public DataValidadePerecivel11() {
        super("Data de validade inválida. Digite uma data no formato DD/MM/AAAA.");
    }
}
