package academy.devdojo.maratonajava.javacore.excessoes;

public class DataValidadePerecivel26 extends IllegalArgumentException {
    public DataValidadePerecivel26() {
        super("Data de validade inválida. Digite uma data no formato DD/MM/AAAA");
    }
}
